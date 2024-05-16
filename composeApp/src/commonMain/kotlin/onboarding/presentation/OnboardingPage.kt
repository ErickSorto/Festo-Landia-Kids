package onboarding.presentation

enum class OnboardingPage(
    val title: String,
    val vectorIcon: String,
    val description: String,
    val pageNumber: Int
) {
    WELCOME(
        title = "Welcome to Collatz Conjecture Visualizer",
        vectorIcon = "welcome",
        description = "Collatz Conjecture Visualizer is a tool that allows you to visualize the Collatz Conjecture in a fun and interactive way.",
        pageNumber = 0
    ),
    CALCULATOR(
        title = "Calculator",
        vectorIcon = "calculator",
        description = "Use the calculator to generate a Collatz sequence for any number.",
        pageNumber = 1
    ),
    VISUALIZER(
        title = "Visualizer",
        vectorIcon = "visualizer",
        description = "Visualize the Collatz Conjecture in a 3D environment.",
        pageNumber = 2
    )
}