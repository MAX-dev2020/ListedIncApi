package com.example.listedinternship.apiRequest

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Url

interface ApiInterface {
    @GET
    fun getDashboardData(@Url url: String): Call<ListedApiResponse>
}
