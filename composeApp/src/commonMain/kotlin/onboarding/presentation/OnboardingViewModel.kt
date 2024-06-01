package onboarding.presentation

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import onboarding.domain.OnboardingEvent

class OnboardingViewModel(
    private val title: String,
    private val description: String
): ViewModel() {
    private val _onBoardingViewModelState = MutableStateFlow(OnboardingViewModelState())
    val onBoardingViewModelState: StateFlow<OnboardingViewModelState> = _onBoardingViewModelState

    fun onEvent(event: OnboardingEvent) {
        when(event) {
            OnboardingEvent.ButtonClicked -> {
                _onBoardingViewModelState.value = _onBoardingViewModelState.value.copy(
                    title = title,
                    description = description
                )
            }
        }
    }
}

data class OnboardingViewModelState(
    val title: String = "",
    val description: String = ""
)