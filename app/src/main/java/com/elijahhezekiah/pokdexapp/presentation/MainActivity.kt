package com.elijahhezekiah.pokdexapp.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.elijahhezekiah.pokdexapp.PokemonListRoute
import com.elijahhezekiah.pokdexapp.PokemonRoute
import com.elijahhezekiah.pokdexapp.presentation.pokemon_details.DetailScreen
import com.elijahhezekiah.pokdexapp.presentation.pokemon_list.MainScreen
import com.elijahhezekiah.pokdexapp.presentation.theme.PokédexAppTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.serialization.Serializable

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

        PokédexAppTheme {

            Surface(color = MaterialTheme.colorScheme.background)
            {
                val navController = rememberNavController()

                enableEdgeToEdge(
                    statusBarStyle = SystemBarStyle.dark(
                        android.graphics.Color.TRANSPARENT
                    )
                )
                NavHost(
                    navController = navController,
                    startDestination = PokemonListRoute,
                    modifier = Modifier.fillMaxSize()
                ) {
                    composable<PokemonListRoute> {
                        MainScreen(
                            onPokemonClick = {name,url ->
                                navController.navigate(PokemonRoute(name,url))
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

                }

            }
        }

     }
    }
}



@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    PokédexAppTheme {
        Greeting("Android")
    }
}