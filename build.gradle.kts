plugins {
    // we define the version of plugin that is used globally. We don't apply the plugin to
    // any module. You need to add it to each module, but without version number.
    id("com.android.library").version("7.3.1") apply false
    kotlin("multiplatform") version "1.7.21" apply false
    // KMMBridge is gradle tools for publishing Xcode frameworks. Used for making iOS KMM module available to use
    id("co.touchlab.faktory.kmmbridge") version "0.3.4" apply false
}