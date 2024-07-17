package mainScreen

import CustomColors.LightMagenta
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.List
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import navigation.ScreenGraph
import navigation.Screens


@Composable
fun MainScreenView(
    onNavigateTo: (Screens) -> Unit
) {
    val navController = rememberNavController()
    Scaffold(
        containerColor = Color.Transparent,
        bottomBar = {
            NavigationBar {
                NavigationBarItem(
                    icon = { Icon(Icons.Default.Home, contentDescription = "Home") },
                    label = { Text("Home") },
                    selected = false,
                    onClick = { /* Handle navigation */ }
                )
                NavigationBarItem(
                    icon = { Icon(Icons.Default.Favorite, contentDescription = "Gallery") },
                    label = { Text("Gallery") },
                    selected = false,
                    onClick = { /* Handle navigation */ }
                )
                NavigationBarItem(
                    icon = { Icon(Icons.AutoMirrored.Filled.List, contentDescription = "Categories") },
                    label = { Text("Categories") },
                    selected = false,
                    onClick = { /* Handle navigation */ }
                )
                NavigationBarItem(
                    icon = { Icon(Icons.Default.Phone, contentDescription = "Contact") },
                    label = { Text("Contact") },
                    selected = false,
                    onClick = { /* Handle navigation */ }
                )
            }
        },
        floatingActionButton = {
            FloatingActionButton(onClick = {
                onNavigateTo(Screens.PartyPlanScreen)
            }) {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        Icons.Default.Add,
                        contentDescription = "Create Party",
                        modifier = Modifier.padding(start = 8.dp)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(text = "Create Party", modifier = Modifier.padding(end = 12.dp))
                }
            }
        }
    ) {
        ScreenGraph(
            navController = navController,
        )
    }

}

@Composable
fun GradientButton(
    text: String,
    onClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .padding(16.dp) // Padding to show border stroke
            .background(
                brush = Brush.horizontalGradient(
                    colors = listOf(
                        LightMagenta.copy(alpha = 0.6f),
                        LightMagenta.copy(alpha = 0.4f)
                    )
                ),
                shape = RoundedCornerShape(8.dp)
            )
            .border(
                BorderStroke(2.dp, Color.White),
                shape = RoundedCornerShape(8.dp)
            )
    ) {
        Button(
            onClick = onClick,
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Transparent
            )
        ) {
            Text(text = text)
        }
    }
}

//@Composable
//fun MapView(modifier: Modifier) {
//    val singapore = LatLng(1.35, 103.87)
//    val cameraPositionState = rememberCameraPositionState {
//        position = CameraPosition.fromLatLngZoom(singapore, 10f)
//    }
//    val markerState = remember { MarkerState(position = singapore) }
//
//    GoogleMap(
//        modifier = modifier,
//        cameraPositionState = cameraPositionState
//    ) {
//        Marker(
//            state = markerState,
//            title = "Singapore",
//            snippet = "Marker in Singapore"
//        )
//    }
//}