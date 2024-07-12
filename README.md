### Objective

Your assignment is to implement a feature for a fake financial institution using Kotlin.

### Brief

The domain contains of accounts with predefined balances.
```kotlin
data class Account(
    val accountId: String,
    val balance: BigDecimal,
)
```
And there is existing logic for account creation.
```kotlin
interface AccountService {
    fun create(account: Account)
    fun findBy(accountId: String): Account
}
```

You have to implement a feature that allows moving funds between these accounts.


All the best and happy coding,

The finmid Team.
