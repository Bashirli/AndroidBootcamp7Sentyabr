package com.bashirli.androidbootcamp7sentyabr.data.repository

import com.bashirli.androidbootcamp7sentyabr.common.Resource
import com.bashirli.androidbootcamp7sentyabr.data.dto.UserDTO
import com.bashirli.androidbootcamp7sentyabr.data.source.LocalSource
import com.bashirli.androidbootcamp7sentyabr.domain.repository.LocalRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class LocalRepositoryImpl @Inject constructor(
     private val source:LocalSource
) : LocalRepository {


    override suspend  fun insertData(userDTO: UserDTO) {
        source.insertData(userDTO)
    }

    override suspend  fun deleteData(userDTO: UserDTO) {
        source.deleteData(userDTO)
    }

    override suspend  fun getAllData(): Flow<Resource<List<UserDTO>>> = flow {
        try {
            emit(Resource.Loading)
            val response = source.getAllData()
            when(response){
                is Resource.Error ->  { emit(Resource.Error(response.message)) }
                is Resource.Success -> {
                    emit(Resource.Success(response.result))
                }
                Resource.Loading -> { Unit }
            }


        }catch (e:Exception){
            emit(Resource.Error(e.localizedMessage))
        }
    }
}