package com.deliveryhero.godroid.tech.exam.ui.main

import android.os.Bundle
import com.deliveryhero.godroid.tech.exam.R.id
import com.deliveryhero.godroid.tech.exam.R.layout
import dagger.android.support.DaggerAppCompatActivity

class MainActivity : DaggerAppCompatActivity() {

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
