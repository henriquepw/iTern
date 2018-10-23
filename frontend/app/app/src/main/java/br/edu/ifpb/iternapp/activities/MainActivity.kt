package br.edu.ifpb.iternapp.activities

import android.content.pm.ActivityInfo
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import br.edu.ifpb.iternapp.R
import br.edu.ifpb.iternapp.fragments.HomeFragment
import br.edu.ifpb.iternapp.fragments.SearchFragment
import br.edu.ifpb.iternapp.fragments.SettingsFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val maneger = supportFragmentManager

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navHome -> {
                startFragment(HomeFragment())
                return@OnNavigationItemSelectedListener true
            }
            R.id.navSearch -> {
                startFragment(SettingsFragment())
                return@OnNavigationItemSelectedListener true
            }
            R.id.navSettings -> {
                startFragment(SearchFragment())
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        startFragment(HomeFragment())

        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
    }

    private fun startFragment(fragment: Fragment) {
        val transaction = maneger.beginTransaction()

        transaction.replace(R.id.fragContainer, fragment)
        transaction.commit()
    }
}
