package com.example.lab_1

import java.lang.Exception
import java.math.BigDecimal

class ConverterWeights: Converter() {
    private val fromCh: String = ""
    private val toCh: String = ""
    private var convertOperation: ((BigDecimal) -> BigDecimal) = {v: BigDecimal -> v}

    override fun convert(from_unit: String, to_unit: String, value: String): String {
        val valueDouble: BigDecimal
        try {
            valueDouble = value.toBigDecimal()

            println("str = $value\tdouble = $valueDouble\tlen=${value.length}")
        }
        catch (e: Exception){
            return ""
        }

        if (fromCh != from_unit || toCh != to_unit) {
            if (from_unit == "tons" && to_unit == "kilograms") {
                val buf = 1000.0
                convertOperation = {v: BigDecimal -> v.multiply(buf.toString().toBigDecimal())}
            }
            else if(from_unit == "tons" && to_unit == "grams") {
                val buf = 1000000.0
                convertOperation = {v: BigDecimal -> v.multiply(buf.toString().toBigDecimal())}
            }
            else if(from_unit == "tons" && to_unit == "tons") {
                convertOperation = {v: BigDecimal -> v}
            }
            else if(from_unit == "kilograms" && to_unit == "grams") {
                val buf = 1000.0
                convertOperation = {v: BigDecimal -> v.multiply(buf.toString().toBigDecimal())}
            }
            else if(from_unit == "kilograms" && to_unit == "tons") {
                val buf = 0.001
                convertOperation = {v: BigDecimal -> v.multiply(buf.toString().toBigDecimal())}
            }
            else if(from_unit == "kilograms" && to_unit == "kilograms") {
                convertOperation = {v: BigDecimal -> v}
            }
            else if(from_unit == "grams" && to_unit == "tons") {
                val buf = 0.000001
                convertOperation = {v: BigDecimal -> v.multiply(buf.toString().toBigDecimal())}
            }
            else if(from_unit == "grams" && to_unit == "kilograms") {
                val buf = 0.001
                convertOperation = {v: BigDecimal -> v.multiply(buf.toString().toBigDecimal())}
            }
            else if(from_unit == "grams" && to_unit == "grams") {
                convertOperation = {v: BigDecimal -> v}
            }
        }

        return convertOperation(valueDouble).toString()
    }
}