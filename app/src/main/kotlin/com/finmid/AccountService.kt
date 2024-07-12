package com.finmid

import java.math.BigDecimal

class AccountService(
    private val accountRepository: AccountRepository,
) {
    fun create(account: Account) {
        if (account.balance < BigDecimal.ZERO) {
            throw IllegalArgumentException("Balance can not be less than zero.")
        }
        accountRepository.createAccount(account)
    }

    fun findBy(accountId: String) = accountRepository.findAccount(accountId)
}
