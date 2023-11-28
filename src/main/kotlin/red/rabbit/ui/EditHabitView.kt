package red.rabbit.ui

import com.github.mvysny.karibudsl.v10.*
import com.vaadin.flow.router.BeforeEvent
import com.vaadin.flow.router.HasUrlParameter
import com.vaadin.flow.router.PageTitle
import com.vaadin.flow.router.Route
import red.rabbit.backend.Habit
import com.github.mvysny.kaributools.navigateTo
import red.rabbit.backend.HabitEditor
import red.rabbit.backend.habitEditor

@Route("edit-habit", layout = MainLayout::class)
@PageTitle("Edit Habit")
class EditHabitView : KComposite(), HasUrlParameter<Long> {
    private lateinit var editor: HabitEditor
    private val root = ui {
        verticalLayout {
            h1("Edit Habit")
            editor = habitEditor()
        }
    }

    override fun setParameter(event: BeforeEvent?, habitId: Long?) {
        editor.habit = Habit.getById(habitId!!)
    }

    companion object {
        fun navigateTo(habitId: Long) = navigateTo(EditHabitView::class, habitId)
    }
}