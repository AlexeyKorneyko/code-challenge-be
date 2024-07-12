package com.finmid

import com.finmid.AccountRepositoryImpl.AccountTable.balance
import org.jetbrains.exposed.dao.id.IdTable
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.selectAll
import org.jetbrains.exposed.sql.transactions.transaction

interface AccountRepository {
    fun createAccount(account: Account)

    fun findAccount(accountId: String): Account?
}

class AccountRepositoryImpl(
    private val db: Database,
) : AccountRepository {
    object AccountTable : IdTable<String>("accounts") {
        override val id = text("account_id").entityId()
        val balance = decimal("balance", 15, 2)
    }

    override fun createAccount(account: Account) {
        transaction(db) {
            AccountTable.insert {
                it[this.id] = account.accountId
                it[this.balance] = account.balance
            }
        }
    }

    override fun findAccount(accountId: String): Account? =
        transaction(db) {
            AccountTable.selectAll().where { AccountTable.id eq accountId }.firstOrNull()?.let {
                Account(it[AccountTable.id].value, it[balance])
            }
        }
}
