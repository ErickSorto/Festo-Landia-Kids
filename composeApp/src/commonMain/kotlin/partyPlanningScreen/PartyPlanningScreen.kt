package partyPlanningScreen

import CustomColors.DarkPastelMagenta
import CustomColors.DeepSkyBlue
import CustomColors.LightMagenta
import CustomColors.LightPastelMagenta
import CustomColors.LightSkyBlue2
import CustomColors.SkyBlue
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.InfiniteTransition
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.animation.expandVertically
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.basicMarquee
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.TileMode
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import festolandiakids.composeapp.generated.resources.Res
import festolandiakids.composeapp.generated.resources.SampleMickyMouse
import festolandiakids.composeapp.generated.resources.SampleToyStory
import festolandiakids.composeapp.generated.resources.baseline_expand_circle_down_24
import festolandiakids.composeapp.generated.resources.exit_icon
import festolandiakids.composeapp.generated.resources.frozen_image
import festolandiakids.composeapp.generated.resources.ladybug_image
import festolandiakids.composeapp.generated.resources.mario_image
import festolandiakids.composeapp.generated.resources.rounded_expand_circle_down_24
import festolandiakids.composeapp.generated.resources.spongebob_image
import festolandiakids.composeapp.generated.resources.tick_symbol_icon
import festolandiakids.composeapp.generated.resources.vag_rundschrift_d
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.Font
import org.jetbrains.compose.resources.painterResource
import kotlin.math.PI
import kotlin.math.cos
import kotlin.math.sin

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PartyPlanScreen(
    partyPlanningScreenViewModelState: PartyPlanningScreenViewModelState,
    onNavigateUp: () -> Unit,
    onEvent: (PartyPlanningScreenEvent) -> Unit
) {
    Scaffold(
        modifier = Modifier
            .fillMaxSize(),
        containerColor = Color.Transparent,
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Box(
                        modifier = Modifier.fillMaxHeight()
                    ) {
                        Text(
                            text = "Create Party",
                            color = Color.White,
                            style = typography.titleMedium,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.align(Alignment.Center),
                        )
                    }

                },
                navigationIcon = {
                    Box(
                        modifier = Modifier.fillMaxHeight()
                    ) {
                        IconButton(
                            onClick = {
                                onNavigateUp()
                            },
                            //enabled = !addEditDreamState.isDreamExitOff && !addEditDreamState.dreamIsSavingLoading
                        ) {
                            Icon(
                                modifier = Modifier.size(12.dp).align(Alignment.Center),
                                painter = painterResource(Res.drawable.exit_icon),
                                contentDescription = "Back",
                                tint = Color.White,
                            )
                        }
                    }
                },
                actions = {
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.Transparent,
                ),
                modifier = Modifier
                    .height(72.dp)
            )
        }
    ) { paddingValues ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    brush = Brush.horizontalGradient(
                        colors = listOf(
                            DarkPastelMagenta,  // Dark pastel magenta
                            LightPastelMagenta
                        )
                    )
                )
                .padding(
                    top = paddingValues.calculateTopPadding(),
                )
                .verticalScroll(rememberScrollState())
        ) {
            Text(
                text = "Name",
                style = typography.titleSmall,
                modifier = Modifier.padding(18.dp, 16.dp, 16.dp, 2.dp),
                color = Color.White,
            )

            TransparentHintTextField(
                hint = "Enter name of the person party is for..",
                isHintVisible = partyPlanningScreenViewModelState.name.isBlank(),
                singleLine = true,
                textStyle = typography.bodyMedium,
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .background(
                        Color.LightGray.copy(
                            alpha = 0.3f
                        )
                    ),
                text = partyPlanningScreenViewModelState.name,
                onValueChange = {
                    onEvent(PartyPlanningScreenEvent.TextFieldChanged(TextFieldType.NAME, it))
                },
                maxCharacters = 30
            )
            Text(
                text = "${partyPlanningScreenViewModelState.name.length}/30",
                style = typography.bodySmall,
                modifier = Modifier.padding(16.dp, 0.dp, 16.dp, 0.dp).align(
                    Alignment.End
                ),
                color = Color.White.copy(alpha = 0.8f),
            )

            Text(
                text = "Number of Guests",
                style = typography.titleSmall,
                modifier = Modifier.padding(18.dp, 16.dp, 16.dp, 2.dp),
                color = Color.White,
            )

            TransparentHintTextField(
                hint = "Enter number of guests..",
                isHintVisible = partyPlanningScreenViewModelState.numberOfPeople.isBlank(),
                singleLine = true,
                textStyle = typography.bodyMedium,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .background(
                        Color.LightGray.copy(
                            alpha = 0.3f
                        )
                    ),
                 text = partyPlanningScreenViewModelState.numberOfPeople,
                onValueChange = {
                    onEvent(PartyPlanningScreenEvent.TextFieldChanged(TextFieldType.NUMBER_OF_PEOPLE, it))
                },
                maxCharacters = 2
            )

            Text(
                text = "${partyPlanningScreenViewModelState.numberOfPeople.length}/2",
                style = typography.bodySmall,
                modifier = Modifier.padding(16.dp, 0.dp, 16.dp, 0.dp).align(
                    Alignment.End
                ),
                color = Color.White.copy(alpha = 0.8f),
            )

            Text(
                text = "Select Theme",
                style = typography.titleSmall,
                modifier = Modifier.padding(18.dp, 16.dp, 16.dp, 2.dp),
                color = Color.White,
            )
            ThemeSelection(
                selectedTheme = partyPlanningScreenViewModelState.selectedTheme,
                onThemeSelected = { name ->
                    onEvent(PartyPlanningScreenEvent.SelectTheme(name))
                }
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Date",
                style = typography.titleSmall,
                modifier = Modifier.padding(18.dp, 16.dp, 16.dp, 2.dp),
                color = Color.White,
            )
            val dateText = partyPlanningScreenViewModelState.date
            TransparentHintTextField(
                hint = "Desired date of the party",
                isHintVisible = partyPlanningScreenViewModelState.date.isBlank(),
                singleLine = true,
                textStyle = typography.bodyMedium,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .background(
                        Color.LightGray.copy(
                            alpha = 0.3f
                        )
                    ),
                text = dateText,
                onValueChange = {
                    onEvent(PartyPlanningScreenEvent.TextFieldChanged(TextFieldType.DATE, it))
                }
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Select Package",
                style = typography.titleSmall,
                modifier = Modifier.padding(18.dp, 16.dp, 16.dp, 2.dp),
                color = Color.White,
            )

            PartyPackage.entries.forEach { partyPackage ->
                PackageCard(
                    partyPackage = partyPackage,
                    partyPlanningScreenViewModelState = partyPlanningScreenViewModelState,
                    selectedPackage = partyPlanningScreenViewModelState.selectedPackage,
                ) {
                    onEvent(it)
                }
            }

            Button(
                onClick = {
                    onEvent(
                        PartyPlanningScreenEvent.ButtonClicked(
                            title = partyPlanningScreenViewModelState.name,
                            description = partyPlanningScreenViewModelState.numberOfPeople
                        )
                    )
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        start = 16.dp,
                        end = 16.dp,
                        bottom = 16.dp
                    ),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFE94057))
            ) {
                Text("Complete", color = Color.White)
            }
            Spacer(modifier = Modifier.height(paddingValues.calculateBottomPadding()))
        }
    }
}

@Composable
fun TransparentHintTextField(
    text: String,
    hint: String,
    modifier: Modifier = Modifier,
    modifier2: Modifier = Modifier,
    isHintVisible: Boolean = true,
    textStyle: TextStyle = TextStyle(),
    singleLine: Boolean = false,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    maxCharacters: Int = 25,
    onValueChange: (String) -> Unit
) {
    Box(modifier = modifier) {
        TextField(
            value = text,
            onValueChange = { newValue ->
                if (newValue.length <= maxCharacters) {
                    onValueChange(newValue)
                }
            },
            textStyle = textStyle,
            singleLine = singleLine,
            keyboardOptions = keyboardOptions,
            modifier = modifier2
                .background(Color.Transparent)
                .fillMaxWidth(),
                colors = TextFieldDefaults.colors().copy(
                    disabledContainerColor = Color.Transparent,
                    focusedContainerColor = Color.Transparent,
                    unfocusedContainerColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    focusedTextColor = Color.White,
                    unfocusedTextColor = Color.White,
                )
        )

        if (isHintVisible && text.isEmpty()) {
            Text(
                text = hint,
                style = textStyle,
                color = Color.White.copy(alpha = 0.8f),
                modifier = Modifier
                    .padding(16.dp)
                    .align(Alignment.CenterStart)
            )
        }
    }
}

@Composable
fun ThemeSelection(
    selectedTheme: String,
    onThemeSelected: (String) -> Unit
) {
    val selectedRowHeightTarget = if (selectedTheme.isEmpty()) 280.dp else 310.dp
    val selectedRowHeight by animateDpAsState(targetValue = selectedRowHeightTarget)


    Row(
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        modifier = Modifier
            .fillMaxWidth()
            .height(selectedRowHeight)
            .horizontalScroll(rememberScrollState())
    ) {
        Spacer(modifier = Modifier.width(0.dp))
        PartyTheme.entries.forEach { theme ->
            val isSelected = selectedTheme == theme.name
            val targetSize = if (isSelected) 220.dp else 180.dp
            val size by animateDpAsState(targetValue = targetSize)
            val selectedElevation by animateDpAsState(targetValue = if (isSelected) 8.dp else 3.dp)


            Card(
                modifier = Modifier
                    .width(size),
                elevation = CardDefaults.cardElevation(defaultElevation = selectedElevation),
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Image(
                        painter = painterResource(theme.image),
                        contentDescription = "Theme Image",
                        modifier = Modifier
                            .height(size)
                            .fillMaxWidth()
                            .padding(8.dp, 8.dp, 8.dp, 0.dp)
                            .clip(RoundedCornerShape(16.dp))
                            .animateContentSize(),
                        contentScale = ContentScale.Crop
                    )
                    Text(
                        text = theme.title,
                        style = typography.titleMedium,
                        color = Color.Black.copy(alpha = 0.6f),
                        modifier = Modifier.padding(8.dp, 8.dp, 8.dp, 4.dp),
                    )
                    Button(
                        onClick = { onThemeSelected(theme.name) },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp, 0.dp, 16.dp, 8.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFE94057)),
                    ) {
                        Text(
                            text = if (isSelected) "Selected" else "Select",
                            color = Color.White,
                            style = typography.bodyLarge,
                            fontFamily = FontFamily(Font(Res.font.vag_rundschrift_d))
                        )
                    }
                }
            }
        }
        Spacer(modifier = Modifier.width(0.dp))
    }
}

@Composable
fun PackageCard(
    partyPackage: PartyPackage,
    selectedPackage: String,
    partyPlanningScreenViewModelState: PartyPlanningScreenViewModelState,
    onEvent: (PartyPlanningScreenEvent) -> Unit
) {
    val isSelected = selectedPackage == partyPackage.name
    val buttonText = if (isSelected) "Selected" else "Select"
    val infiniteTransition = rememberInfiniteTransition(label = "")
    val shimmerBrush = enhancedPastelShimmerBrush(infiniteTransition)

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .border(
                width = if (isSelected) 8.dp else 0.dp,
                brush = if (isSelected) shimmerBrush else SolidColor(Color.Transparent),
                shape = RoundedCornerShape(8.dp)
            ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 3.dp,
        )
    ) {
        val isExpanded = when (partyPackage) {
            PartyPackage.SIMPLE -> partyPlanningScreenViewModelState.isSimplePackageExpanded
            PartyPackage.INTERMEDIATE -> partyPlanningScreenViewModelState.isIntermediatePackageExpanded
            PartyPackage.ADVANCED -> partyPlanningScreenViewModelState.isAdvancedPackageExpanded
            PartyPackage.PLUS -> partyPlanningScreenViewModelState.isPlusPackageExpanded
        }
        val rotation by animateFloatAsState(targetValue = if (isExpanded) 180f else 0f)

        Box {
            Column(
                modifier = Modifier
                    .padding(16.dp)
                    .imePadding()
                    .fillMaxWidth()
            ) {
                // Ribbon header
                RibbonHeader(title = partyPackage.title)

                Spacer(modifier = Modifier.height(4.dp))

                Text(
                    text = "R${partyPackage.price}",
                    style = typography.headlineSmall,
                    modifier = Modifier
                        .padding(start = 8.dp)
                        .align(Alignment.CenterHorizontally)
                        .offset(x = 0.dp),
                    color = Color(0xFFFF6EC7),
                    fontWeight = FontWeight.ExtraBold,
                    fontFamily = FontFamily(Font(Res.font.vag_rundschrift_d))
                )

                AnimatedVisibility(
                    visible = when (partyPackage) {
                        PartyPackage.SIMPLE -> partyPlanningScreenViewModelState.isSimplePackageExpanded
                        PartyPackage.INTERMEDIATE -> partyPlanningScreenViewModelState.isIntermediatePackageExpanded
                        PartyPackage.ADVANCED -> partyPlanningScreenViewModelState.isAdvancedPackageExpanded
                        PartyPackage.PLUS -> partyPlanningScreenViewModelState.isPlusPackageExpanded
                    },
                    enter = expandVertically(
                        animationSpec = tween(
                            durationMillis = 600,
                            easing = LinearOutSlowInEasing
                        )
                    ),
                    exit = shrinkVertically(
                        animationSpec = tween(
                            durationMillis = 600,
                            easing = LinearOutSlowInEasing
                        )
                    )
                ) {
                    Column {
                        partyPackage.features.forEach { feature ->
                            FeatureListItem(feature = feature)
                        }
                        Text(
                            text = "The hall is available for 4 hours, after which an additional fee will be charged!",
                            style = TextStyle(color = Color.Gray, fontSize = 12.sp),
                            modifier = Modifier.padding(vertical = 4.dp),
                            textAlign = TextAlign.Center
                        )
                    }
                }

                Button(
                    onClick = {
                        onEvent(PartyPlanningScreenEvent.SelectPackage(partyPackage.name))
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(48.dp, 0.dp, 48.dp, 0.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFE94057)),
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            painter = painterResource(Res.drawable.rounded_expand_circle_down_24),
                            contentDescription = null,
                            tint = Color.Transparent,
                            modifier = Modifier
                                .size(28.dp)
                                .align(Alignment.CenterVertically)
                        )
                        Spacer(modifier = Modifier.weight(1f))

                        Text(
                            buttonText,
                            color = Color.White,
                            style = typography.bodyLarge,
                            fontFamily = FontFamily(Font(Res.font.vag_rundschrift_d))
                        )

                        Spacer(modifier = Modifier.weight(1f))

                        Icon(
                            painter = painterResource(Res.drawable.baseline_expand_circle_down_24),
                            contentDescription = null,
                            tint = Color.White,
                            modifier = Modifier
                                .size(28.dp)
                                .rotate(rotation)
                                .clickable {
                                    val event = when (partyPackage) {
                                        PartyPackage.SIMPLE -> PartyPlanningScreenEvent.ToggleSimplePackageExpanded(
                                            !isExpanded
                                        )

                                        PartyPackage.INTERMEDIATE -> PartyPlanningScreenEvent.ToggleIntermediatePackageExpanded(
                                            !isExpanded
                                        )

                                        PartyPackage.ADVANCED -> PartyPlanningScreenEvent.ToggleAdvancedPackageExpanded(
                                            !isExpanded
                                        )

                                        PartyPackage.PLUS -> PartyPlanningScreenEvent.TogglePlusPackageExpanded(
                                            !isExpanded
                                        )
                                    }
                                    onEvent(event)
                                }
                                .align(Alignment.CenterVertically)
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun enhancedPastelShimmerBrush(transition: InfiniteTransition): Brush {
    val angleAnim = transition.animateFloat(
        initialValue = 0f,
        targetValue = 360f,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = 6000, easing = LinearEasing),
            repeatMode = RepeatMode.Restart
        ), label = ""
    )

    val angle = angleAnim.value
    val radius = 500f

    val startOffset = Offset(
        x = radius * cos(toRadians(angle)),
        y = radius * sin(toRadians(angle))
    )
    val endOffset = Offset(
        x = radius * cos(toRadians(angle + 180)),
        y = radius * sin(toRadians(angle + 180))
    )

    return Brush.linearGradient(
        colors = listOf(
            Color(0xFFFFC1CC), // Pastel Pink
            LightMagenta.copy(alpha = 0.7f),
            Color(0xFFFFFFB3), // Pastel Yellow
            Color(0xFFAEEBFF), // Pastel Sky Blue,
        ),
        start = startOffset,
        end = endOffset,
        tileMode = TileMode.Mirror
    )
}
// Helper function to convert degrees to radians
fun toRadians(degrees: Float): Float {
    return degrees * (PI / 180).toFloat()
}
@Composable
fun FeatureListItem(feature: String) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Icon(
            painter = painterResource(Res.drawable.tick_symbol_icon),
            contentDescription = null,
            tint = Color(0xFF32CD32),  // Neon pastel green color
            modifier = Modifier.size(32.dp).padding(end = 8.dp)
        )
        Text(
            text = feature,
            style = typography.bodyMedium,
            fontFamily = FontFamily(Font(Res.font.vag_rundschrift_d)),
            modifier = Modifier.padding(vertical = 2.dp).basicMarquee(),
            maxLines = 1,
            color = Color.Black.copy(alpha = 0.6f)
        )
    }
}

@Composable
fun RibbonHeader(title: String) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 40.dp)
            .wrapContentHeight()
            .background(Color.Transparent)
    ) {
        // Left polygon end (K shape, flipped on y-axis)
        Canvas(
            modifier = Modifier
                .align(Alignment.CenterStart)
                .offset(x = (-45).dp, y = 12.dp)
                .size(60.dp, 45.dp)
        ) {
            val path = Path().apply {
                moveTo(size.width, size.height / 2)  // Start at the middle right
                lineTo(size.width, size.height)  // Bottom middle
                lineTo(0f, size.height)  // Bottom left
                lineTo(size.width * 0.30f, size.height / 2)  // Middle left
                lineTo(0f, 0f)  // Top left
                lineTo(size.width, 0f)  // Top middle
                close()
            }
            drawPath(path, color = SkyBlue)
        }

        // Left folded bit
        Canvas(
            modifier = Modifier
                .align(Alignment.BottomStart)
                .offset(y = 10.dp)
                .size(15.dp, 10.dp)
        ) {
            val path = Path().apply {
                lineTo(size.width, 0f)
                lineTo(size.width, size.height)
                close()
            }
            drawPath(path, DeepSkyBlue)
        }

        // Right polygon end (K shape)
        Canvas(
            modifier = Modifier
                .align(Alignment.CenterEnd)
                .offset(x = 45.dp, y = 12.dp)
                .size(60.dp, 45.dp)
        ) {
            val path = Path().apply {
                moveTo(0f, size.height / 2)  // Start at the middle left
                lineTo(0f, size.height)  // Bottom middle
                lineTo(size.width, size.height)  // Bottom right
                lineTo(size.width * 0.70f, size.height / 2)  // Middle right
                lineTo(size.width, 0f)  // Top right
                lineTo(0f, 0f)  // Top middle
                close()
            }
            drawPath(path, color = SkyBlue)
        }

        // Right folded bit
        Canvas(
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .offset(y = 10.dp)
                .size(15.dp, 10.dp)
        ) {
            val path = Path().apply {
                lineTo(0f, size.height)
                lineTo(size.width, 0f)
                close()
            }
            drawPath(path, color = DeepSkyBlue)
        }

        // Main rectangle
        Canvas(
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
                .align(Alignment.Center)
        ) {
            drawRect(color = LightSkyBlue2, size = size)
        }


        // Draw the text
        Text(
            text = title,
            style = typography.titleLarge,
            modifier = Modifier.align(Alignment.Center),
            fontFamily = FontFamily(
                Font(Res.font.vag_rundschrift_d)
            ),
            color = Color.White
        )
    }
}


enum class PartyTheme(val title: String, val image: DrawableResource) {
    SPONGEBOB("Spongebob", Res.drawable.spongebob_image),
    MARIO("Mario", Res.drawable.mario_image),
    MICKEY_MOUSE("Mickey Mouse", Res.drawable.SampleMickyMouse),
    TOY_STORY("Toy Story", Res.drawable.SampleToyStory),
    FROZEN_THEME("Frozen", Res.drawable.frozen_image),
    LADYBUG("Ladybug", Res.drawable.ladybug_image),
}


enum class PartyPackage(val title: String, val price: String, val features: List<String>) {
    SIMPLE(
        "Simple Package",
        "$700.00",
        listOf(
            "Equipped kitchen, 1 server",
            "Serving utensils",
            "Ambient sound",
            "1 toy monitor",
            "Air-conditioned environment",
            "Kids space with toys"
        )
    ),
    INTERMEDIATE(
        "Intermediate Package",
        "$900.00",
        listOf(
            "Equipped kitchen, 1 server",
            "Ambient sound",
            "Serving utensils",
            "1 toy monitor",
            "Air-conditioned environment",
            "Kids space with toys",
            "Basic decoration, balloons not included",
            "12 tablecloths"
        )
    ),
    ADVANCED(
        "Advanced Package",
        "$1700.00",
        listOf(
            "Equipped kitchen, 1 server and 2 waiters",
            "Ambient sound",
            "Serving utensils",
            "1 toy monitor",
            "Air-conditioned environment",
            "Kids space with toys",
            "Plus decoration with 300 plain balloons",
            "12 tablecloths",
            "40 Party gifts: 20 tubes & 20 candy boxes"
        )
    ),
    PLUS(
        "Plus Package",
        "$2300.00",
        listOf(
            "Equipped kitchen, 1 server and 2 waiters",
            "Ambient sound",
            "Serving utensils",
            "1 toy monitor",
            "Air-conditioned environment",
            "Kids space with toys",
            "Plus decoration with 300 plain balloons",
            "12 tablecloths",
            "40 Party gifts: 20 tubes & 20 candy boxes",
            "400 snacks: 150 mini pizzas, 50 hot dogs, 100 mini hamburgers, and 100 mini bags of fries"
        )
    )
}