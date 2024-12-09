package org.example

fun main() {
    val amountOfItems = readln().toIntOrNull() ?: return println("Wrong input!") // Ввод общего количества предметов

    val shulkers: Int = amountOfItems / 1728 // Вычисление, сколько шалкеров
    val stacksForShulkers = (amountOfItems - (shulkers * 1728)) / 64
    val justItems: Int = amountOfItems % 64 // Вычисление, сколько предметов без стаков

    if (shulkers > 0) output('h', shulkers)
    if (stacksForShulkers > 0) output('s', stacksForShulkers)
    if (justItems > 0) output('i', justItems)
}

val types = mapOf('h' to "шалкер", 's' to "стак", 'i' to "предмет")
fun output(type: Char, amount: Int) {
    var rightEnd = " "

    when (amount % 10) {
        0 -> rightEnd = "ов "
        in 2..4 -> rightEnd = "а "
        in 5..9 -> rightEnd = "ов "
    }

    if (amount.toString().apply { if (length >= 2) substring(length - 2) }.toInt() in 11..14)
        rightEnd = "ов "

    print("$amount ${types[type]}$rightEnd")
}
