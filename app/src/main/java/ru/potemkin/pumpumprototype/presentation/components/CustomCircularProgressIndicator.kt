package ru.potemkin.pumpumprototype.presentation.components

import android.graphics.Paint
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.*
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.graphics.drawscope.rotate
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.potemkin.pumpumprototype.ui.theme.*
import kotlin.math.PI
import kotlin.math.cos
import kotlin.math.sin

@Composable
fun CustomCircularProgressIndicator(
    modifier: Modifier = Modifier,
    initialValue:Int,
    primaryColor: Color,
    secondaryColor:Color,
    minValue:Int = 0,
    maxValue:Int = 100,
    circleRadius:Float,
    onPositionChange:(Int)->Unit
) {
    var circleCenter by remember {
        mutableStateOf(Offset.Zero)
    }

    var positionValue by remember {
        mutableStateOf(initialValue)
    }



    Box(
        modifier = modifier
    ){
        Canvas(
            modifier = Modifier
                .fillMaxSize()
        ){
            val width = size.width
            val height = size.height
            val circleThickness = width / 25f
            circleCenter = Offset(x = width/2f, y = height/2f)


            drawCircle(
                brush = Brush.radialGradient(
                    listOf(
                        primaryColor.copy(0.45f),
                        secondaryColor.copy(0.15f)
                    )
                ),
                radius = circleRadius,
                center = circleCenter
            )


            drawCircle(
                style = Stroke(
                    width = circleThickness
                ),
                color = secondaryColor,
                radius = circleRadius,
                center = circleCenter
            )

            drawArc(
                color = primaryColor,
                startAngle = 90f,
                sweepAngle = (360f/maxValue) * positionValue.toFloat(),
                style = Stroke(
                    width = circleThickness,
                    cap = StrokeCap.Round
                ),
                useCenter = false,
                size = Size(
                    width = circleRadius * 2f,
                    height = circleRadius * 2f
                ),
                topLeft = Offset(
                    (width - circleRadius * 2f)/2f,
                    (height - circleRadius * 2f)/2f
                )

            )


            drawContext.canvas.nativeCanvas.apply {
                drawIntoCanvas {
                    drawText(
                        "$positionValue %",
                        circleCenter.x,
                        circleCenter.y + 45.dp.toPx()/3f,
                        Paint().apply {
                            textSize = 38.sp.toPx()
                            textAlign = Paint.Align.CENTER
                            color = white.toArgb()
                            isFakeBoldText = true
                        }
                    )
                }
            }

        }
    }
}

@Preview(showBackground = true)
@Composable
fun Preview() {
    CustomCircularProgressIndicator(
        modifier = Modifier
            .size(250.dp)
            .background(black)
        ,
        initialValue = 50,
        primaryColor = blue,
        secondaryColor = darkBlue,
        circleRadius = 230f,
        onPositionChange = {

        }
    )
}