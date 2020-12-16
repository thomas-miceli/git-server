package fr.tomus

import fr.tomus.fr.tomus.entities.Repositories
import fr.tomus.fr.tomus.entities.Repository
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SortOrder
import org.jetbrains.exposed.sql.selectAll
import org.jetbrains.exposed.sql.transactions.transaction

class Dao(val db: Database) {

    fun repositories() = transaction {
        Repositories.selectAll().orderBy(Repositories.id to SortOrder.DESC).map { Repository.fromRow(it) }
    }
}