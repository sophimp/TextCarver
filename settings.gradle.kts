pluginManagement {
    includeBuild("build-plugin")
    repositories {
        gradlePluginPortal()
        mavenCentral()
        maven(url = "https://maven.pkg.jetbrains.space/public/p/compose/dev")
    }
}

rootProject.name = "TextCarver"

include(":rich-editor")
include(
    ":sample:android",
    ":sample:desktop",
    ":sample:web",
    ":sample:common",
    ":richeditor-compose"
)