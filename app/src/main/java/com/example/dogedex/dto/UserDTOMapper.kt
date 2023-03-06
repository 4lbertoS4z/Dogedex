package com.example.dogedex.dto

import com.example.dogedex.model.Dog
import com.example.dogedex.model.User

class UserDTOMapper {
     fun fromUserDTOListToUserDomain(userDTO: UserDTO) =
        User(userDTO.id,userDTO.email,userDTO.authenticationToken)


}