package dev.seano.cf.route

import io.ktor.server.response.*
import io.ktor.server.routing.*
import kotlinx.serialization.Serializable

val facts = listOf(
    "Some cats are ambidextrous, but 40 percent are either left- or right-pawed.",
    "Male cats are more likely to be left-pawed, while female cats are more likely to be right-pawed.",
    "Cats can jump up to six times their length.",
    "An orange tabby named Stubbs was the mayor of Talkeetna, Alaska for 20 years."
)

@Serializable
data class Facts(val data: List<String>)

fun Route.factsRoute() {
    route("/facts") {
        get {
            call.respond(Facts(facts))
        }
        get("/random") {
            call.respondText { facts.random() }
        }
    }
}
