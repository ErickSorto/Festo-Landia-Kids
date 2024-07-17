package navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import partyHomeScreen.PartyHomeScreen
import partyHomeScreen.PartyHomeScreenViewModel

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
    }
}