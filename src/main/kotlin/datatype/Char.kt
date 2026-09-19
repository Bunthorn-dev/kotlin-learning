package datatype

/**
 * ============================================================
 *  FILE: CharDatatype.kt
 *  TOPIC: Complete Guide to the Char Datatype in Kotlin
 * ============================================================
 *
 *  This file explains everything about the Char type in Kotlin:
 *  - What Char is
 *  - Declaring characters
 *  - Char vs String
 *  - Escape sequences in Char
 *  - Char to Int / Int to Char (Unicode)
 *  - Char comparison
 *  - Useful Char functions (isDigit, isLetter, etc.)
 *  - Char arithmetic
 *  - Nullable Char
 *  - Converting Char <-> String
 *
 *  Run main() to see live output of every concept.
 * ============================================================
 */

fun CharDataType() {

    println("========== 1. BASIC CHAR DECLARATION ==========")
    // Char represents a SINGLE 16-bit Unicode character, declared with SINGLE quotes
    val letter: Char = 'K'
    println("Char value: $letter")
    println("Type: ${letter::class.simpleName}")
    println()


    println("========== 2. CHAR vs STRING (IMPORTANT DIFFERENCE) ==========")
    val charVersion: Char = 'A'      // single quotes, ONE character only
    val stringVersion: String = "A" // double quotes, can hold 0+ characters
    println("charVersion: $charVersion   -> type: ${charVersion::class.simpleName}")
    println("stringVersion: $stringVersion -> type: ${stringVersion::class.simpleName}")
    // val invalid: Char = 'AB'  // ERROR: Char must contain exactly one symbol
    println()


    println("========== 3. ESCAPE SEQUENCES IN CHAR ==========")
    val newLineChar: Char = '\n'
    val tabChar: Char = '\t'
    val singleQuoteChar: Char = '\''
    val backslashChar: Char = '\\'
    val unicodeChar: Char = '\u0041' // Unicode for 'A'

    println("Tab char between words: A${tabChar}B")
    println("Single quote char: $singleQuoteChar")
    println("Backslash char: $backslashChar")
    println("Unicode char \\u0041: $unicodeChar")
    println()


    println("========== 4. CHAR TO INT (Unicode Code Point) ==========")
    val ch = 'A'
    val code = ch.code   // Kotlin 1.5+ way (preferred)
    println("'$ch'.code = $code")   // 65

    @Suppress("DEPRECATION")
    val oldWayCode = ch.toInt() // older/deprecated approach, still works
    println("'$ch'.toInt() (deprecated) = $oldWayCode")
    println()


    println("========== 5. INT TO CHAR ==========")
    val number = 97
    val charFromCode = number.toChar()
    println("$number.toChar() = $charFromCode")  // 'a'
    println()


    println("========== 6. CHAR ARITHMETIC (Using Code Points) ==========")
    // You can't directly add numbers to Char without conversion issues,
    // but Kotlin allows Char + Int -> Char, and Char - Char -> Int
    val a: Char = 'a'
    val nextChar: Char = a + 1        // 'b'
    val charDiff: Int = 'z' - 'a'     // 25 (difference in code points)

    println("'a' + 1 = $nextChar")
    println("'z' - 'a' = $charDiff")
    println()


    println("========== 7. CHAR COMPARISON ==========")
    val c1 = 'A'
    val c2 = 'B'
    println("c1 == c2 : ${c1 == c2}")
    println("c1 < c2  : ${c1 < c2}")      // true, compares by Unicode value
    println("c1.compareTo(c2): ${c1.compareTo(c2)}")
    println()


    println("========== 8. CHAR CLASSIFICATION FUNCTIONS ==========")
    val testChars = listOf('A', 'z', '5', ' ', '@', '\n')

    for (t in testChars) {
        println(
            "Char: '${if (t == '\n') "\\n" else t}' -> " +
                    "isLetter=${t.isLetter()}, " +
                    "isDigit=${t.isDigit()}, " +
                    "isWhitespace=${t.isWhitespace()}, " +
                    "isUpperCase=${t.isUpperCase()}, " +
                    "isLowerCase=${t.isLowerCase()}, " +
                    "isLetterOrDigit=${t.isLetterOrDigit()}"
        )
    }
    println()


    println("========== 9. CHAR CASE CONVERSION ==========")
    val lower = 'k'
    val upper = 'K'
    println("uppercaseChar(): ${lower.uppercaseChar()}")
    println("lowercaseChar(): ${upper.lowercaseChar()}")
    println()


    println("========== 10. DIGIT CHAR TO ACTUAL NUMBER ==========")
    val digitChar = '7'
    val actualNumber = Character.getNumericValue(digitChar)
    // OR using Kotlin extension:
    val actualNumberKotlin = digitChar - '0'
    println("Character.getNumericValue('7') = $actualNumber")
    println("'7' - '0' = $actualNumberKotlin")
    println()


    println("========== 11. NULLABLE CHAR ==========")
    var nullableChar: Char? = null
    println("Nullable char: $nullableChar")

    nullableChar = 'X'
    println("Safe call isLetter: ${nullableChar?.isLetter()}")
    println("Elvis default: ${nullableChar ?: 'Z'}")
    println()


    println("========== 12. CHAR TO STRING & STRING TO CHAR ==========")
    val singleChar: Char = 'M'
    val convertedToString: String = singleChar.toString()
    println("Char to String: $convertedToString (type: ${convertedToString::class.simpleName})")

    val someString = "Hello"
    val firstCharOfString: Char = someString[0]       // indexing returns Char
    val lastCharOfString: Char = someString.last()    // using function
    println("First char of \"Hello\": $firstCharOfString")
    println("Last char of \"Hello\": $lastCharOfString")
    println()


    println("========== 13. ITERATING OVER CHAR RANGE ==========")
    // Char supports ranges just like Int
    print("a to f range: ")
    for (letterInRange in 'a'..'f') {
        print("$letterInRange ")
    }
    println()

    print("Even-step range (a to z step 2): ")
    for (letterInRange in 'a'..'z' step 2) {
        print("$letterInRange ")
    }
    println()
    println()


    println("========== 14. BUILDING A STRING FROM CHARS ==========")
    val charList = listOf('K', 'o', 't', 'l', 'i', 'n')
    val builtString = charList.joinToString("")
    println("Built string from chars: $builtString")

    val charArray = charArrayOf('J', 'a', 'v', 'a')
    val fromCharArray = String(charArray)
    println("String from CharArray: $fromCharArray")
    println()


    println("========== 15. COUNTING CHAR OCCURRENCES IN STRING ==========")
    val sentence = "kotlin is fun to code in kotlin"
    val countOfK = sentence.count { it == 'k' }
    println("Occurrences of 'k' in sentence: $countOfK")
    println()

    println("========== END OF CHAR DATATYPE GUIDE ==========")
}

/*
============================================================
 SUMMARY TABLE (as comments for quick reference)
============================================================

 Concept                | Example                  | Result / Notes
------------------------|---------------------------|-----------------------------
 Declaration             | val c: Char = 'A'        | Single quotes only, ONE char
 Char vs String          | 'A' vs "A"               | Char = single quote & 1 symbol
 Escape sequence         | '\n', '\t', '\\'         | Same escapes as String
 Char -> Int             | 'A'.code                 | 65 (Unicode code point)
 Int -> Char             | 97.toChar()              | 'a'
 Char + Int -> Char      | 'a' + 1                  | 'b'
 Char - Char -> Int      | 'z' - 'a'                | 25
 Comparison              | 'A' < 'B'                | true (Unicode order)
 isDigit/isLetter/etc.   | '5'.isDigit()            | true
 Case conversion         | 'k'.uppercaseChar()      | 'K'
 Digit char to number    | '7' - '0'                | 7
 Char range              | 'a'..'f'                 | a,b,c,d,e,f
 Char to String          | 'M'.toString()           | "M"
 String to Char          | "Hello"[0]               | 'H'

 Key Facts:
 - Char represents ONE 16-bit Unicode character.
 - Declared with single quotes: 'A' (NOT double quotes).
 - Char is NOT a number type in Kotlin (unlike C/Java direct int cast),
   but arithmetic with Int is supported via + and - operators.
 - Use .code (Kotlin 1.5+) instead of deprecated .toInt() to get Unicode value.
 - Ranges ('a'..'z') and step work on Char just like Int.
============================================================
*/