package br.edu.ifpb.iternapp.activities

import android.content.pm.ActivityInfo
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import br.edu.ifpb.iternapp.R
import br.edu.ifpb.iternapp.fragments.HomeFragment
import br.edu.ifpb.iternapp.fragments.SearchFragment
import br.edu.ifpb.iternapp.fragments.SettingsFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var flag = 0
    private val maneger = supportFragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        setSupportActionBar(toolbar)
        startHomeFragment()

    }

    private fun startHomeFragment() {
        flag = 1
        val transaction = maneger.beginTransaction()
        val fragment = HomeFragment()

        transaction.replace(R.id.fragContainer, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }

    private fun startSettinsFragment() {
        flag = 2
        val fragment = SettingsFragment()
        trans(fragment)
    }

    private fun startSearchFragment() {
        flag = 3
        val fragment = SearchFragment()
        trans(fragment)
    }

    private fun trans(fragment: Fragment) {
        val transaction = maneger.beginTransaction()

        transaction.replace(R.id.fragContainer, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }
}
