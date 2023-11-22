package ru.potemkin.pumpumprototype.presentation.screens

import android.annotation.SuppressLint
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import ru.potemkin.pumpumprototype.navigation.AppNavGraph
import ru.potemkin.pumpumprototype.navigation.Screen
import ru.potemkin.pumpumprototype.ui.theme.NavigationItem
import ru.potemkin.pumpumprototype.ui.theme.PumPumPrototypeTheme
import ru.potemkin.pumpumprototype.ui.theme.blue
import ru.potemkin.pumpumprototype.ui.theme.darkBlue
import ru.potemkin.pumpumprototype.ui.theme.white

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainScreen() {

    val navHostController = rememberNavController()

    Scaffold(
        bottomBar = {
            BottomNavigation(
                backgroundColor = blue,
                contentColor = white
            ) {
                val navBackStackEntry by navHostController.currentBackStackEntryAsState()
                val currentRout = navBackStackEntry?.destination?.route

                val items = listOf(
                    NavigationItem.Learning,
                    NavigationItem.Rating,
                    NavigationItem.Profile
                )
                items.forEach { item ->
                    BottomNavigationItem(
                        selected = currentRout == item.screen.route,
                        onClick = { navHostController.navigate(item.screen.route) },
                        icon = {
                            Icon(item.icon, contentDescription = null,tint =  white)
                        },
                        selectedContentColor = white,
                        unselectedContentColor = darkBlue
                    )
                }
            }
        }
    ) { paddingValues ->
        AppNavGraph(
            navHostController = navHostController,
            learningScreenContent = {
                LearningScreen(
                    onTopicClickListener = navHostController.navigate(Screen.Topic.route)
                )
            },
            ratingScreenContent = { RatingScreen(

            )},
            themeScreenContent = { ThemeScreen()}
            //profileScreenContent = { TextCounter(name = "Profile") }
        )
    }
}




@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    PumPumPrototypeTheme {
        MainScreen()
    }
}