import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
expect fun setTranslucentBars(darkTheme: Boolean)

@Composable
expect fun SunAnimationView(modifier: Modifier = Modifier)