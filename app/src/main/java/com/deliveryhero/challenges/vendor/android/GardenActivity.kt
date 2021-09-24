package com.deliveryhero.challenges.vendor.android

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.deliveryhero.challenges.vendor.android.databinding.ActivityGardenBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class GardenActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_garden)
    }
}
