package com.timofeysin


import org.ktorm.database.Database
import org.ktorm.database.asIterable
import org.ktorm.support.postgresql.PostgreSqlDialect


class ShringService {
    private val database = Database.connect(
        url = "jdbc:postgresql://tesla:5432/",
        driver = "org.postgresql.Driver",
        user = "postgres",
        password = "",
        dialect = PostgreSqlDialect()
    )

    fun findAllBases():List<String>? {
        val names = database.useConnection { conn ->
            val sql = "SELECT datname FROM pg_database;"
            conn.prepareStatement(sql).use { statement ->
                //statement.setInt(1, 1)
                statement.executeQuery().asIterable().map { it.getString(1) }
            }
        }
        return names
    }
}

