package onboarding.presentation

import KottieAnimation
import LocalAppColors
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import androidx.compose.ui.unit.dp
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

private const val lottieData = """
{"v":"4.10.1","fr":60,"ip":0,"op":120,"w":800,"h":800,"nm":"loading_animation","ddd":0,"assets":[],"layers":[{"ddd":0,"ind":1,"ty":4,"nm":"Shape Layer 5","sr":1,"ks":{"o":{"a":1,"k":[{"i":{"x":[0.667],"y":[1]},"o":{"x":[0.333],"y":[0]},"n":["0p667_1_0p333_0"],"t":23,"s":[20],"e":[100]},{"i":{"x":[0.667],"y":[1]},"o":{"x":[0.333],"y":[0]},"n":["0p667_1_0p333_0"],"t":34,"s":[100],"e":[20]},{"t":69}],"ix":11},"r":{"a":0,"k":0,"ix":10},"p":{"a":0,"k":[400,400,0],"ix":2},"a":{"a":0,"k":[0,0,0],"ix":1},"s":{"a":0,"k":[100,100,100],"ix":6}},"ao":0,"shapes":[{"ty":"gr","it":[{"d":1,"ty":"el","s":{"a":1,"k":[{"i":{"x":[0,0],"y":[1,1]},"o":{"x":[0.333,0.333],"y":[0,0]},"n":["0_1_0p333_0","0_1_0p333_0"],"t":23,"s":[400,400],"e":[440,440]},{"i":{"x":[0.009,0.009],"y":[1,1]},"o":{"x":[0.333,0.333],"y":[0,0]},"n":["0p009_1_0p333_0","0p009_1_0p333_0"],"t":34,"s":[440,440],"e":[400,400]},{"t":59}],"ix":2},"p":{"a":0,"k":[0,0],"ix":3},"nm":"Ellipse Path 1","mn":"ADBE Vector Shape - Ellipse","hd":false},{"ty":"tr","p":{"a":0,"k":[0,0],"ix":2},"a":{"a":0,"k":[0,0],"ix":1},"s":{"a":0,"k":[100,100],"ix":3},"r":{"a":0,"k":0,"ix":6},"o":{"a":0,"k":100,"ix":7},"sk":{"a":0,"k":0,"ix":4},"sa":{"a":0,"k":0,"ix":5},"nm":"Transform"}],"nm":"Ellipse 1","np":4,"cix":2,"ix":1,"mn":"ADBE Vector Group","hd":false},{"ty":"gs","o":{"a":0,"k":100,"ix":9},"w":{"a":1,"k":[{"i":{"x":[0.833],"y":[0.833]},"o":{"x":[0.167],"y":[0.167]},"n":["0p833_0p833_0p167_0p167"],"t":23,"s":[5],"e":[10]},{"i":{"x":[0.833],"y":[0.833]},"o":{"x":[0.167],"y":[0.167]},"n":["0p833_0p833_0p167_0p167"],"t":34,"s":[10],"e":[5]},{"t":59}],"ix":10},"g":{"p":3,"k":{"a":0,"k":[0,0,0.627,1,0.5,0.496,0.314,1,1,0.992,0,1],"ix":8}},"s":{"a":0,"k":[0,0],"ix":4},"e":{"a":0,"k":[100,0],"ix":5},"t":1,"lc":1,"lj":1,"ml":4,"nm":"Gradient Stroke 1","mn":"ADBE Vector Graphic - G-Stroke","hd":false}],"ip":0,"op":120,"st":0,"bm":0},{"ddd":0,"ind":2,"ty":4,"nm":"Shape Layer 4","sr":1,"ks":{"o":{"a":1,"k":[{"i":{"x":[0.667],"y":[1]},"o":{"x":[0.333],"y":[0]},"n":["0p667_1_0p333_0"],"t":16,"s":[20],"e":[100]},{"i":{"x":[0.667],"y":[1]},"o":{"x":[0.333],"y":[0]},"n":["0p667_1_0p333_0"],"t":27,"s":[100],"e":[20]},{"t":62}],"ix":11},"r":{"a":0,"k":0,"ix":10},"p":{"a":0,"k":[400,400,0],"ix":2},"a":{"a":0,"k":[0,0,0],"ix":1},"s":{"a":0,"k":[100,100,100],"ix":6}},"ao":0,"shapes":[{"ty":"gr","it":[{"d":1,"ty":"el","s":{"a":1,"k":[{"i":{"x":[0.667,0.667],"y":[1,1]},"o":{"x":[0.333,0.333],"y":[0,0]},"n":["0p667_1_0p333_0","0p667_1_0p333_0"],"t":16,"s":[320,320],"e":[360,360]},{"i":{"x":[0.025,0.025],"y":[1,1]},"o":{"x":[0.333,0.333],"y":[0,0]},"n":["0p025_1_0p333_0","0p025_1_0p333_0"],"t":27,"s":[360,360],"e":[320,320]},{"t":52}],"ix":2},"p":{"a":0,"k":[0,0],"ix":3},"nm":"Ellipse Path 1","mn":"ADBE Vector Shape - Ellipse","hd":false},{"ty":"tr","p":{"a":0,"k":[0,0],"ix":2},"a":{"a":0,"k":[0,0],"ix":1},"s":{"a":0,"k":[100,100],"ix":3},"r":{"a":0,"k":0,"ix":6},"o":{"a":0,"k":100,"ix":7},"sk":{"a":0,"k":0,"ix":4},"sa":{"a":0,"k":0,"ix":5},"nm":"Transform"}],"nm":"Ellipse 1","np":3,"cix":2,"ix":1,"mn":"ADBE Vector Group","hd":false},{"ty":"gs","o":{"a":0,"k":100,"ix":9},"w":{"a":1,"k":[{"i":{"x":[0.833],"y":[0.833]},"o":{"x":[0.167],"y":[0.167]},"n":["0p833_0p833_0p167_0p167"],"t":16,"s":[5],"e":[10]},{"i":{"x":[0.833],"y":[0.833]},"o":{"x":[0.167],"y":[0.167]},"n":["0p833_0p833_0p167_0p167"],"t":27,"s":[10],"e":[5]},{"t":52}],"ix":10},"g":{"p":3,"k":{"a":0,"k":[0,0,0.627,1,0.5,0.496,0.314,1,1,0.992,0,1],"ix":8}},"s":{"a":0,"k":[0,0],"ix":4},"e":{"a":0,"k":[100,0],"ix":5},"t":1,"lc":1,"lj":1,"ml":4,"nm":"Gradient Stroke 1","mn":"ADBE Vector Graphic - G-Stroke","hd":false}],"ip":0,"op":120,"st":0,"bm":0},{"ddd":0,"ind":3,"ty":4,"nm":"Shape Layer 3","sr":1,"ks":{"o":{"a":1,"k":[{"i":{"x":[0.667],"y":[1]},"o":{"x":[0.333],"y":[0]},"n":["0p667_1_0p333_0"],"t":9,"s":[20],"e":[100]},{"i":{"x":[0.667],"y":[1]},"o":{"x":[0.333],"y":[0]},"n":["0p667_1_0p333_0"],"t":20,"s":[100],"e":[20]},{"t":55}],"ix":11},"r":{"a":0,"k":0,"ix":10},"p":{"a":0,"k":[400,400,0],"ix":2},"a":{"a":0,"k":[0,0,0],"ix":1},"s":{"a":0,"k":[100,100,100],"ix":6}},"ao":0,"shapes":[{"ty":"gr","it":[{"d":1,"ty":"el","s":{"a":1,"k":[{"i":{"x":[0.667,0.667],"y":[1,1]},"o":{"x":[0.333,0.333],"y":[0,0]},"n":["0p667_1_0p333_0","0p667_1_0p333_0"],"t":9,"s":[240,240],"e":[280,280]},{"i":{"x":[0.051,0.051],"y":[1,1]},"o":{"x":[0.333,0.333],"y":[0,0]},"n":["0p051_1_0p333_0","0p051_1_0p333_0"],"t":20,"s":[280,280],"e":[240,240]},{"t":45}],"ix":2},"p":{"a":0,"k":[0,0],"ix":3},"nm":"Ellipse Path 1","mn":"ADBE Vector Shape - Ellipse","hd":false},{"ty":"tr","p":{"a":0,"k":[0,0],"ix":2},"a":{"a":0,"k":[0,0],"ix":1},"s":{"a":0,"k":[100,100],"ix":3},"r":{"a":0,"k":0,"ix":6},"o":{"a":0,"k":100,"ix":7},"sk":{"a":0,"k":0,"ix":4},"sa":{"a":0,"k":0,"ix":5},"nm":"Transform"}],"nm":"Ellipse 1","np":3,"cix":2,"ix":1,"mn":"ADBE Vector Group","hd":false},{"ty":"gs","o":{"a":0,"k":100,"ix":9},"w":{"a":1,"k":[{"i":{"x":[0.833],"y":[0.833]},"o":{"x":[0.167],"y":[0.167]},"n":["0p833_0p833_0p167_0p167"],"t":9,"s":[5],"e":[10]},{"i":{"x":[0.833],"y":[0.833]},"o":{"x":[0.167],"y":[0.167]},"n":["0p833_0p833_0p167_0p167"],"t":20,"s":[10],"e":[5]},{"t":45}],"ix":10},"g":{"p":3,"k":{"a":0,"k":[0,0,0.627,1,0.5,0.496,0.314,1,1,0.992,0,1],"ix":8}},"s":{"a":0,"k":[0,0],"ix":4},"e":{"a":0,"k":[100,0],"ix":5},"t":1,"lc":1,"lj":1,"ml":4,"nm":"Gradient Stroke 1","mn":"ADBE Vector Graphic - G-Stroke","hd":false}],"ip":0,"op":120,"st":0,"bm":0},{"ddd":0,"ind":4,"ty":4,"nm":"Shape Layer 2","sr":1,"ks":{"o":{"a":1,"k":[{"i":{"x":[0.667],"y":[1]},"o":{"x":[0.333],"y":[0]},"n":["0p667_1_0p333_0"],"t":2,"s":[20],"e":[100]},{"i":{"x":[0.667],"y":[1]},"o":{"x":[0.333],"y":[0]},"n":["0p667_1_0p333_0"],"t":13,"s":[100],"e":[20]},{"t":48}],"ix":11},"r":{"a":0,"k":0,"ix":10},"p":{"a":0,"k":[400,400,0],"ix":2},"a":{"a":0,"k":[0,0,0],"ix":1},"s":{"a":0,"k":[100,100,100],"ix":6}},"ao":0,"shapes":[{"ty":"gr","it":[{"d":1,"ty":"el","s":{"a":1,"k":[{"i":{"x":[0.667,0.667],"y":[1,1]},"o":{"x":[0.333,0.333],"y":[0,0]},"n":["0p667_1_0p333_0","0p667_1_0p333_0"],"t":2,"s":[160,160],"e":[200,200]},{"i":{"x":[0.034,0.034],"y":[1,1]},"o":{"x":[0.333,0.333],"y":[0,0]},"n":["0p034_1_0p333_0","0p034_1_0p333_0"],"t":13,"s":[200,200],"e":[160,160]},{"t":38}],"ix":2},"p":{"a":0,"k":[0,0],"ix":3},"nm":"Ellipse Path 1","mn":"ADBE Vector Shape - Ellipse","hd":false},{"ty":"tr","p":{"a":0,"k":[0,0],"ix":2},"a":{"a":0,"k":[0,0],"ix":1},"s":{"a":0,"k":[100,100],"ix":3},"r":{"a":0,"k":0,"ix":6},"o":{"a":0,"k":100,"ix":7},"sk":{"a":0,"k":0,"ix":4},"sa":{"a":0,"k":0,"ix":5},"nm":"Transform"}],"nm":"Ellipse 1","np":3,"cix":2,"ix":1,"mn":"ADBE Vector Group","hd":false},{"ty":"gs","o":{"a":0,"k":100,"ix":9},"w":{"a":1,"k":[{"i":{"x":[0.833],"y":[0.833]},"o":{"x":[0.167],"y":[0.167]},"n":["0p833_0p833_0p167_0p167"],"t":2,"s":[5],"e":[10]},{"i":{"x":[0.833],"y":[0.833]},"o":{"x":[0.167],"y":[0.167]},"n":["0p833_0p833_0p167_0p167"],"t":13,"s":[10],"e":[5]},{"t":38}],"ix":10},"g":{"p":3,"k":{"a":0,"k":[0,0,0.627,1,0.5,0.496,0.314,1,1,0.992,0,1],"ix":8}},"s":{"a":0,"k":[0,0],"ix":4},"e":{"a":0,"k":[100,0],"ix":5},"t":1,"lc":1,"lj":1,"ml":4,"nm":"Gradient Stroke 1","mn":"ADBE Vector Graphic - G-Stroke","hd":false}],"ip":0,"op":120,"st":0,"bm":0},{"ddd":0,"ind":5,"ty":4,"nm":"Shape Layer 1","sr":1,"ks":{"o":{"a":1,"k":[{"i":{"x":[0.667],"y":[1]},"o":{"x":[0.333],"y":[0]},"n":["0p667_1_0p333_0"],"t":0,"s":[20],"e":[100]},{"i":{"x":[0.667],"y":[1]},"o":{"x":[0.333],"y":[0]},"n":["0p667_1_0p333_0"],"t":11,"s":[100],"e":[20]},{"t":46}],"ix":11},"r":{"a":0,"k":0,"ix":10},"p":{"a":0,"k":[400,400,0],"ix":2},"a":{"a":0,"k":[0,0,0],"ix":1},"s":{"a":0,"k":[100,100,100],"ix":6}},"ao":0,"shapes":[{"ty":"gr","it":[{"d":1,"ty":"el","s":{"a":1,"k":[{"i":{"x":[0.667,0.667],"y":[1,1]},"o":{"x":[0.333,0.333],"y":[0,0]},"n":["0p667_1_0p333_0","0p667_1_0p333_0"],"t":0,"s":[80,80],"e":[120,120]},{"i":{"x":[0,0],"y":[1,1]},"o":{"x":[0.333,0.333],"y":[0,0]},"n":["0_1_0p333_0","0_1_0p333_0"],"t":11,"s":[120,120],"e":[80,80]},{"t":36}],"ix":2},"p":{"a":0,"k":[0,0],"ix":3},"nm":"Ellipse Path 1","mn":"ADBE Vector Shape - Ellipse","hd":false},{"ty":"tr","p":{"a":0,"k":[0,0],"ix":2},"a":{"a":0,"k":[0,0],"ix":1},"s":{"a":0,"k":[100,100],"ix":3},"r":{"a":0,"k":0,"ix":6},"o":{"a":0,"k":100,"ix":7},"sk":{"a":0,"k":0,"ix":4},"sa":{"a":0,"k":0,"ix":5},"nm":"Transform"}],"nm":"Ellipse 1","np":3,"cix":2,"ix":1,"mn":"ADBE Vector Group","hd":false},{"ty":"gs","o":{"a":0,"k":100,"ix":9},"w":{"a":1,"k":[{"i":{"x":[0.833],"y":[0.833]},"o":{"x":[0.167],"y":[0.167]},"n":["0p833_0p833_0p167_0p167"],"t":0,"s":[5],"e":[10]},{"i":{"x":[0.833],"y":[0.833]},"o":{"x":[0.167],"y":[0.167]},"n":["0p833_0p833_0p167_0p167"],"t":11,"s":[10],"e":[5]},{"t":35}],"ix":10},"g":{"p":3,"k":{"a":0,"k":[0,0,0.627,1,0.5,0.496,0.314,1,1,0.992,0,1],"ix":8}},"s":{"a":0,"k":[0,0],"ix":4},"e":{"a":0,"k":[100,0],"ix":5},"t":1,"lc":1,"lj":1,"ml":4,"nm":"Gradient Stroke 1","mn":"ADBE Vector Graphic - G-Stroke","hd":false}],"ip":0,"op":120,"st":0,"bm":0}]}
"""
//@Composable
//fun LottieAnimationView(modifier: Modifier = Modifier) {
//    val animationJson = stringResource(Res.string.sun_animation)
//    val composition by rememberLottieComposition(LottieCompositionSpec.JsonString(animationJson))
//
//    Box(
//        contentAlignment = Alignment.Center,
//        modifier = modifier.size(1000.dp) // Adjust the size as needed
//    ) {
//        LottieAnimation(
//            composition = composition,
//            iterations = LottieConstants.IterateForever,
//            modifier = Modifier.fillMaxSize()
//        )
//    }
//}
@OptIn(ExperimentalResourceApi::class)
@Composable
fun KottieAnimationView(modifier: Modifier = Modifier) {
    var animation by remember { mutableStateOf("") }

    animation = stringResource(Res.string.sun_animation)


    val composition = rememberKottieComposition(
       spec = KottieCompositionSpec.JsonString(jsonString = animation)
    )

    val animationState by animateKottieCompositionAsState(
        composition = composition,
        iterations = KottieConstants.IterateForever,
        isPlaying = true
    )

    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier.size(1000.dp) // Adjust the size as needed
    ) {
        KottieAnimation(
            composition = composition,
            progress = { animationState.progress },
            modifier = Modifier.fillMaxSize()
        )
    }
}
