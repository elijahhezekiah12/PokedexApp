package com.elijahhezekiah.pokdexapp.domain.use_case.get_pokemen_list_usecase

import com.elijahhezekiah.pokdexapp.common.Resource
import com.elijahhezekiah.pokdexapp.data.model.dto.PokemonData
import com.elijahhezekiah.pokdexapp.data.model.dto.Result
import com.elijahhezekiah.pokdexapp.domain.model.Pokemon
import com.elijahhezekiah.pokdexapp.domain.repository.PokemonRepository
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito
import org.mockito.Mockito.`when`
import retrofit2.HttpException
import java.io.IOException


class GetPokemonListUseCaseTest {

    private lateinit var getPokemonListUseCase: GetPokemonListUseCase
    private lateinit var pokemonRepository: PokemonRepository


    @Before
    fun setUp() {
        pokemonRepository = Mockito.mock(PokemonRepository::class.java)
        getPokemonListUseCase = GetPokemonListUseCase(pokemonRepository)
    }

    @Test
    fun `Successful retrieval of Pokemon list`() {
        // Test the happy path where the repository returns a list of Pokemon successfully. 
        // Verify that the flow emits Resource.Loading, then Resource.Success with the mapped Pokemon list.
        runBlocking {
            val pokemonData= listOf(
                Result(name = "bulbasaur", url = "https://pokeapi.co/api/v2/pokemon/1/"),
                Result(name = "ivysaur", url = "https://pokeapi.co/api/v2/pokemon/2/")
            )
            val expectedPokemonList = listOf(
                Pokemon(name = "bulbasaur", url = "https://pokeapi.co/api/v2/pokemon/1/"),
                Pokemon(name = "ivysaur", url = "https://pokeapi.co/api/v2/pokemon/2/")
            )
            val resultDto =  PokemonData(results = pokemonData)

            `when`(pokemonRepository.getPokemonList()).thenReturn(resultDto)

            val flowResult = getPokemonListUseCase().toList()

            assert(flowResult.size == 2)
            assert(flowResult[0] is Resource.Loading)
            assert(flowResult[1] is Resource.Success)
            val successResource = flowResult[1] as Resource.Success<List<Pokemon>>
            assert(successResource.data == expectedPokemonList)
        }
    }

    @Test
    fun `Empty Pokemon list from repository`() {
        // Test the case where the repository returns an empty list of Pokemon. 
        // Verify that the flow still emits Resource.Loading and then Resource.Success with an empty list.
        runBlocking {
            val expectedPokemonList = emptyList<Pokemon>()
            val resultDto =  PokemonData(results = emptyList())

            `when`(pokemonRepository.getPokemonList()).thenReturn(resultDto)

            val flowResult = getPokemonListUseCase().toList()

            assert(flowResult.size == 2)
            assert(flowResult[0] is Resource.Loading)
            assert(flowResult[1] is Resource.Success && (flowResult[1] as Resource.Success).data == expectedPokemonList)
        }
    }

    @Test
    fun `HttpException during repository call`() {
        // Test when the repository's getPokemonList() throws an HttpException. 
        // Verify that the flow emits Resource.Loading, then Resource.Error with the appropriate error message (localized message or a default message).
        runBlocking {
            val errorMessage = "HTTP 400 Response.error()"
            val httpException = HttpException(
                retrofit2.Response.error<Any>(
                    400,
                    okhttp3.ResponseBody.create(null, "")
                )
            )

            `when`(pokemonRepository.getPokemonList()).thenThrow(httpException)

            val flowResult = getPokemonListUseCase().toList()

            assert(flowResult.size == 2)
            assert(flowResult[0] is Resource.Loading)
            assert(flowResult[1] is Resource.Error && (flowResult[1] as Resource.Error).message == errorMessage)
        }
    }


    @Test
    fun `Other unexpected exception during repository call`() {
        // Test when the repository's getPokemonList() throws an unexpected exception other than HttpException or IOException. 
        // Verify that the flow still handles the exception gracefully (though the current code doesn't explicitly handle other exceptions, a robust test would ensure it doesn't crash).
        // TODO implement test
    }


    @Test
    fun `Repository returns null or unexpected data structure`() {
        // Although the signature suggests List<PokemonDto>, test if the repository unexpectedly returns null or a data structure that cannot be mapped, and how the .toPokemon() handles it.
        // TODO implement test
    }

    @Test
    fun `Multiple subscribers to the flow`() {
        // Test if the flow behaves correctly when multiple consumers subscribe to it. 
        // Since it's a flow built with 'flow { ... }', it should replay the emissions to each new collector.
        // TODO implement test
    }

}