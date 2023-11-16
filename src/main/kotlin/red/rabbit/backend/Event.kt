package red.rabbit.backend

import com.github.vokorm.KEntity
import com.gitlab.mvysny.jdbiorm.Dao
import java.util.Date

data class Event(
    override var id: Long? = null,

    var habit: Habit? = null,

    var date: Date? = null
) : KEntity<Long> {
    companion object : Dao<Event, Long>(Event::class.java)
}