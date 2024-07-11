package partyHomeScreen

import LocalAppColors
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import festolandiakids.composeapp.generated.resources.Res
import festolandiakids.composeapp.generated.resources.SampleMickyMouse
import festolandiakids.composeapp.generated.resources.SamplePinkCastle
import festolandiakids.composeapp.generated.resources.SampleToyStory
import festolandiakids.composeapp.generated.resources.festolandiakids_background
import festolandiakids.composeapp.generated.resources.vag_rundschrift_d
import mainScreen.GradientButton
import onboarding.presentation.components.FestoLandiaKidsLogo
import org.jetbrains.compose.resources.Font
import org.jetbrains.compose.resources.painterResource

@Composable
fun PartyHomeScreen(
    partyHomeScreenViewModelState: PartyHomeScreenViewModelState,
    onEvent: (PartyHomeScreenEvent) -> Unit
) {
    val scrollState = rememberScrollState()
    val colors = LocalAppColors.current
// Create an infinite transition for the breathing and floating effect
    val infiniteTransition = rememberInfiniteTransition()
    // Create an infinite transition for the breathing and floating effect
    val scale by infiniteTransition.animateFloat(
        initialValue = 1f,
        targetValue = 1.05f,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = 9000, easing = LinearEasing),
            repeatMode = RepeatMode.Reverse
        )
    )
    val floatTranslationY by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 11f,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = 8000, easing = LinearEasing),
            repeatMode = RepeatMode.Reverse
        )
    )
    val floatTranslationX by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 5f,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = 10000, easing = LinearEasing),
            repeatMode = RepeatMode.Reverse
        )
    )

    Scaffold {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Transparent)
        ) {
            Image(
                painter = painterResource(Res.drawable.festolandiakids_background),
                contentDescription = "Background",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxSize(1.1f)
                    .graphicsLayer {
                        translationY = floatTranslationY - 0.4f * scrollState.value // Moves up very slowly with parallax
                        translationX = floatTranslationX
                        scaleX = scale
                        scaleY = scale
                    }
            )

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .verticalScroll(scrollState),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                FestoLandiaKidsLogo(
                    modifier = Modifier
                        .padding(top = it.calculateTopPadding(), start = 16.dp, end = 16.dp)
                        .padding(top = 16.dp)
                        .align(Alignment.Start)
                        .graphicsLayer {
                            translationY = 0.8f * scrollState.value // Moves up faster
                        },
                    fontSize = 80.sp
                )

                // Main content box with curved top corners and parallax effect
                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(topStart = 32.dp, topEnd = 32.dp))
                        .background(
                            brush = Brush.horizontalGradient(
                                colors = listOf(
                                    colors.darkPastelMagenta,
                                    colors.lightPastelMagenta
                                )
                            ),
                            shape = RoundedCornerShape(topStart = 32.dp, topEnd = 32.dp)
                        )
                        .fillMaxWidth()
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(
                                color = Color.Transparent,
                                shape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp)
                            )
                    ) {
                        Spacer(modifier = Modifier.height(16.dp))
                        Box(
                            modifier = Modifier
                                .clip(RoundedCornerShape(16.dp))
                                .fillMaxWidth()
                                .padding(16.dp, 8.dp, 16.dp, 16.dp)
                                .shadow(
                                    elevation = 2.dp,
                                    shape = RoundedCornerShape(16.dp)
                                )
                                .background(
                                    color = colors.lightSkyBlue,
                                    shape = RoundedCornerShape(16.dp),
                                )
                        ) {
                            Text(
                                text = "Featured Parties",
                                style = MaterialTheme.typography.headlineMedium,
                                modifier = Modifier.padding(
                                    8.dp
                                ).align(Alignment.Center),
                                color = Color.White,
                                fontFamily = FontFamily(Font(Res.font.vag_rundschrift_d))
                            )
                        }

                        Row(
                            horizontalArrangement = Arrangement.spacedBy(16.dp),
                            modifier = Modifier
                                .fillMaxWidth()
                                .horizontalScroll(rememberScrollState()),
                        ) {
                            // Add cards for featured parties
                            Spacer(modifier = Modifier.width(0.dp))
                            repeat(3) {
                                Card(
                                    modifier = Modifier
                                        .width(325.dp)
                                ) {
                                    Column(
                                        horizontalAlignment = Alignment.CenterHorizontally
                                    ) {
                                        Image(
                                            painter = painterResource(Res.drawable.festolandiakids_background), // Replace with actual image resource
                                            contentDescription = "Featured Party",
                                            modifier = Modifier
                                                .height(150.dp)
                                                .fillMaxWidth()
                                        )
                                        Text(
                                            text = "Party ${it + 1}",
                                            style = MaterialTheme.typography.bodyLarge,
                                            modifier = Modifier.padding(8.dp)
                                        )
                                        Text(
                                            text = "A brief description of the party.",
                                            style = MaterialTheme.typography.bodyMedium,
                                            modifier = Modifier.padding(horizontal = 8.dp)
                                        )
                                        GradientButton(
                                            text = "Book Now",
                                            onClick = { /* Handle book now */ }
                                        )
                                    }
                                }
                            }
                            Spacer(modifier = Modifier.width(0.dp))
                        }

                        // Gallery Section
                        Box(
                            modifier = Modifier
                                .clip(RoundedCornerShape(16.dp))
                                .fillMaxWidth()
                                .padding(16.dp, 48.dp, 16.dp, 16.dp)
                                .shadow(
                                    elevation = 3.dp,
                                    shape = RoundedCornerShape(16.dp)
                                )
                                .background(
                                    color = colors.lightSkyBlue,
                                    shape = RoundedCornerShape(16.dp),
                                )
                        ) {
                            Text(
                                text = "Gallery",
                                style = MaterialTheme.typography.headlineMedium,
                                modifier = Modifier.padding(
                                    8.dp
                                ).align(Alignment.Center),
                                color = Color.White,
                                fontFamily = FontFamily(Font(Res.font.vag_rundschrift_d)),
                            )
                        }
                        Row(
                            horizontalArrangement = Arrangement.spacedBy(16.dp),
                            modifier = Modifier
                                .fillMaxWidth()
                                .horizontalScroll(rememberScrollState())
                        ) {
                            Spacer(modifier = Modifier.width(0.dp))
                            // Add cards for gallery images
                            repeat(3) {
                                val image = when (it) {
                                    0 -> Res.drawable.SampleMickyMouse
                                    1 -> Res.drawable.SampleToyStory
                                    else -> Res.drawable.SamplePinkCastle
                                }

                                val title = when (it) {
                                    0 -> "Micky Mouse"
                                    1 -> "Toy Story"
                                    else -> "Pink Castle"
                                }
                                Card(
                                    modifier = Modifier
                                        .width(325.dp),
                                    elevation =  CardDefaults.cardElevation(
                                        defaultElevation = 3.dp,
                                    )
                                ) {
                                    Column(
                                        horizontalAlignment = Alignment.CenterHorizontally
                                    ) {
                                        Image(
                                            painter = painterResource(image),
                                            contentDescription = "Gallery Image",
                                            modifier = Modifier
                                                .height(225.dp)
                                                .fillMaxWidth()
                                                .padding(16.dp)
                                                .clip(RoundedCornerShape(16.dp)),
                                            contentScale = ContentScale.Crop
                                        )
                                        Text(
                                            text = title,
                                            style = MaterialTheme.typography.bodyLarge,
                                            modifier = Modifier.padding(8.dp)
                                        )
                                    }
                                }
                            }
                            Spacer(modifier = Modifier.width(0.dp))
                        }

                        // Party Packages Section
                        Box(
                            modifier = Modifier
                                .clip(RoundedCornerShape(16.dp))
                                .fillMaxWidth()
                                .padding(16.dp, 48.dp, 16.dp, 16.dp)
                                .shadow(
                                    elevation = 3.dp,
                                    shape = RoundedCornerShape(16.dp)
                                )
                                .background(
                                    color = colors.lightSkyBlue,
                                    shape = RoundedCornerShape(16.dp),
                                )
                        ) {
                            Text(
                                text = "Party Packages",
                                style = MaterialTheme.typography.headlineMedium,
                                modifier = Modifier.padding(
                                    8.dp
                                ).align(Alignment.Center),
                                color = Color.White,
                                fontFamily = FontFamily(Font(Res.font.vag_rundschrift_d)),
                            )
                        }
                        Column(
                            verticalArrangement = Arrangement.spacedBy(16.dp),
                            modifier = Modifier
                                .fillMaxWidth()
                                .horizontalScroll(rememberScrollState())
                        ) {
                            Spacer(modifier = Modifier.width(0.dp))
                            // Add cards for party packages
                            repeat(3) {
                                Card(
                                    modifier = Modifier.fillMaxWidth().padding(
                                        16.dp
                                    )
                                ) {
                                    Column(
                                        horizontalAlignment = Alignment.CenterHorizontally
                                    ) {
                                        Image(
                                            painter = painterResource(Res.drawable.festolandiakids_background), // Replace with actual image resource
                                            contentDescription = "Party Package",
                                            modifier = Modifier
                                                .height(150.dp)
                                                .fillMaxWidth()
                                        )
                                        Text(
                                            text = "Tier ${it + 1} Package",
                                            style = MaterialTheme.typography.bodyLarge,
                                            modifier = Modifier.padding(8.dp)
                                        )
                                        Text(
                                            text = "Description of Tier ${it + 1} Package.",
                                            style = MaterialTheme.typography.bodyMedium,
                                            modifier = Modifier.padding(horizontal = 8.dp)
                                        )
                                        Button(
                                            onClick = { /* Handle book now */ },
                                            modifier = Modifier.padding(8.dp)
                                        ) {
                                            Text(text = "Book Now")
                                        }
                                    }
                                }
                            }
                            Spacer(modifier = Modifier.width(0.dp))
                        }

                        // Testimonials Section
                        Box(
                            modifier = Modifier
                                .clip(RoundedCornerShape(16.dp))
                                .fillMaxWidth()
                                .padding(16.dp, 48.dp, 16.dp, 16.dp)
                                .shadow(
                                    elevation = 3.dp,
                                    shape = RoundedCornerShape(16.dp)
                                )
                                .background(
                                    color = colors.lightSkyBlue,
                                    shape = RoundedCornerShape(16.dp),
                                )
                        ) {
                            Text(
                                text = "Testimonials",
                                style = MaterialTheme.typography.headlineMedium,
                                modifier = Modifier.padding(
                                    8.dp
                                ).align(Alignment.Center),
                                color = Color.White,
                                fontFamily = FontFamily(Font(Res.font.vag_rundschrift_d)),
                            )
                        }
                        Row(
                            horizontalArrangement = Arrangement.spacedBy(16.dp),
                            modifier = Modifier
                                .fillMaxWidth()
                                .horizontalScroll(rememberScrollState())
                        ) {
                            // Add cards for testimonials
                            Spacer(modifier = Modifier.width(0.dp))
                            repeat(3) {
                                Card(
                                    modifier = Modifier
                                        .width(325.dp)
                                ) {
                                    Column(
                                        horizontalAlignment = Alignment.CenterHorizontally
                                    ) {
                                        Text(
                                            text = "Testimonial ${it + 1}",
                                            style = MaterialTheme.typography.bodyLarge,
                                            modifier = Modifier.padding(8.dp)
                                        )
                                        Text(
                                            text = "A brief testimonial from a satisfied customer.",
                                            style = MaterialTheme.typography.bodyMedium,
                                            modifier = Modifier.padding(horizontal = 8.dp)
                                        )
                                    }
                                }
                            }
                            Spacer(modifier = Modifier.width(0.dp))
                        }

                        // Contact Section
                        Box(
                            modifier = Modifier
                                .clip(RoundedCornerShape(16.dp))
                                .fillMaxWidth()
                                .padding(16.dp, 48.dp, 16.dp, 16.dp)
                                .shadow(
                                    elevation = 3.dp,
                                    shape = RoundedCornerShape(16.dp)
                                )
                                .background(
                                    color = colors.lightSkyBlue,
                                    shape = RoundedCornerShape(16.dp),
                                )
                        ) {
                            Text(
                                text = "Contact",
                                style = MaterialTheme.typography.headlineMedium,
                                modifier = Modifier.padding(
                                    8.dp
                                ).align(Alignment.Center),
                                color = Color.White,
                                fontFamily = FontFamily(Font(Res.font.vag_rundschrift_d)),
                            )
                        }

                        Card(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(16.dp, 0.dp, 16.dp, 0.dp)
                        ) {
                            Column(
                                horizontalAlignment = Alignment.CenterHorizontally,
                                modifier = Modifier.padding(16.dp)
                            ) {
                                Text(
                                    text = "",
                                    style = MaterialTheme.typography.labelLarge
                                )
                                Spacer(modifier = Modifier.height(16.dp))
                                Text(
                                    text = "Contact Information",
                                    style = MaterialTheme.typography.bodyMedium
                                )
                                Spacer(modifier = Modifier.height(16.dp))
                                Button(
                                    onClick = {

                                    }
                                ) {
                                    Text(text = "Navigate to Onboarding Screen")
                                }
                            }
                        }

                        // Map Section
                        Box(
                            modifier = Modifier
                                .clip(RoundedCornerShape(16.dp))
                                .fillMaxWidth()
                                .padding(16.dp, 48.dp, 16.dp, 16.dp)
                                .shadow(
                                    elevation = 2.dp,
                                    shape = RoundedCornerShape(16.dp)
                                )
                                .background(
                                    color = colors.lightSkyBlue,
                                    shape = RoundedCornerShape(16.dp),
                                )
                        ) {
                            Text(
                                text = "Map",
                                style = MaterialTheme.typography.headlineMedium,
                                modifier = Modifier.padding(
                                    8.dp
                                ).align(Alignment.Center),
                                color = Color.White,
                                fontFamily = FontFamily(Font(Res.font.vag_rundschrift_d)),
                            )
                        }
                        Card(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(16.dp, 0.dp, 16.dp, 16.dp)
                        ) {
                            // Add interactive map here
                            Text(
                                text = "Map Section",
                                modifier = Modifier.padding(16.dp)
                            )
                        }

                        Spacer(
                            modifier = androidx.compose.ui.Modifier.height(it.calculateBottomPadding())
                        )
                    }
                }
            }
        }
    }

}