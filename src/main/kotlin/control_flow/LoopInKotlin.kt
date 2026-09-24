package control_flow

fun main() {
    val accountList: List<String> = listOf("Saving", "Deposit", "Junior", "Business", "Loan")
    println(accountList[0])
    println(accountList.size)
    for(item in accountList){
        println("==> $item")
    }
}