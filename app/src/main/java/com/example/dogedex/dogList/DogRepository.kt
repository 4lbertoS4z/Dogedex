package com.example.dogedex.dogList

import com.example.dogedex.Dog
import com.example.dogedex.api.DogsApi.retrofitService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class DogRepository {

    suspend fun downloadDogs(): List<Dog> {
        return withContext(Dispatchers.IO) {
            val dogListApiResponse = retrofitService.getAllDogs()
            dogListApiResponse.data.dogs
        }
    }
}