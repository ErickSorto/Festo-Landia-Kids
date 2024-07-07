import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import festolandiakids.composeapp.generated.resources.FestoLandiaKidsSunLogo
import festolandiakids.composeapp.generated.resources.FestoSunLogo
import festolandiakids.composeapp.generated.resources.Res
import org.jetbrains.compose.resources.painterResource

@Composable
actual fun setTranslucentBars(darkTheme: Boolean) {
    // no-op
}


@Composable
actual fun SunAnimationView(modifier: Modifier) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier.size(600.dp) // Adjust the size as needed
    ) {
        Image(
            painter = painterResource(
                Res.drawable.FestoSunLogo
            ),
            contentDescription = null,
            modifier = modifier.fillMaxSize(),
            contentScale = ContentScale.Fit
        )
    }
}
