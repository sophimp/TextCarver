pluginManagement {
    repositories {
        gradlePluginPortal()
        mavenCentral()
        maven(url = "https://maven.pkg.jetbrains.space/public/p/compose/dev")
    }
}

rootProject.name = "TextCarver"

include(":multiplatform-markdown-renderer")
include(":app")
include(":compose-desktop")