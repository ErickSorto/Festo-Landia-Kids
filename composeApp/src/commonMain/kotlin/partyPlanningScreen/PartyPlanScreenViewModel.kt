package partyPlanningScreen

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class PartyPlanScreenViewModel : ViewModel() {
    private val _partyPlanningScreenViewModelState = MutableStateFlow(PartyPlanningScreenViewModelState())
    val partyPlanScreenViewModelState: StateFlow<PartyPlanningScreenViewModelState> = _partyPlanningScreenViewModelState

    fun onEvent(event: PartyPlanningScreenEvent) {
        when (event) {
            is PartyPlanningScreenEvent.ButtonClicked -> {
                _partyPlanningScreenViewModelState.value = _partyPlanningScreenViewModelState.value.copy(
                    title = "Button Clicked"
                )
            }
            is PartyPlanningScreenEvent.CreateNewPartyClicked -> {
                // Handle event
            }
            is PartyPlanningScreenEvent.TextFieldChanged -> {
                when (event.field) {
                    TextFieldType.NAME -> _partyPlanningScreenViewModelState.value = _partyPlanningScreenViewModelState.value.copy(name = event.text)
                    TextFieldType.NUMBER_OF_PEOPLE -> _partyPlanningScreenViewModelState.value = _partyPlanningScreenViewModelState.value.copy(numberOfPeople = event.text)
                    TextFieldType.TIER -> _partyPlanningScreenViewModelState.value = _partyPlanningScreenViewModelState.value.copy(tier = event.text)
                    TextFieldType.DATE -> TODO()
                }
            }
            is PartyPlanningScreenEvent.ThemeSelected -> {
                _partyPlanningScreenViewModelState.value = _partyPlanningScreenViewModelState.value.copy(theme = event.theme)
            }
        }
    }
}

data class PartyPlanningScreenViewModelState(
    val title: String = "",
    val description: String = "",
    val name: String = "",
    val numberOfPeople: String = "",
    val theme: String = "",
    val tier: String = "",
    val date: String = "",
)
enum class TextFieldType {
    NAME, NUMBER_OF_PEOPLE, TIER, DATE
}
