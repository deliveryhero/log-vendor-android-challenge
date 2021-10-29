package com.deliveryhero.godroid.tech.exam.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.deliveryhero.godroid.tech.exam.R.id
import com.deliveryhero.godroid.tech.exam.R.layout
import com.deliveryhero.godroid.tech.exam.ui.main.MainFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout.main_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(id.container, MainFragment.newInstance())
                .commitNow()
        }
    }
}
