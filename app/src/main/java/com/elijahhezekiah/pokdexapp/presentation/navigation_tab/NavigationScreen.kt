package com.elijahhezekiah.pokdexapp.presentation.navigation_tab

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import com.elijahhezekiah.pokdexapp.PokemonRoute
import com.elijahhezekiah.pokdexapp.Route.FavoriteRoute
import com.elijahhezekiah.pokdexapp.Route.PokemonListRoute
import com.elijahhezekiah.pokdexapp.presentation.FavoriteView.FavoriteScreen
import com.elijahhezekiah.pokdexapp.presentation.pokemon_details.DetailScreen
import com.elijahhezekiah.pokdexapp.presentation.pokemon_list.MainScreen


@Composable
fun NavigationScreen(navController: NavHostController) {

    NavHost(
        navController = navController,
        startDestination = PokemonListRoute,
        modifier = Modifier.fillMaxSize()
    ) {

        composable<PokemonListRoute> {
            MainScreen(
                onPokemonClick = { name, url ->
                    navController.navigate(PokemonRoute(name, url))
                }
            )
        }


      composable<PokemonRoute> {
            val args = it.toRoute<PokemonRoute>()

            DetailScreen(
                name = args.name,
                url = args.url
            )
        }

        composable<FavoriteRoute> {
            FavoriteScreen()
        }

    }
}