package tictactoe


import kotlin.math.abs

const val ROWS = 3

fun main() {
    val board = StringBuilder(" ".repeat(9))
    var player = 'X'
    var state = "Game not finished"
    printBoard(board)
//    println(analyze(board))
    while (state == "Game not finished") {
        val move = getMove()
        if (board[move.toIndex()] != ' ') {
            println("This cell is occupied! Choose another one!")
            continue
        }
        board[move.toIndex()] = player
        player = if (player == 'X') 'O' else 'X'
        printBoard(board)
        state = analyze(board)
    }
    println(state)
}

// function to print the board using a template string
fun printBoardT(b: CharSequence): Unit {
    println(
        """
            ---------
            | ${b[0]} ${b[1]} ${b[2]} |
            | ${b[3]} ${b[4]} ${b[5]} |
            | ${b[6]} ${b[7]} ${b[8]} |
            ---------
        """.trimIndent()
    )
}

// function to print the board functionally
fun printBoard(b: CharSequence): Unit {
    println(b.chunked(ROWS)
        .map {
            it
                .asSequence()
                .joinToString(" ", "| ", " |")
        }
        .joinToString(
            "\n",
            "---------\n",
            "\n---------"
        ))
}

// takes the board as a string and returns a state message
fun analyze(board: CharSequence): String {

    // the tested 'lines'
    val hoz = board.chunked(3)
    val vert = board.withIndex().groupBy { it.index % 3 }.values.map { it.map { it.value }.joinToString("") }// hoz
    val diag1 = listOf(board[0], board[4], board[8]).joinToString("")
    val diag2 = listOf(board[2], board[4], board[6]).joinToString("")

    // the lines together, with their total codepoints summed
    val results = (hoz + vert + diag1 + diag2).map { it.sumOf { it.code } }

    // count of each symbol
    val xCount = board.count() { it == 'X' }
    val oCount = board.count() { it == 'O' }

    return when {
        results.containsAll(listOf('X'.code * 3, 'O'.code * 3)) || abs(xCount - oCount) > 1 -> {
            "Impossible"
        }

        results.contains('X'.code * 3) -> {
            "X wins"
        }

        results.contains('O'.code * 3) -> {
            "O wins"
        }

        board.contains(' ') -> {
            "Game not finished"
        }

        else -> {
            "Draw"
        }

    }

}

fun Int.indexToPair(): Pair<Int, Int> {
    return Pair((this / 3) + 1, (this % 3) + 1)
}

fun Pair<Int, Int>.toIndex(): Int {
    return (this.second - 1) + ((this.first - 1) * 3)
}

fun getMove(): Pair<Int, Int> {
    var coord: Pair<Int, Int>? = null
    while (coord == null) {
        val input = readln().split(" ").takeIf { it.size == 2 }
            ?.mapNotNull { it.toIntOrNull() }
            ?.takeIf { it.size == 2 }
            ?.let { Pair(it[0], it[1]) }
        if (input != null) {
            if (input.first !in 1..3 || input.second !in 1..3) {
                println("Coordinates should be from 1 to 3!")
            } else {
                coord = input
            }
        } else {
            println("You should enter numbers!")
        }
    }
    return coord
}
