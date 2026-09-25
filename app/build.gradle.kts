plugins {
    alias(libs.plugins.fcitx5.android.app.convention)
    alias(libs.plugins.fcitx5.android.plugin.app.convention)
    alias(libs.plugins.fcitx5.android.build.metadata)
    alias(libs.plugins.fcitx5.android.data.descriptor)
}

android {
    namespace = "org.fcitx.fcitx5.android.plugin.translator"

    defaultConfig {
        applicationId = "org.fcitx.fcitx5.android.plugin.translator"
        versionCode = 1
    }

    buildTypes {
        release {
            resValue("string", "app_name", "@string/app_name_release")
            // use debug signing so the release-variant APK is installable for testing;
            // release variant keeps the non-debug plugin manifest (correct intent action)
            signingConfig = signingConfigs.getByName("debug")
        }
        debug {
            resValue("string", "app_name", "@string/app_name_debug")
        }
    }
}

configure<DataDescriptorPluginExtension> {
    excludes.set(listOf("README.md"))
}

dependencies {
    implementation(libs.fcitx5.android.plugin.base)
    implementation(libs.fcitx5.android.common)
}
