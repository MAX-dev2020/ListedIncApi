package com.example.listedinternship

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.listedinternship.dashboard.DashBoardScreen
import com.example.listedinternship.ui.theme.ListedInternshipTheme
import com.example.listedinternship.viewmodel.ListedViewModel

class MainActivity : ComponentActivity() {
    private val dataViewModel by viewModels<ListedViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ListedInternshipTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val viewModel = ListedViewModel()
                    DashBoardScreen(dataViewModel)
                }
            }
        }
    }
//    private fun makeApiRequest() {
//        GetService().getApiInterface().getDashboardData()
//            .enqueue(object : retrofit2.Callback<ListedApiResponse> {
//                override fun onResponse(
//                    call: Call<ListedApiResponse>,
//                    response: Response<ListedApiResponse>
//                ) {
//                    println("Response: ${response.body()}")
//                    println("Response: ${response.raw()}")
//                }
//
//                override fun onFailure(call: Call<ListedApiResponse>, t: Throwable) {
//                    println( "Error: ${t.message}")
//                    println(t.message)
//                }
//
//            })
//
//    }
}



