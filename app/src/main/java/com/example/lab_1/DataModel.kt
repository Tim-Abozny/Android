package com.example.lab_1

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

open class DataModel : ViewModel() {
    private lateinit var _data: MutableLiveData<String>
    var data: MutableLiveData<String>
        get() = _data
        set(value){
            _data = value
        }

    init {
        this._data.value = ""
    }


}