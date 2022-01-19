import kotlin.math.pow
import kotlin.random.Random

/**
 * Created by 19127048 - Nguyen Duc Nam <br/>
 * Date 1/18/2022 - 9:52 PM <br/>
 * Description: JDK16 <br/>
 */
// 1
fun reverseArray(arr: Array<Int>): Array<Int> = arr.reversedArray()

// 2
fun calculateSumCommonDivisor(n: Int): Pair<Int, Int> {
    var count = 0
    var sum = 0

    for (i in 1..n) {
        if (n % i == 0) {
            count++
            sum += i
        }
    }

    return count to sum
}

// 3
fun calculateSumOfNumber(n: Int): Pair<Int, Int> {
    var counter = 0
    var sum = 0

    var number: Int
    var holder = n
    do {
        number = holder % 10
        holder /= 10

        sum += number
        counter++
    } while (holder != 0)

    return counter to sum
}

// 4
fun countEvenAndOddNumber(n: Int): Pair<Int, Int> {
    var evenCounter = 0
    var oddCounter = 0

    var number: Int
    var holder = n
    do {
        number = holder % 10
        holder /= 10

        if (number % 2 == 0) {
            evenCounter++
        } else {
            oddCounter++
        }
    } while (holder != 0)

    return evenCounter to oddCounter
}

// 5
fun calculateSumOfSquared(n: Int): Int {
    var sum = 0.0
    for (i in 1..n) {
        sum += i.toDouble().pow(2.0)
    }

    return sum.toInt()
}

// 6
fun generateNthStr(str: String, x: Int): Array<String> = Array(x) { item -> "$str-${item + 1}" }

// 7, 8, 9
fun sortArr(arr: Array<Int>, desc: Boolean = false): Array<Int> =
    if (!desc) arr.sortedArray() else arr.sortedArrayDescending()

// 10
fun isSymmetricalNumber(n: Int): Boolean {
    val numberAsStr = n.toString()
    val size = numberAsStr.length
    for (i in numberAsStr.indices) {
        if (numberAsStr[i] != numberAsStr[size - i - 1]) return false
    }

    return true
}

// 11
fun isPrimeNumber(n: Int): Boolean {
    if (n <= 1) {
        return false
    }

    for (i in 2..(n / 2)) {
        if (n % i == 0) {
            return false
        }
    }

    return true
}

// 12
data class ArrayResult(val max: Int?, val maxEven: Int?, val maxOdd: Int?, val maxPrime: Int?)

fun findMaxsInArray(arr: Array<Int>): ArrayResult {
    val max = arr.maxOrNull()?.toInt()
    val maxEven = arr.filter { it % 2 == 0 }.maxOrNull()?.toInt()
    val maxOdd = arr.filter { it % 2 != 0 }.maxOrNull()
    val maxPrime = arr.filter { isPrimeNumber(it) }.maxOrNull()?.toInt()

    return ArrayResult(max, maxEven, maxOdd, maxPrime)
}

fun main() {
    val arr = Array(5) { Random.nextInt(0, 10) }
    print("Original array: ")
    arr.forEach { print("$it ") }
    println()

    // 1
    print("Reverse array: ")
    val reverseArr = reverseArray(arr)
    reverseArr.forEach { print("$it ") }
    println()

    // 2
    val n = Random.nextInt(0, 22)
    var resultTuple = calculateSumCommonDivisor(n)
    println("$n's common divisor (count, sum): $resultTuple")

    // 3
    resultTuple = calculateSumOfNumber(n)
    println("$n's number of digits (count, sum): $resultTuple")

    // 4
    resultTuple = countEvenAndOddNumber(n)
    println("$n's (even, odd): $resultTuple")

    // 5
    val result = calculateSumOfSquared(n)
    println("S($n) = $result")

    // 6
    val resultArray = generateNthStr("nlhdung", (1..100).random())
    resultArray.forEach { print("$it ") }
    println()

    // 7, 9
    var resultIntArr = sortArr(arr)
    resultIntArr.forEach { print("$it ") }
    println()

    // 8, 9
    resultIntArr = sortArr(arr, true)
    resultIntArr.forEach { print("$it ") }
    println()

    // 10
    println("Is 121 symmetrical: ${isSymmetricalNumber(121)}")
    println("Is 123 symmetrical: ${isSymmetricalNumber(123)}")

    // 11
    println("Is 7 a prime number: ${isPrimeNumber(7)}")
    println("Is 22 a prime number: ${isPrimeNumber(22)}")

    // 12
    println(findMaxsInArray(arr))
}