package com.elijahhezekiah.pokdexapp.domain.model

import androidx.room.PrimaryKey
import androidx.room.Entity


@Entity(tableName = "pokemon")
data class Pokemon(
    @PrimaryKey(autoGenerate = false)
    val name: String,

    val url: String
)