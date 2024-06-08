fun main() {
    val str1 = readln()
    val op = readln()
    val str2 = readln()

    println(
        when (op) {
            "equals" -> ::equals
            "plus" -> ::plus
            "endsWith" -> ::ew
            else -> null
        }?.invoke(str1, str2)?.toString() ?: "Unknown operation"
    )
}

fun equals(str1: String, str2: String): Boolean {
    return str1 == str2
}

fun plus(str1: String, str2: String): String {
    return str1 + str2
}

fun ew(str1: String, str2: String): Boolean {
    return str1.endsWith(str2)
}