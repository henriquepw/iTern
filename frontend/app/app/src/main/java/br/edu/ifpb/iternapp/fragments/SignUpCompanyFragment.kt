package br.edu.ifpb.iternapp.fragments

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.text.TextUtils
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*

import br.edu.ifpb.iternapp.R
import br.edu.ifpb.iternapp.activities.LoginActivity
import br.edu.ifpb.iternapp.conection.Server
import br.edu.ifpb.iternapp.entities.Company
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.fragment_signup_company.*


class SignUpCompanyFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_signup_company, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        var progress = activity!!.findViewById(R.id.progressBar) as ProgressBar

        val states = arrayOf(
                "Acre (AC)", "Alagoas (AL)", "Amapá (AP)", "Amazonas (AM)",
                "Bahia (BA)", "Ceará (CE)", "Distrito Federal (DF)", "Espírito Santo (ES)",
                "Goiás (GO)", "Maranhão (MA)", "Mato Grosso (MT)", "Mato Grosso do Sul (MS)",
                "Minas Gerais (MG)", "Pará (PA)", "Paraíba (PB)", "Paraná (PR)",
                "Pernambuco (PE)", "Piauí (PI)", "Rio de Janeiro (RJ)", "Rio Grande do Norte (RN)",
                "Rio Grande do Sul (RS)", "Rondônia (RO)", "Roraima (RR)", "Santa Catarina (SC)",
                "São Paulo (SP)", "Sergipe (SE)", "Tocantins (TO)")

        var state: String? = null

        spStates.setAdapter(ArrayAdapter<String>(activity, android.R.layout.simple_spinner_dropdown_item, states))

        spStates.onItemClickListener = AdapterView.OnItemClickListener { _, _, position, _ ->
            state = states[position]
            Toast.makeText(activity, states[position], Toast.LENGTH_SHORT).show()
        }

        btSignup.setOnClickListener {
            var cancel = false
            var focusView: View? = null

            val textViews = arrayOf(
                    txEemail, txPassword, txName,
                    txCnpj, txRazaoSocial,
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

            for (tx in 0 until textViews.size) {
                if (TextUtils.isEmpty(textViews[tx].text.toString())) {
                    textViews[tx].error = "Esse campo precisa ser preenchido"
                    focusView = textViews[tx]
                    cancel = true
                }
            }

            if (!cancel) {
                val company = Company(
                        txEemail.text.toString(),
                        txPassword.text.toString(),
                        txName.text.toString(),
                        txCnpj.text.toString(),
                        txRazaoSocial.text.toString(),
                        txStreet.text.toString(),
                        txNumber.text.toString().toInt(),
                        txNeigh.text.toString(),
                        txCity.text.toString(),
                        txPostalCode.text.toString(),
                        state!!)

                Log.i("Company ---------------", company.toString())

                val service = Server().service
                service.insertCompany(company)
                        .subscribeOn(Schedulers.io())
                        .unsubscribeOn(Schedulers.computation())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe({ _ ->
                            progress.visibility = ProgressBar.VISIBLE
                        }, {
                            Toast.makeText(activity, "${it.message}", Toast.LENGTH_SHORT)
                                    .show()
                            Log.v("Error", it.message)
                        }, {
                            Toast.makeText(activity, "Cadastrado!", Toast.LENGTH_SHORT)
                                    .show()

                            startActivity(Intent(activity, LoginActivity::class.java))
                            activity!!.finish()
                        })
            } else {
                focusView?.requestFocus()
                Toast.makeText(activity, "Preencha os obrigatorios", Toast.LENGTH_SHORT)
                        .show()
            }
        }
    }
}
