package com.example.bodyctrl.ui.components.pickers

import androidx.compose.foundation.layout.Row

import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.RadioButton
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun ColorTagsList(
    currentTag: String,
    onSelect: (String) -> Unit
) {
    val tags = getActivityColors()

    FlowRow(
        modifier = Modifier.padding(bottom = 8.dp),
        horizontalArrangement = Arrangement.spacedBy(4.dp),
        verticalArrangement = Arrangement.spacedBy(2.dp)
    ) {
        ColorTag(
            tagColor = tags[0].hex,
            tagIsChecked = tags[0].hex == currentTag,
            onSelect = {
                onSelect(it)
            }
        )
        ColorTag(
            tagColor = tags[1].hex,
            tagIsChecked = tags[1].hex == currentTag,
            onSelect = {
                onSelect(it)
            }
        )
        ColorTag(
            tagColor = tags[2].hex,
            tagIsChecked = tags[2].hex == currentTag,
            onSelect = {
                onSelect(it)
            }
        )
        ColorTag(
            tagColor = tags[3].hex,
            tagIsChecked = tags[3].hex == currentTag,
            onSelect = {
                onSelect(it)
            }
        )
        ColorTag(
            tagColor = tags[4].hex,
            tagIsChecked = tags[4].hex == currentTag,
            onSelect = {
                onSelect(it)
            }
        )
        ColorTag(
            tagColor = tags[5].hex,
            tagIsChecked = tags[5].hex == currentTag,
            onSelect = {
                onSelect(it)
            }
        )
        ColorTag(
            tagColor = tags[6].hex,
            tagIsChecked = tags[6].hex == currentTag,
            onSelect = {
                onSelect(it)
            }
        )
        ColorTag(
            tagColor = tags[7].hex,
            tagIsChecked = tags[7].hex == currentTag,
            onSelect = {
                onSelect(it)
            }
        )
    }
}


@Composable
fun ColorTag(
    tagColor: String,
    tagIsChecked: Boolean,
    onSelect: (String) -> Unit
) {
    val itemColor = android.graphics.Color.parseColor(tagColor)

    Row {
        RadioButton(
            modifier = Modifier.align(Alignment.CenterVertically),
            selected = tagIsChecked,
            onClick = { onSelect(tagColor) }
        )
        Canvas(modifier = Modifier
            .size(28.dp)
            .align(Alignment.CenterVertically),
            onDraw = {
                drawRect(
                    color = Color(itemColor)
                )
            }
        )
    }
}