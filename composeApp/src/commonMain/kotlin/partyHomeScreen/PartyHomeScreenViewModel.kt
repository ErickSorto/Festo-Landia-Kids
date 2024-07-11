package partyHomeScreen

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class PartyHomeScreenViewModel(): ViewModel() {
    private val _partyHomeScreenViewModelState = MutableStateFlow(PartyHomeScreenViewModelState())
    val partyHomeScreenViewModelState: StateFlow<PartyHomeScreenViewModelState> = _partyHomeScreenViewModelState

    fun onEvent(event: PartyHomeScreenEvent) {
        when(event) {
            is PartyHomeScreenEvent.ButtonClicked -> {
                _partyHomeScreenViewModelState.value = _partyHomeScreenViewModelState.value.copy(
                    title = "Button Clicked"
                )
            }

            PartyHomeScreenEvent.CreateNewPartyClicked -> TODO()
        }
    }
}

data class PartyHomeScreenViewModelState(
    val title: String = "",
    val description: String = ""
)