package com.elijahhezekiah.pokdexapp.presentation.FavoriteView.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.elijahhezekiah.pokdexapp.domain.model.Pokemon

@Composable
fun  FavoritePokemonListItem (
    pokemon: Pokemon,
    modifier: Modifier = Modifier

){

    Card(
        modifier = modifier
    ){

        Column (
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(6.dp)
        ) {

            Text(
                text = pokemon.name,
                style = MaterialTheme.typography.titleMedium
            )

        }

    }

}