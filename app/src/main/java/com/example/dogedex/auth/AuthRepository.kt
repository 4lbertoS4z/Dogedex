package com.example.dogedex.auth

import com.example.dogedex.api.ApiResponseStatus
import com.example.dogedex.api.DogsApi
import com.example.dogedex.api.makeNetworkCall
import com.example.dogedex.dto.DogDtoMapper
import com.example.dogedex.dto.SignUpDTO
import com.example.dogedex.dto.UserDTOMapper
import com.example.dogedex.model.User

class AuthRepository {
    suspend fun signUp(email:String, password:String
                       , passwordConfirmation:String): ApiResponseStatus<User> = makeNetworkCall {

        val signUpDTO = SignUpDTO(email,password, passwordConfirmation)
        val signUpResponse = DogsApi.retrofitService.signUp(signUpDTO)

        if (!signUpResponse.isSuccess){
            throw Exception(signUpResponse.message)
        }

        val userDTO = signUpResponse.data.user
        val userDTOMapper = UserDTOMapper()
        userDTOMapper.fromUserDTOListToUserDomain(userDTO)
    }
}