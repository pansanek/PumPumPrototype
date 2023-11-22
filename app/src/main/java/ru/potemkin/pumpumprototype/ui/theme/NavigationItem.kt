package ru.potemkin.pumpumprototype.ui.theme

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Create
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Star
import androidx.compose.ui.graphics.vector.ImageVector
import ru.potemkin.pumpumprototype.R
import ru.potemkin.pumpumprototype.navigation.Screen

sealed class NavigationItem(
    val screen: Screen,
    val titleResId: Int,
    val icon: ImageVector
) {

    object Learning : NavigationItem(
        screen = Screen.Learning,
        titleResId = R.string.navigation_item_learning,
        icon = Icons.Outlined.Create
    )

    object Rating : NavigationItem(
        screen = Screen.Rating,
        titleResId = R.string.navigation_item_rating,
        icon = Icons.Outlined.Star
    )

    object Profile : NavigationItem(
        screen = Screen.Profile,
        titleResId = R.string.navigation_item_profile,
        icon = Icons.Outlined.Person
    )
}