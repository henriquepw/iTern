package br.edu.ifpb.iternapp.fragments.company

import android.app.AlertDialog
import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import br.edu.ifpb.iternapp.R
import br.edu.ifpb.iternapp.activities.LoginActivity
import br.edu.ifpb.iternapp.activities.add.AddVacancyActivity
import br.edu.ifpb.iternapp.activities.edit.EditCompanyActivity
import br.edu.ifpb.iternapp.conection.Server
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.dialog_choice.view.*
import kotlinx.android.synthetic.main.fragment_settings_company.*

class SettingsFragmentCompany : Fragment() {

    var dialog: Dialog? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_settings_company, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        btDeleteCompany.setOnClickListener {
            val view = layoutInflater.inflate(R.layout.dialog_choice, null)

            view.btNo.setOnClickListener {
                dialog?.dismiss()
            }

            view.btYes.setOnClickListener {
                if (Server.userID != 0) {
                    val service = Server.service
                    service.deleteCompany(Server.userID)
                            .subscribeOn(Schedulers.io())
                            .unsubscribeOn(Schedulers.computation())
                            .observeOn(AndroidSchedulers.mainThread())
                            .subscribe({ res ->
                                Server.toask(activity!!, "Conta apagada", false)
                                Server.userID = res.id

                                startActivity(Intent(activity, LoginActivity::class.java))
                                activity?.finish()
                            }, { err ->
                                Server.toask(activity!!, "Erro ${err.message}", false)
                                dialog?.dismiss()
                            })
                } else {
                    Server.toask(activity!!, "melda ${Server.userID}", false)
                }
            }

            showDialog(view)
        }

        btAddVacancy.setOnClickListener {
            startActivity(Intent(activity, AddVacancyActivity::class.java))
        }

        btEditCompany.setOnClickListener {
            startActivity(Intent(activity, EditCompanyActivity::class.java))
        }
    }

    private fun showDialog(view: View) {
        val builder = AlertDialog.Builder(activity)
        builder.setView(view)
        dialog = builder.create()
        dialog?.show()
    }
}
