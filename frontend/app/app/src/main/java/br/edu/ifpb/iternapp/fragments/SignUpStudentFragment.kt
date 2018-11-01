package br.edu.ifpb.iternapp.fragments

import android.app.AlertDialog
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
import br.edu.ifpb.iternapp.entities.Course
import br.edu.ifpb.iternapp.entities.Phone
import br.edu.ifpb.iternapp.entities.Student
import com.github.rtoshiro.util.format.SimpleMaskFormatter
import com.github.rtoshiro.util.format.text.MaskTextWatcher
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.fragment_signup_student.*


class SignUpStudentFragment : Fragment() {

    private var dialog: Dialog? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_signup_student, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        var progress = activity!!.findViewById(R.id.progressBar) as ProgressBar

        setMask(txDate, "NN/NN/NNNN")
        setMask(txPhone, "(NN) NNNNN-NNNN")
        setMask(txCourseReferencePeriod, "N")
        setMask(txCourseIngressYear, "NNNN.N")
        setMask(txCourseConclusionYear, "NNNN")

        val states = arrayOf(
                "Acre (AC)", "Alagoas (AL)", "Amapá (AP)", "Amazonas (AM)",
                "Bahia (BA)", "Ceará (CE)", "Distrito Federal (DF)", "Espírito Santo (ES)",
                "Goiás (GO)", "Maranhão (MA)", "Mato Grosso (MT)", "Mato Grosso do Sul (MS)",
                "Minas Gerais (MG)", "Pará (PA)", "Paraíba (PB)", "Paraná (PR)",
                "Pernambuco (PE)", "Piauí (PI)", "Rio de Janeiro (RJ)", "Rio Grande do Norte (RN)",
                "Rio Grande do Sul (RS)", "Rondônia (RO)", "Roraima (RR)", "Santa Catarina (SC)",
                "São Paulo (SP)", "Sergipe (SE)", "Tocantins (TO)")

        var state: String? = null

        val adp = ArrayAdapter<String>(activity, android.R.layout.simple_spinner_dropdown_item, states)
        spStates.setAdapter(adp)

        spStates.onItemClickListener = OnItemClickListener { _, _, position, _ ->
            state = states[position]
            Toast.makeText(activity, states[position], Toast.LENGTH_SHORT).show()
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
                    txCity, txPostalCode/*,
                    txCourseName, txCourseReferencePeriod,
                    txCourseIngressYear, txCourseIngressWay,
                    txCourseInstitution, txCourseIRA,
                    txCourseShift, txCourseConclusionYear*/)
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
            }

            if (txCourseIngressYear.text.toString().length != 6) {
                txCourseIngressYear.error = "Campo incompleto"
                focusView = txCourseIngressYear
                cancel = true
            }

            if (txCourseConclusionYear.text.toString().length != 4) {
                txCourseConclusionYear.error = "Campo incompleto"
                focusView = txCourseConclusionYear
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

                var studentID = 0
                val service = Server.service

                service.insertStudent(student)
                        .subscribeOn(Schedulers.io())
                        .unsubscribeOn(Schedulers.computation())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe({
                            progress.visibility = ProgressBar.VISIBLE
                            studentID = it.id
                        }, {
                            progress.visibility = ProgressBar.GONE
                            Toast.makeText(activity, "${it.message}", Toast.LENGTH_SHORT)
                                    .show()
                            Log.v("Error", it.message)
                        }, {
                            Toast.makeText(activity, "Foi $studentID", Toast.LENGTH_SHORT)
                                    .show()

                            /*val phone = Phone(
                                    studentID,
                                    txPhone.text.toString())

                            service.insertStudentPhone(phone)
                                    .subscribeOn(Schedulers.io())
                                    .unsubscribeOn(Schedulers.computation())
                                    .observeOn(AndroidSchedulers.mainThread())
                                    .subscribe({}, { e ->
                                        progress.visibility = ProgressBar.GONE
                                        Toast.makeText(activity, "${e.message}", Toast.LENGTH_SHORT)
                                                .show()
                                        Log.v("Error", e.message)
                                    }, {
                                        progress.visibility = ProgressBar.GONE
                                        Toast.makeText(activity, "phone save", Toast.LENGTH_SHORT)
                                                .show()

                                        startActivity(Intent(activity, LoginActivity::class.java))
                                        activity!!.finish()
                                    })

                            val course = Course(
                                    studentID,
                                    txCourseInstitution.text.toString(),
                                    txCourseName.text.toString(),
                                    txCourseReferencePeriod.text.toString(),
                                    txCourseIngressYear.text.toString(),
                                    txCourseIngressWay.text.toString(),
                                    txCourseConclusionYear.text.toString(),
                                    txCourseIRA.text.toString().toDouble(),
                                    txCourseShift.text.toString())

                            service.insertStudentCourse(course)
                                    .subscribeOn(Schedulers.io())
                                    .unsubscribeOn(Schedulers.computation())
                                    .observeOn(AndroidSchedulers.mainThread())
                                    .subscribe({

                                    }, {
                                        Toast.makeText(activity, "${it.message}", Toast.LENGTH_SHORT)
                                              .show()
                                        Log.v("Error", it.message)
                                    }, {

                                    })*/
                        })
            } else {
                focusView?.requestFocus()
                Toast.makeText(activity, "Preencha os obrigatorios", Toast.LENGTH_SHORT)
                        .show()
            }
        }
    }

    private fun setMask(view: EditText, mask: String) {
        val mtw = MaskTextWatcher(view, SimpleMaskFormatter(mask))
        view.addTextChangedListener(mtw)
    }
}
