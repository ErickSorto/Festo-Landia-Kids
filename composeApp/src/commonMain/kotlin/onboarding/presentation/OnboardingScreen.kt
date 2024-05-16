package onboarding.presentation

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import festolandiakids.composeapp.generated.resources.Res
import festolandiakids.composeapp.generated.resources.festbackground
import festolandiakids.composeapp.generated.resources.festolandiakids_background
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource

@OptIn(ExperimentalFoundationApi::class, ExperimentalResourceApi::class)
@Composable
fun OnboardingScreen() {

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Image(
            painter = painterResource(Res.drawable.festolandiakids_background),
            contentDescription = "Compose Logo",
            modifier = Modifier.fillMaxSize().blur(5.dp),
            contentScale = ContentScale.FillBounds,
        )
    }
    val pagerState = rememberPagerState(pageCount = {
        3
    })

    Scaffold(
        containerColor = Color.Transparent
    ){
        Column {
            HorizontalPager(
                pageContent = { pageNumber ->
                    OnboardingPage.entries.forEach { entry ->
                        if (entry.pageNumber == pageNumber) {
                            Box(
                                contentAlignment = Alignment.Center,
                                modifier = Modifier.fillMaxSize()
                            ) {
                                Text(text = entry.title)
                            }
                        }
                    }
                },
                state = pagerState,
                modifier = Modifier.padding(it)
            )
        }
    }
}