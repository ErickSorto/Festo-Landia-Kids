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
    val LightYellow = Color(0xFFFFCC00)
    val DarkYellow = Color(0xFFB8860B)
    val LightSkyBlue = Color(0xFF87CEEB)
    val LightMagenta = Color(0xFFFF66FF)
}
data class AppColors(
    val yellow: Color,
    val lightYellow: Color,
    val darkYellow: Color,
    val lightSkyBlue: Color,
    val lightMagenta: Color
)

val LocalAppColors = staticCompositionLocalOf {
    AppColors(
        yellow = CustomColors.Yellow,
        lightYellow = CustomColors.LightYellow,
        darkYellow = CustomColors.DarkYellow,
        lightSkyBlue = CustomColors.LightSkyBlue,
        lightMagenta = CustomColors.LightMagenta
    )
}


@Composable
fun FestoLandiaKidsTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
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
