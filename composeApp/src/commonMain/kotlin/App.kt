import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import navigation.MainGraph
import onboarding.presentation.OnboardingScreen
import onboarding.presentation.OnboardingViewModel
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.KoinContext
import org.koin.compose.currentKoinScope

@Composable
@Preview
fun App() {
    KoinContext {
        FestoLandiaKidsTheme(
            darkTheme = false
        ) {
            val navController = rememberNavController()

            MainGraph(
                navController = navController,
                onDataLoaded = {}
            )
        }
    }
}

