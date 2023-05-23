package com.example.listedinternship.composables.profile

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.listedinternship.R

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
 fun Profile(){
 Scaffold(
  containerColor = Color(0xFF0E6FFF),
  topBar = {
   TopAppBar(
    title = {
     Text(
      text = "Profile",
      style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Bold),
      modifier = Modifier
       .padding(top = 25.dp, start = 20.dp)
     )
    },
    actions = {
     IconButton(
      onClick = { },
      modifier = Modifier
       .padding(top = 25.dp, end = 10.dp)
       .clip(RoundedCornerShape(45)),
      colors = IconButtonDefaults.iconButtonColors(
       contentColor = Color.White,
       containerColor = Color(0x21FFFFFF)
      )
     ) {
      Icon(
       painter = painterResource(id = R.drawable.wrench),
       contentDescription = "Wrench",
      )
     }
    },
    colors = TopAppBarDefaults.mediumTopAppBarColors(
     containerColor = Color(0xFF0E6FFF),
     titleContentColor = Color.White
    ),
   )
  },
 ) {
  Card(
   modifier = Modifier
    .padding(top = 90.dp)
    .fillMaxSize()
    .background(Color(0xFF0E6FFF)),
   shape = RoundedCornerShape(topStartPercent = 4, topEndPercent = 4),
   colors = CardDefaults.cardColors(
    containerColor = Color(0xFFF5F5F5),
   ),
   elevation = CardDefaults.cardElevation(0.dp)
  ) {}
 }
}