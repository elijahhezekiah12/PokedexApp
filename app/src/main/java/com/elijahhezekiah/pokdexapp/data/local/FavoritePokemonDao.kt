package com.elijahhezekiah.pokdexapp.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.elijahhezekiah.pokdexapp.domain.model.Pokemon



@Dao
interface FavoritePokemonDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(pokemon: Pokemon)

    @Query("select * from pokemon Where name =:name")
    suspend fun getPokemonById(name: String): Pokemon?

    @Query("DELETE FROM pokemon WHERE name =:name")
    suspend fun deletePokemonByName(name: String)

    @Query("SELECT * FROM pokemon")
    suspend fun getAllPokemon(): List<Pokemon?>
}
