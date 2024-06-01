package mainScreen

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class MainScreenViewModel(): ViewModel() {
    private val _mainScreenViewModelState = MutableStateFlow(MainScreenViewModelState())
    val mainScreenViewModelState: StateFlow<MainScreenViewModelState> = _mainScreenViewModelState

    fun onEvent(event: MainScreenEvent) {
        when(event) {
            is MainScreenEvent.ButtonClicked -> {
                _mainScreenViewModelState.value = _mainScreenViewModelState.value.copy(
                    title = event.title
                )
            }
        }
    }

}

data class MainScreenViewModelState(
    val title: String = "",
    val description: String = ""
)