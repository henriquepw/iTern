package br.edu.ifpb.iternapp.fragments.student

import android.annotation.SuppressLint
import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.text.TextUtils
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import android.widget.AdapterView.OnItemClickListener

import br.edu.ifpb.iternapp.R
import br.edu.ifpb.iternapp.activities.LoginActivity
import br.edu.ifpb.iternapp.conection.Server
import br.edu.ifpb.iternapp.entities.Network
import br.edu.ifpb.iternapp.entities.Phone
import br.edu.ifpb.iternapp.entities.Student
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.fragment_signup_student.*


class SignUpFragmentStudent : Fragment() {

    private var dialog: Dialog? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_signup_student, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        var progress = activity!!.findViewById(R.id.progressBar) as ProgressBar

        Server.setMask(txDate, "NN/NN/NNNN")
        Server.setMask(txPhone, "(NN) NNNNN-NNNN")

        val states = Server.STATES

        var state: String? = null

        val adp = ArrayAdapter<String>(activity, android.R.layout.simple_spinner_dropdown_item, states)
        spStates.setAdapter(adp)

        spStates.onItemClickListener = OnItemClickListener { _, _, position, _ ->
            state = states[position]
            Server.toask(activity!!, state!!, false)
        }

        btNext.setOnClickListener {
            var cancel = false
            var focusView: View? = null

            val textViews = arrayOf(
                    txEemail, txPassword,
                    txName, txDate,
                    txCpf, txRG,
                    txNaturalidade, txNacionalidade,
                    txPhone, txStreet,
                    txNumber, txNeigh,
                    txCity, txPostalCode)
            textViews.reverse()

            spStates.error = null
            for (tx in textViews)
                tx.error = null

            /*if (state == null) {
                spStates.error = "Esse campo precisa ser preenchido"
                focusView = spStates
                cancel = true
            }

            if (!txEemail.text.toString().contains("@")) {
                txEemail.error = "Formato invalido"
                focusView = txEemail
                cancel = true
            }

            if (txPassword.text.toString().length < 5) {
                txPassword.error = "Pelo menos 5 caracteres"
                focusView = txPassword
                cancel = true
            }

            if (txDate.text.toString().length != 10) {
                txDate.error = "Campo incompleto"
                focusView = txDate
                cancel = true
            }

            if (txPhone.text.toString().length != 15) {
                txPhone.error = "Campo incompleto"
                focusView = txPhone
                cancel = true
            }*/

            for (tx in 0 until textViews.size) {
                if (TextUtils.isEmpty(textViews[tx].text.toString())) {
                    textViews[tx].error = "Esse campo precisa ser preenchido"
                    focusView = textViews[tx]
                    cancel = true
                }
            }

            if (!cancel) {
                val student = Student(
                        txEemail.text.toString(),
                        txPassword.text.toString(),
                        txName.text.toString(),
                        txDate.text.toString(),
                        txStreet.text.toString(),
                        txNumber.text.toString().toInt(),
                        txNeigh.text.toString(),
                        txCity.text.toString(),
                        txPostalCode.text.toString(),
                        state!!,
                        txLattes.text.toString(),
                        txRG.text.toString(),
                        txCpf.text.toString(),
                        txNacionalidade.text.toString(),
                        txNaturalidade.text.toString())

                Log.i("Student ---------------", student.toString())

                val service = Server.service

                service.insertStudent(student)
                        .subscribeOn(Schedulers.io())
                        .unsubscribeOn(Schedulers.computation())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe({ res ->
                            progress.visibility = ProgressBar.VISIBLE
                            Server.userID = res.id
                            Server.toask(activity!!, "Foi ${Server.userID}")
                        }, { err ->
                            progress.visibility = ProgressBar.GONE
                            Server.toask(activity!!, "${err.message}")
                            Log.v("Error", err.message)
                        }, {
                            val phone = Phone(
                                    Server.userID,
                                    txPhone.text.toString())

                            service.insertStudentPhone(phone)
                                    .subscribeOn(Schedulers.io())
                                    .unsubscribeOn(Schedulers.computation())
                                    .observeOn(AndroidSchedulers.mainThread())
                                    .subscribe({
                                        addNetworks(progress)
                                    }, { err ->
                                        progress.visibility = ProgressBar.GONE
                                        Server.toask(activity!!, "${err.message}")
                                        Log.v("Error", err.message)
                                    })


                        })
            } else {
                focusView?.requestFocus()
                Server.toask(activity!!, "Preencha os obrigatorios")
            }
        }
    }

    @SuppressLint("CheckResult")
    private fun addNetworks(progress: ProgressBar) {
        val textViews = arrayOf(txLinkedin, txGithub)

        for (tv in textViews) {
            if (!TextUtils.isEmpty(tv.text.toString())) {
                val network = Network(
                        Server.userID,
                        tv.hint.toString(),
                        tv.text.toString())

                Server.service.insertNetwork(network)
                        .subscribeOn(Schedulers.io())
                        .unsubscribeOn(Schedulers.computation())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe({
                            progress.visibility = ProgressBar.GONE
                            Server.toask(activity!!, "Salvo")

                            startActivity(Intent(activity, LoginActivity::class.java))
                            activity!!.finish()
                        }, { err ->
                            Server.toask(activity!!, "${err.message}")
                        })
            }
        }
    }
}
