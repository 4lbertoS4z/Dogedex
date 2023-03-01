package com.example.dogedex.dto

import com.example.dogedex.Dog

class DogDtoMapper {
    private fun fromDogDTOToDogDomain(dogDto: DogDto): Dog {
        return Dog(dogDto.id,dogDto.index,dogDto.name,dogDto.type,dogDto.heightFemale,dogDto.heightMale,dogDto.imageUrl,
            dogDto.lifeExpectancy,dogDto.temperament,dogDto.weightFemale,dogDto.weightMale)
    }
    fun fromDogDTOListToDogDomainList(dogDtoList: List<DogDto>):List<Dog>{
        return dogDtoList.map { fromDogDTOToDogDomain(it) }
    }
}