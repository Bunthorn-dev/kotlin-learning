package datatype

/**
 * ============================================================
 *  FILE: ReferenceType.kt
 *  TOPIC: Complete Guide to Reference Types in Kotlin
 * ============================================================
 *
 *  This file explains everything about Reference Types in Kotlin:
 *  - What a Reference Type is
 *  - Value Type vs Reference Type
 *  - Examples of Reference Types (String, Array, Class, Object, etc.)
 *  - How references work in memory (== vs ===)
 *  - Passing references to functions
 *  - Null references
 *  - Reference types and mutability
 *  - Data classes as reference types
 *  - Autoboxing (primitive -> wrapper reference type)
 *
 *  Run main() to see live output of every concept.
 * ============================================================
 */

fun ReferenceType() {

    println("========== 1. WHAT IS A REFERENCE TYPE? ==========")
    /*
        A Reference Type stores a REFERENCE (memory address/pointer) to an object,
        not the actual value itself. When you assign or pass a reference type,
        you are copying the REFERENCE, not the underlying data.

        In Kotlin, almost everything is an object (unlike Java's raw primitives),
        but under the hood on the JVM:
        - Basic types (Int, Char, Boolean, etc.) are optimized as PRIMITIVES
          when possible (value types) for performance.
        - Everything else (String, Array, custom classes, collections, etc.)
          is a REFERENCE TYPE.
    */
    println("Concept explained in comments above.")
    println()


    println("========== 2. VALUE TYPE vs REFERENCE TYPE ==========")
    // Value-like type (Int is optimized as JVM primitive 'int' internally)
    var x = 10
    var y = x       // y gets a COPY of x's value
    y = 20
    println("x = $x, y = $y")  // x stays 10, because it's a copied value
    println()

    // Reference type behavior (custom class)
    class Box(var value: Int)

    val box1 = Box(10)
    val box2 = box1     // box2 points to the SAME object as box1 (reference copied)
    box2.value = 99
    println("box1.value = ${box1.value}") // 99 -> both point to same object!
    println("box2.value = ${box2.value}") // 99
    println()


    println("========== 3. COMMON REFERENCE TYPES IN KOTLIN ==========")
    val stringRef: String = "Hello"                     // String -> reference type
    val arrayRef: IntArray = intArrayOf(1, 2, 3)         // Array -> reference type
    val listRef: List<Int> = listOf(1, 2, 3)             // Collections -> reference type
    val mapRef: Map<String, Int> = mapOf("a" to 1)       // Map -> reference type
    class Person(val name: String)
    val personRef = Person("Alice")                       // Custom class -> reference type

    println("String reference: $stringRef")
    println("Array reference: ${arrayRef.joinToString()}")
    println("List reference: $listRef")
    println("Map reference: $mapRef")
    println("Custom class reference: ${personRef.name}")
    println()


    println("========== 4. STRUCTURAL (==) vs REFERENTIAL (===) EQUALITY ==========")
    val p1 = Person("Bob")
    val p2 = Person("Bob")
    val p3 = p1

    println("p1 == p2  (structural, compares equals()): ${p1 == p2}")   // false, no equals() override
    println("p1 === p2 (referential, same object?): ${p1 === p2}")      // false, different objects
    println("p1 === p3 (referential, same object?): ${p1 === p3}")      // true, p3 points to same object
    println()

    // With data class, == is auto-generated to compare content
    data class PersonData(val name: String)
    val d1 = PersonData("Bob")
    val d2 = PersonData("Bob")
    println("Data class d1 == d2 (content compared): ${d1 == d2}")  // true
    println("Data class d1 === d2 (reference compared): ${d1 === d2}") // false
    println()


    println("========== 5. PASSING REFERENCE TYPES TO FUNCTIONS ==========")
    fun modifyBox(b: Box) {
        b.value = 500   // modifies the SAME object the caller has
    }

    val myBox = Box(1)
    println("Before function call: ${myBox.value}")
    modifyBox(myBox)
    println("After function call: ${myBox.value}")  // changed! reference was passed
    println()

    fun modifyValue(v: Int) {
        var localCopy = v
        localCopy = 500   // only changes the local copy
    }

    var myInt = 1
    modifyValue(myInt)
    println("Int after function call: $myInt")  // stays 1, value types are copied
    println()


    println("========== 6. ARRAYS ARE MUTABLE REFERENCE TYPES ==========")
    val originalArray = arrayOf(1, 2, 3)
    val aliasArray = originalArray  // same reference
    aliasArray[0] = 999
    println("originalArray[0] after modifying aliasArray: ${originalArray[0]}") // 999
    println()


    println("========== 7. NULL REFERENCES ==========")
    // Reference types can be null (with nullable type ?), value-optimized types can too
    var nullableRef: Person? = null
    println("Nullable reference: $nullableRef")

    nullableRef = Person("Charlie")
    println("Safe call: ${nullableRef?.name}")
    println()


    println("========== 8. AUTOBOXING: PRIMITIVE -> WRAPPER (REFERENCE) TYPE ==========")
    /*
        When a "value-like" type (Int, Boolean, etc.) is used in a context
        requiring an object (like generics, nullable types, or collections),
        Kotlin automatically "boxes" it into its wrapper reference type
        (Integer, Boolean, etc. on the JVM).
    */
    val primitiveInt: Int = 5                 // optimized as JVM primitive 'int'
    val boxedInt: Int? = 5                    // boxed into Integer (reference type) because nullable
    val listOfBoxedInts: List<Int> = listOf(1, 2, 3) // stored as boxed Integers internally

    println("primitiveInt: $primitiveInt")
    println("boxedInt (nullable, becomes reference type): $boxedInt")
    println("listOfBoxedInts (elements boxed): $listOfBoxedInts")

    // Demonstrating boxing causes different identity for nullable Int objects sometimes
    val boxedA: Int? = 200
    val boxedB: Int? = 200
    println("boxedA == boxedB : ${boxedA == boxedB}")     // true (structural)
    println("boxedA === boxedB: ${boxedA === boxedB}")    // may be false! (separate boxed objects outside -128..127 cache)
    println()


    println("========== 9. MUTABLE vs IMMUTABLE REFERENCE TYPES ==========")
    // Reference type object itself can be mutable or immutable
    class MutablePoint(var x: Int, var y: Int)      // mutable reference type
    data class ImmutablePoint(val x: Int, val y: Int) // immutable-by-convention reference type

    val mutablePoint = MutablePoint(1, 1)
    mutablePoint.x = 50 // allowed, internal state changed
    println("Mutable point after change: (${mutablePoint.x}, ${mutablePoint.y})")

    val immutablePoint = ImmutablePoint(1, 1)
    val movedPoint = immutablePoint.copy(x = 50) // must create a NEW object
    println("Immutable original: (${immutablePoint.x}, ${immutablePoint.y})")
    println("Immutable copy with change: (${movedPoint.x}, ${movedPoint.y})")
    println()


    println("========== 10. REFERENCE TYPE IN COLLECTIONS (SHARED STATE RISK) ==========")
    val sharedList = mutableListOf(1, 2, 3)
    val listAlias = sharedList  // same reference

    listAlias.add(4)
    println("sharedList after modifying listAlias: $sharedList") // [1, 2, 3, 4]
    println("Both variables point to the SAME list object")
    println()


    println("========== 11. toString(), hashCode(), equals() FOR REFERENCE TYPES ==========")
    class Animal(val name: String)
    val animal = Animal("Dog")
    println("Default toString(): ${animal.toString()}")      // shows class + hash
    println("Default hashCode(): ${animal.hashCode()}")

    data class AnimalData(val name: String)
    val animalData = AnimalData("Cat")
    println("Data class toString(): ${animalData.toString()}") // meaningful output
    println()

    println("========== END OF REFERENCE TYPE GUIDE ==========")
}

/*
============================================================
 SUMMARY TABLE (as comments for quick reference)
============================================================

 Concept                  | Value Type (e.g. Int)     | Reference Type (e.g. String, Class)
--------------------------|----------------------------|--------------------------------------
 Stores                   | Actual value               | Memory address / reference to object
 Assignment (=)           | Copies the value            | Copies the reference (same object)
 Passed to function        | Copy, changes don't persist | Reference shared, changes persist*
 Default equality (==)     | Compares values             | Compares content (if equals overridden)
 Identity check (===)      | Compares values (rare use)   | Compares memory reference
 Examples in Kotlin        | Int, Long, Double, Boolean,
                              Char (optimized primitives) | String, Array, List, Map, custom
                                                             classes, data classes, objects
 Nullability effect        | Becomes boxed (reference)
                              when made nullable (Int?)   | Already a reference type by nature

 *Note: reassigning the reference itself inside a function does NOT affect
 the caller's reference (only mutating the object's internal state does).

 Key Facts:
 - Kotlin has NO raw primitives visible in source code; everything looks like
   an object, but the compiler optimizes non-nullable basic types (Int, Char,
   Boolean, etc.) into JVM primitives for performance = "value type" behavior.
 - The moment a basic type becomes NULLABLE (Int?) or used generically
   (List<Int>), it gets AUTOBOXED into its wrapper class = reference type.
 - String, Array, collections, and all custom classes are ALWAYS reference types.
 - Use == for content comparison, === for checking if two variables point
   to the exact same object in memory.
 - data class auto-generates equals()/hashCode()/toString() based on content,
   making == comparisons meaningful for reference types.
============================================================
*/