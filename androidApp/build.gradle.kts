//import org.jetbrains.kotlin.kapt3.base.Kapt.kapt

plugins {
    id("com.android.application")
    kotlin("android")
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
    id("kotlin-parcelize")
    id("com.google.firebase.crashlytics")
    kotlin("plugin.serialization") version Deps.kotlinVersion
}

android {
    signingConfigs {
        create("onda") {
        }
    }
    namespace = "uz.farkhod.weather.android"


    compileSdk = 34
    defaultConfig {
        applicationId = "uz.smartaudit.weather"
        minSdk = 24
        targetSdk = 33
        versionCode = 3
        versionName = "1.0.2"
        vectorDrawables {
            useSupportLibrary = true
        }
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = Deps.composeVersion


    }
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }


    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    packagingOptions {
        resources.excludes.add("META-INF/*")
    }
}

dependencies {
    implementation(project(":shared"))
    implementation(Deps.composeUi)
    implementation(Deps.composeUiTooling)
    implementation(Deps.composeUiToolingPreview)
    implementation(Deps.composeFoundation)
    implementation(Deps.composeMaterial)
    implementation(Deps.activityCompose)
    implementation(Deps.composeIconsExtended)
    implementation(Deps.composeNavigation)
    implementation(Deps.coilCompose)

    //hilt
    implementation(Deps.hiltAndroid)
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.3.1")
    implementation("androidx.activity:activity-compose:1.5.1")
    implementation(platform("androidx.compose:compose-bom:2022.10.00"))
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.material3:material3")
    implementation(project(mapOf("path" to ":shared")))
    implementation(project(mapOf("path" to ":shared")))
    implementation(project(mapOf("path" to ":shared")))
    implementation(project(mapOf("path" to ":shared")))
    implementation(project(mapOf("path" to ":shared")))
    implementation(platform("androidx.compose:compose-bom:2022.10.00"))
    implementation("com.google.android.play:app-update-ktx:+")
    implementation(platform("androidx.compose:compose-bom:2023.03.00"))
    implementation("androidx.leanback:leanback:1.0.0")
    implementation(platform("androidx.compose:compose-bom:2023.03.00"))
    implementation("com.google.firebase:firebase-firestore-ktx:24.8.1")
    implementation("com.google.ar.sceneform:filament-android:1.17.1")
    implementation("com.google.android.libraries.places:places:4.0.0")
    androidTestImplementation(platform("androidx.compose:compose-bom:2022.10.00"))
    androidTestImplementation("androidx.compose.ui:ui-test-junit4")
    androidTestImplementation(platform("androidx.compose:compose-bom:2022.10.00"))
    androidTestImplementation(platform("androidx.compose:compose-bom:2023.03.00"))
    androidTestImplementation(platform("androidx.compose:compose-bom:2023.03.00"))
    debugImplementation("androidx.compose.ui:ui-tooling")
    debugImplementation("androidx.compose.ui:ui-test-manifest")

    kapt(Deps.hiltAndroidCompiler)
    kapt(Deps.hiltCompiler)
    implementation(Deps.hiltNavigationCompose)

    //ktor
    implementation(Deps.ktorAndroid)
    implementation(Deps.ktorWebSocket)
    implementation(Deps.ktorServer)
    implementation(Deps.ktorLogging)
    implementation(Deps.ktorSerialization)
    implementation(Deps.ktorSerializationJson)
    implementation(Deps.ktorClientSer)

    implementation("io.ktor:ktor-client-cio:2.1.3")
    implementation("io.ktor:ktor-client-content-negotiation:2.1.3")
    implementation("ch.qos.logback:logback-classic:1.2.6")
    implementation ("org.jetbrains.kotlinx:kotlinx-serialization-json:1.3.3")
    implementation("io.ktor:ktor-client-content-negotiation:2.1.3")
    implementation("androidx.lifecycle:lifecycle-extensions:2.2.0")
    //splash
    implementation(Deps.splash)

    //system bars customization
    implementation(Deps.systemUiController)

    //accompanist-pager
    implementation(Deps.accompanistPager)

    //accompanist permission
    implementation(Deps.permission)

    //nav animation
    implementation(Deps.navAnimation)

    //firebase BoM
    implementation(Deps.firebaseBOM)

    //firebase analytics
    implementation(Deps.firebaseAnalytics)

    //firebase crashlytics
    implementation(Deps.firebaseCrashLytics)

    //firebase messaging
    implementation(Deps.firebaseMessaging)

    //device name
    implementation(Deps.deviceName)

    // google maps
    implementation(Deps.mapsCompose)
    implementation(Deps.gmsMaps)

    //gms play services location
//    implementation(Deps.gmsLocation)

    //shimmer
    implementation(Deps.shimmer)

    //Camera
    implementation(Deps.camera2)
    implementation(Deps.cameraView)
    implementation(Deps.cameraLifecycle)
    implementation(Deps.cameraCore)

    //calendar
    implementation(Deps.calendar)
    implementation(Deps.ktxDateTime)

  implementation(Deps.exoplayer)

    implementation(Deps.json)
    implementation(Deps.swipereFresh)
}

