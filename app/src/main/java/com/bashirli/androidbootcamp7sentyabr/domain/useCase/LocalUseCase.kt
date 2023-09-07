package com.bashirli.androidbootcamp7sentyabr.domain.useCase

import com.bashirli.androidbootcamp7sentyabr.data.dto.UserDTO
import com.bashirli.androidbootcamp7sentyabr.domain.repository.LocalRepository
import javax.inject.Inject

class LocalUseCase @Inject constructor(
    private val repo:LocalRepository
) {

    suspend fun insertData(userDTO: UserDTO) = repo.insertData(userDTO)

    suspend fun deleteData(userDTO: UserDTO) = repo.deleteData(userDTO)

    suspend fun getAllData() = repo.getAllData()


}