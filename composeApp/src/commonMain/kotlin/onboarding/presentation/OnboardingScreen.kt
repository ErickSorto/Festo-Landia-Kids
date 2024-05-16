package onboarding.presentation

import LocalAppColors
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.rememberPagerState
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import festolandiakids.composeapp.generated.resources.Res
import festolandiakids.composeapp.generated.resources.festolandiakids_background
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource

@OptIn(ExperimentalFoundationApi::class, ExperimentalResourceApi::class)
@Composable
fun OnboardingScreen() {
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
    val pagerState = rememberPagerState(pageCount = {
        3
    })

    Scaffold(
        containerColor = Color.Transparent
    ){
        Column(
            modifier = Modifier.fillMaxSize().padding(it),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.weight(1f))
            Text("Festo", style = typography.displayLarge, color = colors.tertiary, fontSize = 100.sp, fontWeight = FontWeight.Bold)
            Text("Landia", style = typography.displayLarge, color = Color.Blue, fontSize = 100.sp, fontWeight = FontWeight.Bold)
            Text("Kids", style = typography.displayLarge, color = Color.Magenta, fontSize = 100.sp, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.weight(1f))
        }
    }
}