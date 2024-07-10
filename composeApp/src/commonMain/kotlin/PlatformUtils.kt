import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.TextUnit

@Composable
expect fun setTranslucentBars(darkTheme: Boolean)

@Composable
expect fun SunAnimationView(modifier: Modifier = Modifier, fontSize: TextUnit)

@Composable
expect fun MapView(modifier: Modifier)