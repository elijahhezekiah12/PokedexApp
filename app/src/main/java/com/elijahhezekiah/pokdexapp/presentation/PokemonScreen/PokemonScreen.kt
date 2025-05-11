package com.elijahhezekiah.pokdexapp.presentation.PokemonScreen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.elijahhezekiah.pokdexapp.presentation.navigation_tab.NavigationScreen
import com.elijahhezekiah.pokdexapp.presentation.navigation_tab.components.PokemonBottomAppBar


@Composable
fun PokemonScreen(

) {

    val navController = rememberNavController()

    Scaffold(

        bottomBar = {
            BottomAppBar(modifier = Modifier) {
                PokemonBottomAppBar(
                    navController = navController
                )
            }
        },
    ) { innerPadding ->
        Box(
            modifier = Modifier.padding(
                PaddingValues(
                    0.dp,
                    0.dp,
                    0.dp,
                    innerPadding.calculateBottomPadding()
                )
            )
        ) {
           NavigationScreen(navController = navController)
        }
    }


}