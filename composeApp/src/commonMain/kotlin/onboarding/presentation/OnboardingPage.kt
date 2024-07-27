package onboarding.presentation

enum class OnboardingPage(
    val title: String,
    val vectorIcon: String,
    val description: String,
    val pageNumber: Int
) {
    WELCOME(
        title = "Welcome to Festo Landia Kids",
        vectorIcon = "welcome",
        description = "Festo Landia Kids is happy to make your child's birthday party a " +
                "memorable one. Create your party, explore options, and plan your event.",
        pageNumber = 0
    ),
    CREATE_PARTY(
        title = "Create your party",
        vectorIcon = "calculator",
        description = "Make your child's dream party a reality with the help of artificial intelligence.",
        pageNumber = 1
    ),
    EXPLORE_OPTIONS(
        title = "Explore your options",
        vectorIcon = "visualizer",
        description = "Explore different themes, packages, and options to make your child's party unique and affordable.",
        pageNumber = 2
    ),
    PLAN_EVENT(
        title = "Plan your event",
        vectorIcon = "calendar",
        description = "Plan your event, create a guest list, and send out invitations to make your child's party a success.",
        pageNumber = 3
    )
}