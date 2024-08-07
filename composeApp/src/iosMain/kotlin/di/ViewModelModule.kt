package di
import mainScreen.MainScreenViewModel
import onboarding.presentation.OnboardingViewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module
import partyHomeScreen.PartyHomeScreenViewModel
import partyPlanningScreen.PartyPlanScreenViewModel

actual val viewModelModule = module {
    single {
        OnboardingViewModel(get(named("title")), get(named("subtitle")))
    }
    single {
        MainScreenViewModel()
    }
    single {
        PartyHomeScreenViewModel()
    }
    single {
        PartyPlanScreenViewModel()
    }
}