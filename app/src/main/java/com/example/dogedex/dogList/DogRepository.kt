package com.example.dogedex.dogList

import com.example.dogedex.Dog
import com.example.dogedex.R
import com.example.dogedex.api.ApiResponseStatus
import com.example.dogedex.api.DogsApi.retrofitService
import com.example.dogedex.dto.DogDtoMapper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.net.UnknownHostException

class DogRepository {

    suspend fun downloadDogs(): ApiResponseStatus {
        return withContext(Dispatchers.IO) {
            try {
                val dogListApiResponse = retrofitService.getAllDogs()
                val dogDTOList = dogListApiResponse.data.dogs
                val dogDTOMapper = DogDtoMapper()
               ApiResponseStatus.Success (dogDTOMapper.fromDogDTOListToDogDomainList(dogDTOList))
            }catch (e:UnknownHostException){
                ApiResponseStatus.Error(R.string.unknow_host_exception_error)
            }catch (e:Exception){
                ApiResponseStatus.Error(R.string.unknow_error)
            }
        }
    }
}