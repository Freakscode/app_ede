// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    var room_version = "2.6.1"
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.kotlin.android) apply false
    alias(libs.plugins.kotlin.compose) apply false
    id("com.google.devtools.ksp") version "2.0.21-1.0.27" apply false
    id("androidx.room") version room_version apply false
    //alias(libs.plugins.ksp) apply false
    //alias(libs.plugins.room) apply false
    //alias(libs.plugins.dagger.hilt) apply false
}