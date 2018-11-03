package br.edu.ifpb.iternapp.activities.edit

import android.content.pm.ActivityInfo
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import br.edu.ifpb.iternapp.R
import br.edu.ifpb.iternapp.conection.Server
import kotlinx.android.synthetic.main.activity_edit_company.*

class EditCompanyActivity : AppCompatActivity() {

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
    }
}
