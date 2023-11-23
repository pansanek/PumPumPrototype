package ru.potemkin.pumpumprototype.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation

fun NavGraphBuilder.topicHomeNavGraph(
    topicScreenContent: @Composable () -> Unit,
    theoryScreenContent:@Composable () -> Unit,
    exerciseScreenContent:@Composable () -> Unit
) {
    navigation(
        startDestination = Screen.Topic.route,
        route = Screen.TopicHome.route
    ){
        composable(Screen.Topic.route) {
            topicScreenContent()
        }
        composable(Screen.Theory.route) {
            theoryScreenContent()
        }
        composable(Screen.Exercise.route) {
            exerciseScreenContent()
        }
    }
}