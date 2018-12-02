package br.edu.ifpb.iternapp.adapters

import android.annotation.SuppressLint
import android.app.Activity
import android.app.AlertDialog
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import android.widget.TextView
import br.edu.ifpb.iternapp.R
import br.edu.ifpb.iternapp.entities.Student

class StudentAdapter(
        private val students: ArrayList<Student>,
        private val type: Boolean = true,
        private val activity: Activity) : RecyclerView.Adapter<StudentAdapter.Holder>() {

    private var dialog: AlertDialog? = null

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): Holder {
        var view = LayoutInflater.from(p0.context).inflate(R.layout.list_item_student, p0, false)
        return Holder(view)
    }

    override fun getItemCount(): Int {
        return students.size
    }

    private fun removeItem(student: Student) {
        var pos = students.indexOf(student)
        students.remove(student)
        notifyItemRemoved(pos)
    }

    @SuppressLint("InflateParams", "SetTextI18n")
    override fun onBindViewHolder(p0: Holder, p1: Int) {
        val student = students[p1]
        p0.name.text = student.name


        p0.bt.setOnClickListener {
            val builder = AlertDialog.Builder(activity)
            val view = activity.layoutInflater.inflate(R.layout.dialog_student, null)

            // Exibir dados do aluno
            val txName = view.findViewById<TextView>(R.id.txtName)
            val txDate = view.findViewById<TextView>(R.id.txDate)
            val txStreet = view.findViewById<TextView>(R.id.txStreet)
            val txNumber = view.findViewById<TextView>(R.id.txNumber)
            val txNeigh = view.findViewById<TextView>(R.id.txNeigh)
            val txCity = view.findViewById<TextView>(R.id.txCity)
            val txPostalCode = view.findViewById<TextView>(R.id.txPostalCode)
            val txStates = view.findViewById<TextView>(R.id.txStates)
            val txLattes = view.findViewById<TextView>(R.id.txLattes)
            val txRG = view.findViewById<TextView>(R.id.txRG)
            val txCpf = view.findViewById<TextView>(R.id.txCpf)
            val txNacionalidade = view.findViewById<TextView>(R.id.txNacionalidade)
            val txNaturalidade = view.findViewById<TextView>(R.id.txNaturalidade)

            //txName.text = student.name
            txDate.text = student.birthday
            txStreet.text = student.street
            txNumber.text = "${student.number}"
            txNeigh.text = student.neighborhood
            txCity.text = student.city
            txPostalCode.text = student.postal_code
            txStates.text = student.state
            txLattes.text = student.url_lattes
            txRG.text = student.rg
            txCpf.text = student.cpf
            txNacionalidade.text = student.birth_place
            txNaturalidade.text = student.citizenship

            builder.setView(view)
            dialog = builder.create()
            dialog?.show()
        }

    }

    class Holder(view: View) : RecyclerView.ViewHolder(view) {
        val name = view.findViewById<TextView>(R.id.txStudent)!!
        val bt = view.findViewById<RelativeLayout>(R.id.bt)!!
    }
}