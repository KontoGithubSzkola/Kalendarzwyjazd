package com.example.kalendarzwyjazd
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class Date(val time: Long) : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }
}