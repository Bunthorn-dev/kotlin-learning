package datatype

/**
 * ============================================================
 *  FILE: BasicDataType.kt
 *  TOPIC: Complete Guide to Basic Data Types in Kotlin
 * ============================================================
 *
 *  This file explains everything about Kotlin's Basic Data Types:
 *  - Numbers (Byte, Short, Int, Long, Float, Double)
 *  - Boolean
 *  - Char
 *  - String
 *  - Arrays
 *  - Literal constants & underscores in numbers
 *  - Type conversion (explicit casting)
 *  - Nullable versions of basic types
 *  - Default values & ranges
 *
 *  Run main() to see live output of every concept.
 * ============================================================
 */

fun BasicDataType() {

    println("========== 1. INTEGER TYPES ==========")
    /*
        Type   | Size    | Range
        -------|---------|----------------------------------
        Byte   | 8-bit   | -128 to 127
        Short  | 16-bit  | -32768 to 32767
        Int    | 32-bit  | -2,147,483,648 to 2,147,483,647
        Long   | 64-bit  | -9223372036854775808 to 9223372036854775807
    */
    val byteVal: Byte = 100
    val shortVal: Short = 30000
    val intVal: Int = 100000
    val longVal: Long = 10000000000L   // 'L' suffix required for Long literal

    println("Byte  : $byteVal   (range: ${Byte.MIN_VALUE} to ${Byte.MAX_VALUE})")
    println("Short : $shortVal (range: ${Short.MIN_VALUE} to ${Short.MAX_VALUE})")
    println("Int   : $intVal (range: ${Int.MIN_VALUE} to ${Int.MAX_VALUE})")
    println("Long  : $longVal (range: ${Long.MIN_VALUE} to ${Long.MAX_VALUE})")
    println()


    println("========== 2. FLOATING-POINT TYPES ==========")
    /*
        Type   | Size    | Precision
        -------|---------|------------------
        Float  | 32-bit  | ~6-7 decimal digits
        Double | 64-bit  | ~15-16 decimal digits
    */
    val floatVal: Float = 10.5F        // 'F' suffix required for Float
    val doubleVal: Double = 10.5678912345

    println("Float  : $floatVal")
    println("Double : $doubleVal")
    println()


    println("========== 3. BOOLEAN TYPE ==========")
    val isKotlinFun: Boolean = true
    val isJavaOutdated: Boolean = false
    println("isKotlinFun: $isKotlinFun")
    println("AND: ${isKotlinFun && isJavaOutdated}")
    println("OR : ${isKotlinFun || isJavaOutdated}")
    println("NOT: ${!isKotlinFun}")
    println()


    println("========== 4. CHAR TYPE ==========")
    val charVal: Char = 'K'
    println("Char: $charVal  (Unicode code: ${charVal.code})")
    println()


    println("========== 5. STRING TYPE ==========")
    val stringVal: String = "Kotlin Basics"
    println("String: $stringVal (length: ${stringVal.length})")
    println()


    println("========== 6. LITERAL CONSTANTS ==========")
    val decimal = 123
    val hex = 0x1A          // hexadecimal
    val binary = 0b1010     // binary
    // Note: Kotlin does NOT support octal literals
    val readableMillion = 1_000_000   // underscores for readability
    val readableLong = 1_000_000_000_000L

    println("Decimal: $decimal")
    println("Hex (0x1A): $hex")
    println("Binary (0b1010): $binary")
    println("Readable Int with underscores: $readableMillion")
    println("Readable Long with underscores: $readableLong")
    println()


    println("========== 7. TYPE CONVERSION (EXPLICIT CASTING) ==========")
    /*
        Kotlin does NOT allow implicit widening conversions (unlike Java).
        You must explicitly convert using functions like toInt(), toLong(), etc.
    */
    val smallNum: Int = 42
    val bigNum: Long = smallNum.toLong()     // Int -> Long
    val asDouble: Double = smallNum.toDouble() // Int -> Double
    val asByte: Byte = smallNum.toByte()      // Int -> Byte (may lose data if too large)
    val backToInt: Int = asDouble.toInt()     // Double -> Int (truncates decimal)

    println("Int to Long: $bigNum")
    println("Int to Double: $asDouble")
    println("Int to Byte: $asByte")
    println("Double to Int (truncated): $backToInt")

    // val wrong: Long = smallNum  // ERROR: type mismatch, no implicit conversion allowed
    println()


    println("========== 8. STRING <-> NUMBER CONVERSION ==========")
    val numberAsString = "456"
    val parsedInt = numberAsString.toInt()
    val parsedDouble = "3.14".toDouble()
    val safeParse = "abc".toIntOrNull()  // returns null instead of crashing

    println("String to Int: $parsedInt")
    println("String to Double: $parsedDouble")
    println("Invalid string toIntOrNull(): $safeParse")
    println("Number to String: ${(789).toString()}")
    println()


    println("========== 9. NULLABLE BASIC TYPES ==========")
    var nullableInt: Int? = null
    println("Nullable Int: $nullableInt")
    nullableInt = 10
    println("Safe call: ${nullableInt?.plus(5)}")
    println("Elvis default: ${nullableInt ?: 0}")
    println()


    println("========== 10. ARRAYS OF BASIC TYPES ==========")
    val intArray: IntArray = intArrayOf(1, 2, 3)
    val doubleArray: DoubleArray = doubleArrayOf(1.1, 2.2, 3.3)
    val charArray: CharArray = charArrayOf('X', 'Y', 'Z')
    val genericArray: Array<String> = arrayOf("A", "B", "C")

    println("IntArray: ${intArray.joinToString()}")
    println("DoubleArray: ${doubleArray.joinToString()}")
    println("CharArray: ${charArray.joinToString()}")
    println("Array<String>: ${genericArray.joinToString()}")
    println()


    println("========== 11. UNSIGNED TYPES (Kotlin 1.3+) ==========")
    /*
        Type    | Size    | Range
        --------|---------|------------------
        UByte   | 8-bit   | 0 to 255
        UShort  | 16-bit  | 0 to 65535
        UInt    | 32-bit  | 0 to 4294967295
        ULong   | 64-bit  | 0 to 18446744073709551615
    */
    val uByteVal: UByte = 200u
    val uIntVal: UInt = 4000000000u
    val uLongVal: ULong = 18000000000000000000u

    println("UByte: $uByteVal")
    println("UInt: $uIntVal")
    println("ULong: $uLongVal")
    println()


    println("========== 12. checking type with 'is' ==========")
    val unknown: Any = 100
    when (unknown) {
        is Int -> println("$unknown is an Int")
        is String -> println("$unknown is a String")
        else -> println("Unknown type")
    }
    println()


    println("========== 13. DEFAULT VALUES SUMMARY ==========")
    println("Basic types have NO default 'zero' auto-initialization in Kotlin;")
    println("every val/var MUST be explicitly initialized or declared nullable.")
    println()

    println("========== END OF BASIC DATA TYPE GUIDE ==========")
}

/*
============================================================
 SUMMARY TABLE (as comments for quick reference)
============================================================

 Category    | Type     | Size     | Example              | Notes
-------------|----------|----------|----------------------|--------------------------------
 Integer     | Byte     | 8-bit    | val b: Byte = 10     | -128 to 127
 Integer     | Short    | 16-bit   | val s: Short = 1000  | -32768 to 32767
 Integer     | Int      | 32-bit   | val i: Int = 1000    | Default integer type
 Integer     | Long     | 64-bit   | val l: Long = 100L   | Needs 'L' suffix
 Floating    | Float    | 32-bit   | val f: Float = 1.5F  | Needs 'F' suffix
 Floating    | Double   | 64-bit   | val d: Double = 1.5  | Default floating type
 Boolean     | Boolean  | 1-bit*   | val b: Boolean = true| true / false only
 Character   | Char     | 16-bit   | val c: Char = 'A'    | Single quotes, Unicode
 Text        | String   | N/A      | val s: String = "Hi" | Sequence of Chars
 Unsigned    | UByte/UShort/UInt/ULong | -- | val u: UInt = 5u | Kotlin 1.3+, 'u' suffix

 Key Facts:
 - Kotlin has NO implicit type widening (Int does NOT auto-convert to Long).
 - Every numeric conversion must be explicit: toInt(), toLong(), toDouble(), etc.
 - Long literals need 'L' suffix, Float literals need 'F' suffix, Unsigned need 'u'/'U'.
 - Underscores (_) can be used in number literals for readability: 1_000_000.
 - All basic types can be made nullable using '?' (e.g., Int?), which causes
   them to be "boxed" into their wrapper reference type internally.
 - Kotlin supports hex (0x), binary (0b), but NOT octal literals.
============================================================
*/