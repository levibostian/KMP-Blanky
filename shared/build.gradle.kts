import org.jetbrains.kotlin.gradle.plugin.mpp.pm20.util.archivesName

plugins {
    id("com.android.library")
    kotlin("multiplatform")
    id("maven-publish")
    id("co.touchlab.faktory.kmmbridge")
}

val packageName = "earth.levi"
val libraryName = "dropbox"
val libraryVersion = System.getenv("LIBRARY_VERSION") ?: "local"

group = packageName
version = libraryVersion

repositories {
    gradlePluginPortal()
    google()
    mavenCentral()
}

kotlin {
    android {
        publishLibraryVariants("release", "debug")
    }
    ios {
        binaries {
            framework {
                baseName = libraryName
            }
        }
    }
    js {
        browser() // include if you want to create client-side js
        nodejs()  // include if you want to create server-side js
    }
    
    sourceSets {
        val commonMain by getting
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }

        val androidMain by getting
        val androidTest by getting

        val iosMain by getting
        val iosTest by getting

        val jsMain by getting
        val jsTest by getting
    }
}

android {
    namespace = "$packageName.$libraryName"
    compileSdk = 32
    defaultConfig {
        minSdk = 21
        targetSdk = 32
    }
}

kmmbridge {
    mavenPublishArtifacts()
    manualVersions()
    spm(commitManually = true)
}

addGithubPackagesRepository()