package com.unikom.latihandatalocal

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var sharedPref: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sharedPref = this.getSharedPreferences(loginKey, MODE_PRIVATE)

        if (getLogin().username != "" && getLogin().password != "") {
            startToHelloActivity(getAccount().username)
        }

        btn_login.setOnClickListener {
            if (edtusername.text.toString() == getAccount().username &&
                edtpassword.text.toString() == getAccount().password
            ) {
                saveLogin()
                startToHelloActivity(getAccount().username)
            } else {
                Toast.makeText(this, "Salah Password gan", Toast.LENGTH_SHORT)
                    .show()
            }
        }

        tv_signup.setOnClickListener {
            startToSignUpActivity()
        }
    }

    fun startToHelloActivity(username: String) {
        val i = Intent(this, HelloActivity::class.java)
        i.putExtra(usernamekey, username)
        startActivity(i)
    }

    fun startToSignUpActivity() {
        val i = Intent(this, SignUpActivity::class.java)
        startActivity(i)
    }

    private fun saveLogin() {
        val pref = this.getSharedPreferences(statusLogin, MODE_PRIVATE)
        with(pref.edit()) {
            putString(usernamekey, edtusername.text.toString())
            putString(passwordkey, edtpassword.text.toString())
            commit()
        }
    }

    private fun getAccount(): Account {
        return Account(
            sharedPref.getString(usernamekey, "")!!,
            sharedPref.getString(passwordkey, "")!!
        )
    }

    fun getLogin(): Account {
        val pref = this.getSharedPreferences(statusLogin, MODE_PRIVATE)
        return Account(
            pref.getString(usernamekey, "")!!,
            pref.getString(passwordkey, "")!!
        )
    }

    companion object {
        val statusLogin = "status_login"
        val loginKey = "login_key"
        val usernamekey = "username"
        val passwordkey = "password"
    }
}
