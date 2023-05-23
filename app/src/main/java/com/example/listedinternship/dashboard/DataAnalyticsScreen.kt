package com.example.listedinternship.dashboard

import androidx.compose.foundation.Image
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.listedinternship.R
import com.example.listedinternship.apiRequest.ListedApiResponse

@Composable
fun DataAnalyticsScreen(dashBoardData: State<ListedApiResponse?>) {

    Row(
        modifier = Modifier
            .padding(top = 20.dp)
            .horizontalScroll(rememberScrollState())
    ) {
        Card(
            modifier = Modifier
                .size(120.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color.White,
            ),
        ) {
            Column {
                Image(
                    painter = painterResource(id = R.drawable.ellipse),
                    contentDescription = "ellipse",
                    modifier = Modifier.padding(10.dp)
                )
                Spacer(modifier = Modifier.padding(5.dp))
                Text(
                    text = dashBoardData.value?.today_clicks.toString(),
                    modifier = Modifier.padding(start =  10.dp),
                    style = MaterialTheme.typography.bodyMedium,
                    color = Color.Black,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "Today's Clicks",
                    modifier = Modifier.padding(top = 10.dp, start = 10.dp),
                    style = MaterialTheme.typography.bodySmall,
                    color = Color(0xFF999CA0)
                )
            }

        }

        Spacer(modifier = Modifier.padding(10.dp))
        Card(
            modifier = Modifier
                .size(120.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color.White,
            ),
        ) {
            Image(
                painter = painterResource(id = R.drawable.pin), contentDescription = "pin",
                modifier = Modifier.padding(10.dp)
            )
            Spacer(modifier = Modifier.padding(5.dp))
            Text(
                text = dashBoardData.value?.top_location.toString(),
                modifier = Modifier.padding(start =  10.dp),
                style = MaterialTheme.typography.bodyMedium,
                color = Color.Black,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "Top Location",
                modifier = Modifier.padding(top = 10.dp, start = 10.dp),
                style = MaterialTheme.typography.bodySmall,
                color = Color(0xFF999CA0)
            )
        }

        Spacer(modifier = Modifier.padding(10.dp))
        Card(
            modifier = Modifier
                .size(120.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color.White,
            ),
        ) {
            Image(
                painter = painterResource(id = R.drawable.globe), contentDescription = "globe",
                modifier = Modifier.padding(10.dp)
            )
            Spacer(modifier = Modifier.padding(5.dp))
            Text(
                text = dashBoardData.value?.top_source.toString(),
                modifier = Modifier.padding(start =  10.dp),
                style = MaterialTheme.typography.bodyMedium,
                color = Color.Black,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "Top Source",
                modifier = Modifier.padding(top = 10.dp, start = 10.dp),
                style = MaterialTheme.typography.bodySmall,
                color = Color(0xFF999CA0)
            )
        }
        Spacer(modifier = Modifier.padding(10.dp))

        Card(
            modifier = Modifier
                .size(120.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color.White,
            ),
        ) {
            Image(
                painter = painterResource(id = R.drawable.ellipse), contentDescription = "ellipse",
                modifier = Modifier.padding(10.dp)
            )
            Spacer(modifier = Modifier.padding(5.dp))
            Text(
                text = dashBoardData.value?.total_clicks.toString(),
                modifier = Modifier.padding(start =  10.dp),
                style = MaterialTheme.typography.bodyMedium,
                color = Color.Black,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "Total clicks",
                modifier = Modifier.padding(top = 10.dp, start = 10.dp),
                style = MaterialTheme.typography.bodySmall,
                color = Color(0xFF999CA0)
            )
        }
    }
}