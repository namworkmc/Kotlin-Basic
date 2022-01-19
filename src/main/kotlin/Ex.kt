import kotlin.random.Random

/**
 * Created by 19127048 - Nguyen Duc Nam<br/>
 * Date 1/19/2022 - 12:35 PM<br/>
 * Description: JDK16<br/>
 */

fun solveEx1(km: Int): Float {
    var price = 0f
    if (km > 0) {
        if (km <= 1) {
            price = 15_000f
        } else if (km in 2..5) {
            price = 15_000f + km * 13_500f
        } else if (km in 6..120) {
            price = 15_000f + 5 * 13_500f + km * 11_000f
        } else {
            price = 15_000f + 5 * 13_500f + km * 11_000f
            price *= (90f / 100)
        }
    }

    return price
}

fun solveEx2(price: Int, quantity: Int, isShipping: Boolean): Float {
    val shippingFee = if (isShipping) 20_000 else 0

    val total = price.toFloat() * quantity + shippingFee
    return if (total > 100_000) total * (90f / 100) else total
}

fun solveEx3(currency: Int, isVND: Boolean): Float = if (isVND) currency / 22_700f else currency * 22_700f

fun solveEx4(n: Int): Int {
    var sum = 0
    var counter = 0
    while (sum <= n) {
        counter++
        sum += counter
    }

    return counter
}

fun main() {
    val km = (0..500).random()
    println("Solve problem 1, km = ${km}: ${solveEx1(km)}")

    val bookPrice = (30_000..100_000).random()
    val bookQuantity = (1..10).random()
    val isShipping = Random.nextBoolean()
    println("Solve problem 2, price = $bookPrice, quantity = $bookQuantity, shipping = $isShipping: ${solveEx2(bookPrice, bookQuantity, isShipping)}")

    val isVND = Random.nextBoolean()
    val currency = if (isVND) (22_700..500_000).random() else (1..100).random()
    println("Solve problem 3, VND = $isVND, currency = $currency: ${solveEx3(currency, isVND)}")

    val n = (0..100).random()
    println("Solve problem 4, n = $n, k = ${solveEx4(n)}")
}