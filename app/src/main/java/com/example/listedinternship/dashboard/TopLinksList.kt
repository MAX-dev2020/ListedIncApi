package com.example.listedinternship.dashboard

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.listedinternship.R
import com.example.listedinternship.apiRequest.Link

@Composable
fun TopLinksList(topLinks: State<List<Link>>) {
    repeat(topLinks.value.size) {
        Card(
            modifier = Modifier.fillMaxWidth(),
            colors = CardDefaults.cardColors(
                containerColor = Color.White,
            )
        ) {
            Row {
                Box(modifier = Modifier.padding(20.dp)) {
                    Image(
                        painter = painterResource(id = R.drawable.search),
                        contentDescription = "sd"
                    )
                }
                Box(modifier = Modifier.padding(20.dp)) {
                    Column {
                        Text(
                            text = "Top Links",
                            style = MaterialTheme.typography.labelMedium,
                            color = Color.Black
                        )
                        Text(
                            text = "22 Aug 2022", style = MaterialTheme.typography.labelSmall,
                            color = Color(0xFF999CA0)
                        )
                    }
                }
                Spacer(modifier = Modifier.weight(1f))
                Box(modifier = Modifier.padding(20.dp)) {
                    Column {
                        Text(
                            text = "223",
                            style = MaterialTheme.typography.labelMedium,
                            color = Color.Black,
                            fontWeight = FontWeight.Bold
                        )
                        Text(
                            text = "Clicks", style = MaterialTheme.typography.labelSmall,
                            color = Color(0xFF999CA0)
                        )
                    }
                }
            }
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .background(Color(0xFFA6C7FF))
                    .padding(10.dp)
            ) {
                Text(
                    text = "Your Link",
                    style = MaterialTheme.typography.displayMedium,
                    color = Color(0xFF0E6FFF),
                    modifier = Modifier.weight(1f)
                )
                Icon(
                    painter = painterResource(id = R.drawable.copy),
                    contentDescription = "Copy",
                    tint = Color(0xFF0E6FFF),
                    modifier = Modifier.padding(start = 8.dp)
                )
            }
        }
        Spacer(modifier = Modifier.padding(10.dp))
    }

}