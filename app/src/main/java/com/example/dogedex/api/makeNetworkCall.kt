package com.example.dogedex.api

import com.example.dogedex.R
import com.example.dogedex.dto.DogDtoMapper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.net.UnknownHostException

suspend fun <T> makeNetworkCall(
    call:suspend  () -> T
): ApiResponseStatus <T> = withContext(Dispatchers.IO) {
        try {
            ApiResponseStatus.Success(call())
        } catch (e: UnknownHostException) {
            ApiResponseStatus.Error(R.string.unknow_host_exception_error)
        } catch (e: Exception) {
            ApiResponseStatus.Error(R.string.unknow_error)
        }

}