package com.elijahhezekiah.pokdexapp.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.elijahhezekiah.pokdexapp.domain.model.Pokemon

@Database(version = 1, entities = [Pokemon::class], exportSchema = false)
abstract class PokedexDatabase : RoomDatabase() {
     abstract fun getFavoritePokemonDao(): FavoritePokemonDao
}