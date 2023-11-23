package red.rabbit.backend

import com.github.vokorm.KEntity
import com.gitlab.mvysny.jdbiorm.Dao
import jakarta.validation.constraints.NotNull
import java.util.Date

data class Event(
    override var id: Long? = null,

    @field:NotNull
    var habit: Habit? = null,

    @field:NotNull
    var date: Date? = null
) : KEntity<Long> {
    companion object : Dao<Event, Long>(Event::class.java)
}