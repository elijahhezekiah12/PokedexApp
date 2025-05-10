package com.elijahhezekiah.pokdexapp.domain.use_case.get_pokemon_details_usecase

import com.elijahhezekiah.pokdexapp.common.Resource
import com.elijahhezekiah.pokdexapp.data.model.Mappers.toPokemonDetails
import com.elijahhezekiah.pokdexapp.domain.model.PokemonDetails
import com.elijahhezekiah.pokdexapp.domain.repository.PokemonRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetPokemonDetailsUseCase @Inject constructor(
    private val repository: PokemonRepository
) {
    operator fun invoke(pokemonName: String)  : Flow<Resource<PokemonDetails>> = flow {
        try {
            val pokemonDetails = repository.getPokemonInfo(pokemonName).toPokemonDetails()
            emit(Resource.Success(pokemonDetails))
        } catch(e: HttpException) {
            emit(Resource.Error<PokemonDetails>(e.localizedMessage ?: "An unexpected error occured"))
        } catch(_: IOException) {
            emit(Resource.Error<PokemonDetails>("Couldn't reach server. Check your internet connection."))
        }
    }

}