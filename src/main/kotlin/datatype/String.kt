package datatype

/**
 * ============================================================
 *  FILE: StringDatatype.kt
 *  TOPIC: Complete Guide to the String Datatype in Kotlin
 * ============================================================
 *
 *  This file explains everything about the String type in Kotlin:
 *  - What String is
 *  - Types of String literals
 *  - String properties & methods
 *  - String immutability
 *  - String templates
 *  - String comparison
 *  - Common operations
 *
 *  Run main() to see live output of every concept.
 * ============================================================
 */

fun StringTypes() {

    println("========== 1. BASIC STRING DECLARATION ==========")
    // String is a class in Kotlin (kotlin.String), backed by java.lang.String on JVM
    val basicString: String = "Hello Kotlin"
    println(basicString)
    println("Type: ${basicString::class.simpleName}")
    println()


    println("========== 2. ESCAPED STRING (Regular String) ==========")
    // Uses double quotes. Supports escape sequences.
    val escapedString = "Hello,\nWelcome to \"Kotlin\"\tProgramming"
    println(escapedString)
    /*
        Common escape sequences:
        \n  -> new line
        \t  -> tab
        \"  -> double quote
        \\  -> backslash
        \$  -> literal dollar sign (needed because $ is used for templates)
    */
    println("Escaped dollar: \$100")
    println()


    println("========== 3. RAW STRING (Triple-Quoted String) ==========")
    // No need to escape characters. Great for multi-line text, JSON, regex, HTML.
    val rawString = """
        Hello,
        This is a raw string.
        No need to escape "quotes" or \backslashes\.
    """.trimIndent()
    println(rawString)
    println()

    val jsonExample = """
        {
            "name": "John",
            "age": 30
        }
    """.trimIndent()
    println("Raw string used for JSON:\n$jsonExample")
    println()


    println("========== 4. STRING TEMPLATES (Interpolation) ==========")
    val userName = "Alice"
    val userAge = 28

    // Simple variable insertion
    println("My name is $userName")

    // Expression insertion using ${}
    println("Next year I will be ${userAge + 1} years old")

    // Works inside raw strings too
    val templateInRaw = """
        User: $userName
        Age next year: ${userAge + 1}
    """.trimIndent()
    println(templateInRaw)
    println()


    println("========== 5. STRING IMMUTABILITY ==========")
    // Strings in Kotlin are IMMUTABLE - operations create NEW strings
    val original = "Hello"
    val modified = original + " World"
    println("Original: $original")   // unchanged
    println("Modified: $modified")   // new string
    println()


    println("========== 6. NULLABLE STRING ==========")
    var nullableStr: String? = null
    println("Nullable string value: $nullableStr")

    nullableStr = "Now I have a value"
    // Safe call operator
    println("Length using safe call: ${nullableStr?.length}")

    // Elvis operator for default value
    val safeLength = nullableStr?.length ?: 0
    println("Safe length with default: $safeLength")
    println()


    println("========== 7. MUTABLE STRING (StringBuilder) ==========")
    // String itself is immutable, so use StringBuilder for mutable operations
    val builder = StringBuilder()
    builder.append("Hello")
    builder.append(" ")
    builder.append("World")
    builder.insert(5, ",")
    println("StringBuilder result: $builder")
    println("Converted to String: ${builder.toString()}")
    println()


    println("========== 8. EMPTY vs BLANK STRING ==========")
    val emptyStr = ""
    val blankStr = "   "
    val normalStr = "Kotlin"

    println("emptyStr.isEmpty()  = ${emptyStr.isEmpty()}")
    println("blankStr.isEmpty()  = ${blankStr.isEmpty()}")
    println("blankStr.isBlank()  = ${blankStr.isBlank()}")
    println("normalStr.isBlank() = ${normalStr.isBlank()}")
    println()


    println("========== 9. STRING COMPARISON ==========")
    val str1 = "Kotlin"
    val str2 = "Kotlin"
    val str3 = String(charArrayOf('K','o','t','l','i','n'))

    println("str1 == str2 (structural equality): ${str1 == str2}")   // true, compares content
    println("str1 === str3 (referential equality): ${str1 === str3}") // false, different objects
    println("str1.equals(str2): ${str1.equals(str2)}")
    println("str1.equals(str2, ignoreCase = true): ${str1.equals("KOTLIN", ignoreCase = true)}")
    println("str1.compareTo(str2): ${str1.compareTo(str2)}")
    println()


    println("========== 10. STRING INDEXING & ITERATION ==========")
    val word = "Kotlin"
    println("First char: ${word[0]}")
    println("Last char: ${word[word.length - 1]}")
    println("Iterating characters:")
    for (ch in word) {
        print("$ch-")
    }
    println()
    println()


    println("========== 11. COMMON STRING FUNCTIONS ==========")
    val sample = "  Hello Kotlin World  "

    println("Original      : '$sample'")
    println("trim()        : '${sample.trim()}'")
    println("length        : ${sample.length}")
    println("uppercase()   : ${sample.uppercase()}")
    println("lowercase()   : ${sample.lowercase()}")
    println("replace()     : ${sample.trim().replace("Kotlin", "World")}")
    println("contains()    : ${sample.contains("Kotlin")}")
    println("startsWith()  : ${sample.trim().startsWith("Hello")}")
    println("endsWith()    : ${sample.trim().endsWith("World")}")
    println("indexOf()     : ${sample.indexOf("Kotlin")}")
    println("substring()   : ${sample.trim().substring(6)}")
    println("split()       : ${sample.trim().split(" ")}")
    println("reversed()    : ${sample.trim().reversed()}")
    println("repeat(2)     : ${"Hi".repeat(2)}")
    println("padStart()    : ${"5".padStart(3, '0')}")
    println("padEnd()      : ${"5".padEnd(3, '0')}")
    println()


    println("========== 12. STRING TO OTHER TYPES (Conversion) ==========")
    val numberStr = "123"
    val doubleStr = "45.67"

    val toInt = numberStr.toInt()
    val toDouble = doubleStr.toDouble()
    val toIntOrNull = "abc".toIntOrNull() // returns null instead of crashing

    println("toInt(): $toInt")
    println("toDouble(): $toDouble")
    println("toIntOrNull() on invalid string: $toIntOrNull")
    println()


    println("========== 13. OTHER TYPES TO STRING ==========")
    val num = 100
    val dbl = 3.14
    val boolVal = true

    println("num.toString(): ${num.toString()}")
    println("dbl.toString(): ${dbl.toString()}")
    println("boolVal.toString(): ${boolVal.toString()}")
    println()


    println("========== 14. MULTILINE + FORMATTED STRING ==========")
    val formatted = String.format("Name: %s, Age: %d, Score: %.2f", "Bob", 25, 89.456)
    println(formatted)
    println()


    println("========== 15. STRING ARRAY / LIST ==========")
    val fruits = listOf("Apple", "Banana", "Cherry")
    println("Joined: ${fruits.joinToString(", ")}")
    println("Joined with prefix/suffix: ${fruits.joinToString(prefix = "[", postfix = "]", separator = " | ")}")
    println()

    println("========== END OF STRING DATATYPE GUIDE ==========")
}

/*
============================================================
 SUMMARY TABLE (as comments for quick reference)
============================================================

 Type                | Syntax                  | Multi-line | Escapes | Use Case
---------------------|--------------------------|------------|---------|----------------------------
 Escaped String       | "text"                  | No         | Yes     | General text
 Raw String           | """text"""              | Yes        | No      | Templates, JSON, regex
 Template String      | "$var" / "${expr}"      | Depends    | Depends | Dynamic content
 Mutable String       | StringBuilder()         | Yes        | N/A     | Building strings in loops
 Nullable String      | String?                 | N/A        | N/A     | Optional values

 Key Facts:
 - Kotlin String maps to java.lang.String on JVM (immutable).
 - Use == for content comparison, === for reference comparison.
 - Use StringBuilder for heavy string modifications (loops, concatenation).
 - Use raw strings (triple quotes) to avoid escaping characters.
 - Nullable strings require safe call (?.) or Elvis operator (?:).
============================================================
*/