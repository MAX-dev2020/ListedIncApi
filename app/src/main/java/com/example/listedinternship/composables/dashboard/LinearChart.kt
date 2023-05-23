package com.example.listedinternship.composables.dashboard


import android.graphics.Paint
import android.graphics.PointF
import androidx.compose.foundation.Canvas
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.graphics.toArgb

sealed class LinearChartStyle {
    object Default : LinearChartStyle()
}
@Composable
fun LinearChart(
    modifier: Modifier = Modifier,
    style: LinearChartStyle = LinearChartStyle.Default,
    data: List<Int>,
    dates: List<Any>
) {
    Canvas(modifier = modifier) {
        // distance between each x point
        val distance = size.width / (data.size + 1)
        var currentX = 0F
        val maxValue = data.maxOrNull() ?: 0
        val points = mutableListOf<PointF>()

        val yAxisLabels = generateYAxisLabels(maxValue)
        val paint = Paint().apply {
            color = Color(0xFF999CA0).toArgb()
            textSize = 20f
        }

        // Draw y-axis labels
        yAxisLabels.forEachIndexed { index, label ->
            val xPos = -10f
            val yPos = size.height - index * (size.height / (yAxisLabels.size - 1)) - paint.textSize / 2 // Reduce the spacing
            drawContext.canvas.nativeCanvas.drawText(
                label.toString(),
                xPos,
                yPos,
                paint
            )
        }

        // Draw y-axis line
        drawLine(
            start = Offset(40f, 0f), // Adjust the x position as per your preference
            end = Offset(40f, size.height), // Adjust the x position as per your preference
            color = Color(0xFF999CA0),
            strokeWidth = 2f
        )

        data.forEachIndexed { index, currentData ->
            if (data.size >= index + 2) {
                val y0 = (maxValue - currentData) * (size.height / maxValue)
                val x0 = currentX + distance
                points.add(PointF(x0, y0))
                currentX += distance
            }
        }

        // Draw x-axis labels
        dates.forEachIndexed { index, date ->
            val xPos = 20f + index * (size.width / (dates.size - 1))
            val yPos = size.height + 40f // Add space between line and labels
            drawContext.canvas.nativeCanvas.drawText(
                date.toString(),
                xPos,
                yPos,
                paint
            )
        }

        // Draw x-axis line
        drawLine(
            start = Offset(0f, size.height),
            end = Offset(size.width, size.height),
            color = Color(0xFF999CA0),
            strokeWidth = 2f
        )



        if (style == LinearChartStyle.Default) {
            for (i in 0 until points.size - 1) {
                drawLine(
                    start = Offset(points[i].x, points[i].y),
                    end = Offset(points[i + 1].x, points[i + 1].y),
                    color = Color(0xFF0E6FFF),
                    strokeWidth = 8f
                )
            }
        } else {
            val cubicPoints1 = mutableListOf<PointF>()
            val cubicPoints2 = mutableListOf<PointF>()

            for (i in 1 until points.size) {
                cubicPoints1.add(PointF((points[i].x + points[i - 1].x) / 2, points[i - 1].y))
                cubicPoints2.add(PointF((points[i].x + points[i - 1].x) / 2, points[i].y))
            }

            val path = Path()
            path.moveTo(points.first().x, points.first().y)

            for (i in 1 until points.size) {
                path.cubicTo(
                    cubicPoints1[i - 1].x,
                    cubicPoints1[i - 1].y,
                    cubicPoints2[i - 1].x,
                    cubicPoints2[i - 1].y,
                    points[i].x,
                    points[i].y
                )
            }

            drawPath(path, color = Color(0xFF0E6FFF), style = Stroke(width = 8f))
        }
    }
}
// Helper function to generate y-axis labels from 0 to maxValue
private fun generateYAxisLabels(maxValue: Int): List<Int> {
    val labels = mutableListOf<Int>()
    val step = maxValue / 5 // Adjust the number of labels as per your preference

    for (i in 0..5) {
        labels.add(i * step)
    }

    return labels
}
