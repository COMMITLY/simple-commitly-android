package com.dlrjsgml.hiltman.root

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.dlrjsgml.hiltman.feature.login.LoginScreen

@Composable
fun NavGraph() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = NavGroup.LOGIN,
    ) {
        composable(route = NavGroup.LOGIN) {
            LoginScreen()
        }
    }
}