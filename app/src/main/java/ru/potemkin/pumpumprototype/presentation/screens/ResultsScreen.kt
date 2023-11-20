package ru.potemkin.pumpumprototype.presentation.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.potemkin.pumpumprototype.R
import ru.potemkin.pumpumprototype.ui.theme.PumPumPrototypeTheme

@Composable
fun ResultsScreen() {
// Sample data for demonstration
    val tasks = (1..10).toList()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        Text(
            text = "Результаты",
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier.padding(8.dp)
        )
        Column {
            // Header
            Text(
                text = "Правильно решено: 4",
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier.padding(8.dp)
            )

            Text(
                text = "Нерешено: 6",
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier.padding(8.dp)
            )
        }
            LazyRow(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                items(tasks.size) {
                    Box(
                        modifier = Modifier
                            .size(40.dp)
                            .background(
                                MaterialTheme.colorScheme.primary,
                                shape = MaterialTheme.shapes.medium
                            )
                            .padding(4.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "$it",
                            color = Color.White,
                            fontWeight = FontWeight.Bold
                        )
                    }
                    Spacer(modifier = Modifier.width(8.dp))
                }
            }
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                // Header
                Text(
                    text = "Задание ${tasks[1]}",
                    style = MaterialTheme.typography.titleLarge,
                    modifier = Modifier.padding(8.dp)
                )

                // Task description
                Text(
                    text = "Описание задания ${tasks[1]}. ",
                    style = MaterialTheme.typography.titleMedium,
                    modifier = Modifier.padding(8.dp)
                )

                // Image
                Image(
                    painter = painterResource(id = R.drawable.writing_svgrepo_com), // Замените на реальный ресурс
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp)
                        .clip(MaterialTheme.shapes.medium)
                )

                // Task answer
                Text(
                    text = "Ответ на задание ${tasks[1]}",
                    style = MaterialTheme.typography.titleMedium,
                    modifier = Modifier.padding(8.dp)
                )

                // Task answer
                Text(
                    text = "Описание ответа на задание ${tasks[1]}",
                    style = MaterialTheme.typography.titleMedium,
                    modifier = Modifier.padding(8.dp)
                )
                // Image
                Image(
                    painter = painterResource(id = R.drawable.writing_svgrepo_com), // Замените на реальный ресурс
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp)
                        .clip(MaterialTheme.shapes.medium)
                )



                // Action buttons (for demonstration purposes)
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Button(
                        onClick = {
                            // Handle "Далее" button click
                        },
                        modifier = Modifier
                            .padding(8.dp)
                    ) {
                        Text("Назад")
                    }

                    Button(
                        onClick = {
                            // Handle "Далее" button click
                        },
                        modifier = Modifier
                            .padding(8.dp)
                    ) {
                        Text("Далее")
                    }
                }
            }

    }
}


@Preview(showBackground = true)
@Composable
fun ResultsScreenPreview() {
    PumPumPrototypeTheme {
        ResultsScreen()
    }
}