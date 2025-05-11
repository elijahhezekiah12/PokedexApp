package com.elijahhezekiah.pokdexapp.presentation.pokemon_details

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.elijahhezekiah.pokdexapp.domain.model.Pokemon
import com.elijahhezekiah.pokdexapp.presentation.pokemon_details.components.BaseStatsItem

@Composable
fun DetailScreen(
    viewModel: DetailViewModel = hiltViewModel(),
    name: String,
    url: String
) {

    LaunchedEffect(key1 = name) {
        viewModel.getPokemonDetails(name)
    }

    val state = viewModel.state.value
    val isFavoriteActive = remember { mutableStateOf(false) }

    Scaffold { innerPadding ->

        state.pokemon?.let { pokemon ->

            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(bottom = innerPadding.calculateBottomPadding()),
                horizontalAlignment = Alignment.Start
            ) {

                item {

                    AsyncImage(
                        model = pokemon.sprites.other?.home?.front_shiny,
                        contentDescription = null,
                        modifier = Modifier.fillMaxWidth()
                            .height(450.dp)
                            .clip(
                                RoundedCornerShape(
                                    bottomEnd = 20.dp
                                )
                            )
                            .padding(16.dp),
                        contentScale = ContentScale.Crop
                    )

                }



                item {
                    Column(
                        modifier = Modifier
                            .padding(10.dp)
                            .background(
                                Color(0xFFC4C7EB),
                                shape = RoundedCornerShape(20.dp)
                            )
                            .padding(horizontal = 16.dp, vertical = 16.dp)
                            .fillMaxWidth(),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {


                        Row {

                            Text(
                                text = "Name",
                                style = MaterialTheme.typography.titleLarge,
                                fontWeight = FontWeight.Bold,
                                textAlign = TextAlign.Center
                            )

                            Text(
                                text = " - ",
                                modifier = Modifier.padding(horizontal = 4.dp)
                            )

                            Text(
                                text = pokemon.name,
                                fontWeight = FontWeight.Bold,
                                textAlign = TextAlign.Center
                            )

                        }


                        Row {

                            Text(
                                text = "Height",
                                style = MaterialTheme.typography.titleLarge,
                                fontWeight = FontWeight.Bold,
                                textAlign = TextAlign.Center
                            )

                            Text(
                                text = " - ",
                                modifier = Modifier.padding(horizontal = 4.dp)
                            )

                            Text(
                                text = pokemon.height.toString(),
                                fontWeight = FontWeight.Bold,
                                textAlign = TextAlign.Center
                            )

                        }

                        Row {
                            Spacer(modifier = Modifier.weight(2f))
                            Text(
                                text = "Weight",
                                style = MaterialTheme.typography.titleLarge,
                                fontWeight = FontWeight.Bold,
                                textAlign = TextAlign.Center
                            )

                            Text(
                                text = " - ",
                                modifier = Modifier.padding(horizontal = 4.dp)
                            )

                            Text(
                                text = pokemon.weight.toString(),
                                fontWeight = FontWeight.Bold,
                                textAlign = TextAlign.Center
                            )



                         Spacer(modifier = Modifier.weight(1f))
                         IconButton(onClick = {
                            isFavoriteActive.value = !isFavoriteActive.value
                            if(isFavoriteActive.value) viewModel.favoritePokemon(Pokemon(name,url))
                            else viewModel.unfavoritePokemon(Pokemon(name,url))

                            }) {
                                Icon(
                                    imageVector = Icons.Default.Favorite,
                                    contentDescription = "favorite",
                                    tint = if (isFavoriteActive.value) Color.Red else Color.White
                                )
                            }

                        }

                    }

                }

                item {
                    Text(
                        text = "Base stats",
                        style = MaterialTheme.typography.titleMedium
                    )
                    Spacer(modifier = Modifier.height(15.dp))
                }
                items(pokemon.stats.size) { stats ->
                    BaseStatsItem(
                        stats = pokemon.stats[stats],
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(25.dp)
                    )
                    HorizontalDivider()
                }


            }

        }
    }

}

@Preview(showBackground = true)
@Composable
fun DetailScreenPreview() {
    DetailScreen(
        name = "Pikachu",
        url = "https://pokeapi.co/api/v2/pokemon/pikachu/"
    )
}