package red.rabbit.ui

import com.github.mvysny.karibudsl.v10.*
import com.vaadin.flow.component.Text
import com.vaadin.flow.router.BeforeEvent
import com.vaadin.flow.router.HasUrlParameter
import com.vaadin.flow.router.Route
import red.rabbit.backend.Habit
import com.github.mvysny.kaributools.navigateTo
import com.vaadin.flow.router.PageTitle


@Route("habit", layout = MainLayout::class)
@PageTitle("Habit")
class HabitView: KComposite(), HasUrlParameter<Long> {
    private lateinit var name: Text
    private lateinit var type: Text
    private val root = ui {
        verticalLayout {
            div {
               strong("Name: ")
               this@HabitView.name = text("")
            }
            div {
                strong("Habit Type: ")
                this@HabitView.type = text("")
            }
            routerLink(null, "List of Habits", HabitsView::class)
        }
    }

    override fun setParameter(event: BeforeEvent, habitId: Long?) {
        val habit = Habit.getById(habitId!!)
        name.text = habit.name
        type.text = habit.habitType.toString()
    }

    companion object {
        fun navigateTo(habitId: Long) = navigateTo(HabitView::class, habitId)
    }

}