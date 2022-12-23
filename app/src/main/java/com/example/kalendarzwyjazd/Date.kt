package com.example.kalendarzwyjazd
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class Date : AppCompatActivity() {

    val time: Long

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.kalendarz)

    }
}