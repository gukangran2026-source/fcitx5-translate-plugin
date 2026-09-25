pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
        maven("https://maven.fcitx.workers.dev")
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven("https://maven.fcitx.workers.dev")
    }
    // library alias should be in sync with https://github.com/fcitx5-android/fcitx5-android/blob/master/gradle/libs.versions.toml
    versionCatalogs {
        create("libs") {
            plugin("kotlin.android", "org.jetbrains.kotlin.android").version("2.2.21")

            version("android", "8.13.0")
            plugin("android.application", "com.android.application").versionRef("android")
            plugin("android.library", "com.android.library").versionRef("android")

            plugin("aboutlibraries", "com.mikepenz.aboutlibraries.plugin").version("12.2.4")
            library("android.desugarJDKLibs", "com.android.tools", "desugar_jdk_libs").version("2.1.5")

            version("main", "0.1.2")

            fun pluginA(id: String) = plugin("fcitx5-android.$id", "org.fcitx.fcitx5.android.$id").versionRef("main")
            pluginA("app-convention")
            pluginA("lib-convention")
            pluginA("plugin-app-convention")
            pluginA("build-metadata")
            pluginA("data-descriptor")
            pluginA("fcitx-component")
            pluginA("fcitx-headers")
            pluginA("native-app-convention")
            pluginA("native-lib-convention")

            fun libraryA(id: String) = library("fcitx5-android.$id", "org.fcitx.fcitx5.android.lib", id).versionRef("main")
            libraryA("plugin_base")
            libraryA("common")
        }
    }
}
rootProject.name = "fcitx5-android-plugin-translate"
include(":app")
