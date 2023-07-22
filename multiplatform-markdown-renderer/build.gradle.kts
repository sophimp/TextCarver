plugins {
    kotlin("multiplatform")
    id("com.android.library")
    id("org.jetbrains.compose")
    id("org.jetbrains.dokka")
}

android {
    compileSdk = Versions.androidCompileSdk

    defaultConfig {
        minSdk = Versions.androidMinSdk
        targetSdk = Versions.androidTargetSdk
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    namespace = "com.mikepenz.markdown"
}

kotlin {
    jvm()

    //js {
    //    nodejs {}
    //    browser {}
    //    compilations.all {
    //        kotlinOptions {
    //            moduleKind = "umd"
    //            sourceMap = true
    //            sourceMapEmbedSources = null
    //        }
    //    }
    //}

    android {
        publishLibraryVariants("release")
    }
}

dependencies {
    implementation("androidx.core:core-ktx:1.9.0")
    commonMainApi(Deps.Markdown.core)

    commonMainCompileOnly(compose.runtime)
    commonMainCompileOnly(compose.ui)
    commonMainCompileOnly(compose.foundation)
    commonMainCompileOnly(compose.material)

    "androidMainImplementation"(Deps.Compose.coilCompose)
}

tasks.dokkaHtml.configure {
    dokkaSourceSets {
        configureEach {
            noAndroidSdkLink.set(false)
        }
    }
}

//tasks.create<Jar>("javadocJar") {
//    dependsOn("dokkaJavadoc")
//    from("$buildDir/javadoc")
//}

//mavenPublish {
//    releaseSigningEnabled = true
//    androidVariantToPublish = "release"
//}
//
//publishing {
//    repositories {
//        maven {
//            name = "installLocally"
//            setUrl("${rootProject.buildDir}/localMaven")
//        }
//    }
//}