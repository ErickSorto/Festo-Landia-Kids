package navigation

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
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
import partyPlanningScreen.PartyPlanScreen
import partyPlanningScreen.PartyPlanScreenViewModel


@Composable
fun MainGraph(
    navController: NavHostController,
    onDataLoaded: () -> Unit,
) {
    NavHost(
        navController = navController,
        startDestination = Screens.OnboardingScreen.name,
        enterTransition = {
            when (targetState.destination.route) {
                Screens.PartyPlanScreen.name -> slideInVertically(
                    initialOffsetY = { fullHeight -> fullHeight },
                    animationSpec = tween(durationMillis = 600, easing = FastOutSlowInEasing)
                )
                else -> fadeIn(animationSpec = tween(700))
            }
        },
        exitTransition = {
            when (targetState.destination.route) {
                //do nothing when navigating to plan screen
                Screens.PartyPlanScreen.name -> fadeOut(animationSpec = tween(10000))
                else -> fadeOut(animationSpec = tween(700))
            }
        },
        popExitTransition = {
            when (targetState.destination.route) {
                Screens.PartyPlanScreen.name -> slideOutVertically(
                    targetOffsetY = { fullHeight -> fullHeight },
                    animationSpec = tween(durationMillis = 600, easing = FastOutSlowInEasing)
                )
                else -> slideOutVertically(
                    targetOffsetY = { fullHeight -> fullHeight },
                    animationSpec = tween(durationMillis = 600, easing = FastOutSlowInEasing)
                )
            }
        }
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
               onNavigateTo = {
                   navController.navigate(it.name)
               }
            )
        }

        composable(route = Screens.PartyPlanScreen.name) {
            val partyPlanScreenViewModel = koinViewModel<PartyPlanScreenViewModel>()
            val partyPlanningScreenViewModelState = partyPlanScreenViewModel.partyPlanScreenViewModelState.collectAsState()

            PartyPlanScreen(
                partyPlanningScreenViewModelState = partyPlanningScreenViewModelState.value,
                onNavigateUp = {
                    navController.navigateUp()
                },
                onEvent = {
                    partyPlanScreenViewModel.onEvent(it)
                },
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