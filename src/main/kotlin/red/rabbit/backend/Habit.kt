package red.rabbit.backend

import com.github.vokorm.KEntity
import com.gitlab.mvysny.jdbiorm.Dao

data class Habit(
    override var id: Long? = null,

    var name: String? = null,

    var habitType: HabitType? = null
) : KEntity<Long>  {
    companion object : Dao<Habit, Long>(Habit::class.java)
}