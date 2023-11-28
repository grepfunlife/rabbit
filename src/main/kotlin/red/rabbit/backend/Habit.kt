package red.rabbit.backend

import com.github.vokorm.KEntity
import com.gitlab.mvysny.jdbiorm.Dao
import jakarta.validation.constraints.NotNull
import red.rabbit.backend.enums.HabitType

data class Habit(
    override var id: Long? = null,

    @field:NotNull
    var name: String? = null,

    @field:NotNull
    var habitType: HabitType? = null
) : KEntity<Long>  {
    companion object : Dao<Habit, Long>(Habit::class.java)
}