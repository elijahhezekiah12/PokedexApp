package com.elijahhezekiah.pokdexapp.presentation.navigation_tab.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Favorite
import androidx.compose.material.icons.rounded.Home
import androidx.compose.ui.graphics.vector.ImageVector
import com.elijahhezekiah.pokdexapp.Route

sealed class BottomTab(val  title: String, val icon: ImageVector?, val rootRoute: Route) {
    data object Main : BottomTab("Main", Icons.Rounded.Home, Route.PokemonListRoute)
    data object Favorite : BottomTab("Favorite", Icons.Rounded.Favorite, Route.FavoriteRoute)

}