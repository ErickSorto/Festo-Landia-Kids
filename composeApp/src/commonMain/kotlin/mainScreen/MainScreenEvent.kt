package mainScreen

sealed class MainScreenEvent {
    data class ButtonClicked(val title: String) : MainScreenEvent()
}