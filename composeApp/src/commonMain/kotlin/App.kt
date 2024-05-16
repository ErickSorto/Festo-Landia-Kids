import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import onboarding.presentation.OnboardingScreen
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    MaterialTheme {
        OnboardingScreen()
    }
}