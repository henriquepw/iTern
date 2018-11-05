package br.edu.ifpb.iternapp.activities.edit

import android.annotation.SuppressLint
import android.content.Intent
import android.content.pm.ActivityInfo
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ProgressBar
import br.edu.ifpb.iternapp.R
import br.edu.ifpb.iternapp.activities.MainStudentActivity
import br.edu.ifpb.iternapp.conection.Server
import br.edu.ifpb.iternapp.entities.Student
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_edit_student.*

class EditStudentActivity : AppCompatActivity() {

    private var student: Student? = null

    @SuppressLint("CheckResult")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_student)

        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        setSupportActionBar(toolSignup)

        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setDisplayShowHomeEnabled(true)

        val states = Server.STATES

        var state: String? = null

        spStates.setAdapter(ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_dropdown_item,
                states))

        spStates.onItemClickListener = AdapterView.OnItemClickListener { _, _, position, _ ->
            state = states[position]
            Server.toask(this, state!!, false)
        }

        Server.service.getStudentById(Server.userID)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ student ->
                    Log.v("------------", student.toString())
                    this.student = student
                    state = student.state
                    setStudent(student)
                }, { err ->
                    Server.toask(this, "Erro: ${err.message}")
                }, {
                    loading.visibility = ProgressBar.GONE
                    data.visibility = ProgressBar.VISIBLE
                })

        btUpdate.setOnClickListener { btOnClick(state!!) }
    }


    private fun setStudent(student: Student) {
        this.student = student
        txEmail.setText(student.email)
        txPassword.setText(student.password)
        txName.setText(student.name)
        txStreet.setText(student.street)
        txNumber.setText(student.number.toString())
        txNeigh.setText(student.neighborhood)
        txCity.setText(student.city)
        txPostalCode.setText(student.postal_code)
        spStates.setText(student.state)
        txDate.setText(student.birthday)
        txRG.setText(student.rg)
        txCpf.setText(student.cpf)
        txNacionalidade.setText(student.birth_place)
        txNaturalidade.setText(student.citizenship)

        if (student.url_lattes != null)
            txLattes.setText(student.url_lattes)

    }

    @SuppressLint("CheckResult")
    private fun update(student: Student) {
        Log.i("Company.toString()", student.toString())
        if (student == this.student) {
            Server.toask(this, "Você não modificou nada.", false)
        } else {
            Server.service.updateStudent(Server.userID, student)
                    .subscribeOn(Schedulers.io())
                    .unsubscribeOn(Schedulers.computation())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe({
                        Server.toask(this, "Salvo", false)
                        startActivity(Intent(this, MainStudentActivity::class.java))
                        finish()
                    }, { err ->
                        Server.toask(this, "Erro: ${err.message}", false)
                    })
        }
    }

    private fun btOnClick(state: String) {
        val student = Student(
                txEmail.text.toString(),
                txPassword.text.toString(),
                txName.text.toString(),
                txDate.text.toString(),
                txStreet.text.toString(),
                txNumber.text.toString().toInt(),
                txNeigh.text.toString(),
                txCity.text.toString(),
                txPostalCode.text.toString(),
                state,
                txLattes.text.toString(),
                txRG.text.toString(),
                txCpf.text.toString(),
                txNacionalidade.text.toString(),
                txNaturalidade.text.toString())

        update(student)
    }
}
