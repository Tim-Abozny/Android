package com.example.lab_1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity(), OnSelectedButtonListener  {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    override fun onButtonSelected(btnIndex: Int) {
        // подключаем FragmentManager
        val fragmentManager = supportFragmentManager

        // Получаем ссылку на второй фрагмент по ID
        val fragment2 = fragmentManager.findFragmentById(R.id.fragmentContainerView) as ConverterFragment?
        fragment2?.setDescription(btnIndex)
    }
}