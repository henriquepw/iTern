package br.edu.ifpb.iternapp.fragments

import android.app.AlertDialog
import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Toast

import br.edu.ifpb.iternapp.R
import br.edu.ifpb.iternapp.activities.LoginActivity
import br.edu.ifpb.iternapp.activities.add.AddCourseActivity
import br.edu.ifpb.iternapp.activities.edit.EditStudentActivity
import br.edu.ifpb.iternapp.conection.Server
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.dialog_choice.view.*
import kotlinx.android.synthetic.main.dialog_network.view.*
import kotlinx.android.synthetic.main.fragment_settings_student.*

class SettingsFragmentStudent : Fragment() {

    var dialog: Dialog? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_settings_student, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        btDeleteStudent.setOnClickListener {
            val view = layoutInflater.inflate(R.layout.dialog_choice, null)

            view.btNo.setOnClickListener {
                dialog?.dismiss()
            }

            view.btYes.setOnClickListener {
                val service = Server.service
                service.deleteStudent(Server.userID)
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
            }

            showDialog(view)
        }

        btAddCourse.setOnClickListener {
            startActivity(Intent(activity, AddCourseActivity::class.java))
        }

        btAddNetwork.setOnClickListener {
            val view = layoutInflater.inflate(R.layout.dialog_network, null)

            val networks = arrayOf(
                    "Github",
                    "linkedin")

            val adp = ArrayAdapter<String>(activity, android.R.layout.simple_spinner_dropdown_item, networks)
            view.spNetwork.setAdapter(adp)

            view.btCancel.setOnClickListener {
                dialog?.dismiss()
            }

            view.btSave.setOnClickListener {
                //Salvar rede
                dialog?.dismiss()
            }

            showDialog(view)
        }

        btEditStudent.setOnClickListener {
            startActivity(Intent(activity, EditStudentActivity::class.java))
        }

    }

    private fun showDialog(view: View) {
        val builder = AlertDialog.Builder(activity)
        builder.setView(view)
        dialog = builder.create()
        dialog?.show()
    }
}
