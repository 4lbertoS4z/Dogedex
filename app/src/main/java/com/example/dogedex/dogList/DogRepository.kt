package com.example.dogedex.dogList

import com.example.dogedex.model.Dog
import com.example.dogedex.api.ApiResponseStatus
import com.example.dogedex.api.DogsApi.retrofitService
import com.example.dogedex.api.makeNetworkCall
import com.example.dogedex.dto.DogDtoMapper

class DogRepository {

    suspend fun downloadDogs(): ApiResponseStatus<List<Dog>> = makeNetworkCall {
            val dogListApiResponse = retrofitService.getAllDogs()
            val dogDTOList = dogListApiResponse.data.dogs
            val dogDTOMapper = DogDtoMapper()
            dogDTOMapper.fromDogDTOListToDogDomainList(dogDTOList)
        }



}