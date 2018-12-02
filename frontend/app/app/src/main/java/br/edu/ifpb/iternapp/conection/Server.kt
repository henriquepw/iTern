package br.edu.ifpb.iternapp.conection

import android.content.Context
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.github.rtoshiro.util.format.SimpleMaskFormatter
import com.github.rtoshiro.util.format.text.MaskTextWatcher
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object Server {
    private val retrofit = Retrofit.Builder()
            .baseUrl("http://itern-node-com.umbler.net/")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()

    val service = retrofit.create(APIService::class.java)!!

    var userID = 0

    val STATES = arrayOf(
            "Acre (AC)", "Alagoas (AL)", "Amapá (AP)", "Amazonas (AM)",
            "Bahia (BA)", "Ceará (CE)", "Distrito Federal (DF)", "Espírito Santo (ES)",
            "Goiás (GO)", "Maranhão (MA)", "Mato Grosso (MT)", "Mato Grosso do Sul (MS)",
            "Minas Gerais (MG)", "Pará (PA)", "Paraíba (PB)", "Paraná (PR)",
            "Pernambuco (PE)", "Piauí (PI)", "Rio de Janeiro (RJ)", "Rio Grande do Norte (RN)",
            "Rio Grande do Sul (RS)", "Rondônia (RO)", "Roraima (RR)", "Santa Catarina (SC)",
            "São Paulo (SP)", "Sergipe (SE)", "Tocantins (TO)")

    fun toask(context: Context, msg: String, duration: Boolean = true) {
        val dur = Toast.LENGTH_LONG.takeIf { duration } ?: Toast.LENGTH_SHORT

        Toast.makeText(context, msg, dur).show()
    }

    fun setMask(view: TextView, mask: String) {
        val mtw = MaskTextWatcher(view, SimpleMaskFormatter(mask))
        view.addTextChangedListener(mtw)
    }
}