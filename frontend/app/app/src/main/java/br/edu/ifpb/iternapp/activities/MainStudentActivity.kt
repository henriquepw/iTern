package br.edu.ifpb.iternapp.activities

import android.content.Intent
import android.content.pm.ActivityInfo
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.view.Menu
import android.view.MenuItem
import br.edu.ifpb.iternapp.R
import br.edu.ifpb.iternapp.fragments.company.HomeFragmentCompany
import br.edu.ifpb.iternapp.fragments.student.HomeFragmentStudent
import br.edu.ifpb.iternapp.fragments.student.SearchFragmentStudent
import br.edu.ifpb.iternapp.fragments.student.SettingsFragmentStudent
import kotlinx.android.synthetic.main.activity_main.*

class MainStudentActivity : AppCompatActivity() {

    private val maneger = supportFragmentManager

    private val mOnNavigationItemSelectedListener = BottomNavigationView
            .OnNavigationItemSelectedListener { item ->
                when (item.itemId) {
                    R.id.navHome -> {
                        startFragment(HomeFragmentStudent())
                        return@OnNavigationItemSelectedListener true
                    }
                    R.id.navSettings -> {
                        startFragment(SettingsFragmentStudent())
                        return@OnNavigationItemSelectedListener true
                    }
                    R.id.navSearch -> {
                        startFragment(SearchFragmentStudent())
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
        startFragment(HomeFragmentCompany())

        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
    }

    private fun startFragment(fragment: Fragment) {
        maneger.beginTransaction()
                .replace(R.id.fragContainer, fragment)
                .commit()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        super.onCreateOptionsMenu(menu)
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        super.onOptionsItemSelected(item)

        if (item?.itemId == R.id.exit) {
            startActivity(Intent(baseContext, LoginActivity::class.java))
            finish()
        }

        return true
    }
}
