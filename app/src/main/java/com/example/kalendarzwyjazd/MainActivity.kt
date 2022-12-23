package com.example.kalendarzwyjazd

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CalendarView
import android.widget.TextView
import java.text.SimpleDateFormat
import java.util.*
import kotlin.math.absoluteValue

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    //zmienne przyciski
    val data_przyjazdu = findViewById<Button>(R.id.poczatek)
    val data_wyjazdu = findViewById<Button>(R.id.Koniec)
    val rezerwuj = findViewById<Button>(R.id.rezerwacja)

    //zmienne textview
    val czastrwania = findViewById<TextView>(R.id.textView)
    val wyjazd = findViewById<TextView>(R.id.text4)
    val przyjazd = findViewById<TextView>(R.id.text5)

    //Zamaina formatu daty
    fun zmian(czas: Long): List<Int>{
        val date = Date(czas)
        val dateFormat = SimpleDateFormat("dd/MM/yyyy")
        val formDate = dateFormat.format(date).split("/").map {
            it.toInt()
        }
        return formDate
    }

    fun rezerwacja(koniec: MutableList<Int>, poczatek : MutableList<Int>, czas_trwania : TextView) {
        val wyjazdoblicz = (poczatek[2] * 360) + (poczatek[1] * 30) + poczatek[0]
        val przyjazdoblicz = (koniec[2] * 360) + (koniec[1] * 30) + koniec[0]
        val iloscdni = wyjazdoblicz.toChar() - przyjazdoblicz.toChar()
        czastrwania.text = " ${System.lineSeparator()}${iloscdni.absoluteValue + 1}"
    }





}