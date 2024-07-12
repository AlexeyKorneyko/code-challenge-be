package com.finmid

import org.flywaydb.core.Flyway
import org.testcontainers.containers.PostgreSQLContainer

fun postgreSqlContainer() =
    PostgreSQLContainer("postgres:16")
        .withEnv("POSTGRES_HOST_AUTH_METHOD", "trust")
        .withDatabaseName("postgres")
        .withUsername("postgres")
        .apply {
            start()
            Flyway
                .configure()
                .dataSource(jdbcUrl, username, password)
                .load()
                .migrate()
        }
