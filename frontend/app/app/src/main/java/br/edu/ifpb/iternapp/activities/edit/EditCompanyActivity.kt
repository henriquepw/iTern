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
import br.edu.ifpb.iternapp.activities.MainCompanyActivity
import br.edu.ifpb.iternapp.conection.Server
import br.edu.ifpb.iternapp.entities.Company
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_edit_company.*

class EditCompanyActivity : AppCompatActivity() {

    private var company: Company? = null

    @SuppressLint("CheckResult")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_company)

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

        Server.service.getCompanyById(Server.userID)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ company ->
                    Log.v("------------", company.toString())
                    this.company = company
                    state = company.state
                    setCompany(company)
                }, { err ->
                    Server.toask(this, "Erro: ${err.message}")
                }, {
                    loading.visibility = ProgressBar.GONE
                    data.visibility = ProgressBar.VISIBLE
                })

        btUpdate.setOnClickListener { btOnClick(state!!) }
    }

    private fun setCompany(company: Company) {
        this.company = company
        txEmail.setText(company.email)
        txPassword.setText(company.password)
        txName.setText(company.name)
        txCnpj.setText(company.cnpj)
        txRazaoSocial.setText(company.razao_social)
        txStreet.setText(company.street)
        txNumber.setText(company.number.toString())
        txNeigh.setText(company.neighborhood)
        txCity.setText(company.city)
        txPostalCode.setText(company.postal_code)
        spStates.setText(company.state)
    }

    @SuppressLint("CheckResult")
    private fun update(company: Company) {
        Log.i("Company.toString()", company.toString())
        if (company == this.company) {
            Server.toask(this, "Você não modificou nada.", false)
        } else {
            Server.service.updateCompany(Server.userID, company)
                    .subscribeOn(Schedulers.io())
                    .unsubscribeOn(Schedulers.computation())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe({
                        Server.toask(this, "Salvo", false)
                        startActivity(Intent(this, MainCompanyActivity::class.java))
                        finish()
                    }, { err ->
                        Server.toask(this, "Erro: ${err.message}", false)
                    })
        }
    }

    private fun btOnClick(state: String) {
        val company = Company(
                txEmail.text.toString(),
                txPassword.text.toString(),
                txName.text.toString(),
                txCnpj.text.toString(),
                txRazaoSocial.text.toString(),
                txStreet.text.toString(),
                txNumber.text.toString().toInt(),
                txNeigh.text.toString(),
                txCity.text.toString(),
                txPostalCode.text.toString(),
                state)

        update(company)
    }
}
