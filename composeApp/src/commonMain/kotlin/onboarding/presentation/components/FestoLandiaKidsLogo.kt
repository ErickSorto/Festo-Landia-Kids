package onboarding.presentation.components

import LocalAppColors
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.offset
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
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.Font

@OptIn(ExperimentalResourceApi::class)
@Composable
fun FestoLandiaKidsLogo() {
    val colors = LocalAppColors.current
    Column(){
        val offset = Offset(5.0f, 5.0f)
        Text(
            "FESTO",
            style = MaterialTheme.typography.displayLarge.copy(
                shadow = Shadow(
                    color = Color.Black.copy(
                        alpha = 0.5f
                    ), offset = offset, blurRadius = 6f
                )
            ),
            color = colors.yellow,
            fontSize = 105.sp,
            fontWeight = FontWeight.Bold,
            lineHeight = 80.sp,
            modifier = Modifier.offset(
                x = 0.dp,
                y = 10.dp
            ),
            fontFamily = FontFamily(Font(Res.font.vag_rundschrift_d))
        )
        Text(
            "LÂNDIA",
            style = MaterialTheme.typography.displayLarge.copy(
                shadow = Shadow(
                    color = Color.Black.copy(
                        alpha = 0.5f
                    ), offset = offset, blurRadius = 6f
                )
            ),
            color = colors.lightSkyBlue,
            fontSize = 105.sp,
            fontWeight = FontWeight.Bold,
            lineHeight = 80.sp,
            fontFamily = FontFamily(Font(Res.font.vag_rundschrift_d))
        )
        Text(
            "KIDS",
            style = MaterialTheme.typography.displayLarge.copy(
                shadow = Shadow(
                    color = Color.Black.copy(
                        alpha = 0.5f
                    ), offset = offset, blurRadius = 6f
                )
            ),
            color = colors.lightMagenta,
            fontSize = 105.sp,
            fontWeight = FontWeight.Bold,
            lineHeight = 80.sp,
            modifier = Modifier.offset(
                x = 0.dp,
                y = (-10).dp
            ),
            fontFamily = FontFamily(Font(Res.font.vag_rundschrift_d))
        )
    }
}