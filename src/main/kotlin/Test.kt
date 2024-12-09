package org.example

/**
 * Этот .kt файл существует просто для теста фишки опредения каждой цифры в числе, чтобы использовать её
 * для правильного склонения уже непосредственно в Main.kt
 */

fun main() {
    var numInput = readln().toInt()
    val numLength: Int = numInput.toString().length

    var preLastDigit: Int = 0
    var lastDigit: Int = 0

    for (i in numLength downTo 1) {
        var numBuffer = numInput
        val zeros = Math.pow(10.0, i.toDouble()-1).toInt()

        numBuffer /= zeros
        numInput -= zeros * numBuffer

        println(numBuffer)

        when (i) {
            2 -> preLastDigit = numBuffer
            1 -> lastDigit = numBuffer
        }
    }
    println("Предпоследняя: ${preLastDigit}, последняя ${lastDigit}")
}