import java.util.Scanner

// Data class to represent an operation
data class Operation(val num1: Double, val num2: Double, val operator: String, val result: Double)

// Calculator class with arithmetic functions
class Calculator {

    // Functions for basic arithmetic operations
    fun add(a: Double, b: Double): Double = a + b
    fun subtract(a: Double, b: Double): Double = a - b
    fun multiply(a: Double, b: Double): Double = a * b
    fun divide(a: Double, b: Double): Double {
        return if (b != 0.0) a / b else Double.NaN // Handling division by zero
    }
}

// Main function to run the calculator
fun main() {
    val scanner = Scanner(System.`in`)
    val calculator = Calculator()
    val history = mutableListOf<Operation>() // List to store the calculation history

    println("Welcome to the Kotlin Calculator with History and Data Class Support!")

    // Loop for multiple operations
    while (true) {
        println("Enter first number:")
        val num1 = scanner.nextDouble()

        println("Enter second number:")
        val num2 = scanner.nextDouble()

        println("Choose an operation (+, -, *, /) or type 'history' to view previous calculations, or 'exit' to quit:")
        val operation = scanner.next()

        if (operation == "history") {
            if (history.isEmpty()) {
                println("No calculations yet.")
            } else {
                println("Calculation History:")
                history.forEach { println("${it.num1} ${it.operator} ${it.num2} = ${it.result}") }
            }
            continue
        }

        if (operation == "exit") break

        val result = when (operation) {
            "+" -> calculator.add(num1, num2)
            "-" -> calculator.subtract(num1, num2)
            "*" -> calculator.multiply(num1, num2)
            "/" -> calculator.divide(num1, num2)
            else -> {
                println("Invalid operation.")
                continue
            }
        }

        // Store each calculation in the history list as an Operation object
        history.add(Operation(num1, num2, operation, result))

        println("Result: $result")
    }

    println("Thank you for using the Kotlin Calculator!")
}
