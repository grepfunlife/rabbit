package red.rabbit.ui

import ActionEditor
import actionEditor
import com.github.mvysny.karibudsl.v10.KComposite
import com.github.mvysny.karibudsl.v10.h1
import com.github.mvysny.karibudsl.v10.verticalLayout
import com.github.mvysny.kaributools.navigateTo
import com.vaadin.flow.router.BeforeEvent
import com.vaadin.flow.router.HasUrlParameter
import com.vaadin.flow.router.PageTitle
import com.vaadin.flow.router.Route
import red.rabbit.backend.Action

@Route("edit-action", layout = MainLayout::class)
@PageTitle("Edit Action")
class EditActionView : KComposite(), HasUrlParameter<Long> {
    private lateinit var editor: ActionEditor
    private val root = ui {
        verticalLayout {
            h1("Edit Action")
            editor = actionEditor()
        }
    }

    override fun setParameter(event: BeforeEvent?, actionId: Long?) {
        editor.action = Action.getById(actionId!!)
    }

    companion object {
        fun navigateTo(actionId: Long) = navigateTo(EditActionView::class, actionId)
    }
}