package com.example.screens.main.impl.usecases

import com.example.entities.ProcessState
import com.example.screens.main.api.data.DataPlayer
import com.example.screens.main.api.usecases.GetPlayersUseCase
import com.example.screens.main.impl.components.PlayersList
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext

class GetPlayerUseCaseImpl : GetPlayersUseCase {
    private val players = PlayersList
    override suspend fun invoke(searchPattern: String): ProcessState<List<DataPlayer>> =
        withContext(Dispatchers.IO) {
            delay(500L)
            ProcessState.Success(players.filter {
                it.nickname.contains(
                    searchPattern, ignoreCase = true
                )
            })
        }

}