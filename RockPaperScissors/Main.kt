// Updated an old Rock Paper Scissors game and found unique values for each option
// Managed to change the functions to be a little less verbose
// Might be difficult to read though as have to know how I got the numbers for the final check
// Basically each result, other than a draw had a unique result when subtracted. So I used that
// Kept the Computer results there as a reminder more than anything else.

fun main() {
    val options = arrayOf("Rock", "Paper", "Scissors")
    val gameChoice = getGameChoice(options)
    // Kept this to check for draw working:
    //println(gameChoice)
    val userInput = getUserChoice(options)

    println(checkResult(gameChoice, userInput))
}

fun getGameChoice(optionParam: Array<String>) =
    optionParam[(Math.random() * optionParam.size).toInt()]

// Updated the original to keep the getUserChoice prompting until a correct value is entered

fun getUserChoice(optionParam: Array<String>): String {
    var userInput: String = ""
    while (userInput.isEmpty() || (userInput !in optionParam)){
        println("Please Enter one of the following: ")
        for (item in optionParam) print(" $item")
        println(".")
        userInput = readln()
    }
    return  userInput
}

fun checkResult(computer: String, user: String): String {
    var winner: String
    val compLen = computer.length
    val userLen = user.length
    val userWins = arrayOf(-1, -3, 4)
    // val compWins = arrayOf(-4, 1, 3)
    if (compLen == userLen) {
        winner = "It's a draw"
    } else if (compLen - userLen in userWins) {
        winner = "User wins"
    }
    else {
        winner = "Computer wins"
    }

    return "Computer chooses $computer .\n\n User chooses $user .\n\n Final result is $winner !"
}