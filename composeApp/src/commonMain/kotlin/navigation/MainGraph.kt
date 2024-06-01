package navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import mainScreen.MainScreenView
import mainScreen.MainScreenViewModel
import onboarding.presentation.OnboardingScreen
import onboarding.presentation.OnboardingViewModel
import org.koin.compose.currentKoinScope


@Composable
fun MainGraph(
    navController: NavHostController,
    onDataLoaded: () -> Unit,
) {
    NavHost(
        navController = navController,
        startDestination = Screens.OnboardingScreen.name,
    ) {
        //welcome
        composable(route = Screens.OnboardingScreen.name) {
            val onboardingViewModel = koinViewModel<OnboardingViewModel>()
            val onboardingViewModelState = onboardingViewModel.onBoardingViewModelState.collectAsState()
            OnboardingScreen(
                onboardingViewModelState = onboardingViewModelState.value,
                onEvent = {
                    onboardingViewModel.onEvent(it)
                },
                onNavigateToMainScreen = {
                    navController.popBackStack()
                    navController.navigate(Screens.MainScreen.name)
                },
            )
        }

        composable(route = Screens.MainScreen.name) {
            val mainScreenViewModel = koinViewModel<MainScreenViewModel>()
            val mainScreenViewModelState = mainScreenViewModel.mainScreenViewModelState.collectAsState()
            MainScreenView(
                mainScreenViewModelState = mainScreenViewModelState.value,
                onNavigateToOnboardingScreen = {
                    navController.popBackStack()
                    navController.navigate(Screens.OnboardingScreen.name)
                },
                onMainEvent = {
                    mainScreenViewModel.onEvent(it)
                },
                onDataLoaded = {
                    onDataLoaded()
                }
            )
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