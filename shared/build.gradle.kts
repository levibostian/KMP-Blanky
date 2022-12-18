plugins {
    id("com.android.library")
    kotlin("multiplatform")
}

group = "earth.levi"
version = "1.0-SNAPSHOT"

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
                baseName = "dropbox"
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
    namespace = "earth.levi.dropbox"
    compileSdk = 32
    defaultConfig {
        minSdk = 21
        targetSdk = 32
    }
}
