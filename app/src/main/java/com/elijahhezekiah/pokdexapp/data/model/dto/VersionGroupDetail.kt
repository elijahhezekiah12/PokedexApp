package com.elijahhezekiah.pokdexapp.data.model.dto

data class VersionGroupDetail(
    val level_learned_at: Int,
    val move_learn_method: MoveLearnMethod,
    val order: Int?,
    val version_group: VersionGroup
)