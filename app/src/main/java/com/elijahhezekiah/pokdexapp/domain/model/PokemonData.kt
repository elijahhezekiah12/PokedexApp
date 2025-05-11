package com.elijahhezekiah.pokdexapp.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "pokemon")
data class Pokemon(

    @PrimaryKey(autoGenerate = false)
    val name: String,

    val url: String
)