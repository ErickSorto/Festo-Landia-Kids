import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.interop.UIKitView
import kotlinx.cinterop.ExperimentalForeignApi
import androidx.compose.ui.platform.ComposeViewController

@Composable
actual fun setTranslucentBars(darkTheme: Boolean) {
    // no-op
}


@OptIn(ExperimentalForeignApi::class)
@Composable
actual fun SunAnimationView(modifier: Modifier) {
    UIKitView(
        modifier = modifier,
        factory = {
            UIImageView().apply {
                image = UIImage.imageNamed("FestoLandiaKidsSunLogo") // Replace with your actual PNG resource name
                backgroundColor = UIColor.clearColor
                opaque = false
                contentMode = UIViewContentMode.ScaleAspectFit
            }
        },
        update = {
            it.setImage(UIImage.imageNamed("FestoLandiaKidsSunLogo"))
        }
    )
}