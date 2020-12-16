package fr.tomus.routes

import fr.tomus.Dao
import io.ktor.application.call
import io.ktor.locations.Location
import io.ktor.locations.get
import io.ktor.mustache.MustacheContent
import io.ktor.response.respond
import io.ktor.routing.Route

@Location("/")
class Home

fun Route.index(dao: Dao) {
    // Uses the location feature to register a get route for '/'.
    get<Home> {
        val repositories = dao.repositories()
        call.respond(MustacheContent("index.hbs", mapOf("repositories" to repositories)))
    }
}
