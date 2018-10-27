package br.edu.ifpb.iternapp.fragments

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.support.design.widget.TextInputEditText
import android.support.v4.app.Fragment
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import android.widget.AdapterView.OnItemClickListener

import br.edu.ifpb.iternapp.R
import com.github.rtoshiro.util.format.SimpleMaskFormatter
import com.github.rtoshiro.util.format.text.MaskTextWatcher
import kotlinx.android.synthetic.main.dialog_network_choice.view.*
import kotlinx.android.synthetic.main.fragment_signup_student.*


class SignUpStudentFragment : Fragment() {

    private var builder: AlertDialog.Builder? = null
    private var dialog: Dialog? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_signup_student, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        builder = AlertDialog.Builder(activity)

        setMask(txDate, "NN/NN/NNNN")
        setMask(txPhone, "(NN) NNNNN-NNNN")

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

        spStates.onItemClickListener = OnItemClickListener { parent, view, position, id ->
            state = states[position]
            Toast.makeText(activity, "Foi ${states[position]}", Toast.LENGTH_SHORT).show()
        }

        btNext.setOnClickListener {
            var cancel = false
            var focusView: View? = null

            val textViews = arrayOf(
                    txEemail,
                    txPassword,
                    txName,
                    txDate,
                    txCpf,
                    txRG,
                    txNaturalidade,
                    txNacionalidade,
                    txPhone,
                    txStreet,
                    txNumber,
                    txNeigh,
                    txCity,
                    txPostalCode)

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

            if (txPassword.text.toString().length > 4) {
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

            for (tx in 0 until textViews.size) {
                if (TextUtils.isEmpty(textViews[tx].text.toString())) {
                    textViews[tx].error = "Esse campo precisa ser preenchido"
                    focusView = textViews[tx]
                    cancel = true
                }
            }

            if (cancel) {
                val choice = layoutInflater
                        .inflate(R.layout.dialog_network_choice, null)

                val network = layoutInflater
                        .inflate(R.layout.dialog_network, null)

                /*choice.btNo.setOnClickListener {
                    dialog?.dismiss()
                }

                choice.btYes.setOnClickListener {
                    dialog?.dismiss()

                    showDialog(network)
                }*/

                showDialog(network)
            } else {
                focusView?.requestFocus()
                Toast.makeText(activity, "Preencha os obrigatorios", Toast.LENGTH_LONG)
                        .show()
            }
        }
    }

    private fun showDialog(view: View) {
        builder?.setView(view)
        dialog = builder?.create()
        dialog?.show()
    }

    private fun setMask(view: EditText, mask: String) {
        val mtw = MaskTextWatcher(view, SimpleMaskFormatter(mask))
        view.addTextChangedListener(mtw)
    }
}
