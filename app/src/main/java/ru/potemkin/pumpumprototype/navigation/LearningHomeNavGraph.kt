package ru.potemkin.pumpumprototype.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation

fun NavGraphBuilder.learningHomeNavGraph(
    learningScreenContent: @Composable () -> Unit,
    themeScreenContent:@Composable () -> Unit
) {
    navigation(
        startDestination = Screen.Learning.route,
        route = Screen.LearningHome.route
    ){
        composable(Screen.Learning.route) {
            learningScreenContent()
        }
        composable(Screen.Topic.route) {
            themeScreenContent()
        }
    }
}