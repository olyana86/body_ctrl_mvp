package com.example.bodyctrl.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.bodyctrl.data.Parameters
import com.example.bodyctrl.ui.viewmodels.ParametersViewModel
import com.example.bodyctrl.utils.getGramsRemain
import com.example.bodyctrl.utils.getKilogramsFromGrams

@Composable
fun ParametersScreen(navController: NavHostController) {

    val viewModel: ParametersViewModel = hiltViewModel()

    val parameters = viewModel.parameters.observeAsState(initial = emptyList())

    if (parameters.value.isNotEmpty()) {

        val height = remember { mutableIntStateOf(parameters.value.first().height) }

        val aimWeightKilograms =
            remember { mutableIntStateOf(getKilogramsFromGrams(parameters.value.first().weight)) }
        val aimWeightGrams = remember {
            mutableIntStateOf(
                getGramsRemain(
                    parameters.value.first().weight,
                    aimWeightKilograms.intValue
                )
            )
        }
        val aimChest = remember { mutableIntStateOf(parameters.value.first().chest) }
        val aimWaist = remember { mutableIntStateOf(parameters.value.first().waist) }
        val aimHip = remember { mutableIntStateOf(parameters.value.first().hip) }

        val currentWeightKilograms =
            remember { mutableIntStateOf(getKilogramsFromGrams(parameters.value.last().weight)) }
        val currentWeightGrams = remember {
            mutableIntStateOf(
                getGramsRemain(
                    parameters.value.last().weight,
                    currentWeightKilograms.intValue
                )
            )
        }
        val currentChest = remember { mutableIntStateOf(parameters.value.last().chest) }
        val currentWaist = remember { mutableIntStateOf(parameters.value.last().waist) }
        val currentHip = remember { mutableIntStateOf(parameters.value.last().hip) }


        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp)
                .verticalScroll(rememberScrollState())
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "Параметры: моя цель",
                    modifier = Modifier.padding(vertical = 8.dp),
                    style = MaterialTheme.typography.titleLarge,
                    textAlign = TextAlign.Center
                )
            }
            Box(modifier = Modifier.fillMaxWidth()) {
                Column {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(intrinsicSize = IntrinsicSize.Max)
                    ) {
                        Box(
                            modifier = Modifier
                                .weight(0.3f)
                                .fillMaxHeight()
                                .border(1.dp, color = MaterialTheme.colorScheme.secondaryContainer),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = "Вес",
                                modifier = Modifier.padding(4.dp),
                                style = MaterialTheme.typography.bodyLarge
                            )
                        }
                        Box(
                            modifier = Modifier
                                .weight(0.7f)
                                .fillMaxHeight()
                                .border(1.dp, color = MaterialTheme.colorScheme.secondaryContainer),
                            contentAlignment = Alignment.Center
                        ) {
                            Row {
                                OutlinedTextField(
                                    modifier = Modifier
                                        .weight(0.5f)
                                        .padding(4.dp),
                                    value = aimWeightKilograms.intValue.toString(),
                                    onValueChange = {
                                        aimWeightKilograms.intValue =
                                            if (it.isBlank()) 0 else it.toInt()
                                    },
                                    label = { Text(text = "кг") },
                                    singleLine = true
                                )
                                OutlinedTextField(
                                    modifier = Modifier
                                        .weight(0.5f)
                                        .padding(4.dp),
                                    value = aimWeightGrams.intValue.toString(),
                                    onValueChange = {
                                        aimWeightGrams.intValue =
                                            if (it.isBlank()) 0 else it.toInt()
                                    },
                                    label = { Text(text = "граммы") },
                                    singleLine = true
                                )
                            }
                        }
                    }
                    Spacer(modifier = Modifier.height(8.dp))
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(intrinsicSize = IntrinsicSize.Max)
                    ) {
                        Box(
                            modifier = Modifier
                                .weight(0.3f)
                                .fillMaxHeight()
                                .border(1.dp, color = MaterialTheme.colorScheme.secondaryContainer),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = "Объем груди",
                                modifier = Modifier.padding(4.dp),
                                style = MaterialTheme.typography.bodyLarge
                            )
                        }
                        Spacer(modifier = Modifier.width(8.dp))
                        Box(
                            modifier = Modifier
                                .weight(0.3f)
                                .fillMaxHeight()
                                .border(1.dp, color = MaterialTheme.colorScheme.secondaryContainer),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = "Объем талии",
                                modifier = Modifier.padding(4.dp),
                                style = MaterialTheme.typography.bodyLarge
                            )
                        }
                        Spacer(modifier = Modifier.width(8.dp))
                        Box(
                            modifier = Modifier
                                .weight(0.3f)
                                .fillMaxHeight()
                                .border(1.dp, color = MaterialTheme.colorScheme.secondaryContainer),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = "Объем бедер",
                                modifier = Modifier.padding(4.dp),
                                style = MaterialTheme.typography.bodyLarge
                            )
                        }
                    }

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(intrinsicSize = IntrinsicSize.Max)
                    ) {
                        Box(
                            modifier = Modifier
                                .weight(0.3f)
                                .fillMaxHeight()
                                .border(1.dp, color = MaterialTheme.colorScheme.secondaryContainer),
                            contentAlignment = Alignment.Center
                        ) {
                            Row {
                                OutlinedTextField(
                                    modifier = Modifier.padding(4.dp),
                                    value = aimChest.intValue.toString(),
                                    onValueChange = {
                                        aimChest.intValue = if (it.isBlank()) 0 else it.toInt()
                                    },
                                    label = { Text(text = "см") },
                                    singleLine = true
                                )
                            }
                        }
                        Spacer(modifier = Modifier.width(8.dp))
                        Box(
                            modifier = Modifier
                                .weight(0.3f)
                                .fillMaxHeight()
                                .border(1.dp, color = MaterialTheme.colorScheme.secondaryContainer),
                            contentAlignment = Alignment.Center
                        ) {
                            Row {
                                OutlinedTextField(
                                    modifier = Modifier.padding(4.dp),
                                    value = aimWaist.intValue.toString(),
                                    onValueChange = {
                                        aimWaist.intValue = if (it.isBlank()) 0 else it.toInt()
                                    },
                                    label = { Text(text = "см") },
                                    singleLine = true
                                )
                            }
                        }
                        Spacer(modifier = Modifier.width(8.dp))
                        Box(
                            modifier = Modifier
                                .weight(0.3f)
                                .fillMaxHeight()
                                .border(1.dp, color = MaterialTheme.colorScheme.secondaryContainer),
                            contentAlignment = Alignment.Center
                        ) {
                            Row {
                                OutlinedTextField(
                                    modifier = Modifier.padding(4.dp),
                                    value = aimHip.intValue.toString(),
                                    onValueChange = {
                                        aimHip.intValue = if (it.isBlank()) 0 else it.toInt()
                                    },
                                    label = { Text(text = "см") },
                                    singleLine = true
                                )
                            }
                        }
                    }
                }
            }
            Spacer(modifier = Modifier.height(8.dp))
            Box(modifier = Modifier.fillMaxWidth()) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    OutlinedTextField(
                        modifier = Modifier
                            .padding(4.dp)
                            .weight(0.5f),
                        value = height.intValue.toString(),
                        onValueChange = { height.intValue = if (it.isBlank()) 0 else it.toInt() },
                        label = { Text(text = "Мой рост, сантиметры") },
                        singleLine = true
                    )
                    Spacer(modifier = Modifier.width(16.dp))
                    Button(onClick = {
                        val parametersAim = Parameters(
                            id = 1,
                            type = parameters.value.first().type,
                            height = height.intValue,
                            weight = aimWeightKilograms.intValue * 1000 + aimWeightGrams.intValue,
                            chest = aimChest.intValue,
                            waist = aimWaist.intValue,
                            hip = aimHip.intValue
                        )
                        viewModel.updateParameters(parametersAim)
                        navController.navigate("Main")
                    }) {
                        Text(text = "Сохранить")
                    }
                }
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "Параметры: сейчас",
                    modifier = Modifier.padding(vertical = 8.dp),
                    style = MaterialTheme.typography.titleLarge,
                    color = MaterialTheme.colorScheme.primary,
                    textAlign = TextAlign.Center
                )
            }
            Box(modifier = Modifier.fillMaxWidth()) {
                Column {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(intrinsicSize = IntrinsicSize.Max)
                    ) {
                        Box(
                            modifier = Modifier
                                .weight(0.3f)
                                .fillMaxHeight()
                                .border(1.dp, color = MaterialTheme.colorScheme.primaryContainer)
                                .background(MaterialTheme.colorScheme.secondaryContainer),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = "Вес",
                                modifier = Modifier.padding(4.dp),
                                style = MaterialTheme.typography.bodyLarge
                            )
                        }
                        Box(
                            modifier = Modifier
                                .weight(0.7f)
                                .fillMaxHeight()
                                .border(1.dp, color = MaterialTheme.colorScheme.primaryContainer)
                                .background(MaterialTheme.colorScheme.secondaryContainer),
                            contentAlignment = Alignment.Center
                        ) {
                            Row {
                                OutlinedTextField(
                                    modifier = Modifier
                                        .weight(0.5f)
                                        .padding(4.dp),
                                    value = currentWeightKilograms.intValue.toString(),
                                    onValueChange = {
                                        currentWeightKilograms.intValue =
                                            if (it.isBlank()) 0 else it.toInt()
                                    },
                                    label = { Text(text = "кг") },
                                    singleLine = true
                                )
                                OutlinedTextField(
                                    modifier = Modifier
                                        .weight(0.5f)
                                        .padding(4.dp),
                                    value = currentWeightGrams.intValue.toString(),
                                    onValueChange = {
                                        currentWeightGrams.intValue =
                                            if (it.isBlank()) 0 else it.toInt()
                                    },
                                    label = { Text(text = "граммы") },
                                    singleLine = true
                                )
                            }
                        }
                    }
                    Spacer(modifier = Modifier.height(8.dp))
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(intrinsicSize = IntrinsicSize.Max)
                    ) {
                        Box(
                            modifier = Modifier
                                .weight(0.3f)
                                .fillMaxHeight()
                                .border(1.dp, color = MaterialTheme.colorScheme.primaryContainer)
                                .background(MaterialTheme.colorScheme.secondaryContainer),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = "Объем груди",
                                modifier = Modifier.padding(4.dp),
                                style = MaterialTheme.typography.bodyLarge
                            )
                        }
                        Spacer(modifier = Modifier.width(8.dp))
                        Box(
                            modifier = Modifier
                                .weight(0.3f)
                                .fillMaxHeight()
                                .border(1.dp, color = MaterialTheme.colorScheme.primaryContainer)
                                .background(MaterialTheme.colorScheme.secondaryContainer),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = "Объем талии",
                                modifier = Modifier.padding(4.dp),
                                style = MaterialTheme.typography.bodyLarge
                            )
                        }
                        Spacer(modifier = Modifier.width(8.dp))
                        Box(
                            modifier = Modifier
                                .weight(0.3f)
                                .fillMaxHeight()
                                .border(1.dp, color = MaterialTheme.colorScheme.primaryContainer)
                                .background(MaterialTheme.colorScheme.secondaryContainer),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = "Объем бедер",
                                modifier = Modifier.padding(4.dp),
                                style = MaterialTheme.typography.bodyLarge
                            )
                        }
                    }

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(intrinsicSize = IntrinsicSize.Max)
                    ) {
                        Box(
                            modifier = Modifier
                                .weight(0.3f)
                                .fillMaxHeight()
                                .border(1.dp, color = MaterialTheme.colorScheme.primaryContainer)
                                .background(MaterialTheme.colorScheme.secondaryContainer),
                            contentAlignment = Alignment.Center
                        ) {
                            Row {
                                OutlinedTextField(
                                    modifier = Modifier
                                        .weight(0.5f)
                                        .padding(4.dp),
                                    value = currentChest.intValue.toString(),
                                    onValueChange = {
                                        currentChest.intValue = if (it.isBlank()) 0 else it.toInt()
                                    },
                                    label = { Text(text = "см") },
                                    singleLine = true
                                )
                            }
                        }
                        Spacer(modifier = Modifier.width(8.dp))
                        Box(
                            modifier = Modifier
                                .weight(0.3f)
                                .fillMaxHeight()
                                .border(1.dp, color = MaterialTheme.colorScheme.primaryContainer)
                                .background(MaterialTheme.colorScheme.secondaryContainer),
                            contentAlignment = Alignment.Center
                        ) {
                            Row {
                                OutlinedTextField(
                                    modifier = Modifier.padding(4.dp),
                                    value = currentWaist.intValue.toString(),
                                    onValueChange = {
                                        currentWaist.intValue = if (it.isBlank()) 0 else it.toInt()
                                    },
                                    label = { Text(text = "см") },
                                    singleLine = true
                                )
                            }
                        }
                        Spacer(modifier = Modifier.width(8.dp))
                        Box(
                            modifier = Modifier
                                .weight(0.3f)
                                .fillMaxHeight()
                                .border(1.dp, color = MaterialTheme.colorScheme.primaryContainer)
                                .background(MaterialTheme.colorScheme.secondaryContainer),
                            contentAlignment = Alignment.Center
                        ) {
                            Row {
                                OutlinedTextField(
                                    modifier = Modifier.padding(4.dp),
                                    value = currentHip.intValue.toString(),
                                    onValueChange = {
                                        currentHip.intValue = if (it.isBlank()) 0 else it.toInt()
                                    },
                                    label = { Text(text = "см") },
                                    singleLine = true
                                )
                            }
                        }
                    }
                }
            }
            Spacer(modifier = Modifier.height(8.dp))
            Box(modifier = Modifier.fillMaxWidth()) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    Button(onClick = { navController.popBackStack() }) {
                        Text(text = "Отмена")
                    }
                    Button(onClick = {
                        val parametersCurrent = Parameters(
                            id = 2,
                            type = parameters.value.last().type,
                            height = height.intValue,
                            weight = currentWeightKilograms.intValue * 1000 + currentWeightGrams.intValue,
                            chest = currentChest.intValue,
                            waist = currentWaist.intValue,
                            hip = currentHip.intValue
                        )
                        viewModel.updateParameters(parametersCurrent)
                        navController.navigate("Main")
                    }) {
                        Text(text = "Сохранить")
                    }
                }
            }
        }
    }
}