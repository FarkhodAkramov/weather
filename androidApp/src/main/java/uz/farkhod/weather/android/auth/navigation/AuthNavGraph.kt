package uz.farkhod.weather.android.auth.navigation

import android.annotation.SuppressLint
import android.app.Activity
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable
import kotlinx.coroutines.launch

import uz.farkhod.weather.auth.main.presentation.MainEvent

import androidx.compose.material.Scaffold
import androidx.compose.runtime.rememberCoroutineScope
import uz.farkhod.weather.android.auth.screens.main.AndroidMainViewModel
import uz.farkhod.weather.android.auth.screens.main.MainScreen
import uz.farkhod.weather.android.auth.screens.main.components.DrawerHeader
import uz.farkhod.weather.android.core.domain.utils.SharedPref

@RequiresApi(Build.VERSION_CODES.O)
@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@OptIn(ExperimentalAnimationApi::class)
@Composable
fun AuthNavGraph() {
    val navController = rememberNavController()
    val context = LocalContext.current
    val activity = LocalContext.current as? Activity

    val scaffoldState = rememberScaffoldState()
    val scope = rememberCoroutineScope()
    val viewModelMain = hiltViewModel<AndroidMainViewModel>()
    val stateMain by viewModelMain.state.collectAsState()

    Scaffold(
        scaffoldState = scaffoldState,
        drawerGesturesEnabled = scaffoldState.drawerState.isOpen,
        drawerContent = {

            DrawerHeader(
                weatherList = stateMain.weatherList,
                onClick = {
                    scope.launch {
                        scaffoldState.drawerState.close()
                    }
//                    viewModelShop.onEvent(OnSaleShopMainEvent.ClearState)
                    viewModelMain.onEvent(MainEvent.CtnChange(it))
                    SharedPref.setCountryCode(context, it)

                },
            )
        },
    ) {
        Scaffold() {
            Box(modifier = Modifier) {
                AnimatedNavHost(
                    navController,
                    AuthScreens.MainPage.route
                ) {
                    composable(AuthScreens.MainPage.route) {

                        MainScreen(
                            state = stateMain,
                            onEvent = { event ->
                                when (event) {

                                    is MainEvent.DrawerClick -> {
                                        scope.launch {
                                            scaffoldState.drawerState.open()
                                        }
                                    }

                                    is MainEvent.CtnChange -> {
                                        SharedPref.setCountryCode(context, event.cntCode)

                                    }





                                    else -> viewModelMain.onEvent(event)
                                }


                            }
                        )


                    }

                }

            }
        }
    }


}