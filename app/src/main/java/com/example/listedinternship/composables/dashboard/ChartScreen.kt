package com.example.listedinternship.composables.dashboard

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.listedinternship.LinearChart
import com.example.listedinternship.LinearChartStyle
import com.example.listedinternship.R
import java.time.Month

@Composable
fun ChartScreen(overallChart: State<Map<String, Int>?>) {
    val firstDate = overallChart.value?.keys?.firstOrNull()
    val lastDate = overallChart.value?.keys?.lastOrNull()
    val formattedDateRange = buildDateRangeString(firstDate, lastDate)
    println("overallChart: $overallChart")
    if (overallChart.value == null) {
        // Show progress indicator
        CircularProgressIndicator(
            color = Color(0xFF0E6FFF),
        )
    } else {
        Card(
            modifier = Modifier
                .padding(top = 30.dp)
                .aspectRatio(1.5f),
            colors = CardDefaults.cardColors(
                containerColor = Color.White,
            ),
        ) {
            Row {
                Text(
                    text = "Overview",
                    style = MaterialTheme.typography.bodySmall,
                    color = Color(0xFF999CA0),
                    modifier = Modifier.padding(20.dp)
                )

                Spacer(modifier = Modifier.weight(1f))

                Button(
                    onClick = { /*TODO*/ },
                    modifier = Modifier.padding(top = 10.dp, end = 20.dp),
                    shape = RoundedCornerShape(10.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.White,
                        contentColor = Color(0xFF999CA0)
                    ), border = BorderStroke(1.dp, Color(0x14000000))
                ) {
                    Text(
                        text = formattedDateRange,
                        style = MaterialTheme.typography.titleSmall,
                        color = Color.Black
                    )

                    Icon(
                        painter = painterResource(id = R.drawable.clock),
                        contentDescription = "clock",
                        modifier = Modifier.padding(start = 20.dp)
                    )
                }
            }

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(360.dp)
                    .padding(16.dp),
            ) {
                Column(
                    modifier = Modifier
                        .padding(16.dp)
                        .wrapContentSize(align = Alignment.BottomStart)
                ) {
                    LinearChart(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(200.dp),
                        data = provideMockData(overallChart.value),
                        style = LinearChartStyle.Default,
                        dates = provideMockDates(overallChart.value),
                    )
                }
            }
        }
    }
}

private fun provideMockData(chartData: Map<String, Int>?): List<Int> {
    val dataPoints = chartData?.values?.toList()
    if (dataPoints != null) {
        return dataPoints
    }
    return listOf(0, 0, 0, 0, 0, 0, 0)
}

private fun provideMockDates(chartData: Map<String, Int>?): List<Any> {
    val dataPoints = chartData?.keys?.toMutableList()
    //get only the date from the string

    if (dataPoints != null) {
        for (i in 0 until dataPoints.size) {
            dataPoints[i] = dataPoints[i].substring(8, 10)
        }
        println("dataPoints: $dataPoints")
        return dataPoints
    }
    return listOf("0", "0", "0", "0", "0", "0", "0")
}



@Composable
fun buildDateRangeString(startDate: String?, endDate: String?): String {
    if (startDate != null && endDate != null) {
        val startMonth = startDate.substring(5, 7).toInt()
        val startDay = startDate.substring(8, 10).toInt()
        val endMonth = endDate.substring(5, 7).toInt()
        val endDay = endDate.substring(8, 10).toInt()

        val startMonthName = Month.values()[startMonth - 1].toString().lowercase().capitalize().substring(0, 3)
        val endMonthName = Month.values()[endMonth - 1].toString().lowercase().capitalize().substring(0, 3)

        return "$startDay $startMonthName - $endDay $endMonthName"
    }

    return ""
}

