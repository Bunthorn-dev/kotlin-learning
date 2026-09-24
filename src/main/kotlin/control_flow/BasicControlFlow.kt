package control_flow

fun main() {
//  getStudentGrade(90.0F)
//    val barCode = "2000"
//    val productId = "0003"
//    getProductName(barCode = barCode, productId = productId)
    val nidCard = "12"
    getTeacherNameByNIdCard(nidCard)
}

fun getStudentGrade(score: Float) {
    var grade = 'E'
    if (score in 90.0 .. 100.0) {
        grade = 'A'
    } else if (score in 80.0 .. 90.0) {
        grade = 'B'
    }

    println(grade)
}

// use if els and when for control flow of kotlin

fun getProductName(barCode: String, productId: String) {
    when {
        barCode == "2000" && productId == "0003" -> {
            println("Product B")
        }
        barCode == "30000" -> {
            print("Another Product")
        }

        else -> {
            println("Unknown Product")
        }
    }
}

fun getTeacherNameByNIdCard(nidCard: String) {
    when (nidCard) {
        "12", "13" -> {
            println("Cambodia's product")
        }
        "14" -> {
            println("Japanese's Iden")
        }
        else -> {
            println("Unknown Teacher")
        }
    }
}











