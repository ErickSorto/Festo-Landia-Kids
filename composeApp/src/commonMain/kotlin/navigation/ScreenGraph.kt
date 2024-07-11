package navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import partyHomeScreen.PartyHomeScreen
import partyHomeScreen.PartyHomeScreenViewModel
import partyPlanningScreen.PartyPlanScreen
import partyPlanningScreen.PartyPlanScreenViewModel

@Composable
fun ScreenGraph(
    navController: NavHostController,
) {
    NavHost(
        navController = navController,
        startDestination = Screens.PartyHomeScreen.name,
    ) {
        composable(route = Screens.PartyHomeScreen.name) {
            val partyHomeScreenViewModel = koinViewModel<PartyHomeScreenViewModel>()
            val partyHomeScreenViewModelState = partyHomeScreenViewModel.partyHomeScreenViewModelState.collectAsState()

            PartyHomeScreen(
                partyHomeScreenViewModelState = partyHomeScreenViewModelState.value,
                onEvent = {
                    partyHomeScreenViewModel.onEvent(it)
                },
            )
        }

        composable(route = Screens.PartyPlanScreen.name) {
            val partyPlanScreenViewModel = koinViewModel<PartyPlanScreenViewModel>()
            val partyPlanningScreenViewModelState = partyPlanScreenViewModel.partyPlanScreenViewModelState.collectAsState()

            PartyPlanScreen(
                partyPlanningScreenViewModelState = partyPlanningScreenViewModelState.value,
                onEvent = {
                    partyPlanScreenViewModel.onEvent(it)
                },
            )
        }
    }
}