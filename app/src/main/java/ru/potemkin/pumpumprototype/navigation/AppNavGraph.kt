package ru.potemkin.pumpumprototype.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation

@Composable
fun AppNavGraph(
    navHostController: NavHostController,
    learningScreenContent: @Composable () -> Unit,
    ratingScreenContent: @Composable () -> Unit,
    //profileScreenContent: @Composable () -> Unit,
    themeScreenContent:@Composable () -> Unit,
    ) {
        NavHost(
            navController = navHostController,
            startDestination = Screen.LearningHome.route
        ) {
            learningHomeNavGraph(learningScreenContent, themeScreenContent)
            composable(Screen.Rating.route) {
                ratingScreenContent()
            }
//            composable(Screen.Profile.route) {
//                profileScreenContent()
//            }
        }
    }