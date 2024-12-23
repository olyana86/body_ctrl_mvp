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
import com.example.bodyctrl.data.DayTrackers
import com.example.bodyctrl.ui.viewmodels.DayTrackersViewModel
import com.example.bodyctrl.utils.getHoursFromMinutes
import com.example.bodyctrl.utils.getLitersFromMilliliters
import com.example.bodyctrl.utils.getMillilitersRemain
import com.example.bodyctrl.utils.getMinutesRemain

@Composable
fun DayTrackersScreen(navController: NavHostController) {

    val viewModel: DayTrackersViewModel = hiltViewModel()

    val dayTrackers = viewModel.dayTrackers.observeAsState(initial = emptyList())

    if (dayTrackers.value.isNotEmpty()) {

        val aimSleepHours =
            remember { mutableIntStateOf(getHoursFromMinutes(dayTrackers.value.first().sleep)) }
        val aimSleepMinutes = remember {
            mutableIntStateOf(
                getMinutesRemain(
                    dayTrackers.value.first().sleep,
                    aimSleepHours.intValue
                )
            )
        }
        val aimWaterLiters =
            remember { mutableIntStateOf(getLitersFromMilliliters(dayTrackers.value.first().water)) }
        val aimWaterMilliliters = remember {
            mutableIntStateOf(
                getMillilitersRemain(
                    dayTrackers.value.first().water,
                    aimWaterLiters.intValue
                )
            )
        }
        val aimCalories = remember { mutableIntStateOf(dayTrackers.value.first().calories) }

        val currentSleepHours =
            remember { mutableIntStateOf(getHoursFromMinutes(dayTrackers.value.last().sleep)) }
        val currentSleepMinutes = remember {
            mutableIntStateOf(
                getMinutesRemain(
                    dayTrackers.value.last().sleep,
                    currentSleepHours.intValue
                )
            )
        }
        val currentWaterLiters =
            remember { mutableIntStateOf(getLitersFromMilliliters(dayTrackers.value.last().water)) }
        val currentWaterMilliliters = remember {
            mutableIntStateOf(
                getMillilitersRemain(
                    dayTrackers.value.last().water,
                    currentWaterLiters.intValue
                )
            )
        }
        val currentCalories = remember { mutableIntStateOf(dayTrackers.value.last().calories) }



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
                    text = "Трекеры дня: цель на день",
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
                                .weight(0.5f)
                                .fillMaxHeight()
                                .border(1.dp, color = MaterialTheme.colorScheme.primaryContainer),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = "Трекер сна",
                                modifier = Modifier.padding(4.dp),
                                style = MaterialTheme.typography.bodyLarge
                            )
                        }
                        Box(
                            modifier = Modifier
                                .weight(0.5f)
                                .fillMaxHeight()
                                .border(1.dp, color = MaterialTheme.colorScheme.primaryContainer),
                            contentAlignment = Alignment.Center
                        ) {
                            Row {
                                OutlinedTextField(
                                    modifier = Modifier
                                        .weight(0.5f)
                                        .padding(4.dp),
                                    value = aimSleepHours.intValue.toString(),
                                    onValueChange = {
                                        aimSleepHours.intValue = if (it.isBlank()) 0 else it.toInt()
                                    },
                                    label = { Text(text = "часы") },
                                    singleLine = true
                                )
                                OutlinedTextField(
                                    modifier = Modifier
                                        .weight(0.5f)
                                        .padding(4.dp),
                                    value = aimSleepMinutes.intValue.toString(),
                                    onValueChange = {
                                        aimSleepMinutes.intValue =
                                            if (it.isBlank()) 0 else it.toInt()
                                    },
                                    label = { Text(text = "минуты") },
                                    singleLine = true
                                )
                            }
                        }
                    }

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(intrinsicSize = IntrinsicSize.Max)
                    ) {
                        Box(
                            modifier = Modifier
                                .weight(0.5f)
                                .fillMaxHeight()
                                .border(1.dp, color = MaterialTheme.colorScheme.primaryContainer),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = "Трекер воды",
                                modifier = Modifier.padding(4.dp),
                                style = MaterialTheme.typography.bodyLarge
                            )
                        }
                        Box(
                            modifier = Modifier
                                .weight(0.5f)
                                .fillMaxHeight()
                                .border(1.dp, color = MaterialTheme.colorScheme.primaryContainer),
                            contentAlignment = Alignment.Center
                        ) {
                            Row {
                                OutlinedTextField(
                                    modifier = Modifier
                                        .weight(0.5f)
                                        .padding(4.dp),
                                    value = aimWaterLiters.intValue.toString(),
                                    onValueChange = {
                                        aimWaterLiters.intValue =
                                            if (it.isBlank()) 0 else it.toInt()
                                    },
                                    label = { Text(text = "литры") },
                                    singleLine = true
                                )
                                OutlinedTextField(
                                    modifier = Modifier
                                        .weight(0.5f)
                                        .padding(4.dp),
                                    value = aimWaterMilliliters.intValue.toString(),
                                    onValueChange = {
                                        aimWaterMilliliters.intValue =
                                            if (it.isBlank()) 0 else it.toInt()
                                    },
                                    label = { Text(text = "мл") },
                                    singleLine = true
                                )
                            }
                        }
                    }
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(intrinsicSize = IntrinsicSize.Max)
                    ) {
                        Box(
                            modifier = Modifier
                                .weight(0.5f)
                                .fillMaxHeight()
                                .border(1.dp, color = MaterialTheme.colorScheme.primaryContainer),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = "Трекер калорий",
                                modifier = Modifier.padding(4.dp),
                                style = MaterialTheme.typography.bodyLarge
                            )
                        }
                        Box(
                            modifier = Modifier
                                .weight(0.5f)
                                .fillMaxHeight()
                                .border(1.dp, color = MaterialTheme.colorScheme.primaryContainer),
                            contentAlignment = Alignment.Center
                        ) {
                            Row {
                                OutlinedTextField(
                                    modifier = Modifier.padding(4.dp),
                                    value = aimCalories.intValue.toString(),
                                    onValueChange = {
                                        aimCalories.intValue = if (it.isBlank()) 0 else it.toInt()
                                    },
                                    label = { Text(text = "калории") },
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
                    horizontalArrangement = Arrangement.End
                ) {
                    Button(onClick = {
                        val dayTrackersAim = DayTrackers(
                            id = 1,
                            type = dayTrackers.value.first().type,
                            sleep = aimSleepHours.intValue * 60 + aimSleepMinutes.intValue,
                            water = aimWaterLiters.intValue * 1000 + aimWaterMilliliters.intValue,
                            calories = aimCalories.intValue
                        )
                        viewModel.updateDayTrackers(dayTrackersAim)
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
                    text = "Трекеры дня: сейчас",
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
                                .weight(0.5f)
                                .fillMaxHeight()
                                .border(1.dp, color = MaterialTheme.colorScheme.primaryContainer)
                                .background(MaterialTheme.colorScheme.secondaryContainer),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = "Трекер сна",
                                modifier = Modifier.padding(4.dp),
                                style = MaterialTheme.typography.bodyLarge
                            )
                        }
                        Box(
                            modifier = Modifier
                                .weight(0.5f)
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
                                    value = currentSleepHours.intValue.toString(),
                                    onValueChange = {
                                        currentSleepHours.intValue =
                                            if (it.isBlank()) 0 else it.toInt()
                                    },
                                    label = { Text(text = "часы") },
                                    singleLine = true
                                )
                                OutlinedTextField(
                                    modifier = Modifier
                                        .weight(0.5f)
                                        .padding(4.dp),
                                    value = currentSleepMinutes.intValue.toString(),
                                    onValueChange = {
                                        currentSleepMinutes.intValue =
                                            if (it.isBlank()) 0 else it.toInt()
                                    },
                                    label = { Text(text = "минуты") },
                                    singleLine = true
                                )
                            }
                        }
                    }

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(intrinsicSize = IntrinsicSize.Max)
                    ) {
                        Box(
                            modifier = Modifier
                                .weight(0.5f)
                                .fillMaxHeight()
                                .border(1.dp, color = MaterialTheme.colorScheme.primaryContainer)
                                .background(MaterialTheme.colorScheme.secondaryContainer),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = "Трекер воды",
                                modifier = Modifier.padding(4.dp),
                                style = MaterialTheme.typography.bodyLarge
                            )
                        }
                        Box(
                            modifier = Modifier
                                .weight(0.5f)
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
                                    value = currentWaterLiters.intValue.toString(),
                                    onValueChange = {
                                        currentWaterLiters.intValue =
                                            if (it.isBlank()) 0 else it.toInt()
                                    },
                                    label = { Text(text = "литры") },
                                    singleLine = true
                                )
                                OutlinedTextField(
                                    modifier = Modifier
                                        .weight(0.5f)
                                        .padding(4.dp),
                                    value = currentWaterMilliliters.intValue.toString(),
                                    onValueChange = {
                                        currentWaterMilliliters.intValue =
                                            if (it.isBlank()) 0 else it.toInt()
                                    },
                                    label = { Text(text = "мл") },
                                    singleLine = true
                                )
                            }
                        }
                    }
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(intrinsicSize = IntrinsicSize.Max)
                    ) {
                        Box(
                            modifier = Modifier
                                .weight(0.5f)
                                .fillMaxHeight()
                                .border(1.dp, color = MaterialTheme.colorScheme.primaryContainer)
                                .background(MaterialTheme.colorScheme.secondaryContainer),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = "Трекер калорий",
                                modifier = Modifier.padding(4.dp),
                                style = MaterialTheme.typography.bodyLarge
                            )
                        }
                        Box(
                            modifier = Modifier
                                .weight(0.5f)
                                .fillMaxHeight()
                                .border(1.dp, color = MaterialTheme.colorScheme.primaryContainer)
                                .background(MaterialTheme.colorScheme.secondaryContainer),
                            contentAlignment = Alignment.Center
                        ) {
                            Row {
                                OutlinedTextField(
                                    modifier = Modifier.padding(4.dp),
                                    value = currentCalories.intValue.toString(),
                                    onValueChange = {
                                        currentCalories.intValue =
                                            if (it.isBlank()) 0 else it.toInt()
                                    },
                                    label = { Text(text = "калории") },
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
                        val dayTrackersCurrent = DayTrackers(
                            id = 2,
                            type = dayTrackers.value.first().type,
                            sleep = currentSleepHours.intValue * 60 + currentSleepMinutes.intValue,
                            water = currentWaterLiters.intValue * 1000 + currentWaterMilliliters.intValue,
                            calories = currentCalories.intValue
                        )
                        viewModel.updateDayTrackers(dayTrackersCurrent)
                        navController.navigate("Main")
                    }) {
                        Text(text = "Сохранить")
                    }
                }
            }
        }
    }
}
