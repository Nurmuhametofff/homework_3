fun main() {
    println(
        " Введите тип карты: \n" +
                "1 - Mastercard\n" +
                "2 - Maestro\n" +
                "3 - Visa\n" +
                "4 - Мир\n" +
                "5 - VK Pay"
    )
    val typeCard: Int = readln().toInt()
    print(" Введите сумму предыдущих переводов за месяц: ")
    val previousRemittance: Double = readln().toDouble()
    print("Введите сумму перевода: ")
    val amount: Double = readln().toDouble()

    val payMent: Double = pay(typeCard, previousRemittance, amount)

    if(payMent > 0) println("Сумма перевода составит $payMent") else
        println("Минимальная сумма перевода по карте Mastercard и Maestro составляет 21 руб.")


}

fun pay(typeCard: Int, previousRemittance: Double, amount: Double): Double {
    val payMent: Double = when (typeCard) {
        1, 2 -> if ((previousRemittance + amount) < 75_000) amount else (amount - ((amount / 100) * 0.6 + 20.0))
        3, 4 -> (amount - ((amount / 100) * 0.75))
        5 -> amount
        else -> amount

    }
    return if(payMent > 0) payMent else 0.0
}