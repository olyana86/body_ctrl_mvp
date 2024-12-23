package com.example.bodyctrl.ui.components.tableitems

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.bodyctrl.ui.theme.BodyCTRLTheme

@Composable
fun MainParametersTableTitle() {
    Box(modifier = Modifier.fillMaxWidth()) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(intrinsicSize = IntrinsicSize.Max)
        ) {
            Box(
                modifier = Modifier
                    .weight(0.25f)
                    .fillMaxHeight()
                    .border(1.dp, color = MaterialTheme.colorScheme.primaryContainer)
                    .background(MaterialTheme.colorScheme.secondaryContainer),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "Параметры",
                    modifier = Modifier.padding(4.dp),
                    style = MaterialTheme.typography.bodyMedium
                )
            }
            Box(
                modifier = Modifier
                    .weight(0.15f)
                    .fillMaxHeight()
                    .border(1.dp, color = MaterialTheme.colorScheme.primaryContainer)
                    .background(MaterialTheme.colorScheme.secondaryContainer),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "Вес, кг",
                    modifier = Modifier.padding(4.dp),
                    style = MaterialTheme.typography.bodyMedium
                )
            }
            Box(
                modifier = Modifier
                    .weight(0.15f)
                    .fillMaxHeight()
                    .border(1.dp, color = MaterialTheme.colorScheme.primaryContainer)
                    .background(MaterialTheme.colorScheme.secondaryContainer),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "Объем груди",
                    modifier = Modifier.padding(4.dp),
                    style = MaterialTheme.typography.bodyMedium
                )
            }
            Box(
                modifier = Modifier
                    .weight(0.15f)
                    .fillMaxHeight()
                    .border(1.dp, color = MaterialTheme.colorScheme.primaryContainer)
                    .background(MaterialTheme.colorScheme.secondaryContainer),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "Объем талии",
                    modifier = Modifier.padding(4.dp),
                    style = MaterialTheme.typography.bodyMedium
                )
            }
            Box(
                modifier = Modifier
                    .weight(0.15f)
                    .fillMaxHeight()
                    .border(1.dp, color = MaterialTheme.colorScheme.primaryContainer)
                    .background(MaterialTheme.colorScheme.secondaryContainer),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "Объем бедер",
                    modifier = Modifier.padding(4.dp),
                    style = MaterialTheme.typography.bodyMedium
                )
            }
            Box(
                modifier = Modifier
                    .weight(0.15f)
                    .fillMaxHeight()
                    .border(1.dp, color = MaterialTheme.colorScheme.primaryContainer)
                    .background(MaterialTheme.colorScheme.secondaryContainer),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "ИМТ",
                    modifier = Modifier.padding(4.dp),
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }
    }
}

@Preview
@Composable
fun TablePreview() {
    BodyCTRLTheme {
        MainParametersTableTitle()
    }
}