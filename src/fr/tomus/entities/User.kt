package fr.tomus.entities

import org.jetbrains.exposed.dao.id.IntIdTable
import org.jetbrains.exposed.sql.Column
import org.jetbrains.exposed.sql.ResultRow
import java.io.Serializable

// SQL TABLE
object Users : IntIdTable("user") {
    val username: Column<String> = varchar("username", 255)
    val password: Column<String> = varchar("password", 255)
}

// OBJECT
data class User(
    val id: Int?,
    val username: String,
    val password: String,
) : Serializable {
    companion object {
        fun fromRow(resultRow: ResultRow) = User (
            resultRow[Users.id].value,
            resultRow[Users.username],
            resultRow[Users.password]
        )
    }
}