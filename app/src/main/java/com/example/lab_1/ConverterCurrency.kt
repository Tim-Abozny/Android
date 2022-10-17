package com.example.lab_1

import java.lang.Exception
import java.math.BigDecimal

class ConverterCurrency : Converter() {
    private val fromCh: String = ""
    private val toCh: String = ""

    private var convertOperation: ((BigDecimal) -> BigDecimal) = { v: BigDecimal -> v }

    override fun convert(from_unit: String, to_unit: String, value: String): String {
        val valueDouble: BigDecimal
        try {
            valueDouble = value.toBigDecimal()
        } catch (e: Exception) {
            return ""
        }

        if (fromCh != from_unit || toCh != to_unit) {
            if (from_unit == "dollars" && to_unit == "dollars") {

                convertOperation = {v: BigDecimal -> v}
            }
            else if(from_unit == "dollars" && to_unit == "euro") {
                val buf = 1.0026
                convertOperation = {v: BigDecimal -> v.multiply(buf.toString().toBigDecimal())}
            }
            else if(from_unit == "dollars" && to_unit == "rubles") {
                val buf = 2.532
                convertOperation = {v: BigDecimal -> v.multiply(buf.toString().toBigDecimal())}
            }
            else if(from_unit == "euro" && to_unit == "euro") {

                convertOperation = {v: BigDecimal -> v}
            }
            else if(from_unit == "euro" && to_unit == "dollars") {
                val buf = 0.997
                convertOperation = {v: BigDecimal -> v.multiply(buf.toString().toBigDecimal())}
            }
            else if(from_unit == "euro" && to_unit == "rubles") {
                val buf = 2.525
                convertOperation = {v: BigDecimal -> v.multiply(buf.toString().toBigDecimal())}
            }
            else if(from_unit == "rubles" && to_unit == "rubles") {

                convertOperation = {v: BigDecimal -> v}
            }
            else if(from_unit == "rubles" && to_unit == "dollars") {
                val buf = 0.3949
                convertOperation = {v: BigDecimal -> v.multiply(buf.toString().toBigDecimal())}
            }
            else if(from_unit == "rubles" && to_unit == "euro") {
                val buf = 0.396
                convertOperation = {v: BigDecimal -> v.multiply(buf.toString().toBigDecimal())}
            }
        }

        return convertOperation(valueDouble).toString()
    }
}