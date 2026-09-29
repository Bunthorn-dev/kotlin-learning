package control_flow

fun main() {
    val accountList: List<String> = listOf("Saving", "Deposit", "Junior", "Business", "Loan")
    accountList(accountList)

    val electronicDevice: List<String> = listOf("Laptop", "DeskTop", "Monitor", "Keyboard", "Mouse")
//    electronicDevice(electronicDevice)

    val electronicDeviceA: Array<String> = arrayOf("Laptop", "DeskTop", "Monitor", "Keyboard", "Mouse")
//    electronicDeviceA(electronicDeviceA)
}

fun accountList(accountList: List<String>) {
    println(accountList[0])
    println(accountList.size)
    for(item in accountList.indices){
        println("==> ${accountList[item]} is at $item")
    }
}

/**
 * - Practice for loop
 * - Create an array related electronic device
 * - Use for loop and print the element of an array
 * -
 * **/

fun electronicDevice(electronicDevice: List<String>) {
    for(item in electronicDevice){
        println("==> $item")
    }
}

fun electronicDeviceA(electronicDevice: Array<String>) {
    for(item in electronicDevice){
        println("==> $item")
    }
}
