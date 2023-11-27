package red.rabbit.ui

import ActionEditor
import actionEditor
import com.github.mvysny.karibudsl.v10.KComposite
import com.github.mvysny.karibudsl.v10.h1
import com.github.mvysny.karibudsl.v10.verticalLayout
import com.vaadin.flow.router.PageTitle
import com.vaadin.flow.router.Route
import red.rabbit.backend.Action

@Route("create-action", layout = MainLayout::class)
@PageTitle("Create Habit")
class CreateActionView : KComposite() {
    private lateinit var editor: ActionEditor
    private val root = ui {
        verticalLayout {
            h1("New Action")
            editor = actionEditor() {
                action = Action()
            }
        }
    }
}