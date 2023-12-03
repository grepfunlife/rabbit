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
import red.rabbit.backend.Action


@Route("action", layout = MainLayout::class)
@PageTitle("Action")
class ActionView: KComposite(), HasUrlParameter<Long> {
    private lateinit var habitName: Text
    private lateinit var date: Text
    private lateinit var editLink: RouterLink
    private val root = ui {
        verticalLayout {
            div {
                strong("Name: ")
                this@ActionView.habitName = text("")
            }
            div {
                strong("Date: ")
                this@ActionView.date = text("")
            }
            editLink = routerLink(null, "Edit")
//            routerLink(null, "List of Habits", HabitsView::class)
        }
    }

    override fun setParameter(event: BeforeEvent, actionId: Long?) {
        val action = Action.getById(actionId!!)
        habitName.text =  Habit.getById(action.habitId!!).name
        date.text = action.date.toString()
        editLink.setRoute(EditActionView::class, actionId)
    }

    companion object {
        fun navigateTo(actionId: Long) = navigateTo(ActionView::class, actionId)
    }

}