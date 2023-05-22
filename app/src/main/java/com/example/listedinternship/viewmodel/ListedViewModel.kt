package com.example.listedinternship.viewmodel

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.listedinternship.apiRequest.GetService
import com.example.listedinternship.apiRequest.Link
import com.example.listedinternship.apiRequest.ListedApiResponse
import kotlinx.coroutines.flow.MutableStateFlow
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ListedViewModel : ViewModel(){

    private val _topLinks = MutableStateFlow(emptyList<Link>())
    private val _recentLinks = MutableStateFlow(emptyList<Link>())
    val topLinks: MutableStateFlow<List<Link>> = _topLinks
    val recentLinks: MutableStateFlow<List<Link>> = _recentLinks

    fun makeApiRequest() {
        GetService().getApiInterface().getDashboardData()
            .enqueue(object : Callback<ListedApiResponse> {
                override fun onResponse(
                    call: Call<ListedApiResponse>,
                    response: Response<ListedApiResponse>
                ) {
                    println("Response: ${response.body()}")
                    println("Response: ${response.raw()}")
                    // Process the response data here
                    val data = response.body()?.data
                    _topLinks.value = data?.top_links ?: emptyList()
                    _recentLinks.value = data?.recent_links ?: emptyList()
                }

                override fun onFailure(call: Call<ListedApiResponse>, t: Throwable) {
                    println("Error: ${t.message}")
                    // Handle the error here
                }
            })
    }
}