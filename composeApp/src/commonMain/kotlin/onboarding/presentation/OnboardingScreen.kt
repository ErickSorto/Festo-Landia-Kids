package onboarding.presentation

import LocalAppColors
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import festolandiakids.composeapp.generated.resources.Res
import festolandiakids.composeapp.generated.resources.festolandiakids_background
import festolandiakids.composeapp.generated.resources.vag_rundschrift_d
import onboarding.presentation.components.FestoLandiaKidsLogo
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.Font
import org.jetbrains.compose.resources.painterResource

@OptIn(ExperimentalResourceApi::class)
@Composable
fun OnboardingScreen(
    onboardingViewModelState: OnboardingViewModelState,
    onEvent: (OnboardingEvent) -> Unit
) {

    val colors = LocalAppColors.current

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Image(
            painter = painterResource(Res.drawable.festolandiakids_background),
            contentDescription = "Compose Logo",
            modifier = Modifier.fillMaxSize().blur(0.dp),
            contentScale = ContentScale.Crop,
        )
    }

    Scaffold(
        containerColor = Color.Transparent
    ) {
        Column(
            modifier = Modifier.fillMaxSize().padding(it),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Welcome to FestoLandia Kids",
            )
            Text(
                text = onboardingViewModelState.title + onboardingViewModelState.description,
                style = typography.displaySmall,
            )

            Spacer(modifier = Modifier.weight(1f))

            FestoLandiaKidsLogo()

            Button(
                onClick = {
                    onEvent(OnboardingEvent.ButtonClicked)
                },
                modifier = Modifier.padding(16.dp).border(
                    width = 2.dp,
                    color = colors.lightYellow,
                    shape = MaterialTheme.shapes.medium
                ),
                shape = MaterialTheme.shapes.medium,
                colors = ButtonDefaults.buttonColors(
                    containerColor = colors.lightMagenta,
                    contentColor = Color.White,
                ),
                elevation = ButtonDefaults.buttonElevation(
                    defaultElevation = 5.dp,
                    pressedElevation = 10.dp
                )

            ) {
                Text(
                    text = "Continue",
                    style = typography.displaySmall,
                    color = Color.White,
                    fontFamily = FontFamily(Font(Res.font.vag_rundschrift_d))
                )
            }
            Spacer(modifier = Modifier.weight(1f))
        }
    }
}