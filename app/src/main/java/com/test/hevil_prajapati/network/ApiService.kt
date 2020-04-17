package com.test.hevil_prajapati.network

import com.test.hevil_prajapati.model.DropBoxUserContent
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface ApiService {

    @GET("facts.json")
    suspend fun getDropBoxUserContent(): Response<DropBoxUserContent>

    companion object {
        operator fun invoke(): ApiService {
            return Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://dl.dropboxusercontent.com/s/2iodh4vg0eortkl/")
                .build()
                .create(ApiService::class.java)
        }
    }
}
