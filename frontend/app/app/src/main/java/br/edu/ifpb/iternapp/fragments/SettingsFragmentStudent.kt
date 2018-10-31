package br.edu.ifpb.iternapp.fragments

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import br.edu.ifpb.iternapp.R
import br.edu.ifpb.iternapp.activities.add.AddCourseActivity
import br.edu.ifpb.iternapp.activities.edit.EditStudentActivity
import kotlinx.android.synthetic.main.fragment_settings_student.*

class SettingsFragmentStudent : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_settings_student, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        btDeleteStudent.setOnClickListener {

        }

        btAddCourse.setOnClickListener {
            startActivity(Intent(activity, AddCourseActivity::class.java))
        }

        btAddNetwork.setOnClickListener {

        }

        btEditStudent.setOnClickListener {
            startActivity(Intent(activity, EditStudentActivity::class.java))
        }

    }
}
