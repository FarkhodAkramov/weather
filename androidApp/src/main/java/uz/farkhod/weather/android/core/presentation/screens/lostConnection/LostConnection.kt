package uz.farkhod.weather.android.core.presentation.screens.lostConnection


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import uz.farkhod.weather.android.core.presentation.theme.BrandBlack
import uz.farkhod.weather.android.core.presentation.theme.BrandWhite

import uz.farkhod.weather.android.core.presentation.theme.medium16

@Composable
fun LostConnectionScreen(
    text: String,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(BrandWhite)
            .padding(40.dp)
    ) {
        Spacer(
            modifier = Modifier
                .fillMaxHeight()
                .weight(1f)
        )
        Column(
            modifier = Modifier
                .fillMaxHeight()
                .weight(8f)
        ) {

            Box(
                modifier = Modifier
                    .fillMaxWidth()

            ) {

                Column(
                    modifier = Modifier
                        .align(Alignment.TopCenter)
                ) {
                    Spacer(modifier = Modifier.height(64.dp))

                }

            }
            Spacer(modifier = Modifier.height(40.dp))
            Text(
                text = text,
                style = medium16,
                color = BrandBlack,
                modifier = Modifier
                    .fillMaxWidth(),
                textAlign = TextAlign.Center
            )
        }
    }
}