package com.bashirli.androidbootcamp7sentyabr.domain.repository

import com.bashirli.androidbootcamp7sentyabr.common.Resource
import com.bashirli.androidbootcamp7sentyabr.data.dto.UserDTO
import kotlinx.coroutines.flow.Flow

interface LocalRepository {

    suspend  fun insertData(userDTO: UserDTO)

    suspend  fun deleteData(userDTO: UserDTO)

    suspend  fun getAllData(): Flow<Resource<List<UserDTO>>>

}