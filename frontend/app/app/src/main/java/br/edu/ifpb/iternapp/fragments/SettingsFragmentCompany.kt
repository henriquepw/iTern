package br.edu.ifpb.iternapp.fragments

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import br.edu.ifpb.iternapp.R
import br.edu.ifpb.iternapp.activities.add.AddVacancyActivity
import br.edu.ifpb.iternapp.activities.edit.EditCompanyActivity
import kotlinx.android.synthetic.main.fragment_settings_company.*

class SettingsFragmentCompany : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_settings_company, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        btDeleteCompany.setOnClickListener {

        }

        btAddVacancy.setOnClickListener {
            startActivity(Intent(activity, AddVacancyActivity::class.java))
        }

        btEditCompany.setOnClickListener {
            startActivity(Intent(activity, EditCompanyActivity::class.java))
        }
    }
}
