package homeworks

class DataTypes {
    // 1. Byte (-128 to 127)
    val byteVar = 100

    // 2. Short (-32768 to 32767)
    val shortVar = 30000

    // 3. Int (-2^31 to 2^31-1)
    val intVar = 123456

    // 4. Long (needs "L" suffix)
    val longVar = 123456L

    // 5. Char (single character, single quotes)
    val charVar = 'B'

    // 6. String (double quotes)
    val stringVar = "Bunthorn Thoeurn"

    // 7. Float (needs 'f' suffix)
    val floatVar = 12.34F

    // 8. Double (default decimal type)
    val doubleVar = 12.3456789

    // 9. Array
    // Mutable array -> content ca be changed though declared with val
    val mutableArray: IntArray = intArrayOf(1,2,3,4)

    // Immutable array -> read-only list, on way modify its contents
    val immutableArray: List<Int> = listOf(10, 20, 30, 40, 50)

    fun printAllValues() {
        println("Byte: $byteVar")
        println("Short: $shortVar")
        println("Int: $intVar")
        println("Long: $longVar")
        println("Char: $charVar")
        println("String: $stringVar")
        println("Float: $floatVar")
        println("Double: $doubleVar")
        print("Mutable Array: ")
        mutableArray.forEach {print("$it" )}
        println()

        print("Immutable Array: ")
        immutableArray.forEach { print("$it ") }
        println()

    }
}

fun main() {
    println("==============================")
    val demo = DataTypes()
    demo.printAllValues()
    println("==============================")
}
