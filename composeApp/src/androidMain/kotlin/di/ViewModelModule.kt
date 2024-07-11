package di

import mainScreen.MainScreenViewModel
import onboarding.presentation.OnboardingViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module
import partyHomeScreen.PartyHomeScreenViewModel
import partyPlanningScreen.PartyPlanScreenViewModel

actual val viewModelModule = module {
   viewModel { OnboardingViewModel(get(named("title")), get(named("subtitle"))) }
   viewModel { MainScreenViewModel() }
   viewModel { PartyHomeScreenViewModel() }
   viewModel { PartyPlanScreenViewModel() }
}