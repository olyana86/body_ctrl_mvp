package com.example.bodyctrl

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.example.bodyctrl.navigation.BodyCtrlNavigation
import com.example.bodyctrl.ui.components.appbars.BodyCtrlBottomAppbar
import com.example.bodyctrl.ui.theme.BodyCTRLTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()

            BodyCTRLTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    bottomBar = { BodyCtrlBottomAppbar(navController) }
                ) { innerPadding ->
                    Box(
                        modifier = Modifier
                            .padding(innerPadding)
                            .fillMaxSize()
                    ) {
                        BodyCtrlNavigation(navController)
                    }
                }
            }
        }
    }
}
