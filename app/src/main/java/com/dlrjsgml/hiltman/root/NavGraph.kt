package com.dlrjsgml.hiltman.root

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.dlrjsgml.hiltman.feature.commitly.CommitlyScreen
import com.dlrjsgml.hiltman.feature.login.LoginScreen

@Composable
fun NavGraph() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = NavGroup.COMMITLY,
    ) {
        composable(route = NavGroup.LOGIN) {
            LoginScreen()
        }
        composable(route = NavGroup.COMMITLY) {
            CommitlyScreen()
        }
    }
}