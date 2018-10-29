package br.edu.ifpb.iternapp.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.view.inputmethod.EditorInfo
import android.widget.TextView

import android.annotation.SuppressLint
import android.content.Intent
import android.content.pm.ActivityInfo
import android.util.Log
import android.widget.ProgressBar
import android.widget.Toast
import br.edu.ifpb.iternapp.R
import br.edu.ifpb.iternapp.conection.Server
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    private var user: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT

        password.setOnEditorActionListener(TextView.OnEditorActionListener { _, id, _ ->
            if (id == EditorInfo.IME_ACTION_DONE || id == EditorInfo.IME_NULL) {
                attemptLogin()
                return@OnEditorActionListener true
            }
            false
        })

        email_sign_in_button.setOnClickListener { attemptLogin() }
        btCompany.setOnClickListener { userOnClick("Empresa") }
        btStudent.setOnClickListener { userOnClick("Estudante") }
        btSignup.setOnClickListener { signupOnCLick() }
    }

    private fun signupOnCLick() {
        intent = Intent(this, SignupActivity::class.java)
        startActivity(intent)
    }

    private fun userOnClick(user: String) {
        this.user = user
        tvLogin.setText("Log in - $user")
    }

    @SuppressLint("CheckResult")
    private fun attemptLogin() {
        val emailStr = email.text.toString()
        val passwordStr = password.text.toString()

        var cancel = false
        var focusView: View? = null

        // Reset errors.
        email.error = null
        password.error = null

        // Check for a valid password, if the user entered one.
        if (!TextUtils.isEmpty(passwordStr) && !isPasswordValid(passwordStr)) {
            password.error = "Senha muito pequena"
            focusView = password
            cancel = true
        }

        // Check for a valid email address.
        if (TextUtils.isEmpty(emailStr)) {
            email.error = "Campo obrigatorio"
            focusView = email
            cancel = true
        } else if (!isEmailValid(emailStr)) {
            email.error = "Email invalido"
            focusView = email
            cancel = true
        }

        if (cancel) {
            focusView?.requestFocus()
        } else {
            var server = Server()
            var userId = 0

            when {
                this.user == "" ->
                    Toast.makeText(baseContext, "Empresa ou estudane?", Toast.LENGTH_SHORT)
                            .show()
                this.user == "Estudante" -> {
                    startRequest()
                    progressBarLogin.visibility = ProgressBar.VISIBLE
                    server.service.signinStudent(email.text.toString(), password.text.toString())
                            .subscribeOn(Schedulers.io())
                            .unsubscribeOn(Schedulers.computation())
                            .observeOn(AndroidSchedulers.mainThread())
                            .subscribe({ res ->
                                userId = res.id
                            }, { e ->
                                err(e)
                            }, {
                                Toast.makeText(baseContext, "Foi $userId", Toast.LENGTH_SHORT)
                                        .show()

                                intent = Intent(baseContext, MainActivity::class.java)
                                // ----------------------------------

                                startActivity(intent)
                                finish()
                            })
                }
                else -> {
                    startRequest()
                    server.service.signinCompany(email.text.toString(), password.text.toString())
                            .subscribeOn(Schedulers.io())
                            .unsubscribeOn(Schedulers.computation())
                            .observeOn(AndroidSchedulers.mainThread())
                            .subscribe({ res ->
                                userId = res.id
                            }, { e ->
                                err(e)
                            }, {
                                Toast.makeText(baseContext, "Foi $userId", Toast.LENGTH_SHORT)
                                        .show()

                                finishRequest()
                            })
                }
            }
        }
    }

    private fun isEmailValid(email: String): Boolean {
        return email.contains("@")
    }

    private fun isPasswordValid(password: String): Boolean {
        return password.length >= 4
    }

    private fun err(e: Throwable) {
        email.isEnabled = true
        password.isEnabled = true
        email_sign_in_button.isEnabled = true
        btSignup.isEnabled = true

        progressBarLogin.visibility = ProgressBar.GONE

        Toast.makeText(applicationContext, "${e.message}", Toast.LENGTH_SHORT)
                .show()
        Log.v("Error", e.message)
    }

    private fun startRequest() {
        progressBarLogin.visibility = ProgressBar.VISIBLE

        email_sign_in_button.isEnabled = false
        btSignup.isEnabled = false
        email.isEnabled = false
        password.isEnabled = false
    }

    private fun finishRequest() {
        intent = Intent(baseContext, MainActivity::class.java)
        // ----------------------------------

        startActivity(intent)
        finish()
    }
}