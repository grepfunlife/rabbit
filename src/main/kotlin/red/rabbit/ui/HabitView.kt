package red.rabbit.ui

import com.github.mvysny.karibudsl.v10.*
import com.vaadin.flow.component.Text
import com.vaadin.flow.router.BeforeEvent
import com.vaadin.flow.router.HasUrlParameter
import com.vaadin.flow.router.Route
import red.rabbit.backend.Habit
import com.github.mvysny.kaributools.navigateTo
import com.github.mvysny.kaributools.setRoute
import com.vaadin.flow.router.PageTitle
import com.vaadin.flow.router.RouterLink


@Route("habit", layout = MainLayout::class)
@PageTitle("Habit")
class HabitView: KComposite(), HasUrlParameter<Long> {
    private lateinit var name: Text
    private lateinit var type: Text
    private lateinit var editLink: RouterLink
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
            editLink = routerLink(null, "Edit")
            routerLink(null, "List of Habits", HabitsView::class)
        }
    }

    override fun setParameter(event: BeforeEvent, habitId: Long?) {
        val habit = Habit.getById(habitId!!)
        name.text = habit.name
        type.text = habit.habitType.toString()
        editLink.setRoute(EditHabitView::class, habitId)
    }

    companion object {
        fun navigateTo(habitId: Long) = navigateTo(HabitView::class, habitId)
    }

}