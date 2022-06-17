package com.timofeysin.plugins

import com.github.mustachejava.DefaultMustacheFactory
import io.ktor.server.mustache.Mustache
import io.ktor.server.mustache.MustacheContent
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.request.*
import io.ktor.server.routing.*

fun Application.configureTemplating() {
    install(Mustache) {
        mustacheFactory = DefaultMustacheFactory("templates")
    }

    routing {
        get("/name") {
            call.respond(MustacheContent("index.mustache", mapOf("title" to "Select base","name" to "Все получилось")))
        }
    }
}
data class MustacheUser(val id: Int, val name: String)
