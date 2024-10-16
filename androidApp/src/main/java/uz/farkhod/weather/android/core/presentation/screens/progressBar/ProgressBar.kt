package uz.farkhod.weather.android.core.presentation.screens.progressBar

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import uz.farkhod.weather.android.core.presentation.theme.BrandYellow

@Composable
fun ProgressBar(
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.background)
            .clickable(
                indication = null,
                interactionSource = remember { MutableInteractionSource() }
            ) {}
    ) {
        CircularProgressIndicator(
            modifier = Modifier
                .size(48.dp)
                .align(Alignment.Center),
            color = BrandYellow,
            strokeWidth = 4.dp
        )
    }
}