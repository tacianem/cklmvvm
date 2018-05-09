package com.example.tacianemartimiano.cklmvvm.modules.base

import android.support.v7.app.AppCompatActivity

abstract class BaseActivity : AppCompatActivity() {

    fun showBackButton() {
        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

}