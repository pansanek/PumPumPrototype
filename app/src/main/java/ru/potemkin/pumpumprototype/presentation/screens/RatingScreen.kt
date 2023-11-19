package ru.potemkin.pumpumprototype.presentation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.*
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.potemkin.pumpumprototype.presentation.components.CustomCircularProgressIndicator
import ru.potemkin.pumpumprototype.ui.theme.PumPumPrototypeTheme
import ru.potemkin.pumpumprototype.ui.theme.*

@Composable
fun RatingScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Заголовочный текст
        Text(
            text = "Ваш уровень подготовки",
            style = typography.titleLarge,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        // Круговой индикатор (заглушка)
        Box(
            modifier = Modifier
                .size(250.dp)
                .clip(CircleShape),
        ) {
            CustomCircularProgressIndicator(
                modifier = Modifier
                    .size(250.dp),
                initialValue = 88,
                primaryColor = blue,
                secondaryColor = darkBlue,
                circleRadius = 230f,
                onPositionChange = {
                }
            )
        }

        // Текст "Так держать"
        Text(
            text = "Так держать!",
            style = typography.titleMedium,
            color = blue,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        // Текст "Темы"
        Text(
            text = "Изученные темы:",
            style = typography.titleMedium,
            modifier = Modifier.padding(top = 16.dp, bottom = 8.dp)
                .align(Alignment.Start)
        )

        // Список элементов тем
        LazyColumn {
            items(8) { index ->
                CheckTopicItem("Тема ${index + 1}",true)
            }
        }

        // Панель навигации

    }
}

@Composable
fun CheckTopicItem(topicName: String, check:Boolean) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Прямоугольник с закругленными углами
        Box(
            modifier = Modifier
                .size(20.dp, 20.dp)
                .clip(RoundedCornerShape(16.dp))
                .background(blue)
                .weight(1f)
        ) {
            // Название темы
            Text(
                text = topicName,
                style = typography.bodyMedium,
                color = white,
                modifier = Modifier.padding(start = 16.dp)
            )
        }

        Spacer(modifier = Modifier.width(32.dp))

        // Кружок красного цвета
        Box(
            modifier = Modifier
                .size(16.dp)
                .clip(CircleShape)
                .background(blue),
            contentAlignment = Alignment.Center
        ) {
            // Иконка внутри кружка (заглушка)
            Icon(
                imageVector = Icons.Default.Check,
                contentDescription = null,
                tint = Color.White,
                modifier = Modifier.size(12.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun RatingScreenPreview() {
    PumPumPrototypeTheme {
        RatingScreen()
    }
}