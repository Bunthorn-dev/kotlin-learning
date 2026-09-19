package main.model

class calculate {

    fun add(a: Int, b: Int): Int = a + b

    fun subtract(a: Int, b: Int): Int = a - b

    fun multiply(a: Int, b: Int): Int = a * b

    fun divide(a: Int, b: Int): Double {
        if (b == 0) {
            println("Error: cannot divide by zero")
            return 0.0
        }
        return a.toDouble() / b
    }

    // Long version to test the Long data type
    fun addLong(a: Long, b: Long): Long = a + b
}