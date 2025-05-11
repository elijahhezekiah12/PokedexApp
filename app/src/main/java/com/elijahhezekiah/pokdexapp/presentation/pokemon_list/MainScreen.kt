package com.elijahhezekiah.pokdexapp.presentation.pokemon_list

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.elijahhezekiah.pokdexapp.presentation.pokemon_list.components.PokemonListItem


@Composable
fun MainScreen (
    onPokemonClick: (String, String) -> Unit,
    viewModel: MainViewModel = hiltViewModel(),
){
    val state = viewModel.state.value

     if (state.isLoading){
                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                        CircularProgressIndicator()
                }
        }

     else if(state.error.isNotBlank()){
                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {



                        Text(
                                text = state.error,
                                color = MaterialTheme.colorScheme.error,
                                textAlign = TextAlign.Center,
                                modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(horizontal = 20.dp)

                        )
                }
     }

    else if (state.pokemonList.isNotEmpty()){
        Box(modifier = Modifier.fillMaxSize()) {
            LazyColumn(
                contentPadding = PaddingValues(
                    top = 10.dp,
                    start = 20.dp,
                    end = 20.dp,
                    bottom = 10.dp,
                ),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {

              item {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(
                                Color(0xFFC4C7EB),
                                shape = RoundedCornerShape(20.dp)
                            )
                            .padding(horizontal = 16.dp, vertical = 16.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "Pokemon List",
                            style = MaterialTheme.typography.displaySmall,
                            fontWeight = FontWeight.Bold,
                        )
                        Spacer(modifier = Modifier.weight(1f))

                    }
                }

           items(state.pokemonList) { pokemon ->
                    PokemonListItem(
                        pokemon = pokemon,
                        onItemClick = {
                            onPokemonClick(pokemon.name, pokemon.url)
                        }
                    )
                }
            }
        }
    }
}