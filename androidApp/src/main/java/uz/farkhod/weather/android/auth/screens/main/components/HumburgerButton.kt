package uz.farkhod.weather.android.auth.screens.main.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import uz.farkhod.weather.android.R

@Composable
fun HumburgerButton(modifier: Modifier = Modifier, onClick: () -> Unit) {

    Card(
        modifier = Modifier
            .size(40.dp)
            .clickable {
                onClick()
            },
        shape = RoundedCornerShape(8.dp),
        backgroundColor = Color.Transparent, // Set the Card's background to transparent
        elevation = 0.dp // Optional: Remove shadow if not needed
    ) {
        Box(modifier = Modifier.fillMaxSize()) {
            Image(
                modifier = Modifier.align(Alignment.Center),
                painter = painterResource(id = R.drawable.menu_icon),
                contentDescription = null
            )
        }
    }


}