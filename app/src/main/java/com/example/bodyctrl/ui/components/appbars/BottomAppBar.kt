package com.example.bodyctrl.ui.components.appbars

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Man
import androidx.compose.material.icons.filled.TrackChanges
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@Composable
fun BodyCtrlBottomAppbar(navController: NavHostController) {
    BottomAppBar(
        actions = {
            IconButton(
                onClick = { navController.navigate("Main") },
                content = {
                    Icon(Icons.Default.Home, contentDescription = "Home")
                }
            )
            IconButton(
                onClick = { navController.navigate("Parameters") },
                content = {
                    Icon(Icons.Default.Man, contentDescription = "Parameters")
                }
            )
            IconButton(
              onClick = { navController.navigate("DayTrackers") },
                content = {
                    Icon(Icons.Default.TrackChanges, contentDescription = "DayTrackers")
                }
            )
        },
        floatingActionButton = {
            Button(
                onClick = { navController.navigate("AllDayActivities") }
            ) {
                Icon(Icons.Default.Add, contentDescription = "Add")
                Spacer(modifier = Modifier.width(8.dp))
                Text(text = "АКТИВНОСТЬ")
            }
        }
    )
}