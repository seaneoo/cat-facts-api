package dev.seano.cf

import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.http.content.*
import io.ktor.server.plugins.statuspages.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.configureRouting() {
    install(StatusPages) {
        exception<Throwable> { call, cause ->
            val status = HttpStatusCode.InternalServerError
            call.respondText(text = "${status.value} $cause", status = status)
        }
        status(HttpStatusCode.NotFound) { call, status ->
            call.respondText(text = status.toString(), status = status)
        }
    }

    routing {
        staticResources("/", "static")

        get("/api") {
            call.respondText { "Hello World" }
        }
    }
}
