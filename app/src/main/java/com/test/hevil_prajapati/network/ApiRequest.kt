package com.test.hevil_prajapati.network

import retrofit2.Response
import java.io.IOException

abstract class ApiRequest {

    suspend fun <T : Any> apiRequest(call: suspend () -> Response<T>): T? {
        val response = call.invoke()
        when {
            response.isSuccessful -> return response.body()
            else -> throw ApiException(response.code().toString())
        }
    }
}

class ApiException(message: String) : IOException()
