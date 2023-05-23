package com.example.listedinternship.viewmodel


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
    private var _dashboardData = MutableStateFlow<ListedApiResponse?>(null)
    private var _chartData = MutableStateFlow<Map<String, Int>?>(null)

    val dashboardData: MutableStateFlow<ListedApiResponse?> = _dashboardData
    val topLinks: MutableStateFlow<List<Link>> = _topLinks
    val recentLinks: MutableStateFlow<List<Link>> = _recentLinks
    val chartData: MutableStateFlow<Map<String, Int>?> = _chartData

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
                    _dashboardData.value = response.body()
                    println("_dashboardData: ${_dashboardData.value}")
                    val data = response.body()?.data
                    _topLinks.value = data?.top_links ?: emptyList()
                    _recentLinks.value = data?.recent_links ?: emptyList()
                    _chartData.value = data?.overall_url_chart
                    println("_chartData: ${_chartData.value}")
                }

                override fun onFailure(call: Call<ListedApiResponse>, t: Throwable) {
                    println("Error: ${t.message}")
                    // Handle the error here
                }
            })
    }
}