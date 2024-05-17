import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import onboarding.presentation.OnboardingScreen
import onboarding.presentation.OnboardingViewModel
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.KoinContext
import org.koin.compose.currentKoinScope
import org.koin.core.context.KoinContext

@Composable
@Preview
fun App() {
    KoinContext {
        FestoLandiaKidsTheme(
            darkTheme = false
        ) {
            val navController = rememberNavController()

            NavHost(navController = navController, startDestination = "onboarding"){
                composable("onboarding"){
                    val onboardingViewModel = koinViewModel<OnboardingViewModel>()
                    val onboardingViewModelState = onboardingViewModel.onBoardingViewModelState.collectAsState()
                    OnboardingScreen(
                        onboardingViewModelState = onboardingViewModelState.value
                    ) {
                        onboardingViewModel.onEvent(it)
                    }
                }
            }
        }
    }
}

@Composable
inline fun <reified T: ViewModel> koinViewModel (): T {
    val scope = currentKoinScope()
    return viewModel {
        scope.get<T>()
    }
}