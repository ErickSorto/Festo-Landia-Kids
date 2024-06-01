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
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import festolandiakids.composeapp.generated.resources.Res
import festolandiakids.composeapp.generated.resources.vag_rundschrift_d
import onboarding.presentation.LottieAnimationView
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.Font

@OptIn(ExperimentalResourceApi::class)
@Composable
fun FestoLandiaKidsLogo() {
    val colors = LocalAppColors.current
    val offset = Offset(6.0f, 6.0f)

    Box {
        Column {
            Text(
                "FEST",
                style = MaterialTheme.typography.displayLarge.copy(
                    shadow = Shadow(
                        color = Color.Black.copy(
                            alpha = 0.3f
                        ), offset = offset, blurRadius = 8f
                    )
                ),
                color = colors.yellow,
                fontSize = 105.sp,
                fontWeight = FontWeight.Bold,
                lineHeight = 80.sp,
                fontFamily = FontFamily(Font(Res.font.vag_rundschrift_d)),
                modifier = Modifier.offset(y = (10).dp),
                letterSpacing = 0.5.sp
            )
            Text(
                "LANDIA",
                style = MaterialTheme.typography.displayLarge.copy(
                    shadow = Shadow(
                        color = Color.Black.copy(
                            alpha = 0.3f
                        ), offset = offset, blurRadius = 8f
                    )
                ),
                color = colors.lightSkyBlue,
                fontSize = 105.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily(Font(Res.font.vag_rundschrift_d)),
                letterSpacing = 0.5.sp
            )
            Text(
                "KIDS",
                style = MaterialTheme.typography.displayLarge.copy(
                    shadow = Shadow(
                        color = Color.Black.copy(
                            alpha = 0.3f
                        ), offset = offset, blurRadius = 8f
                    )
                ),
                color = colors.lightMagenta,
                fontSize = 105.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily(Font(Res.font.vag_rundschrift_d)),
                modifier = Modifier.offset(y = (-10).dp),
                letterSpacing = 0.5.sp
            )
        }
        Box(
            modifier = Modifier
                .absoluteOffset(x = 123.dp, y = -40.dp) // Adjust the offset to position the animation over the "O"
                .size(255.dp) // Adjust the size as needed
        ) {
            LottieAnimationView(modifier = Modifier.fillMaxSize())
        }
    }
}
