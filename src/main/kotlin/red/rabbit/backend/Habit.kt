package red.rabbit.backend

import com.github.vokorm.KEntity
import com.gitlab.mvysny.jdbiorm.Dao

data class Habit(
    override var id: Long?,

    var name: String,

    var type: HabitType
) : KEntity<Long>  {
    companion object : Dao<Habit, Long>(Habit::class.java)
}