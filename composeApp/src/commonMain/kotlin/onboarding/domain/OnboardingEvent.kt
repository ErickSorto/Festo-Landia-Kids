package onboarding.domain


sealed class OnboardingEvent {
    data object ButtonClicked : OnboardingEvent()
}