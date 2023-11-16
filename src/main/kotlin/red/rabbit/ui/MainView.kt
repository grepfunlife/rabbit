package red.rabbit.ui

import com.github.mvysny.karibudsl.v10.*
import com.vaadin.flow.router.PageTitle
import com.vaadin.flow.router.Route
import jakarta.annotation.security.PermitAll

@Route("")
@PageTitle("Habitus")
@PermitAll
class MainView: KComposite() {
    private val root = ui {
        verticalLayout {
            setSizeFull(); content { align(center, middle) }; isMargin = false; isSpacing = true

            h1("Improve your habits")
//            image("images/chucknorris.jpg")
//            div { html("<strong>Vaadin version: </strong> ${VaadinVersion.get}") }
//            div { html("<strong>Kotlin version: </strong> ${KotlinVersion.CURRENT}") }
//            div { html("<strong>JVM version: </strong> $jvmVersion") }
        }
    }
}
