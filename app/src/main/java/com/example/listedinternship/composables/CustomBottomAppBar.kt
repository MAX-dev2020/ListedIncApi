package com.example.listedinternship.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.listedinternship.R

@Composable
fun CustomBottomAppBar(
    onLinkClicked: () -> Unit,
    onCoursesClicked: () -> Unit,
    onCampaignsClicked: () -> Unit,
    onProfileClicked: () -> Unit
) {

    var isLinkClicked by remember { mutableStateOf(true) }
    var isCoursesClicked by remember { mutableStateOf(false) }
    var isCampaignsClicked by remember { mutableStateOf(false) }
    var isProfileClicked by remember { mutableStateOf(false) }

    BottomAppBar(
        containerColor = Color.White,
    ) {
        IconButton(
            onClick = { isLinkClicked = true; isCoursesClicked = false; isCampaignsClicked = false; isProfileClicked = false },
            modifier = Modifier.aspectRatio(1f)
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxWidth()
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.link),
                    contentDescription = "Link",
                    tint = if (isLinkClicked) Color.Black else Color(0xFF999CA0)
                )
                Spacer(modifier = Modifier.padding(4.dp))
                Text(
                    text = "Links",
                    style = MaterialTheme.typography.displaySmall,
                    color = if (isLinkClicked) Color.Black else Color(0xFF999CA0),
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(horizontal = 4.dp)
                )
            }
        }

        IconButton(
            onClick = {
                isLinkClicked = false
                isCoursesClicked = true
                isCampaignsClicked = false
                isProfileClicked = false
            },
            modifier = Modifier.aspectRatio(1f)
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxWidth()
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.magazine),
                    contentDescription = "Link",
                    tint = if (isCoursesClicked) Color.Black else Color(0xFF999CA0)
                )
                Spacer(modifier = Modifier.padding(4.dp))
                Text(
                    text = "Courses",
                    style = MaterialTheme.typography.displaySmall,
                    color = if (isCoursesClicked) Color.Black else Color(0xFF999CA0),
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(horizontal = 4.dp)
                )
            }
        }

       Spacer(modifier = Modifier.weight(1f))

        ElevatedButton(onClick = {
        },
            modifier = Modifier
                .size(60.dp)
                .clip(CircleShape),
                colors = ButtonDefaults.elevatedButtonColors(
                    containerColor = Color(0xFF0E6FFF),
                )) {
            Icon(
                painter = painterResource(id = R.drawable.plus),
                contentDescription = "Add",
                tint = Color.White,
            )
        }

        Spacer(modifier = Modifier.weight(1f))

        IconButton(
            onClick = {
                isLinkClicked = false
                isCoursesClicked = false
                isCampaignsClicked = true
                isProfileClicked = false
            },
            modifier = Modifier
                .padding(horizontal = 4.dp)
                .aspectRatio(1f)
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxWidth()
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.fast_forward),
                    contentDescription = "Link",
                    tint = if (isCampaignsClicked) Color.Black else Color(0xFF999CA0),
                )
                Spacer(modifier = Modifier.padding(4.dp))
                Text(
                    text = "Campaigns",
                    style = MaterialTheme.typography.displaySmall,
                    color = if (isCampaignsClicked) Color.Black else Color(0xFF999CA0),
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(horizontal = 4.dp)
                )
            }
        }


        IconButton(
            onClick = {
                isLinkClicked = false
                isCoursesClicked = false
                isCampaignsClicked = false
                isProfileClicked = true
            },
            modifier = Modifier
                .padding(end = 8.dp)
                .aspectRatio(1f)
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxWidth()
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.user),
                    contentDescription = "Link",
                    tint = if (isProfileClicked) Color.Black else Color(0xFF999CA0)
                )
                Spacer(modifier = Modifier.padding(4.dp))
                Text(
                    text = "Profile",
                    style = MaterialTheme.typography.displaySmall,
                    color = if (isProfileClicked) Color.Black else Color(0xFF999CA0),
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center
                )
            }
        }
        when {
            isLinkClicked -> onLinkClicked()
            isCoursesClicked -> onCoursesClicked()
            isCampaignsClicked -> onCampaignsClicked()
            isProfileClicked -> onProfileClicked()
        }
    }
}

