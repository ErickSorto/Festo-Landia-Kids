package di
import onboarding.presentation.OnboardingViewModel
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

actual val viewModelModule = module {
    singleOf(::OnboardingViewModel)
}