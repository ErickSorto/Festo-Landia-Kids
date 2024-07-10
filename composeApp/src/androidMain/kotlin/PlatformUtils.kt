import android.app.Activity
import android.view.View
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.absoluteOffset
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.view.ViewCompat
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.android.libraries.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.MarkerState
import com.google.maps.android.compose.rememberCameraPositionState
import festolandiakids.composeapp.generated.resources.Res
import festolandiakids.composeapp.generated.resources.sun_animation
import org.jetbrains.compose.resources.stringResource
import kottieComposition.KottieCompositionSpec
import kottieComposition.animateKottieCompositionAsState
import kottieComposition.rememberKottieComposition
import utils.KottieConstants

@Composable
actual fun setTranslucentBars(darkTheme: Boolean) {
    val view = LocalView.current
    val context = LocalContext.current
    if (!view.isInEditMode) {
        SideEffect {
            (context as Activity).window.run {
                statusBarColor =
                    Color(0xFF03DAC6).copy(alpha = 0.1f).toArgb()  // Translucent status bar
                navigationBarColor =
                    Color(0xFF03DAC6).copy(alpha = 0.1f).toArgb()  // Translucent navigation bar
                decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_STABLE or
                        View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or
                        View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
            }
            ViewCompat.getWindowInsetsController(view)?.run {
                isAppearanceLightStatusBars = darkTheme
                isAppearanceLightNavigationBars =
                    !darkTheme  // Set navigation bar icons to contrast with the background
            }
        }
    }
}

@Composable
actual fun SunAnimationView(
    modifier: Modifier,
    fontSize: TextUnit
) {

    val density = LocalDensity.current

    // Calculate dynamic offsets and sizes
    val xOffsetSun = with(density) { (fontSize.value * 1.12).sp.toDp() }
    val yOffsetSun = with(density) { -(fontSize.value * 0.41).sp.toDp() }
    val sunSize = with(density) { (fontSize.value * 2.6).sp.toDp() }

    var animation by remember { mutableStateOf("") }

    animation = stringResource(Res.string.sun_animation)


    val composition = rememberKottieComposition(
        spec = KottieCompositionSpec.JsonString(jsonString = animation)
    )

    val animationState by animateKottieCompositionAsState(
        composition = composition,
        iterations = KottieConstants.IterateForever,
        isPlaying = true
    )

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .absoluteOffset(x = xOffsetSun, y = yOffsetSun)
            .size(sunSize) // Adjust the size as needed
    ) {
        KottieAnimation(
            composition = composition,
            progress = { animationState.progress },
            modifier = Modifier.fillMaxSize()
        )
    }
}

@Composable
actual fun MapView(modifier: Modifier) {
    val singapore = LatLng(1.35, 103.87)
    val cameraPositionState = rememberCameraPositionState {
        position = CameraPosition.fromLatLngZoom(singapore, 10f)
    }
    val markerState = remember { MarkerState(position = singapore) }

    GoogleMap(
        modifier = modifier,
        cameraPositionState = cameraPositionState
    ) {
        Marker(
            state = markerState,
            title = "Singapore",
            snippet = "Marker in Singapore"
        )
    }
}