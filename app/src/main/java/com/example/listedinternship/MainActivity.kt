package com.example.listedinternship

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.listedinternship.composables.MainScreen
import com.example.listedinternship.composables.dashboard.DashBoardScreen
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
                    MainScreen(dataViewModel)
                }
            }
        }
    }
}



