package br.edu.ifpb.iternapp.activities.add

import android.content.pm.ActivityInfo
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import br.edu.ifpb.iternapp.R
import br.edu.ifpb.iternapp.conection.Server
import br.edu.ifpb.iternapp.entities.VacancyInsert
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_add_vacancy.*

class AddVacancyActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_vacancy)

        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        setSupportActionBar(toolSignup)

        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setDisplayShowHomeEnabled(true)

        Server.setMask(txWorkload, "NN")

        val states = Server.STATES

        var state: String? = null

        spStates.setAdapter(ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_dropdown_item,
                states))

        spStates.onItemClickListener = AdapterView.OnItemClickListener { _, _, position, _ ->
            state = states[position]
            Server.toask(this, state!!, false)
        }

        btInsert.setOnClickListener {
            var cancel = false
            var focusView: View? = null

            val textViews = arrayOf(
                    txName, txWorkload,
                    txScholarship, txDescription,
                    txStreet, txNumber, txNeigh,
                    txCity, txPostalCode)
            textViews.reverse()

            spStates.error = null
            for (tx in textViews)
                tx.error = null

            if (state == null) {
                spStates.error = "Esse campo precisa ser preenchido"
                focusView = spStates
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
                val vacancy = VacancyInsert(
                        Server.userID,
                        txName.text.toString(),
                        txWorkload.text.toString().toInt(),
                        txScholarship.text.toString().toDouble(),
                        txDescription.text.toString(),
                        txStreet.text.toString(),
                        txNumber.text.toString().toInt(),
                        txNeigh.text.toString(),
                        txCity.text.toString(),
                        txPostalCode.text.toString(),
                        state!!)

                Server.service.insertVacancy(vacancy)
                        .subscribeOn(Schedulers.io())
                        .unsubscribeOn(Schedulers.computation())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe({
                            Server.toask(this, "Vaga Cadastrada", false)
                            finish()
                        }, { err ->
                            Server.toask(this, err.message.toString())
                            Log.v("Error", err.message)
                        })


            } else {
                focusView?.requestFocus()
                Server.toask(this, "Preencha os obrigatorios", false)
            }
        }
    }
}
