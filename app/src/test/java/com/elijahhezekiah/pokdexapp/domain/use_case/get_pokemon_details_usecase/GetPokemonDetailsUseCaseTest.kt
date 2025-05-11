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

            assertThat(result[0]).isInstanceOf(Resource.Success::class.java)
            assertThat((result[0] as Resource.Success<PokemonDetails>).data?.name).isEqualTo(pokemonName)
        }
    }




}