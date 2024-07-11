package partyPlanningScreen

import CustomColors.DarkPastelMagenta
import CustomColors.LightPastelMagenta
import androidx.compose.foundation.ExperimentalFoundationApi
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
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.input.TextFieldLineLimits
import androidx.compose.foundation.text.input.TextFieldState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import festolandiakids.composeapp.generated.resources.Res
import festolandiakids.composeapp.generated.resources.SampleMickyMouse
import festolandiakids.composeapp.generated.resources.SamplePinkCastle
import festolandiakids.composeapp.generated.resources.SampleToyStory
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource

@Composable
fun PartyPlanScreen(
    partyPlanningScreenViewModelState: PartyPlanningScreenViewModelState,
    onEvent: (PartyPlanningScreenEvent) -> Unit
) {
    Scaffold(
        modifier = Modifier
            .fillMaxSize(),
        containerColor = Color.Transparent,
    ) {
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
                .padding(top = it.calculateTopPadding())
                .verticalScroll(rememberScrollState())
        ) {
            Text(
                text = "Name",
                style = TextStyle(color = Color.White, fontSize = 16.sp),
                modifier = Modifier.padding(16.dp)
            )
            val nameState = remember { TextFieldState(partyPlanningScreenViewModelState.name) }
            TransparentHintTextField(
                hint = "Name of the person",
                isHintVisible = partyPlanningScreenViewModelState.name.isBlank(),
                singleLine = true,
                textStyle = TextStyle(color = Color.White),
                modifier = Modifier
                    .clip(RoundedCornerShape(8.dp))
                    .background(Color(0xB3FFFFFF))
                    .padding(16.dp),
                textFieldState = nameState,
            )
            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Number of People",
                style = TextStyle(color = Color.White, fontSize = 16.sp),
                modifier = Modifier.padding(16.dp)
            )
            val numberOfPeopleState =
                remember { TextFieldState(partyPlanningScreenViewModelState.numberOfPeople) }
            TransparentHintTextField(
                hint = "Number of people",
                isHintVisible = partyPlanningScreenViewModelState.numberOfPeople.isBlank(),
                singleLine = true,
                textStyle = TextStyle(color = Color.White),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                modifier = Modifier
                    .clip(RoundedCornerShape(8.dp))
                    .background(Color(0xB3FFFFFF))
                    .padding(16.dp),
                textFieldState = numberOfPeopleState,
            )
            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Theme",
                style = TextStyle(color = Color.White, fontSize = 16.sp),
                modifier = Modifier.padding(16.dp)
            )
            ThemeSelection(
                selectedTheme = if (partyPlanningScreenViewModelState.theme.isBlank()) null else PartyTheme.valueOf(
                    partyPlanningScreenViewModelState.theme
                ),
                onThemeSelected = { theme ->
                    onEvent(PartyPlanningScreenEvent.ThemeSelected(theme.name))
                }
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Tier",
                style = TextStyle(color = Color.White, fontSize = 16.sp),
                modifier = Modifier.padding(16.dp)
            )
            val tierState = remember { TextFieldState(partyPlanningScreenViewModelState.tier) }
            TransparentHintTextField(
                hint = "Tier of the party",
                isHintVisible = partyPlanningScreenViewModelState.tier.isBlank(),
                singleLine = true,
                textStyle = TextStyle(color = Color.White),
                modifier = Modifier
                    .clip(RoundedCornerShape(8.dp))
                    .background(Color(0xB3FFFFFF))
                    .padding(16.dp),
                textFieldState = tierState,
            )
            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Date",
                style = TextStyle(color = Color.White, fontSize = 16.sp),
                modifier = Modifier.padding(16.dp)
            )
            val dateState = remember { TextFieldState(partyPlanningScreenViewModelState.date) }
            TransparentHintTextField(
                hint = "Desired date of the party",
                isHintVisible = partyPlanningScreenViewModelState.date.isBlank(),
                singleLine = true,
                textStyle = TextStyle(color = Color.White),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
                modifier = Modifier
                    .clip(RoundedCornerShape(8.dp))
                    .background(
                        Color(0xB3FFFFFF).copy(
                            alpha = 0.4f
                        )
                    )
                    .padding(16.dp),
                textFieldState = dateState,
            )
            Spacer(modifier = Modifier.height(16.dp))
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
        }
    }
}

@Composable
fun TransparentHintTextField(
    hint: String,
    modifier: Modifier = Modifier,
    modifier2: Modifier = Modifier,
    isHintVisible: Boolean = true,
    textStyle: TextStyle = TextStyle(),
    singleLine: Boolean = false,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    textFieldState: TextFieldState
) {
    Box(modifier = modifier)
    {
        BasicTextField(
            state = textFieldState,
            textStyle = textStyle,
            lineLimits = if (singleLine) TextFieldLineLimits.SingleLine else TextFieldLineLimits.Default,
            scrollState = rememberScrollState(),
            keyboardOptions = keyboardOptions,
            modifier = modifier2
                .fillMaxWidth(),
            cursorBrush = Brush.verticalGradient(
                colors = listOf(
                    Color.White,
                    Color.White
                )
            ),
        )

        if (isHintVisible) {
            Text(text = hint, style = textStyle, color = Color.White)
        }
    }
}

@Composable
fun ThemeSelection(
    selectedTheme: PartyTheme?,
    onThemeSelected: (PartyTheme) -> Unit
) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        modifier = Modifier
            .fillMaxWidth()
            .horizontalScroll(rememberScrollState())
    ) {
        Spacer(modifier = Modifier.width(0.dp))
        PartyTheme.entries.forEach { theme ->
            Card(
                modifier = Modifier
                    .width(325.dp),
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 3.dp,
                ),
                onClick = { onThemeSelected(theme) }
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        painter = painterResource(theme.image),
                        contentDescription = "Theme Image",
                        modifier = Modifier
                            .height(225.dp)
                            .fillMaxWidth()
                            .padding(16.dp)
                            .clip(RoundedCornerShape(16.dp)),
                        contentScale = ContentScale.Crop
                    )
                    Text(
                        text = theme.title,
                        style = MaterialTheme.typography.bodyLarge,
                        modifier = Modifier.padding(8.dp)
                    )
                }
            }
        }
        Spacer(modifier = Modifier.width(0.dp))
    }
}

enum class PartyTheme(val title: String, val image: DrawableResource) {
    MICKEY_MOUSE("Mickey Mouse", Res.drawable.SampleMickyMouse),
    TOY_STORY("Toy Story", Res.drawable.SampleToyStory),
    PINK_CASTLE("Pink Castle", Res.drawable.SamplePinkCastle),
}
