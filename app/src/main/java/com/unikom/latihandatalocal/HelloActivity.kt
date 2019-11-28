package com.unikom.latihandatalocal

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.unikom.latihandatalocal.MainActivity.Companion.loginKey
import com.unikom.latihandatalocal.MainActivity.Companion.usernamekey
import kotlinx.android.synthetic.main.activity_hello.*

class HelloActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hello)

        val username = intent.getStringExtra(usernamekey)
        hello_username.text = username
    }

    fun removeAccount() {
        val sharedPref = this.getSharedPreferences(loginKey, MODE_PRIVATE)
        sharedPref.edit().clear().apply()
        finish()
    }


}
