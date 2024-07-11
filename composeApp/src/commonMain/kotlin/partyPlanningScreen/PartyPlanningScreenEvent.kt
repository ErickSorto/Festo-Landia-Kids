package partyPlanningScreen

sealed class PartyPlanningScreenEvent {
    data class ButtonClicked(val title: String, val description: String) : PartyPlanningScreenEvent()
    data class CreateNewPartyClicked(val title: String, val description: String) : PartyPlanningScreenEvent()
    data class TextFieldChanged(val field: TextFieldType, val text: String) : PartyPlanningScreenEvent()
    data class ThemeSelected(val theme: String) : PartyPlanningScreenEvent()
}