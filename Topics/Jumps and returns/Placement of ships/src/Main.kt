fun main() {
    val ships = List<Pair<Int, Int>>(3) { readln().split(" ").map { it.toInt() }.let { Pair(it[0], it[1]) } }
    println((1..5).filterNot { ships.map { it.first }.contains(it) }.joinToString(" "))
    println((1..5).filterNot { ships.map { it.second }.contains(it) }.joinToString(" "))
}