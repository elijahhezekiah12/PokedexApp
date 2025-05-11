package com.elijahhezekiah.pokdexapp.presentation.FavoriteView

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.elijahhezekiah.pokdexapp.data.local.repository.LocalPokemonRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FavoriteViewModel @Inject constructor(
    private val localPokemonRepository: LocalPokemonRepository
): ViewModel() {

    private val _state = mutableStateOf(FavoritePokemonListState())
    val state : State<FavoritePokemonListState> = _state


   init {
        getFavoritePokemonList()
    }

    private fun getFavoritePokemonList() {

        viewModelScope.launch {

            _state.value.pokemonList= localPokemonRepository.getAllFavoritePokemon()
        }

     }



}