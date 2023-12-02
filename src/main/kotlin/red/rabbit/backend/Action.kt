package red.rabbit.backend

import com.github.vokorm.KEntity
import com.gitlab.mvysny.jdbiorm.Dao
import jakarta.validation.constraints.NotNull
import java.time.LocalDate

data class Action(
        override var id: Long? = null,

        @field:NotNull
        var habitId: Long? = null,

        @field:NotNull
        var date: LocalDate? = null
) : KEntity<Long> {
    companion object : Dao<Action, Long>(Action::class.java)

    val habit: Habit? get() = if (habitId == null) null else Habit.findById(habitId!!)
}