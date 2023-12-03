package red.rabbit.backend.api

import io.javalin.Javalin
import io.javalin.http.NotFoundResponse
import red.rabbit.backend.Habit

fun Javalin.habitRest() {
    get("/rest/habit/{id}") { ctx ->
        val id = ctx.pathParam("id").toLong()
        ctx.json(Habit.findById(id) ?: throw NotFoundResponse("No habit with id $id"))
    }
    get("/rest/habits") { ctx -> ctx.json(Habit.findAll()) }
}