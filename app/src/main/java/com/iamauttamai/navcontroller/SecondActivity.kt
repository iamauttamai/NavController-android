package com.iamauttamai.navcontroller

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.iamauttamai.navcontroller.databinding.ActivityMainBinding
import com.iamauttamai.navcontroller.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        binding.text.text = intent.getStringExtra("data")
        setContentView(binding.root)
    }

    @Deprecated("Deprecated in Java")
    override fun onBackPressed() {
        val data = Intent()
        data.putExtra("data", "Hello, Programmer!")
        setResult(RESULT_OK, data)
        finish()
    }
}