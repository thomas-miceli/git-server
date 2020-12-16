package fr.tomus.fr.tomus.entities

import fr.tomus.entities.Users
import org.jetbrains.exposed.dao.id.IntIdTable
import org.jetbrains.exposed.sql.ResultRow
import java.io.Serializable

// SQL TABLE
object Repositories : IntIdTable("repository") {
    val name = varchar("name", 255)
    val language = varchar("language", 255)
    val private = bool("private")
    val user = reference("user", Users)
}

// OBJECT
data class Repository(
    val id: Int?,
    val name: String,
    val language: String,
    val private: Boolean,
    val user: Int
) : Serializable {
    companion object {
        fun fromRow(resultRow: ResultRow) = Repository (
            resultRow[Repositories.id].value,
            resultRow[Repositories.name],
            resultRow[Repositories.language],
            resultRow[Repositories.private],
            resultRow[Repositories.user].value
        )
    }
}