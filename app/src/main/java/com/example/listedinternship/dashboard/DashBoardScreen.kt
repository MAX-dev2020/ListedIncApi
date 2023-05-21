package com.example.listedinternship.dashboard

import android.annotation.SuppressLint
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults

import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api

import androidx.compose.material3.IconButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.listedinternship.R


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DashBoardScreen() {
    val tabOptions = listOf("Top Links", "Recent Links")
    val selectedTab = remember { mutableStateOf(0) }
    Scaffold(
        containerColor = Color(0xFF0E6FFF),
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Dashboard",
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
        bottomBar = { CustomBottomAppBar() }
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
        ) {
            Column(
                Modifier
                    .verticalScroll(rememberScrollState())
                    .fillMaxSize(),
            ) {
                Box(modifier = Modifier.padding(horizontal = 20.dp, vertical = 30.dp)) {
                    Column {
                        Text(
                            text = "Good Morning",
                            style = MaterialTheme.typography.bodyMedium,
                            color = Color(0xFF999CA0)
                        )
                        Row() {
                            Text(
                                text = "Monish V",
                                style = MaterialTheme.typography.bodyLarge,
                                color = Color.Black,
                                modifier = Modifier.padding(top = 10.dp),
                                fontWeight = FontWeight.Bold
                            )

                            Image(
                                painter = painterResource(id = R.drawable.wave),
                                contentDescription = "wave",
                                modifier = Modifier
                                    .size(38.dp)
                                    .padding(start = 10.dp, top = 5.dp)
                            )
                        }
                        ChartScreen()
                        DataAnalyticsScreen()

                        Button(
                            onClick = { /* Handle button click */ },
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = 20.dp)
                                .aspectRatio(7f),
                            shape = RoundedCornerShape(6.dp),
                            border = BorderStroke(1.dp, Color(0xFFD8D8D8)),
                            colors = ButtonDefaults.outlinedButtonColors(
                                contentColor = Color.Black,
                                containerColor = Color.Transparent
                            )
                        ) {
                            Row(Modifier.padding(end = 8.dp)) {
                                Icon(
                                    painter = painterResource(id = R.drawable.price_boost),
                                    contentDescription = "price_boost",
                                    modifier = Modifier.padding(end = 4.dp)
                                )
                                Text(
                                    text = "View Analytics",
                                    style = MaterialTheme.typography.bodyMedium,
                                    fontWeight = FontWeight.Bold
                                )
                            }
                        }

                        Row(modifier = Modifier.padding(top = 40.dp)) {
                            Button(
                                onClick = { selectedTab.value = 0 },
                                colors = if (selectedTab.value == 0) {
                                    ButtonDefaults.buttonColors(
                                        containerColor = Color(0xFF0E6FFF),
                                        contentColor = Color.White
                                    )
                                } else {
                                    ButtonDefaults.buttonColors(
                                        containerColor = Color.Transparent,
                                        contentColor = Color(0xFF999CA0)
                                    )
                                },
                                modifier = Modifier.weight(2.2f)
                            ) {
                                Text(
                                    text = "Top Links", style = MaterialTheme.typography.bodyMedium,
                                    fontWeight = FontWeight.Bold
                                )
                            }

                            Button(
                                onClick = { selectedTab.value = 1 },
                                colors = if (selectedTab.value == 1) {
                                    ButtonDefaults.buttonColors(
                                        containerColor = Color(0xFF0E6FFF),
                                        contentColor = Color.White
                                    )
                                } else {
                                    ButtonDefaults.buttonColors(
                                        containerColor = Color.Transparent,
                                        contentColor = Color(0xFF999CA0)
                                    )
                                }
                            ) {
                                Text(
                                    text = "Recent Links",
                                    style = MaterialTheme.typography.bodyMedium,
                                    fontWeight = FontWeight.Bold
                                )


                            }
                            Spacer(modifier = Modifier.weight(1f))
                            IconButton(
                                onClick = { /* Handle button click */ },
                                modifier = Modifier
                                    .size(45.dp)
                                    .border(1.dp, Color(0xFFD8D8D8), RoundedCornerShape(15.dp)),
                                colors = IconButtonDefaults.iconButtonColors(
                                    contentColor = Color.Black,
                                    containerColor = Color.Transparent
                                ),

                                ) {
                                Icon(
                                    painter = painterResource(id = R.drawable.search),
                                    contentDescription = "search",
                                    modifier = Modifier.aspectRatio(2f),
                                    tint = Color(0xFF999CA0)
                                )
                            }
                        }
                        Spacer(modifier = Modifier.padding(top = 20.dp))
                        when (selectedTab.value) {
                            0 -> {
                                // Display top links list
                                TopLinksList()
                            }

                            1 -> {
                                // Display recent links list
                                RecentLinksList()
                            }
                        }
                    }
                }
            }
        }
    }
}