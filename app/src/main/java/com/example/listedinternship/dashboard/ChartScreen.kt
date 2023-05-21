package com.example.listedinternship.dashboard

import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun ChartScreen() {
    Card(
        modifier = Modifier
            .padding(top = 30.dp)
            .aspectRatio(1.5f),
        colors = CardDefaults.cardColors(
            containerColor = Color.White,
        ),
    ) {
        Text(text = "Overview", modifier = Modifier.padding(20.dp)
            , style = MaterialTheme.typography.bodySmall,
            color = Color(0xFF999CA0))
    }
}