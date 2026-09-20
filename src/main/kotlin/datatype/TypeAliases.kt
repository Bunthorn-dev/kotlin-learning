package datatype

typealias Username = String
typealias AccountNo = String
typealias TransactionAmount = Double
typealias Progress = () -> Unit
typealias Failure = (errorCode: String,errorMessage: String) -> Unit
typealias Success = (BankAccount) -> Unit

fun main() {
    val toAccountNo: AccountNo = "10000002320"
    val transactionAmount: TransactionAmount = 100.0
    
    // lamda function
    transfer(
        toAccountNo = toAccountNo,
        transactionAmount = transactionAmount,
        onProgress = {
            println("Transfer is processing")
        },
        onSuccess = {
            println("Account is $it")
        },
        onFailure = {
            errorCode, errorMessage ->
            println("===> Error Code is $errorCode")
            println("===> Error Message is $errorMessage")
        }
    )
}

fun transfer(
    toAccountNo: String,
    transactionAmount: TransactionAmount,
    onProgress: Progress,
    onSuccess: Success,
    onFailure: Failure
) {
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

    onProgress()

    // array object
    val accountList: List<BankAccount> = listOf(savingAccount, currentAccount)

    val account = accountList.find { account -> account.accountNumber == toAccountNo }

    if (account == null) {
        onFailure("TN1234", "Receiver account not found")
    } else {
        onSuccess(account)
    }
}
