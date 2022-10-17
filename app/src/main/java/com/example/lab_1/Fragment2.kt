package com.example.lab_1

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Switch
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.graphics.drawable.toDrawable
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import com.example.lab_1.databinding.Fragment2Binding

class Fragment2 : Fragment() {

    private lateinit var viewModel: DataModel
    private lateinit var fragment2 : ConstraintLayout
    private  lateinit var switch : Switch
    private lateinit var button1: Button
    private lateinit var button2: Button
    private lateinit var button3: Button
    private lateinit var button4: Button
    private lateinit var button5: Button
    private lateinit var button6: Button
    private lateinit var button7: Button
    private lateinit var button8: Button
    private lateinit var button9: Button
    private lateinit var button0: Button
    private lateinit var buttonDot: Button
    private lateinit var buttonDot2: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_2, container, false)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = ViewModelProvider(this)[DataModel::class.java]
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        button1 = view.findViewById(R.id.button1)
        button2 = view.findViewById(R.id.button2)
        button3 = view.findViewById(R.id.button3)
        button4 = view.findViewById(R.id.button4)
        button5 = view.findViewById(R.id.button5)
        button6 = view.findViewById(R.id.button6)
        button7 = view.findViewById(R.id.button7)
        button8 = view.findViewById(R.id.button8)
        button9 = view.findViewById(R.id.button9)
        button0 = view.findViewById(R.id.button0)
        buttonDot = view.findViewById(R.id.buttonDot)
        buttonDot2 = view.findViewById(R.id.buttonDot2)
        fragment2 = view.findViewById(R.id.frag2)
        switch = view.findViewById(R.id.switchPremium)

        button1.setOnClickListener {
            viewModel.data.value = "1"
        }
        button2.setOnClickListener {
            viewModel.data.value = "2"
        }
        button3.setOnClickListener {
            viewModel.data.value = "3"
        }
        button4.setOnClickListener {
            viewModel.data.value = "4"
        }
        button5.setOnClickListener {
            viewModel.data.value = "5"
        }
        button6.setOnClickListener {
            viewModel.data.value = "6"
        }
        button7.setOnClickListener {
            viewModel.data.value = "7"
        }
        button8.setOnClickListener {
            viewModel.data.value = "8"
        }
        button9.setOnClickListener {
            viewModel.data.value = "9"
        }
        button0.setOnClickListener {
            viewModel.data.value = "0"
        }
        buttonDot.setOnClickListener {
            viewModel.data.value = "."
        }
        buttonDot2.setOnClickListener {
            viewModel.data.value = "kill"
        }

        switch.setOnClickListener{
            if (switch.isChecked) {
                fragment2.background = Color.BLACK.toDrawable()
                switch.setTextColor(Color.WHITE)
            }
            else if (!switch.isChecked) {
                fragment2.background = Color.WHITE.toDrawable()
                switch.setTextColor(Color.BLACK)
            }
        }
    }
}