package com.example.bodyctrl.ui.components.listitems

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.core.graphics.toColorInt

@Composable
fun MainDayActivityItem(
    itemTitle: String,
    itemDetails: String,
    itemColor: String,
    itemIsChecked: Boolean,
    onCheckedChange: (Boolean) -> Unit,
    onDetailsClick: (Boolean) -> Unit
) {
    val checkedState = remember { mutableStateOf(itemIsChecked) }

    val color = Color(itemColor.toColorInt())

    val title = if (itemTitle.length <= 26) {
        itemTitle
    } else {
        itemTitle.substring(0, 26)
    }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 2.dp)
            .background(color.copy(0.5f), shape = RoundedCornerShape(8.dp))
            .border(
                2.dp,
                color = color,
                shape = RoundedCornerShape(8.dp)
            )
    ) {
        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            Checkbox(
                checked = checkedState.value,
                onCheckedChange = {
                    checkedState.value = it
                    onCheckedChange(it)
                },
                modifier = Modifier.align(Alignment.CenterVertically)
            )
            Spacer(modifier = Modifier.width(16.dp))
            Text(
                text = title, modifier = Modifier.align(Alignment.CenterVertically),
                style = MaterialTheme.typography.titleMedium
            )
            if (itemDetails != "") {
                Spacer(modifier = Modifier.weight(1f))
                IconButton(
                    onClick = { onDetailsClick(true) },
                    modifier = Modifier.align(Alignment.CenterVertically)
                ) {
                    Icon(Icons.Outlined.Info, contentDescription = "Details")
                }
            }
        }
    }
}