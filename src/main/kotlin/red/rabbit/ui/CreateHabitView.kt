package red.rabbit.ui

import com.github.mvysny.karibudsl.v10.KComposite
import com.github.mvysny.karibudsl.v10.h1
import com.github.mvysny.karibudsl.v10.verticalLayout
import com.vaadin.flow.router.PageTitle
import com.vaadin.flow.router.Route
import red.rabbit.backend.Habit
import red.rabbit.backend.HabitEditor
import red.rabbit.backend.habitEditor

@Route("create-habit", layout = MainLayout::class)
@PageTitle("Create Habit")
class CreateHabitView : KComposite() {
    private lateinit var editor: HabitEditor
    private val root = ui {
        verticalLayout {
            h1("New Habit")
            editor = habitEditor {
                habit = Habit()
            }
        }
    }
}