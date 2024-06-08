fun main() {
    val result = when (readln()) {
        "triangle" -> {
            val (a, b, c) = List(3) { readln().toDouble() }
            val s = (a + b + c) / 2
            Math.sqrt(s * (s - a) * (s - b) * (s - c))
        }

        "rectangle" -> {
            val (a, b) = List(2) { readln().toDouble() }
            a * b
        }

        "circle" -> {
            val r = readln().toDouble()
            3.14 * Math.pow(r, 2.0)
        }

        else -> null
    }
    println(result)
}