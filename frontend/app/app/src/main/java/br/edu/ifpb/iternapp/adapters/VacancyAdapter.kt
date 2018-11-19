package br.edu.ifpb.iternapp.adapters

import android.annotation.SuppressLint
import android.app.Activity
import android.app.AlertDialog
import android.app.Service
import android.support.v4.app.DialogFragment
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.RelativeLayout
import android.widget.TextView
import br.edu.ifpb.iternapp.R
import br.edu.ifpb.iternapp.conection.Server
import br.edu.ifpb.iternapp.entities.Vacancy
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.dialog_choice.view.*
import kotlinx.android.synthetic.main.fragment_search.*

class VacancyAdapter(
        private val vacancys: ArrayList<Vacancy>,
        private val type: Boolean = true,
        private val activity: Activity) : RecyclerView.Adapter<VacancyAdapter.Holder>() {

    private var dialog: AlertDialog? = null

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): Holder {
        var view = LayoutInflater.from(p0.context).inflate(R.layout.list_item_vacancy, p0, false)
        return Holder(view)
    }

    override fun getItemCount(): Int {
        return vacancys.size
    }

    @SuppressLint("InflateParams", "SetTextI18n")
    override fun onBindViewHolder(p0: Holder, p1: Int) {
        val vacancy = vacancys[p1]
        p0.name.text = vacancy.name

        p0.bt.setOnClickListener {
            val builder = AlertDialog.Builder(activity)
            val view = activity.layoutInflater.inflate(R.layout.dialog_vacancy, null)

            val txtName = view.findViewById<TextView>(R.id.txtName)
            val txtCompany = view.findViewById<TextView>(R.id.txtCompany)
            val txtScholarship = view.findViewById<TextView>(R.id.txtScholarship)
            val txtWorkload = view.findViewById<TextView>(R.id.txtWorkload)
            val txtDescription = view.findViewById<TextView>(R.id.txtDescription)
            val txtAreas = view.findViewById<TextView>(R.id.txtAreas)

            txtName.text = vacancy.name
            txtScholarship.text = "${txtScholarship.text}${vacancy.scholarship}"
            txtWorkload.text = "${txtWorkload.text}${vacancy.workload}"
            txtDescription.text = "${txtDescription.text}${vacancy.description}"
            txtCompany.text = "${txtCompany.text}${vacancy.company_id}"
            txtAreas.text = "${txtAreas.text}Pegar Areas ainda"

            val btSave = view.findViewById<Button>(R.id.btSave)
            btSave.setOnClickListener {
                Server.service.registerVacancyStudent(Server.userID, vacancy.id)
                        .subscribeOn(Schedulers.io())
                        .unsubscribeOn(Schedulers.computation())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe({
                            Server.toask(activity, "Cadastrado, Boa sorte!")
                        }, { err ->
                            Server.toask(activity, "Erro ${err.message}")
                        })

                dialog?.dismiss()
            }

            builder.setView(view)
            dialog = builder.create()
            dialog?.show()
        }

        if (this.type) {
            p0.btDelete.visibility = ImageButton.GONE
        } else {
            p0.btDelete.setOnClickListener { }
        }

    }

    class Holder(view: View) : RecyclerView.ViewHolder(view) {
        val name = view.findViewById<TextView>(R.id.txVancacy)!!
        val bt = view.findViewById<RelativeLayout>(R.id.bt)!!
        val btDelete = view.findViewById<ImageButton>(R.id.btDelete)!!
    }
}