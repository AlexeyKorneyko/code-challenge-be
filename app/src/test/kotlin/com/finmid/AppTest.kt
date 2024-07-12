package com.finmid

import org.jetbrains.exposed.sql.Database
import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class AppTest {
    private val uut = App(db)

    @Test
    fun `creates accounts with balance`() {
        val account = Account("1", "5.00".toBigDecimal())
        uut.accountService.create(account)
        uut.accountService.findBy(account.accountId)
        assertEquals(account, uut.accountService.findBy(account.accountId))
    }

    @Test
    fun `doesn't allow account with negative balance`() {
        val account = Account("2", "-5.00".toBigDecimal())
        assertThrows<IllegalArgumentException> {
            uut.accountService.create(account)
        }.message.also {
            assertEquals("Balance can not be less than zero.", it)
        }
    }

    companion object {
        private val postgreSQLContainer = postgreSqlContainer()
        private val db =
            Database.connect(
                url = postgreSQLContainer.jdbcUrl,
                user = postgreSQLContainer.username,
                password = postgreSQLContainer.password,
            )

        @JvmStatic
        @AfterAll
        fun tearDown() {
            postgreSQLContainer.stop()
        }
    }
}
