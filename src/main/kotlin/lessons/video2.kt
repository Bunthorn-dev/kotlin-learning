package lessons

import main.model.calculate

var name = "Bunthorn Thoeurn"

class video2 {
    init {
        println("Hello world!")
        println("Hello $name")
        print("print without ln")
        print("print without ln.")
        println("print with ln")
        println("print with ln")

        var byte: Byte = 127
        var shortVariable: Short = 32767
        val intVariable: Int = 2147483647

        print("Byte is $byte")
        println("Byte is $shortVariable")

        /*
         * Homework
         * 1. Test package import in Kotlin
         * 2. Test main entry point
         * 3. Test output
         * 4. Test integer type in Kotlin
         *    - Byte
         *    - Short
         *    - Int
         *    - Long
         */

        println("\n==================")
        println("Answer Homeworks")
        println("==================\n")

        // 3. Test package import
        println("==================")

        val calc = calculate()

        println("10 + 5 = ${calc.add(10, 5)}")
        println("10 - 5 = ${calc.subtract(10, 5)}")
        println("10 * 5 = ${calc.multiply(10, 5)}")
        println("10 / 4 = ${calc.divide(10, 4)}")

        // 4. Integer types
        println("--- Integer types ---")

        val b: Byte = 127
        println("- Byte value = $b, min = ${Byte.MIN_VALUE}, max = ${Byte.MAX_VALUE}")

        val s: Short = 32767
        println("Short value = $s, min = ${Short.MIN_VALUE}, max = ${Short.MAX_VALUE}")

        val i: Int = 2_000_000_000
        println("Int value = $i, min = ${Int.MIN_VALUE}, max = ${Int.MAX_VALUE}")

        val l: Long = 9_000_000_000L
        println("Long value = $l, min = ${Long.MIN_VALUE}, max = ${Long.MAX_VALUE}")

        println("Long add: ${calc.addLong(5_000_000_000L, 4_000_000_000L)}")

        // Show the data type of each variable
        println("\n--- Data types ---")

        println("b = $b, type = ${b::class.simpleName}")
        println("s = $s, type = ${s::class.simpleName}")
        println("i = $i, type = ${i::class.simpleName}")
        println("l = $l, type = ${l::class.simpleName}")

        // Kotlin picks the type automatically
        val small = 100
        val big = 3_000_000_000

        println("small = $small, type = ${small::class.simpleName}")
        println("big = $big, type = ${big::class.simpleName}")

        // Size in bits and bytes
        println("Long size: ${Long.SIZE_BITS} bits = ${Long.SIZE_BYTES} bytes")
        println("Int size:  ${Int.SIZE_BITS} bits = ${Int.SIZE_BYTES} bytes")

        println("==================\n")
    }
}
