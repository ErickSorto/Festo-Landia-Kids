package onboarding.presentation.components


import LocalAppColors
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.absoluteOffset
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import festolandiakids.composeapp.generated.resources.Res
import festolandiakids.composeapp.generated.resources.vag_rundschrift_d
import onboarding.presentation.KottieAnimationView
import org.jetbrains.compose.resources.Font

@Composable
fun FestoLandiaKidsLogo(
    modifier: Modifier = Modifier,
    fontSize: TextUnit = 105.sp
) {
    val colors = LocalAppColors.current
    val offset = Offset(6.0f, 6.0f)
    val density = LocalDensity.current

    // Calculate dynamic offsets
    val yOffsetFest = with(density) { (fontSize.value / 10).sp.toDp() }
    val yOffsetKids = with(density) { -(fontSize.value / 10).sp.toDp() }
    val xOffsetSun = with(density) { (fontSize.value * 1.17).sp.toDp() }
    val yOffsetSun = with(density) { -(fontSize.value * 0.38).sp.toDp() }
    val sunSize = with(density) { (fontSize.value * 2.43).sp.toDp() }

    Box(
        modifier = modifier
    ) {
        Column {
            Text(
                "FEST",
                style = MaterialTheme.typography.displayLarge.copy(
                    shadow = Shadow(
                        color = Color.Black.copy(alpha = 0.3f),
                        offset = offset,
                        blurRadius = 8f
                    )
                ),
                color = colors.yellow,
                fontSize = fontSize,
                fontWeight = FontWeight.Bold,
                lineHeight = 80.sp,
                fontFamily = FontFamily(Font(Res.font.vag_rundschrift_d)),
                modifier = Modifier.offset(y = yOffsetFest),
                letterSpacing = 0.5.sp
            )
            Text(
                "LANDIA",
                style = MaterialTheme.typography.displayLarge.copy(
                    shadow = Shadow(
                        color = Color.Black.copy(alpha = 0.3f),
                        offset = offset,
                        blurRadius = 8f
                    )
                ),
                color = colors.lightSkyBlue,
                fontSize = fontSize,
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily(Font(Res.font.vag_rundschrift_d)),
                letterSpacing = 0.5.sp
            )
            Text(
                "KIDS",
                style = MaterialTheme.typography.displayLarge.copy(
                    shadow = Shadow(
                        color = Color.Black.copy(alpha = 0.3f),
                        offset = offset,
                        blurRadius = 8f
                    )
                ),
                color = colors.lightMagenta,
                fontSize = fontSize,
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily(Font(Res.font.vag_rundschrift_d)),
                modifier = Modifier.offset(y = yOffsetKids),
                letterSpacing = 0.5.sp
            )
        }
        Box(
            modifier = Modifier
                .absoluteOffset(x = xOffsetSun, y = yOffsetSun)
                .size(sunSize)
        ) {
            KottieAnimationView(modifier = Modifier.fillMaxSize())
        }
    }
}

