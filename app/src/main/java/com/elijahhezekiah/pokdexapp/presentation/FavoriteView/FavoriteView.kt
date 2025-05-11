package com.elijahhezekiah.pokdexapp.presentation.FavoriteView

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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.elijahhezekiah.pokdexapp.domain.model.Pokemon
import com.elijahhezekiah.pokdexapp.presentation.FavoriteView.components.FavoritePokemonListItem


@Composable
fun FavoriteScreen (
    viewModel: FavoriteViewModel = hiltViewModel()

){
    val state = viewModel.state.value

     Box(modifier = Modifier.fillMaxSize()) {
            LazyColumn(
                contentPadding = PaddingValues(
                    top =  10.dp,
                    start = 20.dp,
                    end = 20.dp,
                    bottom = 10.dp,
                ),
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {


                item {
                    Row(
                        modifier = Modifier.background(
                            Color(0xFFC4C7EB),
                            shape = RoundedCornerShape(20.dp)
                        )
                            .align(alignment = Alignment.CenterEnd)
                            .padding(horizontal = 16.dp, vertical = 16.dp)
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {

                        Text(
                            text = "Favorite Pokemon",
                            style = MaterialTheme.typography.displaySmall,
                            fontWeight = FontWeight.Bold,
                        )
                        Spacer(modifier = Modifier.weight(10f))
                        IconButton(onClick = {

                        }) {
                            Icon(
                                imageVector = Icons.Default.Favorite,
                                contentDescription = "favorite",
                                tint = MaterialTheme.colorScheme.primary,
                            )
                        }

                    }
                }

                items(state.pokemonList) { pokemon ->
                    FavoritePokemonListItem(
                        pokemon = pokemon?: Pokemon("","")
                    )

                }

            }

    }

}