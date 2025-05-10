package com.elijahhezekiah.pokdexapp.di

import com.elijahhezekiah.pokdexapp.common.Constants
import com.elijahhezekiah.pokdexapp.data.remote.PokeApi
import com.elijahhezekiah.pokdexapp.data.remote.repository.PokemonRepositoryImpl
import com.elijahhezekiah.pokdexapp.domain.repository.PokemonRepository
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object PokemonModule {

    @Provides
    @Singleton
    fun provideMoshi(): Moshi =
        Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()


    @Provides
    @Singleton
    fun providePokemonApi(moshi: Moshi): PokeApi =
        Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()
            .create(PokeApi::class.java)


    @Singleton
    @Provides
    fun providePokemonRepository(api: PokeApi) : PokemonRepository{
        return PokemonRepositoryImpl(api)

    }


}