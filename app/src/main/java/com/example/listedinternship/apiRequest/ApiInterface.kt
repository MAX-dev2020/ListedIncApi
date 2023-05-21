package com.example.listedinternship.apiRequest

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header

interface ApiInterface {
    @GET("api/v1/dashboardNew")
    fun getDashboardData(): Call<ListedApiResponse>
}