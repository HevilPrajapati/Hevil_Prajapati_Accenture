package com.test.hevil_prajapati.repository

import com.test.hevil_prajapati.network.ApiRequest
import com.test.hevil_prajapati.network.ApiService

class DropBoxUserContentRepository(
    private val dropBoxUserContentApi: ApiService
) : ApiRequest() {

    suspend fun getDropBoxUserContent() = apiRequest {
        dropBoxUserContentApi.getDropBoxUserContent()
     }
}
