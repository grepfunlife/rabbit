pluginManagement {
    val vaadin_version: String by settings
    plugins {
        id("com.vaadin") version vaadin_version
    }
}

rootProject.name = "rabbit"