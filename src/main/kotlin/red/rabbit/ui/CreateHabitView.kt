package red.rabbit.ui

import com.github.mvysny.karibudsl.v10.*
import com.vaadin.flow.router.PageTitle
import com.vaadin.flow.router.Route
import red.rabbit.backend.Habit
import red.rabbit.backend.HabitType

@Route("create-habit", layout = MainLayout::class)
@PageTitle("Create Habit")
class CreateHabitView : KComposite() {
    private val binder = beanValidationBinder<Habit>()
    private val root = ui {
        verticalLayout {
            h1("New Habit")
            textField("Name") {
                bind(binder).bind(Habit::name)
            }
            comboBox<HabitType>("HabitType") {
                setItems(*HabitType.entries.toTypedArray())
                bind(binder).bind(Habit::habitType)
            }
            button("Save") {
                onLeftClick {
                    val habit = Habit()
                    if (binder.writeBeanIfValid(habit)) {
                        habit.save()
                        HabitView.navigateTo(habit.id!!)
                    }
                }
            }
            routerLink(null, "List of Habits", HabitsView::class)
        }
    }
}