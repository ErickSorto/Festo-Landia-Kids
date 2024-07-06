import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.interop.UIKitView
import kotlinx.cinterop.ExperimentalForeignApi
import platform.UIKit.*
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
            UIView().apply {
                backgroundColor = UIColor.clearColor
                opaque = false
                setClipsToBounds(true)
            }
        },
        background = Color.Transparent,
        update = {
            val imageView = UIImageView().apply {
                image = UIImage.imageNamed("FestoLandiaKidsSunLogo") // Replace with your actual PNG resource name
                translatesAutoresizingMaskIntoConstraints = false
                contentMode = UIViewContentModeScaleAspectFit
                backgroundColor = UIColor.clearColor
                opaque = false
            }
            it.addSubview(imageView)

            NSLayoutConstraint.activateConstraints(
                listOf(
                    imageView.widthAnchor.constraintEqualToAnchor(it.widthAnchor),
                    imageView.heightAnchor.constraintEqualToAnchor(it.heightAnchor),
                    imageView.centerXAnchor.constraintEqualToAnchor(it.centerXAnchor),
                    imageView.centerYAnchor.constraintEqualToAnchor(it.centerYAnchor)
                )
            )
        }
    )
}