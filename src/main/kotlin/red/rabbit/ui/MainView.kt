package red.rabbit.ui

import com.github.mvysny.karibudsl.v10.*
import com.vaadin.flow.router.PageTitle
import com.vaadin.flow.router.Route
import jakarta.annotation.security.PermitAll

@Route("", layout = MainLayout::class)
@PageTitle("Rabbit")
@PermitAll
class MainView: KComposite() {
    private val root = ui {
        verticalLayout {
            setSizeFull(); content { align(center, middle) }; isMargin = false; isSpacing = true

            h1("Improve your habits")
        }
    }
}
