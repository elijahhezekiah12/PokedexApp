package com.elijahhezekiah.pokdexapp.domain.use_case.get_pokemen_list_usecase

import android.util.Log
import com.elijahhezekiah.pokdexapp.common.Resource
import com.elijahhezekiah.pokdexapp.data.model.Mappers.toPokemon
import com.elijahhezekiah.pokdexapp.domain.model.Pokemon
import com.elijahhezekiah.pokdexapp.domain.repository.PokemonRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetPokemonListUseCase @Inject constructor(
    private val repository: PokemonRepository
) {
    operator fun invoke(): Flow<Resource<List<Pokemon>>>  = flow {
        try {
            emit(Resource.Loading())

            val pokemonList = repository.getPokemonList().toPokemon()
            emit(Resource.Success(pokemonList))

           // Log.d("This are the list of pokemon", "Pokemon List: $pokemonList")

        } catch (e: HttpException) {
            emit(Resource.Error<List<Pokemon>>(e.localizedMessage ?: "HTTP 400 Response.error"))
        } catch (e: IOException) {
            emit(Resource.Error<List<Pokemon>>("Couldn't reach server. Check your internet connection."))
        }
    }
}