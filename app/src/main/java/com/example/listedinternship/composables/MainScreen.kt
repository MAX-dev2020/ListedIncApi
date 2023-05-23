package com.example.listedinternship.composables

import android.annotation.SuppressLint

import androidx.compose.material3.ExperimentalMaterial3Api

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.example.listedinternship.composables.campaigns.Campaigns
import com.example.listedinternship.composables.courses.Courses
import com.example.listedinternship.composables.dashboard.DashBoardScreen
import com.example.listedinternship.composables.profile.Profile
import com.example.listedinternship.viewmodel.ListedViewModel

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(viewModel: ListedViewModel) {
    var dashBoardScreen by  remember {
        mutableStateOf(true)
    }
    var campaignsScreen by  remember {
        mutableStateOf(false)
    }
    var coursesScreen by  remember {
        mutableStateOf(false)
    }
    var profileScreen by  remember {
        mutableStateOf(false)
    }

    val topLinks = viewModel.topLinks.collectAsState()
    val recentLinks = viewModel.recentLinks.collectAsState()
    val dashBoardData = viewModel.dashboardData.collectAsState()
    val chartData = viewModel.chartData.collectAsState()

    LaunchedEffect(Unit){
        viewModel.makeApiRequest("api/v1/dashboardNew")
    }

    Scaffold(
        bottomBar = {
            CustomBottomAppBar(
                onLinkClicked = {
                    dashBoardScreen = true
                    campaignsScreen = false
                    coursesScreen = false
                    profileScreen = false
                },
                onCoursesClicked = {
                    coursesScreen = true
                    dashBoardScreen = false
                    campaignsScreen = false
                    profileScreen = false
                },
                onCampaignsClicked = {
                    campaignsScreen = true // Handle the "Campaigns" button click in the MainScreen
                    coursesScreen = false
                    dashBoardScreen = false
                    profileScreen = false
                },
                onProfileClicked = {
                    profileScreen = true// Handle the "Profile" button click in the MainScreen
                    coursesScreen = false
                    dashBoardScreen = false
                    campaignsScreen = false
                }
            )
        }
    ) {
        if (dashBoardScreen) {
            DashBoardScreen(
                topLinks = topLinks,
                recentLinks = recentLinks,
                dashBoardData = dashBoardData,
                chartData = chartData
            )
        }
        if (campaignsScreen) {
            Campaigns()
        }
        if (coursesScreen) {
            Courses()
        }
        if (profileScreen) {
            Profile()
        }
    }
}
