package com.example.lab_1

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnLongClickListener
import android.view.ViewGroup
import android.widget.Button
import android.widget.Switch
import androidx.appcompat.app.AppCompatDelegate
import androidx.fragment.app.Fragment


interface OnSelectedButtonListener {
    fun onButtonSelected(btnIndex: Int)
}

class KeyboardFragment : Fragment(), View.OnClickListener, OnLongClickListener {

    private lateinit var btn1: Button
    private lateinit var btn2: Button
    private lateinit var btn3: Button
    private lateinit var btn4: Button
    private lateinit var btn5: Button
    private lateinit var btn6: Button
    private lateinit var btn7: Button
    private lateinit var btn8: Button
    private lateinit var btn9: Button
    private lateinit var btn0: Button
    private lateinit var btnPoint: Button
    private lateinit var btnClean: Button
    private  lateinit var switch : Switch

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btn1 = view.findViewById(R.id.button1)
        btn2 = view.findViewById(R.id.button2)
        btn3 = view.findViewById(R.id.button3)
        btn4 = view.findViewById(R.id.button4)
        btn5 = view.findViewById(R.id.button5)
        btn6 = view.findViewById(R.id.button6)
        btn7 = view.findViewById(R.id.button7)
        btn8 = view.findViewById(R.id.button8)
        btn9 = view.findViewById(R.id.button9)
        btn0 = view.findViewById(R.id.button0)
        btnPoint = view.findViewById(R.id.buttonDot)
        btnClean = view.findViewById(R.id.buttonKill)
        switch = view.findViewById(R.id.switchPremium)

        btn1.setOnClickListener(this)
        btn2.setOnClickListener(this)
        btn3.setOnClickListener(this)
        btn4.setOnClickListener(this)
        btn5.setOnClickListener(this)
        btn6.setOnClickListener(this)
        btn7.setOnClickListener(this)
        btn8.setOnClickListener(this)
        btn9.setOnClickListener(this)
        btn0.setOnClickListener(this)
        btnPoint.setOnClickListener(this)
        btnClean.setOnClickListener(this)
        btnClean.setOnLongClickListener(this)

        switch.setOnClickListener{
            if (switch.isChecked) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            }
            else if (!switch.isChecked) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            }
        }

    }

    override fun onClick(v: View?) {
        val btnIndex = fromIdToIndex(v!!.id)

        val listener = activity as OnSelectedButtonListener?
        listener?.onButtonSelected(btnIndex)
    }

    private fun fromIdToIndex(id: Int): Int {
        var index = -1

        when (id) {
            R.id.button0 -> index = 0
            R.id.button1 -> index = 1
            R.id.button2 -> index = 2
            R.id.button3 -> index = 3
            R.id.button4 -> index = 4
            R.id.button5 -> index = 5
            R.id.button6 -> index = 6
            R.id.button7 -> index = 7
            R.id.button8 -> index = 8
            R.id.button9 -> index = 9
            R.id.buttonDot -> index = 10
            R.id.buttonKill -> index = 11
        }
        return index
    }

    override fun onLongClick(v: View?): Boolean {
        val listener = activity as OnSelectedButtonListener?

        listener?.onButtonSelected(12)
        return true
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.keyboard_frag, container, false)
    }

}