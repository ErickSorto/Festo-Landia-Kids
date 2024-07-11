package partyHomeScreen

sealed class PartyHomeScreenEvent {
    data object ButtonClicked: PartyHomeScreenEvent()

    data object CreateNewPartyClicked: PartyHomeScreenEvent()
}