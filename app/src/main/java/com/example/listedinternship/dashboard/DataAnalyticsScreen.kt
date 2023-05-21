package com.example.listedinternship.dashboard

import androidx.compose.foundation.Image
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.listedinternship.R

@Composable
fun DataAnalyticsScreen() {

    Row(modifier = Modifier.padding(top = 20.dp).horizontalScroll(rememberScrollState())) {
        Card(
            modifier = Modifier
                .size(120.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color.White,
            ),
        ) {
            Image(painter = painterResource(id = R.drawable.ellipse), contentDescription = "ellipse",
            modifier = Modifier.padding(10.dp))
        }
        Spacer( modifier = Modifier.padding(10.dp))
        Card(modifier = Modifier
            .size(120.dp),colors = CardDefaults.cardColors(
            containerColor = Color.White,
        ),) {
            Image(painter = painterResource(id = R.drawable.pin), contentDescription = "pin" ,
                modifier = Modifier.padding(10.dp))
        }

        Spacer( modifier = Modifier.padding(10.dp))
        Card(modifier = Modifier
            .size(120.dp),colors = CardDefaults.cardColors(
            containerColor = Color.White,
        ),) {
            Image(painter = painterResource(id = R.drawable.globe), contentDescription = "globe" ,
                modifier = Modifier.padding(10.dp))
        }
        Spacer( modifier = Modifier.weight(1f))
    }
}