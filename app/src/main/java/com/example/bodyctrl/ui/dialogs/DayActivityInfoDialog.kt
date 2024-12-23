package com.example.bodyctrl.ui.dialogs

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState

@Composable
fun DayActivityInfoDialog(
    infoText: String,
    shouldShow: MutableState<Boolean>
) {
    if (shouldShow.value) {
        AlertDialog(
            onDismissRequest = {
                shouldShow.value = false
            },
            title = {
                Text(text = "Подробности")
            },
            text = {
                Text(text = infoText)
            },
            confirmButton = {
                Button(
                    onClick = {
                        shouldShow.value = false
                    }) {
                    Text(
                        text = "OK"
                    )
                }
            }
        )
    }
}