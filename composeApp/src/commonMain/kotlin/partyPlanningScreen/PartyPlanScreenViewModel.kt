package partyPlanningScreen

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class PartyPlanScreenViewModel() : ViewModel() {
    private val _partyPlanningScreenViewModelState = MutableStateFlow(PartyPlanningScreenViewModelState())
    val partyPlanScreenViewModelState: StateFlow<PartyPlanningScreenViewModelState> = _partyPlanningScreenViewModelState

    fun onEvent(event: PartyPlanningScreenEvent) {
        when (event) {
            is PartyPlanningScreenEvent.ButtonClicked -> {
                _partyPlanningScreenViewModelState.value = _partyPlanningScreenViewModelState.value.copy(
                    title = "Button Clicked"
                )
            }

            is PartyPlanningScreenEvent.CreateNewPartyClicked -> TODO()
        }
    }
}

data class PartyPlanningScreenViewModelState(
    val title: String = "",
    val description: String = ""
)