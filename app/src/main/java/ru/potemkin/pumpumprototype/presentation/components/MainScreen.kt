package ru.potemkin.pumpumprototype.presentation.components

import android.annotation.SuppressLint
import androidx.compose.animation.core.tween
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.exyte.animatednavbar.AnimatedNavigationBar
import com.exyte.animatednavbar.animation.balltrajectory.Parabolic
import com.exyte.animatednavbar.animation.indendshape.Height
import com.exyte.animatednavbar.animation.indendshape.shapeCornerRadius
import ru.potemkin.pumpumprototype.presentation.screens.LearningScreen
import ru.potemkin.pumpumprototype.presentation.screens.RatingScreen
import ru.potemkin.pumpumprototype.ui.theme.PumPumPrototypeTheme
import ru.potemkin.pumpumprototype.ui.theme.blue
import ru.potemkin.pumpumprototype.ui.theme.darkBlue
import ru.potemkin.pumpumprototype.ui.theme.white

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainScreen() {
    val navBarItems = remember {
        NavigationBarItems.values()
    }
    var selectedIndex by remember {
        mutableStateOf(0)
    }

    Scaffold(
        modifier = Modifier.padding(bottom = 12.dp),
        bottomBar = {
            AnimatedNavigationBar(
                modifier = Modifier
                    .height(64.dp)
                    .padding(8.dp),
                selectedIndex = selectedIndex,
                cornerRadius = shapeCornerRadius(34.dp),
                ballAnimation = Parabolic(tween(300)),
                indentAnimation = Height(tween(300)),
                barColor = blue,
                ballColor = darkBlue
                ) {
                    navBarItems.forEach { item ->
                        Box(
                            modifier = Modifier
                                .fillMaxSize()
                                .noRippleClickable { selectedIndex = item.ordinal },
                            contentAlignment = Alignment.Center
                        ){
                            Icon(
                                modifier = Modifier.size(26.dp),
                                imageVector = item.icon,
                                contentDescription = "BarIcon",
                                tint = if (selectedIndex == item.ordinal) darkBlue
                                else white
                            )
                        }
                    }
            }
        }
    ) {
        navBarItems.forEach{item ->
            if (item == NavigationBarItems.Learn) LearningScreen()
        }
    }
}




enum class NavigationBarItems(val icon:ImageVector){
    Learn(icon=Icons.Default.CheckCircle),
    Rate(icon=Icons.Default.Star),
    Profile(icon=Icons.Default.Person)
}

fun Modifier.noRippleClickable(onClick: () -> Unit): Modifier = composed {
    clickable (
        indication = null,
        interactionSource = remember {
            MutableInteractionSource()
        }
    ){
        onClick()
    }
}


@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    PumPumPrototypeTheme {
        MainScreen()
    }
}