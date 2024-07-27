package onboarding.presentation

import KottieAnimation
import LocalAppColors
import SunAnimationView
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import festolandiakids.composeapp.generated.resources.Res
import festolandiakids.composeapp.generated.resources.festolandiakids_background
import festolandiakids.composeapp.generated.resources.sun_animation
import festolandiakids.composeapp.generated.resources.vag_rundschrift_d
import kottieComposition.KottieCompositionSpec
import kottieComposition.animateKottieCompositionAsState
import kottieComposition.rememberKottieComposition
import onboarding.presentation.components.FestoLandiaKidsLogo
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.Font
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import utils.KottieConstants

@OptIn(ExperimentalResourceApi::class)
@Composable
fun OnboardingScreen(
    onboardingViewModelState: OnboardingViewModelState,
    onEvent: (OnboardingEvent) -> Unit,
    onNavigateToMainScreen: () -> Unit
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
//        Column {
//            HorizontalPager(
//                pageContent = { pageNumber ->
//                    OnboardingPage.entries.forEach { entry ->
//                        if (entry.pageNumber == pageNumber) {
//                            Box(
//                                contentAlignment = Alignment.Center,
//                                modifier = Modifier.fillMaxSize()
//                            ) {
//                                Text(text = entry.title)
//                            }
//                        }
//                    }
//                },
//                state = pagerState,
//                modifier = Modifier.padding(it)
//            )
        Column(
            modifier = Modifier.fillMaxSize().padding(it),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Spacer(modifier = Modifier.weight(1f))

            Spacer(modifier = Modifier.height(80.dp))

            Spacer(modifier = Modifier.weight(1f))

            FestoLandiaKidsLogo()
            Spacer(modifier = Modifier.weight(1f))
            Button(
                onClick = {
                    onNavigateToMainScreen()
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
@Composable
fun KottieAnimationView(
    modifier: Modifier = Modifier,
    fontSize: TextUnit,
) {

    SunAnimationView(
        modifier = modifier,
        fontSize = fontSize
    )
}
