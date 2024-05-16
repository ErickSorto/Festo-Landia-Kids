import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

private val DarkColorScheme = darkColorScheme(
    primary = Color(0xFFFFD700),
    secondary = Color(0xFFFFD700),
    tertiary = Color(0xFFFFD700)
)



private val LightColorScheme = lightColorScheme(
    primary = Color(0xFFFFD700),
    secondary = Color(0xFFFFD700),
    tertiary = Color(0xFFFFD700)
)

object CustomColors {
    val Yellow = Color(0xFFFFD700)
    val LightYellow = Color(0xFFFFFFE0)
    val DarkYellow = Color(0xFFB8860B)
    // Add more custom colors as needed
}
data class AppColors(
    val primary: Color,
    val secondary: Color,
    val tertiary: Color,
)

val LocalAppColors = staticCompositionLocalOf {
    AppColors(
        primary = CustomColors.Yellow,
        secondary = CustomColors.LightYellow,
        tertiary = CustomColors.DarkYellow
    )
}


@Composable
fun FestoLandiaKidsTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) DarkColorScheme else LightColorScheme
    setTranslucentBars(darkTheme)
    MaterialTheme(
        colorScheme = colorScheme,
        typography = MaterialTheme.typography,
        content = content
    )
}
