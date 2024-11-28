package partyPlanningScreen

import CustomColors.DarkPastelMagenta
import CustomColors.DarkYellow
import CustomColors.DeepSkyBlue
import CustomColors.LightMagenta
import CustomColors.LightPastelMagenta
import CustomColors.LightSkyBlue2
import CustomColors.LightYellow
import CustomColors.SkyBlue
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Animatable
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
import androidx.compose.foundation.layout.wrapContentSize
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
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.TileMode
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
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
import kotlin.random.Random

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
                                modifier = Modifier.size(12.dp).align(Alignment.Center).padding(2.dp),
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
                    .fillMaxWidth()
                    .height(88.dp)
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
                        Color.DarkGray.copy(
                            alpha = 0.10f
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
                        Color.DarkGray.copy(
                            alpha = 0.10f
                        )
                    ),
                text = dateText,
                onValueChange = {
                    onEvent(PartyPlanningScreenEvent.TextFieldChanged(TextFieldType.DATE, it))
                }
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
                },
                enabled = !partyPlanningScreenViewModelState.isCustomThemeExpanded
            )
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(18.dp, 16.dp, 16.dp, 0.dp)
            )
            {
                Text(
                    text = "Custom Theme",
                    style = typography.titleSmall,
                    color = Color.White,
                )
                Spacer(modifier = Modifier.width(16.dp))
                SwitchWithCustomColors(
                    onCheckedChange = {
                        onEvent(PartyPlanningScreenEvent.ToggleCustomThemeExpanded(it))
                    },
                    checked = partyPlanningScreenViewModelState.isCustomThemeExpanded
                )
            }
            TransparentHintTextField(
                hint = "Enter custom theme name..",
                isHintVisible = partyPlanningScreenViewModelState.customTheme.isBlank(),
                singleLine = true,
                textStyle = typography.bodyMedium.copy(
                    if (partyPlanningScreenViewModelState.isCustomThemeExpanded) Color.White else Color.White.copy(
                        alpha = 0.6f
                    )
                ),
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .background(
                        Color.DarkGray.copy(
                            if (partyPlanningScreenViewModelState.isCustomThemeExpanded) 0.1f else 0.01f
                        )
                    ),
                text = partyPlanningScreenViewModelState.customTheme,
                onValueChange = {
                    onEvent(
                        PartyPlanningScreenEvent.TextFieldChanged(
                            TextFieldType.CUSTOM_THEME,
                            it
                        )
                    )
                },
                enabled = partyPlanningScreenViewModelState.isCustomThemeExpanded,
                maxCharacters = 30
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
                        PartyPlanningScreenEvent.CreatePartyClicked(
                            partyPlanningScreenViewModelState.name,
                            partyPlanningScreenViewModelState.date
                        )
                    )
                },
                modifier = Modifier.padding(16.dp).border(
                    width = 2.dp,
                    color = LightYellow,
                    shape = MaterialTheme.shapes.medium
                ).align(
                    Alignment.CenterHorizontally
                ),
                shape = MaterialTheme.shapes.medium,
                colors = ButtonDefaults.buttonColors(
                    containerColor = LightMagenta,
                    contentColor = Color.White,
                ),
                elevation = ButtonDefaults.buttonElevation(
                    defaultElevation = 5.dp,
                    pressedElevation = 10.dp
                )

            ) {
                Text(
                    text = "Create Party",
                    style = typography.displaySmall,
                    color = Color.White,
                    fontFamily = FontFamily(Font(Res.font.vag_rundschrift_d))
                )
            }
            Spacer(modifier = Modifier.height(paddingValues.calculateBottomPadding()))
        }
    }
}

@Composable
fun SwitchWithCustomColors(
    onCheckedChange: (Boolean) -> Unit,
    checked: Boolean
) {


    Switch(
        checked = checked,
        onCheckedChange = {
            onCheckedChange(it)
        },
        colors = SwitchDefaults.colors(
            checkedThumbColor = Color.White,
            checkedTrackColor = LightMagenta.copy(alpha = 0.6f),
            uncheckedThumbColor = Color.White.copy(alpha = 0.6f),
            uncheckedTrackColor = Color.Gray.copy(alpha = 0.3f),
            uncheckedBorderColor = Color.Transparent
        )
    )
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
    onValueChange: (String) -> Unit,
    enabled: Boolean = true
) {

    val borderAlpha = if (enabled) 0.45f else 0.2f
    Box(modifier = modifier.border(
        width = 3.dp,
        color = Color.White.copy(borderAlpha),
        shape = RoundedCornerShape(8.dp)
    )) {
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
                disabledIndicatorColor = Color.Transparent,
            ),
            enabled = enabled
        )

        val hintColor = if (enabled) Color.White.copy(alpha = 0.9f) else Color.White.copy(alpha = 0.7f)
        if (isHintVisible && text.isEmpty()) {
            Text(
                text = hint,
                style = textStyle,
                color = hintColor,
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
    enabled: Boolean,
    onThemeSelected: (String) -> Unit
) {
    val selectedRowHeightTarget = if (selectedTheme.isEmpty() || !enabled)
        280.dp else 310.dp
    val selectedRowHeight by animateDpAsState(targetValue = selectedRowHeightTarget)
    var showConfetti by remember { mutableStateOf(false) }

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
            val targetSize = if (isSelected && enabled
                ) 220.dp else 180.dp
            val size by animateDpAsState(targetValue = targetSize)
            val alpha by animateFloatAsState(targetValue = if (enabled) 1f else 0.8f)
            val textAlpha by animateFloatAsState(targetValue = if (enabled) .6f else 0.4f)
            val selectedElevation by animateDpAsState(targetValue = if (isSelected) 8.dp else 3.dp)
            Box(
                contentAlignment = Alignment.Center,
            ) {
                if (showConfetti && isSelected) {
                    ConfettiEffect(modifier = Modifier.size(size),
                        onAnimationEnd = {
                            showConfetti = false
                        }
                    )
                }
                Card(
                    onClick = {
                        onThemeSelected(theme.name)
                        showConfetti = true
                    },
                    modifier = Modifier
                        .width(size)
                        .alpha(alpha),
                    elevation = CardDefaults.cardElevation(defaultElevation = selectedElevation),
                    enabled = enabled,
                ) {
                    Box {
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Image(
                                painter = painterResource(theme.image),
                                contentDescription = "Theme Image",
                                modifier = Modifier
                                    .height(size)
                                    .fillMaxWidth()
                                    .padding(8.dp, 8.dp, 8.dp, 0.dp)
                                    .clip(RoundedCornerShape(16.dp))
                                    .alpha(alpha)
                                    .animateContentSize(),
                                contentScale = ContentScale.Crop
                            )
                            Text(
                                text = theme.title,
                                style = typography.titleMedium,
                                color = Color.Black.copy(textAlpha),
                                modifier = Modifier.padding(8.dp, 8.dp, 8.dp, 4.dp),
                            )
                            val buttonColor by animateColorAsState(
                                targetValue = if (isSelected) Color(0xFFE94057) else Color.Gray.copy(
                                    alpha = 0.6f
                                )
                            )
                            Box {
                                Button(
                                    onClick = {
                                        onThemeSelected(theme.name)
                                        showConfetti = true
                                    },
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(16.dp, 0.dp, 16.dp, 8.dp),
                                    colors = ButtonDefaults.buttonColors(containerColor = buttonColor),
                                    shape = RoundedCornerShape(16.dp),
                                    enabled = enabled
                                ) {
                                    Text(
                                        text = if (isSelected && enabled)
                                            "Selected" else "Select",
                                        color = Color.White,
                                        style = typography.bodyLarge,
                                        fontFamily = FontFamily(Font(Res.font.vag_rundschrift_d))
                                    )
                                }
                            }
                        }
                        if (showConfetti && isSelected) {
                            ConfettiEffect(modifier = Modifier.fillMaxSize(),
                                onAnimationEnd = {
                                    showConfetti = false
                                }
                            )
                        }
                    }
                }
            }

        }
        Spacer(modifier = Modifier.width(0.dp))
    }
}

sealed class Shape {
    object Circle : Shape()
    object Square : Shape()
    data class Rectangle(val heightRatio: Float) : Shape()
}

data class Particle(
    var x: Float,
    var y: Float,
    val width: Float,
    val height: Float,
    val color: Color,
    val shape: Shape,
    var alpha: Float,
    var velocityX: Float,
    var velocityY: Float,
    var rotation: Float
)

fun Shape.draw(drawScope: DrawScope, particle: Particle) {
    when (this) {
        Shape.Circle -> {
            val offsetMiddle = particle.width / 2
            drawScope.drawCircle(
                color = particle.color.copy(alpha = particle.alpha),
                center = Offset(particle.x + offsetMiddle, particle.y + offsetMiddle),
                radius = particle.width / 2
            )
        }

        Shape.Square -> {
            drawScope.drawRect(
                color = particle.color.copy(alpha = particle.alpha),
                topLeft = Offset(particle.x, particle.y),
                size = Size(particle.width, particle.height)
            )
        }

        is Shape.Rectangle -> {
            val height = particle.width * heightRatio
            drawScope.drawRect(
                color = particle.color.copy(alpha = particle.alpha),
                topLeft = Offset(particle.x, particle.y),
                size = Size(particle.width, height)
            )
        }
    }
}


@Composable
fun ConfettiEffect(
    modifier: Modifier = Modifier,
    confettiCount: Int = 60,
    durationMillis: Int = 800,
    onAnimationEnd: () -> Unit,
) {
    val confettiList = remember { List(confettiCount) { createRandomParticle() } }

    val animatable = remember { Animatable(0f) }
    var isAnimationRunning by remember { mutableStateOf(true) }

    LaunchedEffect(isAnimationRunning) {
        if (isAnimationRunning) {
            animatable.animateTo(
                targetValue = 1f,
                animationSpec = tween(durationMillis, easing = LinearEasing)
            )
            isAnimationRunning = false
            onAnimationEnd()
        }
    }

    LaunchedEffect(animatable.value) {
        confettiList.forEach { particle ->
            particle.x += particle.velocityX
            particle.y += particle.velocityY
            particle.velocityY += 0.1f // simulate gravity
            particle.alpha -= 0.01f // fade out
            particle.rotation += particle.velocityX

            if (particle.alpha <= 0) {
                particle.x = Random.nextInt(0, 800).toFloat()
                particle.y = Random.nextInt(0, 100).toFloat()
                particle.alpha = 1f
                particle.velocityX = Random.nextInt(100, 400) / 100f * cos(
                    Random.nextInt(
                        0,
                        360
                    ) * PI / 180
                ).toFloat()
                particle.velocityY = -(Random.nextInt(100, 400) / 100f * sin(
                    Random.nextInt(
                        0,
                        360
                    ) * PI / 180
                ).toFloat()) // Ensure an initial upward velocity
            }
        }
    }

    Canvas(modifier = modifier) {
        confettiList.forEach { particle ->
            drawIntoCanvas {
                it.save()
                it.translate(particle.x, particle.y)
                it.rotate(particle.rotation)
                it.translate(-particle.x, -particle.y)
                particle.shape.draw(this, particle)
                it.restore()
            }
        }
    }
}

fun createRandomParticle(): Particle {
    val shapes = listOf(Shape.Circle, Shape.Square, Shape.Rectangle(1.5f))
    val angle = Random.nextDouble(0.0, 2 * PI)
    val speed = Random.nextDouble(2.0, 5.0)
    return Particle(
        x = Random.nextInt(0, 1000).toFloat(),
        y = Random.nextInt(0, 100).toFloat(),
        width = Random.nextInt(10, 20).toFloat(),
        height = Random.nextInt(10, 20).toFloat(),
        color = Color(Random.nextInt(0xFFFFFF)).copy(alpha = 1f),
        shape = shapes.random(),
        alpha = 1f,
        velocityX = (speed * cos(angle)).toFloat(),
        velocityY = -(speed * sin(angle)).toFloat(),  // Ensure an initial upward velocity
        rotation = 0f
    )
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
    var showConfetti by remember { mutableStateOf(false) }
    if (isSelected && showConfetti) {
        ConfettiEffect(modifier = Modifier.fillMaxWidth(),
            onAnimationEnd = {
                showConfetti = false
            }
        )
    }
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
        val buttonColor by animateColorAsState(
            targetValue = if (isSelected) Color(0xFFE94057) else Color.Gray.copy(
                alpha = 0.6f
            )
        )
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
                        showConfetti = true
                        onEvent(
                            when (partyPackage) {
                                PartyPackage.SIMPLE -> PartyPlanningScreenEvent.ToggleSimplePackageExpanded(
                                    true
                                )

                                PartyPackage.INTERMEDIATE -> PartyPlanningScreenEvent.ToggleIntermediatePackageExpanded(
                                    true
                                )

                                PartyPackage.ADVANCED -> PartyPlanningScreenEvent.ToggleAdvancedPackageExpanded(
                                    true
                                )

                                PartyPackage.PLUS -> PartyPlanningScreenEvent.TogglePlusPackageExpanded(
                                    true
                                )
                            }
                        )
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(48.dp, 0.dp, 48.dp, 0.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = buttonColor),
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
            if (isSelected && showConfetti) {
                ConfettiEffect(modifier = Modifier.fillMaxWidth(),
                    onAnimationEnd = {
                        showConfetti = false
                    }
                )
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