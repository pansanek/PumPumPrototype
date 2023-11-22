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
import androidx.compose.foundation.layout.height
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.potemkin.pumpumprototype.R
import ru.potemkin.pumpumprototype.ui.theme.PumPumPrototypeTheme
import ru.potemkin.pumpumprototype.ui.theme.blue
import ru.potemkin.pumpumprototype.ui.theme.darkBlue
import ru.potemkin.pumpumprototype.ui.theme.white

@Composable
fun ThemeScreen() {
    Column(
    modifier = Modifier
    .fillMaxSize()
    .padding(16.dp)
    ) {
        // Заголовок
        Text(
            text = "#Тема#",
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
                        onClick = {  },
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
        Spacer(modifier = Modifier.height(32.dp))
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
                        text = "Справочные материалы",
                        style = MaterialTheme.typography.titleLarge,
                        modifier = Modifier.padding(bottom = 8.dp)
                    )
                    Button(
                        onClick = {  },
                        colors = ButtonDefaults.buttonColors(darkBlue),
                    ) {
                        Text("Читать")
                    }
                }
                Image(
                    painter = painterResource(id = R.drawable.read_svgrepo_com),
                    contentDescription = "image"
                )
            }
        }

        Text(
            text = "Подтемы:",
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier
                .padding(top = 16.dp, bottom = 8.dp)
                .align(Alignment.Start)
        )
        LazyColumn {
            items(8) { index ->
                ThemeTopicItem("Тема ${index + 1}")
            }
        }
        // Панель навигации (оставлено пустым)
    }
}

@Composable
fun ThemeTopicItem(topicName: String) {
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

        Text(
            text = "# шт.",
            style = MaterialTheme.typography.titleMedium,
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ThemeScreenPreview() {
    PumPumPrototypeTheme {
        ThemeScreen()
    }
}