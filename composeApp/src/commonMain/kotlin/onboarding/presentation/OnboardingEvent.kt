package onboarding.presentation


sealed class OnboardingEvent {
    data object ButtonClicked : OnboardingEvent()
}