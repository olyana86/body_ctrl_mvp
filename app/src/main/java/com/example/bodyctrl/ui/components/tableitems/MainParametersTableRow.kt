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
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.bodyctrl.data.Parameters
import com.example.bodyctrl.ui.theme.BodyCTRLTheme
import kotlin.math.pow
import kotlin.math.sqrt

@Composable
fun MainParametersTableRow(
    parameters: Parameters
) {
    val convertedWeight = parameters.weight.toFloat() / 1000
    val tableWeight = "%.1f".format(convertedWeight)
    val convertedBmi = convertedWeight / (parameters.height.toDouble() / 100).pow(2)
    val tableBmi = "%.1f".format(convertedBmi)

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
                    .border(1.dp, color = MaterialTheme.colorScheme.secondaryContainer),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = parameters.type,
                    modifier = Modifier.padding(horizontal = 4.dp, vertical = 8.dp),
                    style = MaterialTheme.typography.bodyLarge
                )
            }
            Box(
                modifier = Modifier
                    .weight(0.15f)
                    .fillMaxHeight()
                    .border(1.dp, color = MaterialTheme.colorScheme.primaryContainer),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = tableWeight,
                    modifier = Modifier.padding(4.dp),
                    style = MaterialTheme.typography.bodyLarge,
                    fontWeight = FontWeight.Bold
                )
            }
            Box(
                modifier = Modifier
                    .weight(0.15f)
                    .fillMaxHeight()
                    .border(1.dp, color = MaterialTheme.colorScheme.primaryContainer),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = parameters.chest.toString(),
                    modifier = Modifier.padding(4.dp),
                    style = MaterialTheme.typography.bodyLarge,
                    fontWeight = FontWeight.Bold
                )
            }
            Box(
                modifier = Modifier
                    .weight(0.15f)
                    .fillMaxHeight()
                    .border(1.dp, color = MaterialTheme.colorScheme.primaryContainer),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = parameters.waist.toString(),
                    modifier = Modifier.padding(4.dp),
                    style = MaterialTheme.typography.bodyLarge,
                    fontWeight = FontWeight.Bold
                )
            }
            Box(
                modifier = Modifier
                    .weight(0.15f)
                    .fillMaxHeight()
                    .border(1.dp, color = MaterialTheme.colorScheme.primaryContainer),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = parameters.hip.toString(),
                    modifier = Modifier.padding(4.dp),
                    style = MaterialTheme.typography.bodyLarge,
                    fontWeight = FontWeight.Bold
                )
            }
            Box(
                modifier = Modifier
                    .weight(0.15f)
                    .fillMaxHeight()
                    .border(1.dp, color = MaterialTheme.colorScheme.primaryContainer),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = tableBmi,
                    modifier = Modifier.padding(4.dp),
                    style = MaterialTheme.typography.bodyLarge,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}

@Preview
@Composable
fun TableRowPreview() {
    BodyCTRLTheme {
        MainParametersTableRow(
            parameters = Parameters(1, "Сегодня", 160, 66200, 98, 80, 104)
        )
    }
}