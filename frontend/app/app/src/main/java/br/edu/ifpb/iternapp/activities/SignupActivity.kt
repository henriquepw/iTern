package br.edu.ifpb.iternapp.activities

import android.content.pm.ActivityInfo
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import br.edu.ifpb.iternapp.R
import br.edu.ifpb.iternapp.fragments.SignUpCompanyFragment
import br.edu.ifpb.iternapp.fragments.SignUpStudentFragment
import kotlinx.android.synthetic.main.activity_signup.*

class SignupActivity : AppCompatActivity() {

    private val maneger = supportFragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)
        setSupportActionBar(toolSignup)
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT

        btSignCompany.setOnClickListener { startFragment(SignUpCompanyFragment()) }
        btSignStudant.setOnClickListener { startFragment(SignUpStudentFragment()) }
    }

    private fun startFragment(fragment: Fragment) {
        val transaction = maneger.beginTransaction()

        transaction.replace(R.id.fragContainer, fragment)
        transaction.commit()
    }
}
