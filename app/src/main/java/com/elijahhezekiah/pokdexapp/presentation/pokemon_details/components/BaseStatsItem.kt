package com.elijahhezekiah.pokdexapp.presentation.pokemon_details.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import com.elijahhezekiah.pokdexapp.data.model.dto.Stat


@Composable
fun  BaseStatsItem (
    stats: Stat,
    modifier: Modifier = Modifier
){
    Column(
        modifier = modifier
    ) {

        Text(
            text = stats.stat.name,
            style = MaterialTheme.typography.titleMedium
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = stats.base_stat.toString(),
            style = MaterialTheme.typography.bodyMedium,
            fontStyle = FontStyle.Italic
        )

    }
}