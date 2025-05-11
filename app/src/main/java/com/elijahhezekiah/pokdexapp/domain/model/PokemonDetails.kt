package com.elijahhezekiah.pokdexapp.domain.model

import com.elijahhezekiah.pokdexapp.data.model.dto.Sprites
import com.elijahhezekiah.pokdexapp.data.model.dto.Stat

data class PokemonDetails(
    val name: String,
    val sprites: Sprites?,
    val height: Int,
    val weight: Int,
    val stats: List<Stat>
)