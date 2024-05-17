package di

import onboarding.presentation.OnboardingViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.qualifier.named
import org.koin.dsl.module

actual val viewModelModule = module {
   viewModel { OnboardingViewModel(get(named("title")), get(named("subtitle"))) }
}