package br.edu.ifpb.iternapp.activities

import android.content.Intent
import android.content.pm.ActivityInfo
import android.graphics.drawable.AnimationDrawable
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import br.edu.ifpb.iternapp.R

class SplashActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT

        val image = findViewById<ImageView>(R.id.image)
        image.setBackgroundResource(R.drawable.loader)

        val load = image.background as AnimationDrawable
        load.start()

        object : Thread() {
            override fun run() {
                super.run()
                try {
                    Thread.sleep(2000)

                    val intent = Intent(baseContext, LoginActivity::class.java)
                    startActivity(intent)
                    finish()
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }
        }.start()

    }
}
