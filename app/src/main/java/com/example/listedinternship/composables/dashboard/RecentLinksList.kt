package com.example.listedinternship.composables.dashboard

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
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.listedinternship.R
import com.example.listedinternship.apiRequest.Link
import com.example.listedinternship.components.formatTime

@Composable
fun RecentLinksList(recentLinks: State<List<Link>>) {
    if (recentLinks.value.isEmpty()) {
        // Show progress indicator
        CircularProgressIndicator(
            color = Color(0xFF0E6FFF),
        )
    } else {
        repeat(recentLinks.value.size) {
            Card(
                modifier = Modifier.fillMaxWidth(),
                colors = CardDefaults.cardColors(
                    containerColor = Color.White,
                )
            ) {
                Row {
                    Box(
                        modifier = Modifier.padding(20.dp)
                            .size(48.dp)
                            .clip(
                                RoundedCornerShape(8.dp)
                            )
                    ) {
                        if (recentLinks.value[it].original_image != null) {
                            AsyncImage(
                                model = recentLinks.value[it].original_image,
                                contentDescription = "Example Image",
                                contentScale = ContentScale.Fit,
                                modifier = Modifier
                                    .fillMaxSize()

                            )
                        } else {
                            Image(
                                painter = painterResource(id = R.drawable.search),
                                contentDescription = "search",
                            )
                        }
                    }
                    Box(modifier = Modifier.padding(20.dp)) {
                        Column {
                            Text(
                                text = recentLinks.value[it].app, // name of the app
                                style = MaterialTheme.typography.labelMedium,
                                color = Color.Black,
                            )
                            Spacer(modifier = Modifier.padding(5.dp))
                            Text(
                                text = formatTime(recentLinks.value[it].created_at),
                                style = MaterialTheme.typography.labelSmall,
                                color = Color(0xFF999CA0)
                            )
                        }
                    }
                    Spacer(modifier = Modifier.weight(1f))
                    Box(modifier = Modifier.padding(20.dp)) {
                        Column {
                            Text(
                                text = recentLinks.value[it].total_clicks.toString(),
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
                val stroke = Stroke(
                    width = 2f,
                    pathEffect = PathEffect.dashPathEffect(floatArrayOf(10f, 10f), 0f)
                )
                Box(
                    modifier = Modifier
                        .background(Color(0x80A6C7FF))
                        .drawBehind {
                            drawRoundRect(
                                color = Color(0xFFA6C7FF),
                                style = stroke,
                                cornerRadius = CornerRadius(50f, 10f,)
                            )
                        }
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .fillMaxWidth().padding(10.dp)
                    ) {
                        Text(
                            text = recentLinks.value[it].web_link,
                            style = MaterialTheme.typography.displayMedium,
                            color = Color(0xFF0E6FFF),
                            modifier = Modifier.weight(1f),
                            overflow = TextOverflow.Ellipsis,
                            maxLines = 1
                        )
                        Spacer(modifier = Modifier.weight(1f))
                        Icon(
                            painter = painterResource(id = R.drawable.copy),
                            contentDescription = "Copy",
                            tint = Color(0xFF0E6FFF),
                            modifier = Modifier.padding(start = 8.dp)
                        )
                    }
                }
            }
            Spacer(modifier = Modifier.padding(10.dp))
        }
    }
}