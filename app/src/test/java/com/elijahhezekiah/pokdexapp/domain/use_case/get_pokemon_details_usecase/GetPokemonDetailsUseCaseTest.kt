package com.elijahhezekiah.pokdexapp.domain.use_case.get_pokemon_details_usecase

import com.elijahhezekiah.pokdexapp.common.Resource
import com.elijahhezekiah.pokdexapp.data.FakePokemonRepository
import com.elijahhezekiah.pokdexapp.domain.model.PokemonDetails
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class GetPokemonDetailsUseCaseTest {

    private lateinit var getPokemonDetailsUseCase: GetPokemonDetailsUseCase
    private lateinit var fakePokemonRepository: FakePokemonRepository

    @Before
    fun setUp() {
        fakePokemonRepository = FakePokemonRepository()
        getPokemonDetailsUseCase = GetPokemonDetailsUseCase(fakePokemonRepository)
    }

    @Test
    fun `Successful retrieval of Pokemon details`() {
        // Test that the use case emits Resource.Success with the correctly mapped PokemonDetails 
        // when the repository call is successful.
        runBlocking {
            val pokemonName = "Bulbasaur"
            fakePokemonRepository.getPokemonInfo(pokemonName)
            val result = getPokemonDetailsUseCase(pokemonName).toList()

            assertThat(result[0]).isInstanceOf(Resource.Loading::class.java)
            assertThat(result[1]).isInstanceOf(Resource.Success::class.java)
            assertThat((result[1] as Resource.Success<PokemonDetails>).data?.name).isEqualTo(pokemonName)
        }
    }

    @Test
    fun `HttpException with localized message`() {
        // Test that the use case emits Resource.Error with the localized message from a 
        // HttpException when the repository call throws an HttpException with a localized message.
        // TODO implement test
    }


    @Test
    fun `Empty pokemonName string`() {
        // Test the behavior when an empty string is provided as the pokemonName. 
        // Depending on the repository's implementation, this might result in an error or a specific behavior.
        // TODO implement test
    }





    @Test
    fun `Non existent pokemon name`() {
        // Test that the use case correctly handles the scenario where the repository 
        // is called with a pokemon name that does not exist, likely resulting in an HttpException.
        // TODO implement test
    }

}