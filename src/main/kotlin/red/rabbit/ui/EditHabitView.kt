package red.rabbit.ui

import com.github.mvysny.karibudsl.v10.*
import com.vaadin.flow.router.BeforeEvent
import com.vaadin.flow.router.HasUrlParameter
import com.vaadin.flow.router.PageTitle
import com.vaadin.flow.router.Route
import red.rabbit.backend.Habit
import red.rabbit.backend.HabitType
import com.github.mvysny.kaributools.navigateTo

@Route("edit-habit", layout = MainLayout::class)
@PageTitle("Edit Habit")
class EditHabitView : KComposite(), HasUrlParameter<Long> {
    private val binder = beanValidationBinder<Habit>()
    private var habit: Habit? = null
    private val root = ui {
        verticalLayout {
            h1("Edit Habit")
            textField("Name") {
                bind(binder).bind(Habit::name)
            }
            comboBox<HabitType>("HabitType") {
                setItems(*HabitType.entries.toTypedArray())
                bind(binder).bind(Habit::habitType)
            }
            button("Save") {
                onLeftClick {
                    val habit = habit!!
                    if (binder.validate().isOk && binder.writeBeanIfValid(habit)) {
                        habit.save()
                        HabitView.navigateTo(habit.id!!)
                    }
                }
            }
            routerLink(null, "List of Habits", HabitsView::class)
        }
    }

    override fun setParameter(event: BeforeEvent?, habitId: Long?) {
        edit(Habit.getById(habitId!!))
    }

    private fun edit(habit: Habit) {
        this.habit = habit
        binder.readBean(habit)
    }

    companion object {
        fun navigateTo(habitId: Long) = navigateTo(EditHabitView::class, habitId)
    }
}