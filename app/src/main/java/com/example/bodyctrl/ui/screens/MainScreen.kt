package com.example.bodyctrl.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Edit
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.bodyctrl.ui.components.listitems.MainDayActivityItem
import com.example.bodyctrl.ui.components.stats.DayTrackerPieChart
import com.example.bodyctrl.ui.components.tableitems.MainParametersTableRow
import com.example.bodyctrl.ui.components.tableitems.MainParametersTableTitle
import com.example.bodyctrl.ui.dialogs.DayActivityInfoDialog
import com.example.bodyctrl.ui.viewmodels.MainViewModel
import com.example.bodyctrl.utils.booleanToInt
import com.example.bodyctrl.utils.getDateTodayForMainScreen
import com.example.bodyctrl.utils.getSleepValueForMainScreen
import com.example.bodyctrl.utils.getWaterValueForMainScreen
import com.example.bodyctrl.utils.intToBoolean

@Composable
fun MainScreen(navController: NavHostController) {

    val viewModel: MainViewModel = hiltViewModel()

    val parameters = viewModel.parameters.observeAsState(initial = emptyList())
    val dayTrackers = viewModel.dayTrackers.observeAsState(initial = emptyList())
    val dayActivities = viewModel.dayActivities.observeAsState(initial = emptyList())

    val dateToday = "Сегодня " + getDateTodayForMainScreen()

    val shouldShowInfoDialog = remember { mutableStateOf(false) }
    val infoDialogDetailsText = remember { mutableStateOf("") }

    if (shouldShowInfoDialog.value) {
        DayActivityInfoDialog(
            infoText = infoDialogDetailsText.value,
            shouldShow = shouldShowInfoDialog
        )
    }

    if (parameters.value.isNotEmpty() && dayTrackers.value.isNotEmpty()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp)
        ) {
            Box(modifier = Modifier.fillMaxWidth()) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.End
                ) {
                    Text(
                        text = dateToday,
                        style = MaterialTheme.typography.titleMedium,
                        fontStyle = FontStyle.Italic
                    )
                }
            }
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
            ) {
                Row(modifier = Modifier.fillMaxWidth()) {
                    Text(
                        text = "Контроль параметров",
                        modifier = Modifier
                            .padding(start = 16.dp)
                            .align(Alignment.CenterVertically),
                        style = MaterialTheme.typography.titleLarge,
                        color = MaterialTheme.colorScheme.primary
                    )
                    Spacer(modifier = Modifier.weight(1f))
                    IconButton(
                        onClick = { navController.navigate("Parameters") },
                        modifier = Modifier.align(Alignment.CenterVertically)
                    ) {
                        Icon(Icons.Outlined.Edit, contentDescription = "Parameters")
                    }
                }
            }
            Box(modifier = Modifier
                .fillMaxWidth()
                .clickable(onClick = {
                    navController.navigate("Parameters")
                })
            ) {
                Column {
                    MainParametersTableTitle()
                    MainParametersTableRow(parameters.value.last())
                    MainParametersTableRow(parameters.value.first())
                }
            }
            Spacer(modifier = Modifier.height(8.dp))
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
            ) {
                Row(modifier = Modifier.fillMaxWidth()) {
                    Text(
                        text = "Контроль сна/воды/еды",
                        modifier = Modifier
                            .padding(start = 16.dp)
                            .align(Alignment.CenterVertically),
                        style = MaterialTheme.typography.titleLarge,
                        color = MaterialTheme.colorScheme.primary
                    )
                    Spacer(modifier = Modifier.weight(1f))
                    IconButton(
                        onClick = { navController.navigate("DayTrackers") },
                        modifier = Modifier.align(Alignment.CenterVertically)
                    ) {
                        Icon(Icons.Outlined.Edit, contentDescription = "Day Trackers")
                    }
                }
            }
            Box(modifier = Modifier.fillMaxWidth()) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable(onClick = {
                            navController.navigate("DayTrackers")
                        })
                    ,
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    DayTrackerPieChart(
                        totalData = dayTrackers.value.first().sleep,
                        progressData = dayTrackers.value.last().sleep,
                        pieText = "Сон",
                        pieValue = getSleepValueForMainScreen(dayTrackers.value.last().sleep)
                    )
                    DayTrackerPieChart(
                        totalData = dayTrackers.value.first().water,
                        progressData = dayTrackers.value.last().water,
                        pieText = "Вода",
                        pieValue = getWaterValueForMainScreen(dayTrackers.value.last().water)
                    )
                    DayTrackerPieChart(
                        totalData = dayTrackers.value.first().calories,
                        progressData = dayTrackers.value.last().calories,
                        pieText = "Калории",
                        pieValue = "${dayTrackers.value.last().calories} ккал"
                    )
                }
            }
            Spacer(modifier = Modifier.height(8.dp))
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
            ) {
                Row(modifier = Modifier.fillMaxWidth()) {
                    Text(
                        text = "Контроль активности",
                        modifier = Modifier
                            .padding(start = 16.dp)
                            .align(Alignment.CenterVertically),
                        style = MaterialTheme.typography.titleLarge,
                        color = MaterialTheme.colorScheme.primary
                    )
                    Spacer(modifier = Modifier.weight(1f))
                    IconButton(
                        onClick = { navController.navigate("AllDayActivities") },
                        modifier = Modifier.align(Alignment.CenterVertically)
                    ) {
                        Icon(Icons.Outlined.Edit, contentDescription = "All Day Activities")
                    }
                }
            }
            LazyColumn(modifier = Modifier.fillMaxWidth()) {
                items(dayActivities.value, key = { item -> item.id }) { item ->
                    MainDayActivityItem(
                        itemTitle = item.name,
                        itemDetails = item.details,
                        itemColor = item.color,
                        itemIsChecked = intToBoolean(item.isChecked),
                        onCheckedChange = {
                            item.isChecked = booleanToInt(it)
                            viewModel.updateDayActivity(item)
                        },
                        onDetailsClick = {
                            infoDialogDetailsText.value = item.details
                            shouldShowInfoDialog.value = it
                        }
                    )
                }
            }
        }
    }
}