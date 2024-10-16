plugins {
    //trick: for the same plugin versions in all sub-modules
    id("com.android.application").version("8.1.1").apply(false)
    id("com.android.library").version("8.0.1").apply(false)
    kotlin("android").version("1.8.10").apply(false)
    kotlin("multiplatform").version("1.8.10").apply(false)
//    id("org.jetbrains.kotlin.android") version "1.8.10" apply false
//    id("org.jetbrains.kotlin.android") version "1.8.10" apply false
//    id("org.jetbrains.kotlin.android") version "1.7.20" apply false

}

buildscript {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
    dependencies {
        classpath(Deps.kotlinGradlePlugin)
        classpath(Deps.androidBuildTools)
        classpath(Deps.hiltGradlePlugin)
//        classpath(Deps.gms)
        classpath(Deps.firebaseCrashlyticsForClasspath)

    }
}

allprojects {
    repositories {
        mavenCentral()
        google()


    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}

