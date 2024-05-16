import androidx.compose.runtime.Composable
import onboarding.presentation.OnboardingScreen
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    FestoLandiaKidsTheme(
        darkTheme = false
    ) {
        OnboardingScreen()
    }
}