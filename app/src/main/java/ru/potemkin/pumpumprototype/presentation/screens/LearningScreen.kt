package ru.potemkin.pumpumprototype.presentation.screens

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import ru.potemkin.pumpumprototype.R
import ru.potemkin.pumpumprototype.ui.theme.blue
import ru.potemkin.pumpumprototype.ui.theme.darkBlue
import ru.potemkin.pumpumprototype.ui.theme.white

@Composable
fun LearningScreen(
    onTopicClickListener:() -> Unit,
    //onVariantClickListener: (Variant) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        // Заголовок
        Text(
            text = "Начнем учиться!",
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        // Прямоугольник с текстом "Пробный вариант", кнопкой "Начать" и картинкой
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = blue, shape = RoundedCornerShape(16.dp))
                .padding(16.dp)
        ) {
            Row (verticalAlignment = Alignment.CenterVertically){
                Column(
                    modifier = Modifier
                        .padding(end = 16.dp)
                ) {
                    Text(
                        text = "Пробный вариант",
                        style = MaterialTheme.typography.titleLarge,
                        modifier = Modifier.padding(bottom = 8.dp)
                    )
                    Button(
                        onClick = { onTopicClickListener() },
                        colors = ButtonDefaults.buttonColors(darkBlue),
                    ) {
                        Text("Начать")
                    }
                }
                Image(
                    painter = painterResource(id = R.drawable.writing_svgrepo_com),
                    contentDescription = "image"
                )
            }
        }

        // Текст "Рекомендуем повторить"
        Text(
            text = "Рекомендуем повторить",
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier.padding(vertical = 16.dp)
        )
        val topics = listOf("Тема 1", "Тема 2", "Тема 3", "Тема 4", "Тема 5")
        Log.d("TOPIC", topics.size.toString())
        // Горизонтальный список элементов тем
        LazyRow {
            items(topics.size) { topic ->
                Log.d("TOPIC", topics[topic])
                RowTopicItem(topics[topic])
            }
        }
        Text(
            text = "Темы:",
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier
                .padding(top = 16.dp, bottom = 8.dp)
                .align(Alignment.Start)
        )
        LazyColumn {
            items(8) { index ->
                ColumnTopicItem("Тема ${index + 1}")
            }
        }
        // Панель навигации (оставлено пустым)
    }
}

@Composable
fun RowTopicItem(topicName: String) {
    // Прямоугольник с закругленными углами
    Box(
        modifier = Modifier
            .size(128.dp, 64.dp)
            .clip(RoundedCornerShape(48.dp))
            .background(blue)
    ) {
        // Название темы
        Text(
            text = topicName,
            style = MaterialTheme.typography.bodyMedium,
            color = white,
            modifier = Modifier.align(Alignment.Center)
        )
    }

    Spacer(modifier = Modifier.width(32.dp))
}

@Composable
fun ColumnTopicItem(topicName: String) {
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
                style = MaterialTheme.typography.bodyMedium,
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

