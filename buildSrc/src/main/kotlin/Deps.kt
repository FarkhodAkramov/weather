object Deps {
    // COMPOSE
    private const val activityComposeVersion = "1.6.1"
    const val activityCompose = "androidx.activity:activity-compose:$activityComposeVersion"

    const val composeVersion = "1.5.4"
    const val composeUi = "androidx.compose.ui:ui:$composeVersion"
    const val composeUiTooling = "androidx.compose.ui:ui-tooling:$composeVersion"
    const val composeUiToolingPreview = "androidx.compose.ui:ui-tooling-preview:$composeVersion"
    const val composeFoundation = "androidx.compose.foundation:foundation:$composeVersion"
    const val composeMaterial = "androidx.compose.material:material:$composeVersion"
    const val composeIconsExtended =
        "androidx.compose.material:material-icons-extended:$composeVersion"

    private const val composeNavigationVersion = "2.5.3"
    const val composeNavigation = "androidx.navigation:navigation-compose:$composeNavigationVersion"

    private const val coilComposeVersion = "2.1.0"
    const val coilCompose = "io.coil-kt:coil-compose:$coilComposeVersion"

    //gson
    const val json = "com.google.code.gson:gson:2.8.5"

    // HILT
    private const val hiltVersion = "2.48"
    private const val hiltCompilerVersion = "1.0.0"
    const val hiltAndroid = "com.google.dagger:hilt-android:$hiltVersion"
    const val hiltAndroidCompiler = "com.google.dagger:hilt-android-compiler:$hiltVersion"
    const val hiltCompiler = "androidx.hilt:hilt-compiler:$hiltCompilerVersion"
    const val hiltNavigationCompose = "androidx.hilt:hilt-navigation-compose:$hiltCompilerVersion"

    // KTOR
    private const val ktorVersion = "2.1.3"
    const val ktorCore = "io.ktor:ktor-client-core:$ktorVersion"
    const val ktorSerialization = "io.ktor:ktor-client-content-negotiation:$ktorVersion"
    const val ktorSerializationJson = "io.ktor:ktor-serialization-kotlinx-json:$ktorVersion"
    const val ktorAndroid = "io.ktor:ktor-client-android:$ktorVersion"
    const val ktorIOS = "io.ktor:ktor-client-ios:$ktorVersion"
    const val ktorLogging = "io.ktor:ktor-client-logging:$ktorVersion"
    const val ktorServer = "io.ktor:ktor-server-netty:$ktorVersion"
    const val ktorClientSer = "io.ktor:ktor-client-serialization:$ktorVersion"
    const val ktorWebSocket= "io.ktor:ktor-client-websockets:$ktorVersion"



    // GRADLE PLUGINS
    const val kotlinVersion = "1.9.20"
    const val kotlinGradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion"
    const val kotlinAuth = "io.ktor:ktor-server-auth:$kotlinVersion"
    const val kotlinJWT = "io.ktor:ktor-server-auth-jwt:$kotlinVersion"
    const val kotlinJWTDecoder = "com.auth0.android:jwtdecode:2.0.2"
    private const val gradleVersion = "7.2.2"
    const val androidBuildTools = "com.android.tools.build:gradle:$gradleVersion"

    const val hiltGradlePlugin = "com.google.dagger:hilt-android-gradle-plugin:$hiltVersion"

    //splash api
    private const val splashVersion = "1.0.0-alpha02"
    const val splash = "androidx.core:core-splashscreen:$splashVersion"

    //system bars customization
    private const val systemUiControllerVersion = "0.28.0"
    const val systemUiController =
        "com.google.accompanist:accompanist-systemuicontroller:$systemUiControllerVersion"

    //compose nav animation
    private const val navAnimationVersion = "0.31.5-beta"
    const val navAnimation =
        "com.google.accompanist:accompanist-navigation-animation:$navAnimationVersion"

    //accompanist pager
    private const val accompanistPagerVersion = "0.12.0"
    val accompanistPager = "com.google.accompanist:accompanist-pager:$accompanistPagerVersion"

    //accompoist permission
    private const val permissionVersion = "0.21.1-beta"
    val permission = "com.google.accompanist:accompanist-permissions:$permissionVersion"

    //google GSM
    private const val gmsVersion = "4.3.15"
//    val gms = "com.google.gms:google-services:$gmsVersion"

    //firebase BoM
    private const val firebaseBOMVersion = "31.2.1"
    val firebaseBOM = "com.google.firebase:firebase-bom:$firebaseBOMVersion"

    //firebase analytics
    private const val firebaseAVersion = "21.2.0"
    val firebaseAnalytics = "com.google.firebase:firebase-analytics-ktx:$firebaseAVersion"

    //firebase crashlytics
    private const val firebaseCrashVersion = "18.2.13"
    val firebaseCrashLytics = "com.google.firebase:firebase-crashlytics-ktx:$firebaseCrashVersion"

    private const val firebaseCrashlyticsForClasspathVersion = "2.9.4"
    val firebaseCrashlyticsForClasspath =
        "com.google.firebase:firebase-crashlytics-gradle:$firebaseCrashlyticsForClasspathVersion"

    //firebase messaging
    private const val firebaseMessagingVersion = "23.0.8"
    val firebaseMessaging = "com.google.firebase:firebase-messaging-ktx:$firebaseMessagingVersion"

    //get device type
    private const val deviceNameVersion = "2.1.1"
    val deviceName = "com.jaredrummler:android-device-names:$deviceNameVersion"

    // google map
    private const val mapsComposeVersion = "2.11.0"
    val mapsCompose = "com.google.maps.android:maps-compose:$mapsComposeVersion"

    private const val gmsMapsVersion = "18.1.0"
    val gmsMaps = "com.google.android.gms:play-services-maps:$gmsMapsVersion"

    //gms play services location
    private const val gmsLocationVersion = "21.0.1"
//    val gmsLocation = "com.google.android.gms:play-services-location:$gmsLocationVersion"

    private const val shimmerVersion = "1.0.4"
    val shimmer = "com.valentinilk.shimmer:compose-shimmer:$shimmerVersion"

    //Camera
    private val camera2Version = "1.1.0-alpha08"

    val camera2 = "androidx.camera:camera-camera2:$camera2Version"
    val cameraExtention = "androidx.camera:camera-extensions:$camera2Version"
    val cameraCore = "androidx.camera:camera-core:$camera2Version"

    private val cameraViewVersion = "1.3.0-rc01"
    val cameraView = "androidx.camera:camera-view:$cameraViewVersion"
    private val cameraLifecycleVersion = "1.0.1"
    val cameraLifecycle = "androidx.camera:camera-lifecycle:$cameraLifecycleVersion"

    //calendar
    private val calendarVersion = "1.1.0"
    val calendar = "io.github.boguszpawlowski.composecalendar:composecalendar:$calendarVersion"
    val ktxDateTime = "io.github.boguszpawlowski.composecalendar:kotlinx-datetime:$calendarVersion"

    //expo player
    private val exoplayerVersion = "2.18.7"
    val exoplayer = "com.google.android.exoplayer:exoplayer:$exoplayerVersion"

    //swipereFresh
    private val swipereFreshVersion = "0.30.1"
    val swipereFresh = "com.google.accompanist:accompanist-swiperefresh:$swipereFreshVersion"
}