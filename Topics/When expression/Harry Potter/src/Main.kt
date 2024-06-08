fun main() {
    val houses = mapOf(
        "gryffindor" to "bravery",
        "hufflepuff" to "loyalty",
        "slytherin" to "cunning",
        "ravenclaw" to "intellect"
    ).getOrDefault(readln(), "not a valid house")
    println(houses)
}