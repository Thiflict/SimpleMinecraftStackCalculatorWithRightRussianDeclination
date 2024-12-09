package org.example

import kotlin.math.pow
import kotlin.test.Test

class Test {
    @Test
    fun main() {
        var numInput = 122
        val numLength = numInput.toString().length

        var preLastDigit = 0
        var lastDigit = 0

        for (i in numLength..1) {
            var numBuffer = numInput
            val zeros = 10.0.pow(i.toDouble() - 1).toInt()

            numBuffer /= zeros
            numInput -= zeros * numBuffer

            println(numBuffer)

            when (i) {
                2 -> preLastDigit = numBuffer
                1 -> lastDigit = numBuffer
            }
        }
        println("Предпоследняя: $preLastDigit, последняя $lastDigit")
    }
}