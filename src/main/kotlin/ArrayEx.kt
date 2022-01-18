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

    var result = calculateSumOfSquared(n)
    println("S($n) = $result")
}