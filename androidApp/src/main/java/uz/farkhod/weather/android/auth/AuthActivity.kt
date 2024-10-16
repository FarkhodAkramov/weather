package uz.farkhod.weather.android.auth

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material.MaterialTheme
import androidx.compose.ui.Modifier
import androidx.core.view.WindowCompat
import dagger.hilt.android.AndroidEntryPoint
import uz.farkhod.weather.android.MyApplicationTheme
import uz.farkhod.weather.android.auth.navigation.AuthNavGraph

@AndroidEntryPoint
class AuthActivity : ComponentActivity() {

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContent {
            MyApplicationTheme {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(MaterialTheme.colors.background)
                        .navigationBarsPadding()
                        .imePadding()
                        .systemBarsPadding()
                ) {
                    AuthNavGraph()
                }
            }
        }
    }
}