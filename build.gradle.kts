plugins {
    // we define the version of plugin that is used globally. We don't apply the plugin to
    // any module. You need to add it to each module, but without version number.
    id("com.android.library").version("7.3.1") apply false
    kotlin("multiplatform") version "1.7.21" apply false
    id("co.touchlab.faktory.kmmbridge") version "0.3.4" apply false // used for building and deploying SPM snapshots
}