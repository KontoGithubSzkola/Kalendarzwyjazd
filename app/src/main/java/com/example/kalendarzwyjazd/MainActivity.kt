package com.example.kalendarzwyjazd


import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.CalendarView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.text.SimpleDateFormat
import kotlin.math.absoluteValue

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    //zmienne przyciski
    val data_przyjazdu = findViewById<Button>(R.id.poczatek)
    val data_wyjazdu = findViewById<Button>(R.id.Koniec)
    val rezerwuj = findViewById<Button>(R.id.rezerwacja)

    //zmienne textview
    val czastrwania = findViewById<TextView>(R.id.textView)
    val wyjazd = findViewById<TextView>(R.id.text4)
    val przyjazd = findViewById<TextView>(R.id.text5)

    //Zamaina formatu daty
    @SuppressLint("SimpleDateFormat")
    fun zmian(czas: Long): List<Int>{
        val date = Date(czas)
        val dateFormat = SimpleDateFormat("dd/MM/yyyy")
        val formDate = dateFormat.format(date).split("/").map {
            it.toInt()
        }
        return formDate
    }

    @SuppressLint("SetTextI18n")
    fun rezerwacja(koniec: MutableList<Int>, poczatek : MutableList<Int>, czastrwania : TextView) {
        val wyjazdoblicz = (poczatek[2] * 360) + (poczatek[1] * 30) + poczatek[0]
        val przyjazdoblicz = (koniec[2] * 360) + (koniec[1] * 30) + koniec[0]
        val iloscdni = wyjazdoblicz.toChar() - przyjazdoblicz.toChar()
        czastrwania.text = " ${System.lineSeparator()}${iloscdni.absoluteValue + 1}"
    }

    //Podmienianie daty
    fun podm(koniec: MutableList<Int>, poczatek : MutableList<Int>, przyjazd : TextView, wyjazd : TextView) {
        if(poczatek[0] > koniec[0]){
            for (i in 0 until 3) {
                poczatek[i]
            }
            przyjazd.text = wyjazd.text
            wyjazd.text = "${System.lineSeparator()}${poczatek[0]}-${poczatek[1]}-${poczatek[2]}"
        }
        else if(poczatek[0] == koniec[0]){
            if(poczatek[1] > koniec[1]){
                for (i in 0 until 3) {
                    poczatek[i]
                }
                przyjazd.text = wyjazd.text
                wyjazd.text = "${System.lineSeparator()}${poczatek[0]}-${poczatek[1]}-${poczatek[2]}"
            }
            else if(poczatek[1] == koniec[1]){
                if(poczatek[2] > koniec[2]){
                    for (i in 0 until 3) {
                        poczatek[i]
                    }
                    przyjazd.text = wyjazd.text
                    wyjazd.text = "${System.lineSeparator()}${poczatek[0]}-${poczatek[1]}-${poczatek[2]}"
                }
            }
        }
    }

    //inne zmienne
    val kalendarz = findViewById<CalendarView>(R.id.calendar)
    val poczatek = mutableListOf(0,0,0)
    val koniec = mutableListOf(0,0,0)
    val data = arrayListOf(zmian(kalendarz.date)[0] ,zmian(kalendarz.date)[1] ,zmian(kalendarz.date)[2])

    kalendarz.minDate = Date(0).time
    kalendarz.maxDate = Date(0).time + 63115200000


    //Lista
    kalendarz.setOnDateChangeListener{_, d, m, y ->
        data[0] = y
        data[1] = m+1
        data[2] = d
    }


        rezerwuj.setOnClickListener{
            podm(koniec,poczatek,przyjazd,wyjazd)
            rezerwacja(poczatek, koniec, czastrwania)
        }
        data_przyjazdu.setOnClickListener {
            for (i in 0 until 3)
                poczatek[i] = data[i]
            przyjazd.text =  "${System.lineSeparator()}${poczatek[0]}-${poczatek[1]}-${poczatek[2]}"
        }

        data_wyjazdu.setOnClickListener {
            for (i in 0 until 3)
                koniec[i] = data[i]
            wyjazd.text = "${System.lineSeparator()}${koniec[0]}-${koniec[1]}-${koniec[2]}"
        }








}
}
