package com.example.bodyctrl.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.bodyctrl.ui.screens.AllDayActivitiesScreen
import com.example.bodyctrl.ui.screens.DayActivityEditScreen
import com.example.bodyctrl.ui.screens.DayTrackersScreen
import com.example.bodyctrl.ui.screens.MainScreen
import com.example.bodyctrl.ui.screens.NewDayActivityScreen
import com.example.bodyctrl.ui.screens.ParametersScreen

@Composable
fun BodyCtrlNavigation(navController: NavHostController) {

    NavHost(navController = navController, startDestination = "Main") {
        composable("Main") { MainScreen(navController) }
        composable("Parameters") { ParametersScreen(navController) }
        composable("DayTrackers") { DayTrackersScreen(navController) }
        composable("AllDayActivities") { AllDayActivitiesScreen(navController) }
        composable("NewDayActivity") { NewDayActivityScreen(navController) }
        composable(
            "DayActivityEdit/{dayActivityId}",
            arguments = listOf(
                navArgument("dayActivityId")
            { type = NavType.IntType }
            )
        ) { backStackEntry ->
            DayActivityEditScreen(
                navController = navController,
                dayActivityId = backStackEntry.arguments?.getInt("dayActivityId") ?: 0
            )
        }
    }
}