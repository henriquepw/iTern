package br.edu.ifpb.iternapp.activities.add

import android.annotation.SuppressLint
import android.content.Intent
import android.content.pm.ActivityInfo
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.View
import br.edu.ifpb.iternapp.R
import br.edu.ifpb.iternapp.activities.MainStudentActivity
import br.edu.ifpb.iternapp.conection.Server
import br.edu.ifpb.iternapp.entities.Course
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_add_course.*

class AddCourseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        setContentView(R.layout.activity_add_course)

        setSupportActionBar(toolSignup)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setDisplayShowHomeEnabled(true)

        Server.setMask(txCourseReferencePeriod, "N")
        Server.setMask(txCourseIngressYear, "NNNN.N")
        Server.setMask(txCourseConclusionYear, "NNNN")
        btSave.setOnClickListener { btOnClick() }
    }

    @SuppressLint("CheckResult")
    private fun btOnClick() {
        var cancel = false
        var focusView: View? = null

        val textViews = arrayOf(
                txCourseName, txCourseReferencePeriod,
                txCourseIngressYear, txCourseIngressWay,
                txCourseInstitution, txCourseIRA,
                txCourseShift, txCourseConclusionYear)
        textViews.reverse()

        for (tx in textViews)
            tx.error = null

        if (txCourseIngressYear.text.toString().length != 6) {
            txCourseIngressYear.error = "Campo incompleto"
            focusView = txCourseIngressYear
            cancel = true
        }

        if (txCourseConclusionYear.text.toString().length != 4) {
            txCourseConclusionYear.error = "Campo incompleto"
            focusView = txCourseConclusionYear
            cancel = true
        }

        for (tx in 0 until textViews.size) {
            if (TextUtils.isEmpty(textViews[tx].text.toString())) {
                textViews[tx].error = "Esse campo precisa ser preenchido"
                focusView = textViews[tx]
                cancel = true
            }
        }

        if (!cancel) {
            val course = Course(
                    Server.userID,
                    txCourseInstitution.text.toString(),
                    txCourseName.text.toString(),
                    txCourseReferencePeriod.text.toString(),
                    txCourseIngressYear.text.toString(),
                    txCourseIngressWay.text.toString(),
                    txCourseConclusionYear.text.toString(),
                    txCourseIRA.text.toString().toDouble(),
                    txCourseShift.text.toString())

            Server.service.insertStudentCourse(course)
                    .subscribeOn(Schedulers.io())
                    .unsubscribeOn(Schedulers.computation())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe({
                        Server.toask(this, "Salvo")
                        startActivity(Intent(this, MainStudentActivity::class.java))
                        finish()
                    }, { err ->
                        Server.toask(this, "Erro: ${err.message}")
                        Log.v("Error", err.message)
                    })
        } else {
            focusView?.requestFocus()
            Server.toask(this, "Preencha os obrigatorios")
        }
    }
}


