package uz.farkhod.weather.android.auth.navigation

sealed class AuthScreens(val route: String) {


    object SignIn : AuthScreens("sign_in")

    object ForgotPassword : AuthScreens("fot_got_password")
    object SmsVerification : AuthScreens("sms_verification")

    data object NewPassword:AuthScreens("new_password")

    data object MainPage:AuthScreens("main")


}
