package com.example.bodyctrl.ui.screens

import android.widget.Toast.LENGTH_LONG
import android.widget.Toast.makeText
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import com.example.bodyctrl.data.DayActivities
import com.example.bodyctrl.ui.components.pickers.ColorTagsList
import com.example.bodyctrl.ui.viewmodels.DayActivityEditViewModel

@Composable
fun DayActivityEditScreen(
    navController: NavHostController,
    dayActivityId: Int
) {
    val viewModel: DayActivityEditViewModel = hiltViewModel()

    val dayActivity by viewModel.dayActivity.collectAsStateWithLifecycle()
    val context = LocalContext.current

    if (dayActivity.name != "") {

    val activityName = remember { mutableStateOf(dayActivity.name) }
    val activityColor = remember { mutableStateOf(dayActivity.color) }
    val activityDetails = remember { mutableStateOf(dayActivity.details) }
    val activityIsActive = remember { mutableIntStateOf(dayActivity.isActive) }
    val activityIsChecked = remember { mutableIntStateOf(dayActivity.isChecked) }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp)
        ) {
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = activityName.value,
                onValueChange = {
                    activityName.value = it
                },
                label = { Text(text = "Название активности") },
                singleLine = true
            )
            Spacer(modifier = Modifier.height(16.dp))
            Box(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(
                        text = "Выделить цветом в списке",
                        style = MaterialTheme.typography.titleLarge
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    ColorTagsList(
                        currentTag = activityColor.value,
                        onSelect = { activityColor.value = it }
                    )
                }
            }
            Spacer(modifier = Modifier.height(16.dp))
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = activityDetails.value,
                onValueChange = {
                    activityDetails.value = it
                },
                label = { Text(text = "Дополнительная информация") }
            )
            Spacer(modifier = Modifier.height(16.dp))
            Box(modifier = Modifier.fillMaxWidth()) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    Button(onClick = {
                        viewModel.deleteDayActivity(dayActivity)
                        navController.navigate("AllDayActivities")
                    }) {
                        Text(text = "Удалить")
                    }
                    Button(onClick = {
                        if (activityName.value == "") {
                            makeText(context, "Нужно сначала ввести название активности.", LENGTH_LONG).show()
                        } else {
                            val currentDayActivity = DayActivities(
                                id = dayActivityId,
                                name = activityName.value,
                                color = activityColor.value,
                                details = activityDetails.value,
                                isActive = activityIsActive.intValue,
                                isChecked = activityIsChecked.intValue
                            )
                            viewModel.updateDayActivity(currentDayActivity)
                            navController.navigate("AllDayActivities")
                        }
                    }) {
                        Text(text = "Сохранить")
                    }
                }
            }
        }
    }
}
