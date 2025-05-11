package com.elijahhezekiah.pokdexapp.presentation.navigation_tab.components

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.navigation.NavController
import com.elijahhezekiah.pokdexapp.Route
import kotlinx.coroutines.flow.map


@Composable
fun PokemonBottomAppBar (
    navController: NavController
){
    val currentRoute = navController.currentBackStackEntryFlow.map {backStackEntry ->
        backStackEntry.destination.route
    }.collectAsState(initial = Route.PokemonListRoute)

    val items = listOf(
        BottomTab.Main,
        BottomTab.Favorite
    )

    var selectedItem by remember { mutableIntStateOf(0) }

    items.forEachIndexed { index,navigatioItem ->

        if (navigatioItem.rootRoute == currentRoute.value){
            selectedItem = index
        }

    }

    NavigationBar {

        items.forEachIndexed { index, bottomTab ->

            NavigationBarItem(
                alwaysShowLabel = true,
                icon = { Icon(bottomTab.icon!!, contentDescription = bottomTab.title) },
                label = { Text(bottomTab.title) },
                selected = selectedItem == index,
                onClick = {
                    selectedItem = index
                    navController.navigate(bottomTab.rootRoute) {
                        navController.graph.startDestinationRoute?.let { route ->
                            popUpTo(route) {
                                saveState = true
                            }
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )


        }
    }

}