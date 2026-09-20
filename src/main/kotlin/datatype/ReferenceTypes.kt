package datatype

// Model this class is call reference type
data class BankAccount(
    val accountNumber: String,
    val createDate: String,
    val createTime: String,
    val availableBalance: Double,
    val totalBalance: Double,
    val accountType: String,
    var accountCurrency: String,
)

fun main() {

    // ojbect
    val savingAccount = BankAccount(
        accountNumber = "1000000232",
        createDate = "20241025",
        createTime = "0150",
        availableBalance = 1000000.0,
        totalBalance = 1000000000.0,
        accountType = "SavingAccount",
        accountCurrency = "USD"
    )

    // object
    val currentAccount = BankAccount(
        accountNumber = "1000000232",
        createDate = "20231025",
        createTime = "0150",
        availableBalance = 1000000.0,
        totalBalance = 1000000000.0,
        accountType = "currentAccount",
        accountCurrency = "KHR"
    )

    // array object
    val accountList: List<BankAccount> = listOf(savingAccount, currentAccount)

    for (account in accountList) (
        println(account)
    )
}

