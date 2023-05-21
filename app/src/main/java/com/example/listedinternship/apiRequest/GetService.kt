package com.example.listedinternship.apiRequest

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class GetService {
    private lateinit var apiInterface: ApiInterface

    fun getApiInterface(): ApiInterface {
        val okHttpClient = OkHttpClient.Builder()
            .addInterceptor(AuthInterceptor("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6MjU5MjcsImlhdCI6MTY3NDU1MDQ1MH0.dCkW0ox8tbjJA2GgUx2UEwNlbTZ7Rr38PVFJevYcXFI"))
            .build()
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.inopenapp.com") // Set the base url to the address input provided by the user
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create()) // Use Gson for converting response
            .build()

        // Create the TimeInterface object using the retrofit instance
        apiInterface = retrofit.create(ApiInterface::class.java)
        return apiInterface
    }
}