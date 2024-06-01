package navigation

import androidx.compose.ui.graphics.vector.ImageVector

enum class Screens(
    val title: String? = null,
    val icon: ImageVector? = null
) {
    OnboardingScreen(
        title = "Onboarding",
        icon = null
    ),
    MainScreen(
        title = "Main",
        icon = null
    ),
    PartyHomeScreen(
        title = "Party Home",
        icon = null
    ),
    PartyPlanScreen(
        title = "Party Plan",
        icon = null
    ),
    PartyGalleryScreen(
        title = "Party Gallery",
        icon = null
    ),

}