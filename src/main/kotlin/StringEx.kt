/**
 * Created by 19127048 - Nguyen Duc Nam<br/>
 * Date 1/18/2022 - 8:29 PM<br/>
 * Description: JDK16<br/>
 */

// 1
fun getStrLength(str: String): Int = str.length

// 2
fun getStrConcat(str1: String, str2: String): String = str1.plus(str2)

// 3
fun getUppercaseStr(str: String): String = str.uppercase()

// 4
fun replaceStr(str1: String, str2: String, replace: String = "nlhdung"): String = str1.replace(str2, replace)

// 5
fun deleteStr(str1: String, str2: String): String {
    val oldValue = "$str2 "
    return str1.replace(oldValue, "")
}

// 6
fun appendStrAtFirst(str1: String, str2: String): String = appendStrAt(str1, str2, 0)

// 7
fun appendStrAtLast(str1: String, str2: String): String = appendStrAt(str1, str2, str1.length)

// 8
fun appendStrAt(str1: String, str2: String, x: Int = 0): String =
    StringBuilder(str1).insert(x, str2).toString()

// 9
fun countOccurrenceStr(str1: String, str2: String): Int {
    var count = 0
    var startIdx = 0
    var foundIdx = str1.indexOf(str2, startIdx)
    while (foundIdx != -1) {
        count++
        startIdx = foundIdx + str2.length
        foundIdx = str1.indexOf(str2, startIdx)
    }

    return count
}

fun getHalfSubStr(str: String): String = str.substring(0, str.length / 2)

fun main() {
    val id = "19127048 = "
    val name = "Nguyen Duc Duc Nam"

    println(getStrLength(id)) // 1

    println(getStrConcat(id, name)) // 2

    println(getUppercaseStr(name)) // 3

    val substr = "Duc"
    println(replaceStr(name, substr)) // 4

    println(deleteStr(name, substr)) // 5

    val a = appendStrAtFirst(name, "nlhdung")
    println(a) // 6
    val b = appendStrAtLast(name, "nlhdung")
    println(b) // 7
    val c = appendStrAt(name, "nlhdung", 3)
    println(c) // 8

    val stringBuilder: StringBuilder = StringBuilder(a)
    stringBuilder.append(b)
    stringBuilder.append(c)
    // 9
    val str = stringBuilder.toString()
    val count = countOccurrenceStr(str, "nlhdung")
    println("Number of \"nlhdung\" occur in $str: $count")

    // 10
    println(getHalfSubStr(id))
}