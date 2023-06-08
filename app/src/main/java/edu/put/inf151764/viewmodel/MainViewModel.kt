package edu.put.inf151764.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import edu.put.inf151764.data.api.GamesApi
import edu.put.inf151764.data.api.util.wrapApiCall
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.channelFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import java.nio.channels.Channels
import java.time.LocalDateTime
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val gamesApi: GamesApi
) : ViewModel() {

    private val _uiState = MutableStateFlow(State.DEFAULT)
    val uiState: Flow<State> = _uiState
    private val eventChannel = Channel<Event>(Channel.CONFLATED)
    val events = eventChannel.receiveAsFlow()

    fun test() = viewModelScope.launch {
        val test = wrapApiCall {
            gamesApi.getGames("loutre_on_fire")
        }
        test
    }

    fun onLogoutClicked() = viewModelScope.launch {

    }

    fun onUserPicked(userName: String) = viewModelScope.launch {

    }

    fun onSynchronizeClicked()= viewModelScope.launch {

    }

    data class State(
        val userName: String?,
        val synchronizationDate: LocalDateTime?
    ) {
        companion object {
            val DEFAULT = State(
                userName = null,
                synchronizationDate = null
            )
        }
    }

    sealed class Event {
        object ShowLoginPopup: Event()
    }
}