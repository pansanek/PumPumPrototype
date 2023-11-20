package ru.potemkin.pumpumprototype.presentation.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Send
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType.Companion.Number
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.potemkin.pumpumprototype.R
import ru.potemkin.pumpumprototype.ui.theme.PumPumPrototypeTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ExerciseScreen() {
    // Sample data for demonstration
    val tasks = (1..10).toList()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
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
        Column {
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

            // Answer input field
            var answer by remember { mutableStateOf(TextFieldValue()) }

//            OutlinedTextField(
//                value = answer,
//                onValueChange = {
//                    answer = it
//                },
//                label = { Text("Введите ответ") },
//                keyboardOptions = KeyboardOptions(
//                    capitalization = KeyboardCapitalization.None,
//                    keyboardType = Number
//                ),
//                visualTransformation = VisualTransformation.None,
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(8.dp)
//            )
            LazyVerticalGrid(
                columns = GridCells.Fixed(3),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            ) {
                items(6) { i ->
                    Button(
                        onClick = {
                            // Handle button click
                        },
                        modifier = Modifier
                            .size(40.dp)
                            .padding(4.dp)
                    ) {
                        Text(
                            text = "${i + 1}",
                            color = Color.White,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
            }


            // Action buttons (for demonstration purposes)
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                horizontalArrangement = Arrangement.End
            ) {
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
fun ExerciseScreenPreview() {
    PumPumPrototypeTheme {
        ExerciseScreen()
    }
}