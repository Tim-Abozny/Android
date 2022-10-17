package com.example.lab_1

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import android.widget.AdapterView.OnItemSelectedListener
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider


class Fragment1 : Fragment(), OnItemSelectedListener {
    private var converter: Converter? = null

    private lateinit var viewModel: DataModel
    private lateinit var unitList: Spinner
    private lateinit var listFrom: Spinner
    private lateinit var listTo: Spinner
    private lateinit var convertButton: Button
    private  lateinit var textFrom: EditText
    private  lateinit var textTo: EditText

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_1, container, false)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = ViewModelProvider(this)[DataModel::class.java]
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        unitList = view.findViewById(R.id.unitList)
        listFrom = view.findViewById(R.id.listFrom)
        listTo = view.findViewById(R.id.listTo)
        textTo = view.findViewById(R.id.textTo)
        textFrom = view.findViewById(R.id.textFrom)
        convertButton = view.findViewById(R.id.b_Convert)

        viewModel.data.observe(this.viewLifecycleOwner, Observer{
            if (textFrom.text.toString() == "" && it == "0")
                textFrom.setText("0.")
            else
                if (it == "kill") {
                    textFrom.text.clear()
                    textTo.text.clear()
                } else
                    textFrom.text.append(it)
        })

        convertButton.setOnClickListener {

            if (textFrom.text.toString() == "")
                textTo.setText("")
            else if (textFrom.text.toString() == "0." || textFrom.text.toString() == "0.0")
                textTo.setText("0")
            else if (textFrom.text.lastIndex > 12)
                textTo.setText("Введите меньше")
            else {
                textTo.setText(converter?.convert(listFrom.selectedItem.toString(),
                    listTo.selectedItem.toString(), textFrom.text.toString()) ?: "345678")
            }
        }
    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {

        when (parent!!.id) {
            R.id.unitList -> {
                selectedItem()
            }
        }
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
        TODO("Not yet implemented")
    }

    private fun selectedItem()
    {
        when (unitList.selectedItem.toString()) {
            "weight" -> {
                ArrayAdapter.createFromResource(
                    listFrom.context,
                    R.array.convertListWeight,
                    android.R.layout.simple_spinner_item
                ).also { adapter ->
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                    listFrom.adapter = adapter
                }
                ArrayAdapter.createFromResource(
                    listTo.context,
                    R.array.convertListWeight,
                    android.R.layout.simple_spinner_item
                ).also { adapter ->
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                    listTo.adapter = adapter
                }

            }
            "distance" -> {
                ArrayAdapter.createFromResource(
                    listFrom.context,
                    R.array.convertListDistance,
                    android.R.layout.simple_spinner_item
                ).also { adapter ->
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                    listFrom.adapter = adapter
                }
                ArrayAdapter.createFromResource(
                    listTo.context,
                    R.array.convertListDistance,
                    android.R.layout.simple_spinner_item
                ).also { adapter ->
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                    listTo.adapter = adapter
                }
            }
            "currency" -> {
                ArrayAdapter.createFromResource(
                    listFrom.context,
                    R.array.convertListCurrency,
                    android.R.layout.simple_spinner_item
                ).also { adapter ->
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                    listFrom.adapter = adapter
                }
                ArrayAdapter.createFromResource(
                    listTo.context,
                    R.array.convertListCurrency,
                    android.R.layout.simple_spinner_item
                ).also { adapter ->
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                    listTo.adapter = adapter
                }
            }
        }
        converter = Converter.returnConverter(unitList.selectedItem.toString())
    }
}