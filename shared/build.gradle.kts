plugins {
    id("com.android.library")
    kotlin("multiplatform")
    id("maven-publish")
    id("co.touchlab.faktory.kmmbridge")
}

group = "earth.levi"
version = System.getenv("LIBRARY_VERSION") ?: "local"

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

// Gradle plugin to generate SPM and/or cocoapods and publishes artifacts for you.
// https://touchlab.github.io/KMMBridge/artifacts/MAVEN_REPO_ARTIFACTS
kmmbridge {
    mavenPublishArtifacts() // publish SPM compiled framework to Maven repository for storage. Package.swift will then point to the zip.
    manualVersions() // we manually update the gradle module version
    spm() // plugin should generate Package.swift file for us
}

addGithubPackagesRepository() // assuming that you're using github actions, this function will setup github packages maven repo for the maven repo to push to.