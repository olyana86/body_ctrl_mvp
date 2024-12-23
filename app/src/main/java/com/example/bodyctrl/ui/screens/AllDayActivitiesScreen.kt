package com.example.bodyctrl.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.bodyctrl.ui.components.listitems.AllDayActivityItem
import com.example.bodyctrl.ui.viewmodels.AllDayActivitiesViewModel
import com.example.bodyctrl.utils.booleanToInt
import com.example.bodyctrl.utils.intToBoolean

@Composable
fun AllDayActivitiesScreen(navController: NavHostController) {

    val viewModel: AllDayActivitiesViewModel = hiltViewModel()

    val activities = viewModel.dayActivities.observeAsState(initial = emptyList())

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp)
    ) {

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.End
        ) {
            Button(
                onClick = { navController.navigate("NewDayActivity") }
            ) {
                Icon(Icons.Default.Add, contentDescription = "Add")
                Spacer(modifier = Modifier.width(8.dp))
                Text(text = "Новая")
            }
        }
        Spacer(Modifier.height(8.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Выбор физических активностей на сегодня",
                style = MaterialTheme.typography.titleLarge,
                textAlign = TextAlign.Center
            )
        }
        Spacer(Modifier.height(8.dp))
        if (activities.value.isNotEmpty()) {
            LazyColumn {
                items(activities.value, key = { item -> item.id }) { item ->
                    AllDayActivityItem(
                        itemId = item.id,
                        itemTitle = item.name,
                        itemColor = item.color,
                        itemIsActive = intToBoolean(item.isActive),
                        onCheckedChange = {
                            item.isActive = booleanToInt(it)
                            viewModel.updateDayActivity(item)
                        },
                        onEditClick = {
                            navController.navigate("DayActivityEdit/$it")
                        }
                    )
                }
            }
        }
        Spacer(Modifier.height(8.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Button(onClick = { navController.popBackStack() }) {
                Text(text = "Отмена")
            }
            Button(onClick = {
                navController.navigate("Main")
            }) {
                Text(text = "Сохранить")
            }
        }
    }
}