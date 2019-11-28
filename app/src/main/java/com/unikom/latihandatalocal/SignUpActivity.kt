package com.unikom.latihandatalocal

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_sign_up.*

class SignUpActivity : AppCompatActivity() {
    private lateinit var sharedPref: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        sharedPref = this.getSharedPreferences(MainActivity.loginKey, MODE_PRIVATE)

        btn_signup.setOnClickListener {
            if (signupedtusername.text.toString() == "" ||
                signupedtpassword.text.toString() == "") {
                Toast.makeText(this, "Tidak boleh kosong kang",
                    Toast.LENGTH_SHORT).show()
            } else {
                saveAccount()
                startActivity(Intent(this, MainActivity::class.java))
            }
        }
    }

    private fun saveAccount() {
        with(sharedPref.edit()) {
            putString(
                MainActivity.usernamekey,
                signupedtusername.text.toString()
            )
            putString(
                MainActivity.passwordkey,
                signupedtpassword.text.toString()
            )
            commit()
        }
    }

}
