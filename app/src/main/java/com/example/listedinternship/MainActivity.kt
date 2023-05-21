package com.example.listedinternship

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.listedinternship.apiRequest.GetService
import com.example.listedinternship.apiRequest.ListedApiResponse
import com.example.listedinternship.dashboard.DashBoardScreen
import com.example.listedinternship.ui.theme.ListedInternshipTheme
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Call
import retrofit2.Response

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ListedInternshipTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    DashBoardScreen()
                }
            }
        }
    }
}


//@OptIn(DelicateCoroutinesApi::class)
//@Composable
//fun Greeting() {
//    Column(
//        modifier = Modifier.fillMaxSize(),
//        horizontalAlignment = Alignment.CenterHorizontally,
//        verticalArrangement = Arrangement.Center
//    ) {
//        val apiResponse = remember { mutableStateOf("") }
//
//        Button(
//            onClick = {
//
//                makeApiRequest()
//
//            },
//            modifier = Modifier.padding(16.dp)
//        ) {
//            Text(text = "Make API Request")
//        }
//
//        Text(text = apiResponse.value)
//    }
//
//}

private fun makeApiRequest() {
    GetService().getApiInterface().getDashboardData()
        .enqueue(object : retrofit2.Callback<ListedApiResponse> {
            override fun onResponse(
                call: Call<ListedApiResponse>,
                response: Response<ListedApiResponse>
            ) {
                println("Response: ${response.body()}")
                println("Response: ${response.raw()}")
            }

            override fun onFailure(call: Call<ListedApiResponse>, t: Throwable) {
                println(t.message)
            }

        })

}