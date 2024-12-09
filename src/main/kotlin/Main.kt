package org.example

fun main() {
    val amountOfItems = readln().toInt() // Ввод общего количества предметов

    val shulkers: Int = amountOfItems / 1728 // Вычисление, сколько шалкеров
    val stacksForShulkers: Int = ( // Вычисление, сколько стаков, опираясь на шалкеры
            amountOfItems - (
                    shulkers * 1728
                    )
            ) / 64

    val stacks: Int = amountOfItems / 64 // Количество стаков
    val justItems: Int = amountOfItems - stacks * 64 // Вычисление, сколько предметов без стаков

    if (shulkers > 0) output('h', shulkers)
    if (stacksForShulkers > 0) output('s', stacksForShulkers)
    if (justItems > 0) output('i', justItems)

}

fun output(type: Char, amount: Int) {

    var rightEnd: String = " "

    print("$amount ")

    when (type) {
        'h' -> print("шалкер")
        's' -> print("стак")
        'i' -> print("предмет")
    }

    when (amount % 10) {
        2 -> rightEnd = "а "
        3 -> rightEnd = "а "
        4 -> rightEnd = "а "
        5 -> rightEnd = "ов "
        6 -> rightEnd = "ов "
        7 -> rightEnd = "ов "
        8 -> rightEnd = "ов "
        9 -> rightEnd = "ов "
        0 -> rightEnd = "ов "
    }

    when (digits(amount)) {
        11 -> rightEnd = "ов "
        12 -> rightEnd = "ов "
        13 -> rightEnd = "ов "
        14 -> rightEnd = "ов "
    }
    print(rightEnd)
}

fun digits(number: Int): Int {
    var numInput = number
    val numLength: Int = numInput.toString().length

    var preLastDigit: Int = 0
    var lastDigit: Int = 0

    for (i in numLength downTo 1) {
        var numBuffer = numInput
        val zeros = Math.pow(10.0, i.toDouble()-1).toInt()

        numBuffer /= zeros
        numInput -= zeros * numBuffer


        when (i) {
            2 -> preLastDigit = numBuffer
            1 -> lastDigit = numBuffer
        }
    }
    val twoLastDigits = "${preLastDigit}${lastDigit}"
    return twoLastDigits.toInt()
}