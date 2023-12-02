package red.rabbit.backend

import com.github.mvysny.karibudsl.v10.*
import com.vaadin.flow.component.HasComponents
import red.rabbit.backend.enums.HabitType
import red.rabbit.ui.HabitView
import red.rabbit.ui.HabitsView

class HabitEditor: KComposite() {
    private val binder = beanValidationBinder<Habit>()
    var habit: Habit? = null
        set(value) {
            field = value
            if (value != null) binder.readBean(value)
        }

    private val root = ui {
        verticalLayout {
            isMargin = false
            textField("Name") {
                bind(binder).bind(Habit::name)
            }
            comboBox<HabitType>("HabitType") {
                setItems(*HabitType.entries.toTypedArray())
                bind(binder).bind(Habit::habitType)
            }
            button("Save") {
                onLeftClick { _ ->
                    val habit = habit!!
                    if(binder.validate().isOk && binder.writeBeanIfValid(habit)) {
                        habit.save()
                        HabitView.navigateTo(habit.id!!)
                    }
                }
            }
            routerLink(null, "List of Habits", HabitsView::class)
        }
    }
}

fun HasComponents.habitEditor(block: HabitEditor.() -> Unit = {}) = init(HabitEditor(), block)