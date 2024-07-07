import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
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
        modifier = modifier
    ) {
        Image(
            painter = painterResource(
                Res.drawable.FestoSunLogo
            ),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Fit
        )
    }
}
