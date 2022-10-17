package com.example.lab_1

import java.io.Serializable

abstract class Converter() : Serializable {
    abstract fun convert(from_unit: String, to_unit: String, value: String): String

    companion object {
        fun returnConverter(unit: String): Converter? {
            return when (unit) {
                "weight" -> ConverterWeights()
                "distance" -> ConverterDistance()
                "currency" -> ConverterCurrency()
                else -> null
            }
        }
    }
}