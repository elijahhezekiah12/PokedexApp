package com.elijahhezekiah.pokdexapp.presentation.pokemon_list

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.elijahhezekiah.pokdexapp.common.Resource
import com.elijahhezekiah.pokdexapp.domain.use_case.get_pokemen_list_usecase.GetPokemonListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import javax.inject.Inject
import kotlinx.coroutines.flow.onEach


@HiltViewModel
class MainViewModel@Inject constructor(
    private val getPokemonListUseCase: GetPokemonListUseCase
): ViewModel()  {

    private val _state = mutableStateOf(PokemonListState())
    val state : State<PokemonListState> = _state

    init {
        getPokemonList()
    }

    private fun getPokemonList() {
        getPokemonListUseCase().onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _state.value = PokemonListState(pokemonList = result.data ?: emptyList())
                }

                is Resource.Error -> {
                    _state.value =
                        PokemonListState(error = result.message ?: "An unexpected error occured")
                }

                is Resource.Loading -> {
                    _state.value = PokemonListState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }


}