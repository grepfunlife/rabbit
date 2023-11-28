import com.github.mvysny.karibudsl.v10.*
import com.vaadin.flow.component.HasComponents
import com.vaadin.flow.component.orderedlayout.VerticalLayout
import red.rabbit.backend.Action
import red.rabbit.backend.Habit
import red.rabbit.ui.ActionView

class ActionEditor : VerticalLayout() {
    private val binder = beanValidationBinder<Action>()
    var action: Action? = null
        set(value) {
            field = value
            if (value != null) binder.readBean(value)
        }

    init {
        isMargin = false
        datePicker("Date") {
            bind(binder).bind(Action::date)
        }

        comboBox<Habit>("Habit") {
            setItems( Habit.findAll())
//            setItems { Habit.findAll().map { it.id} }
            //TODO:
            setItemLabelGenerator { it.name }
            bind(binder).bind(Action::habit_id)
        }

        button("Save") {
            onLeftClick { event ->
                val action = action!!
                if(binder.validate().isOk && binder.writeBeanIfValid(action)) {
                    action.save()
                    ActionView.navigateTo(action.id!!)
                }
            }
        }
    }
}

fun HasComponents.actionEditor(block: ActionEditor.() -> Unit = {}) = init(ActionEditor(), block)