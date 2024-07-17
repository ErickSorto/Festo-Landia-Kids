package partyPlanningScreen

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class PartyPlanScreenViewModel : ViewModel() {
    private val _partyPlanningScreenViewModelState =
        MutableStateFlow(PartyPlanningScreenViewModelState())
    val partyPlanScreenViewModelState: StateFlow<PartyPlanningScreenViewModelState> =
        _partyPlanningScreenViewModelState



    fun onEvent(event: PartyPlanningScreenEvent) {
        when (event) {
            is PartyPlanningScreenEvent.ButtonClicked -> {
                _partyPlanningScreenViewModelState.value =
                    _partyPlanningScreenViewModelState.value.copy(
                        title = "Button Clicked"
                    )
            }

            is PartyPlanningScreenEvent.CreateNewPartyClicked -> {
                // Handle event
            }

            is PartyPlanningScreenEvent.TextFieldChanged -> {
                when (event.field) {
                    TextFieldType.NAME -> _partyPlanningScreenViewModelState.value =
                        _partyPlanningScreenViewModelState.value.copy(name = event.text)

                    TextFieldType.NUMBER_OF_PEOPLE -> _partyPlanningScreenViewModelState.value =
                        _partyPlanningScreenViewModelState.value.copy(numberOfPeople = event.text)

                    TextFieldType.TIER -> _partyPlanningScreenViewModelState.value =
                        _partyPlanningScreenViewModelState.value.copy(tier = event.text)

                    TextFieldType.DATE -> _partyPlanningScreenViewModelState.value =
                        _partyPlanningScreenViewModelState.value.copy(date = event.text)
                }
            }

            is PartyPlanningScreenEvent.ToggleSimplePackageExpanded -> {
                _partyPlanningScreenViewModelState.value =
                    _partyPlanningScreenViewModelState.value.copy(isSimplePackageExpanded = event.isExpanded)
            }
            is PartyPlanningScreenEvent.ToggleIntermediatePackageExpanded -> {
                _partyPlanningScreenViewModelState.value =
                    _partyPlanningScreenViewModelState.value.copy(isIntermediatePackageExpanded = event.isExpanded)
            }
            is PartyPlanningScreenEvent.ToggleAdvancedPackageExpanded -> {
                _partyPlanningScreenViewModelState.value =
                    _partyPlanningScreenViewModelState.value.copy(isAdvancedPackageExpanded = event.isExpanded)
            }
            is PartyPlanningScreenEvent.TogglePlusPackageExpanded -> {
                _partyPlanningScreenViewModelState.value =
                    _partyPlanningScreenViewModelState.value.copy(isPlusPackageExpanded = event.isExpanded)
            }
            is PartyPlanningScreenEvent.SelectTheme -> {
                _partyPlanningScreenViewModelState.value =
                    _partyPlanningScreenViewModelState.value.copy(selectedTheme = event.theme)
            }

            is PartyPlanningScreenEvent.SelectPackage -> {
                _partyPlanningScreenViewModelState.value =
                    _partyPlanningScreenViewModelState.value.copy(selectedPackage = event.packageType)
            }
        }
    }
}

data class PartyPlanningScreenViewModelState(
    val title: String = "",
    val description: String = "",
    val name: String = "",
    val numberOfPeople: String = "",
    val tier: String = "",
    val date: String = "",
    val selectedTheme: String = "",
    val selectedPackage: String = "",
    val isSimplePackageExpanded: Boolean = false,
    val isIntermediatePackageExpanded: Boolean = false,
    val isAdvancedPackageExpanded: Boolean = false,
    val isPlusPackageExpanded: Boolean = false,
)

enum class TextFieldType {
    NAME, NUMBER_OF_PEOPLE, TIER, DATE
}
