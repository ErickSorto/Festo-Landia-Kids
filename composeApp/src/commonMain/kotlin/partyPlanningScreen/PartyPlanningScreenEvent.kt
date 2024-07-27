package partyPlanningScreen

sealed class PartyPlanningScreenEvent {
    data class ButtonClicked(val title: String, val description: String) : PartyPlanningScreenEvent()
    data class TextFieldChanged(val field: TextFieldType, val text: String) : PartyPlanningScreenEvent()
    data class ToggleSimplePackageExpanded(val isExpanded: Boolean) : PartyPlanningScreenEvent()
    data class ToggleIntermediatePackageExpanded(val isExpanded: Boolean) : PartyPlanningScreenEvent()
    data class ToggleAdvancedPackageExpanded(val isExpanded: Boolean) : PartyPlanningScreenEvent()
    data class TogglePlusPackageExpanded(val isExpanded: Boolean) : PartyPlanningScreenEvent()
    data class ToggleCustomThemeExpanded(val isExpanded: Boolean) : PartyPlanningScreenEvent()
    data class SelectTheme(val theme: String) : PartyPlanningScreenEvent()
    data class SelectPackage(val packageType: String) : PartyPlanningScreenEvent()
    data class CreatePartyClicked(val title: String, val description: String) : PartyPlanningScreenEvent()
}