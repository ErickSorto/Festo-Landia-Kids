import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.TextUnit
import festolandiakids.composeapp.generated.resources.FestoSunLogo
import festolandiakids.composeapp.generated.resources.Res
import org.jetbrains.compose.resources.painterResource
import kotlinx.cinterop.ObjCAction
import platform.CoreLocation.CLLocationCoordinate2DMake
import platform.MapKit.*

@Composable
actual fun setTranslucentBars(darkTheme: Boolean) {
    // no-op
}


@Composable
actual fun SunAnimationView(modifier: Modifier, fontSize: TextUnit
) {
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

@Composable
actual fun MapView(modifier: Modifier) {
    UIKitMapView(modifier = modifier)
}

@Composable
fun UIKitMapView(modifier: Modifier) {
    // This example assumes you have a way to integrate UIKit views in Compose.
    // You'll need to use Compose interop to embed a UIViewRepresentable in Compose.
    val mapView = MKMapView().apply {
        val coordinate = CLLocationCoordinate2DMake(1.35, 103.87)
        val region = MKCoordinateRegionMakeWithDistance(coordinate, 10000.0, 10000.0)
        setRegion(region, animated = true)

        val annotation = MKPointAnnotation()
        annotation.coordinate = coordinate
        annotation.title = "Singapore"
        addAnnotation(annotation)
    }
    UIKitView(modifier = modifier) {
        mapView
    }
}
