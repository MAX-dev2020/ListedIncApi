package com.example.listedinternship.dashboard

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.listedinternship.R

@Composable
fun CustomBottomAppBar() {

    BottomAppBar(
        containerColor = Color.White,

        ) {
        IconButton(
            onClick = { /* Handle link button click */ },
            modifier = Modifier.padding(start = 16.dp)
        ) {
            Column{
                Icon(
                    painter = painterResource(id = R.drawable.link),
                    contentDescription = "Link",
                    tint = Color.Black
                )
                Spacer(modifier = Modifier.weight(1f))
                Text(
                    text = "Links",
                    style = MaterialTheme.typography.displaySmall,
                    color = Color.Black,
                    fontWeight = FontWeight.Bold
                )
            }
        }
        Spacer(modifier = Modifier.weight(1f))
        IconButton(
            onClick = { /* Handle campaigns button click */ },
            modifier = Modifier.padding(end = 16.dp)
        ) {
            Column{
                Icon(
                    painter = painterResource(id = R.drawable.magazine),
                    contentDescription = "Link",
                    tint = Color.Black
                )
                Spacer(modifier = Modifier.weight(1f))
                Text(
                    text = "Courses",
                    style = MaterialTheme.typography.displaySmall,
                    color = Color.Black,
                    fontWeight = FontWeight.Bold
                )
            }
        }


        Box(
            modifier = Modifier
                .size(56.dp)
                .clip(CircleShape)
                .background(Color(0xFF0E6FFF))
                .clickable { /* Handle middle button click */ },
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = Icons.Default.Add,
                contentDescription = "Plus",
                tint = Color.White,
                modifier = Modifier.size(32.dp)
            )
        }

        IconButton(
            onClick = { /* Handle campaigns button click */ },
            modifier = Modifier.padding(start = 16.dp)
        ) {
            Column{
                Icon(
                    painter = painterResource(id = R.drawable.fast_forward),
                    contentDescription = "Link",
                    tint = Color.Black,
                )
                Spacer(modifier = Modifier.weight(1f))
                Text(
                    text = "Links",
                    style = MaterialTheme.typography.displaySmall,
                    color = Color.Black,
                    fontWeight = FontWeight.Bold
                )
            }
        }

        Spacer(modifier = Modifier.weight(1f))

        IconButton(
            onClick = { /* Handle profile button click */ },
            modifier = Modifier.padding(end = 8.dp)
        ) {
            Column{
                Icon(
                    painter = painterResource(id = R.drawable.user),
                    contentDescription = "Link",
                    tint = Color.Black
                )
                Spacer(modifier = Modifier.weight(1f))
                Text(
                    text = "Links",
                    style = MaterialTheme.typography.displaySmall,
                    color = Color.Black,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}

