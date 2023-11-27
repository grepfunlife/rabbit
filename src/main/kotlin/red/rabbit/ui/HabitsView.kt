package red.rabbit.ui

import com.github.mvysny.karibudsl.v10.*
import com.github.mvysny.kaributools.refresh
import com.github.vokorm.dataloader.dataLoader
import com.vaadin.flow.component.grid.Grid
import com.vaadin.flow.data.renderer.NativeButtonRenderer
import com.vaadin.flow.router.AfterNavigationEvent
import com.vaadin.flow.router.AfterNavigationObserver
import com.vaadin.flow.router.Route
import eu.vaadinonkotlin.vaadin.vokdb.setDataLoader
import red.rabbit.backend.Habit
import red.rabbit.confirmDialog

@Route("habits", layout = MainLayout::class)
class HabitsView : KComposite(), AfterNavigationObserver {
    private lateinit var grid: Grid<Habit>
    private val root = ui {
        verticalLayout {
            setSizeFull()
            h1("Habits")
            routerLink(null, "New Habit", CreateHabitView::class)
            grid = grid {
                isExpand = true; setSizeFull()
                setDataLoader(Habit.dataLoader)

                columnFor(Habit::id)
                columnFor(Habit::name)
                columnFor(Habit::habitType)
                addColumn(NativeButtonRenderer<Habit>("Show", { HabitView.navigateTo(it.id!!) }))
                addColumn(NativeButtonRenderer<Habit>("Edit", { EditHabitView.navigateTo(it.id!!) }))
                addColumn(NativeButtonRenderer<Habit>("Delete") { habit ->
                    confirmDialog {
                        habit.delete()
                        this@grid.refresh()
                    }
                })
            }
        }
    }

    override fun afterNavigation(event: AfterNavigationEvent) {
        grid.refresh()
    }
}