package com.elijahhezekiah.pokdexapp.presentation.pokemon_details

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.elijahhezekiah.pokdexapp.common.Resource
import com.elijahhezekiah.pokdexapp.domain.use_case.get_pokemon_details_usecase.GetPokemonDetailsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import javax.inject.Inject
import kotlinx.coroutines.flow.onEach

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val getPokemonDetailsUseCase: GetPokemonDetailsUseCase
) : ViewModel() {

        private val _state = mutableStateOf(PokemonDetailState())
        val state: State<PokemonDetailState> = _state



     fun getPokemonDetails(pokemonName: String) {
         getPokemonDetailsUseCase(pokemonName).onEach { result ->

             when (result) {
                 is Resource.Success -> {
                     _state.value = PokemonDetailState(pokemon = result.data)
                 }
                 is Resource.Error -> {
                     _state.value = PokemonDetailState(
                         error = result.message ?: "An unexpected error occured"
                     )
                 }
                 is Resource.Loading -> {
                     _state.value = PokemonDetailState(isLoading = true)
                 }
             }

         }.launchIn(viewModelScope)
     }

}