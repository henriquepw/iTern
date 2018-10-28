package br.edu.ifpb.iternapp.activities

import android.content.pm.ActivityInfo
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.view.Menu
import br.edu.ifpb.iternapp.R
import br.edu.ifpb.iternapp.fragments.HomeFragment
import br.edu.ifpb.iternapp.fragments.SearchFragment
import br.edu.ifpb.iternapp.fragments.SettingsFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val maneger = supportFragmentManager

    private val mOnNavigationItemSelectedListener = BottomNavigationView
            .OnNavigationItemSelectedListener { item ->
                when (item.itemId) {
                    R.id.navHome -> {
                        val user = intent.getStringExtra("user")
                        val frag = HomeFragment()
                        frag.setTitule(user)
                        startFragment(frag)
                        return@OnNavigationItemSelectedListener true
                    }
                    R.id.navSettings -> {
                        startFragment(SettingsFragment())
                        return@OnNavigationItemSelectedListener true
                    }
                    R.id.navSearch -> {
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
        maneger.beginTransaction()
                .replace(R.id.fragContainer, fragment)
                .commit()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        super.onCreateOptionsMenu(menu)
        menuInflater.inflate(R.menu.main, menu)
        return true
    }
}
