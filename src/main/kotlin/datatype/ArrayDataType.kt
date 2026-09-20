package datatype

/**
 * ============================================================
 *  FILE: ArrayDatatype.kt
 *  TOPIC: Complete Guide to the Array Datatype in Kotlin
 * ============================================================
 *
 *  This file explains everything about Arrays in Kotlin:
 *  - What an Array is
 *  - Creating arrays (multiple ways)
 *  - Primitive-type arrays (IntArray, DoubleArray, etc.)
 *  - Accessing & modifying elements
 *  - Array size & iteration
 *  - Multi-dimensional arrays
 *  - Array of nulls
 *  - Common array functions
 *  - Array vs List
 *  - Converting Array <-> List
 *  - Array is a reference type (mutability behavior)
 *
 *  Run main() to see live output of every concept.
 * ============================================================
 */

fun ArrayDataType() {

    println("========== 1. WHAT IS AN ARRAY? ==========")
    /*
        An Array in Kotlin is a fixed-size, mutable collection of elements
        of the SAME type, represented by the class Array<T>.
        - Size is fixed once created (cannot grow/shrink).
        - Elements CAN be changed (mutable content).
        - Arrays are REFERENCE TYPES.
    */
    println("Concept explained in comments above.")
    println()


    println("========== 2. CREATING ARRAYS ==========")
    // Using arrayOf()
    val fruits: Array<String> = arrayOf("Apple", "Banana", "Cherry")
    println("arrayOf(): ${fruits.joinToString()}")

    // Using Array constructor with a lambda (index -> value)
    val squares = Array(5) { i -> i * i }
    println("Array(size){lambda}: ${squares.joinToString()}")

    // Using arrayOfNulls() - fixed size, all elements null initially
    val nullableArray: Array<String?> = arrayOfNulls(3)
    println("arrayOfNulls(3): ${nullableArray.joinToString()}")

    // Empty array
    val emptyArr = emptyArray<Int>()
    println("emptyArray(): ${emptyArr.joinToString()} (size: ${emptyArr.size})")
    println()


    println("========== 3. PRIMITIVE-TYPE ARRAYS (Performance Optimized) ==========")
    /*
        Kotlin provides SPECIAL array classes for primitive types to avoid
        boxing overhead: IntArray, DoubleArray, CharArray, BooleanArray,
        ByteArray, ShortArray, LongArray, FloatArray.
    */
    val intArr: IntArray = intArrayOf(1, 2, 3, 4)
    val doubleArr: DoubleArray = doubleArrayOf(1.1, 2.2, 3.3)
    val charArr: CharArray = charArrayOf('A', 'B', 'C')
    val boolArr: BooleanArray = booleanArrayOf(true, false, true)
    val byteArr: ByteArray = byteArrayOf(1, 2, 3)
    val longArr: LongArray = longArrayOf(100L, 200L)

    println("IntArray: ${intArr.joinToString()}")
    println("DoubleArray: ${doubleArr.joinToString()}")
    println("CharArray: ${charArr.joinToString()}")
    println("BooleanArray: ${boolArr.joinToString()}")
    println("ByteArray: ${byteArr.joinToString()}")
    println("LongArray: ${longArr.joinToString()}")
    // NOTE: Array<Int> boxes each element as Integer object.
    //       IntArray stores raw 'int' primitives -> more memory efficient.
    println()


    println("========== 4. ACCESSING & MODIFYING ELEMENTS ==========")
    val numbers = intArrayOf(10, 20, 30, 40)
    println("First element: ${numbers[0]}")
    println("Last element: ${numbers[numbers.size - 1]}")
    println("Using .first() and .last(): ${numbers.first()}, ${numbers.last()}")

    numbers[1] = 999   // modifying an element (allowed, arrays are mutable content)
    println("After modifying index 1: ${numbers.joinToString()}")
    println()


    println("========== 5. ARRAY SIZE & ITERATION ==========")
    val colors = arrayOf("Red", "Green", "Blue")
    println("Size: ${colors.size}")

    print("for-in loop: ")
    for (color in colors) print("$color ")
    println()

    print("Indexed loop (indices): ")
    for (i in colors.indices) print("[$i]=${colors[i]} ")
    println()

    print("withIndex(): ")
    for ((index, value) in colors.withIndex()) print("$index:$value ")
    println()
    println()


    println("========== 6. MULTI-DIMENSIONAL ARRAYS ==========")
    // Array of Arrays (like a 2D grid / matrix)
    val matrix: Array<Array<Int>> = arrayOf(
        arrayOf(1, 2, 3),
        arrayOf(4, 5, 6),
        arrayOf(7, 8, 9)
    )

    println("2D Array (matrix):")
    for (row in matrix) {
        println(row.joinToString(" "))
    }
    println("Element at [1][2]: ${matrix[1][2]}")  // row 1, col 2 -> 6
    println()


    println("========== 7. ARRAY OF NULLS ==========")
    val mixedNullable: Array<Int?> = arrayOfNulls(3)
    mixedNullable[0] = 5
    println("Array<Int?> after setting index 0: ${mixedNullable.joinToString()}")
    println()


    println("========== 8. COMMON ARRAY FUNCTIONS ==========")
    val data = intArrayOf(5, 3, 8, 1, 9, 2)

    println("Original: ${data.joinToString()}")
    println("sorted(): ${data.sorted()}")                 // returns List
    println("sortedArray(): ${data.sortedArray().joinToString()}")
    println("reversed(): ${data.reversed()}")
    println("max(): ${data.max()}")
    println("min(): ${data.min()}")
    println("sum(): ${data.sum()}")
    println("average(): ${data.average()}")
    println("contains(8): ${data.contains(8)}")
    println("indexOf(8): ${data.indexOf(8)}")
    println("filter{ it > 4 }: ${data.filter { it > 4 }}")
    println("map{ it * 2 }: ${data.map { it * 2 }}")
    println("count{ it % 2 == 0 }: ${data.count { it % 2 == 0 }}")
    println("distinct(): ${intArrayOf(1, 1, 2, 2, 3).distinct()}")
    println()


    println("========== 9. COPYING & SLICING ARRAYS ==========")
    val original = intArrayOf(1, 2, 3, 4, 5)
    val copy = original.copyOf()                 // full copy
    val copyResized = original.copyOf(3)         // copy with truncated size
    val sliceArr = original.copyOfRange(1, 4)    // sub-array (index 1 to 3)

    copy[0] = 999
    println("Original after copy modified: ${original.joinToString()}") // unaffected
    println("Copy: ${copy.joinToString()}")
    println("copyOf(3): ${copyResized.joinToString()}")
    println("copyOfRange(1,4): ${sliceArr.joinToString()}")
    println()


    println("========== 10. FILLING & COMPARING ARRAYS ==========")
    val fillArr = IntArray(5)
    fillArr.fill(7)
    println("fill(7): ${fillArr.joinToString()}")

    val arrA = intArrayOf(1, 2, 3)
    val arrB = intArrayOf(1, 2, 3)
    println("arrA == arrB (structural, WRONG for arrays!): ${arrA == arrB}")   // false! reference check
    println("arrA.contentEquals(arrB) (CORRECT way): ${arrA.contentEquals(arrB)}") // true
    println()


    println("========== 11. ARRAY IS A REFERENCE TYPE ==========")
    val refArr1 = arrayOf(1, 2, 3)
    val refArr2 = refArr1        // same reference
    refArr2[0] = 500
    println("refArr1 after modifying refArr2: ${refArr1.joinToString()}") // changed too!
    println()


    println("========== 12. ARRAY <-> LIST CONVERSION ==========")
    val arrToConvert = arrayOf("X", "Y", "Z")
    val convertedList: List<String> = arrToConvert.toList()
    val convertedMutableList: MutableList<String> = arrToConvert.toMutableList()

    println("Array to List: $convertedList")
    println("Array to MutableList: $convertedMutableList")

    val listBack = listOf(1, 2, 3)
    val backToArray: Array<Int> = listBack.toTypedArray()
    println("List to Array: ${backToArray.joinToString()}")
    println()


    println("========== 13. ARRAY vs LIST (KEY DIFFERENCES) ==========")
    println("Array : fixed size, mutable elements, works well with primitives (IntArray etc.)")
    println("List  : can be immutable (List) or resizable (MutableList), more idiomatic in Kotlin")
    println()

    println("========== END OF ARRAY DATATYPE GUIDE ==========")
}

/*
============================================================
 SUMMARY TABLE (as comments for quick reference)
============================================================

 Array Type      | Declaration Example              | Notes
-----------------|-----------------------------------|--------------------------------
 Array<T>        | arrayOf("A","B")                 | Generic, boxes primitives
 IntArray        | intArrayOf(1,2,3)                | Primitive int[], no boxing
 DoubleArray     | doubleArrayOf(1.1,2.2)           | Primitive double[]
 CharArray       | charArrayOf('a','b')             | Primitive char[]
 BooleanArray    | booleanArrayOf(true,false)       | Primitive boolean[]
 ByteArray       | byteArrayOf(1,2,3)               | Primitive byte[]
 LongArray       | longArrayOf(1L,2L)               | Primitive long[]
 FloatArray      | floatArrayOf(1f,2f)              | Primitive float[]
 ShortArray      | shortArrayOf(1,2)                | Primitive short[]
 arrayOfNulls<T> | arrayOfNulls<String>(3)          | Fixed size, all null initially
 Array(n){...}   | Array(5){ i -> i*i }             | Built using lambda per index
 2D Array        | Array(3){ Array(3){0} }          | Array of Arrays (matrix)

 Key Facts:
 - Arrays have a FIXED size once created (cannot add/remove elements).
 - Array CONTENT is mutable (you CAN change element values via index).
 - Arrays are REFERENCE TYPES: assigning copies the reference, not the data.
 - Use .contentEquals() to compare array VALUES (== compares references!).
 - Use .copyOf() / .copyOfRange() to create independent copies.
 - Primitive arrays (IntArray, DoubleArray, etc.) avoid boxing overhead
   and are more memory/performance efficient than Array<Int>, Array<Double>.
 - Convert between Array and List using .toList() / .toTypedArray().
============================================================
*/