package com.bashirli.androidbootcamp7sentyabr.data.source

import com.bashirli.androidbootcamp7sentyabr.common.Resource
import com.bashirli.androidbootcamp7sentyabr.data.dto.UserDTO
import com.bashirli.androidbootcamp7sentyabr.data.service.RoomDAO
import javax.inject.Inject

class LocalSourceImpl @Inject constructor(
    private val service:RoomDAO
) : LocalSource {
    override suspend  fun insertData(userDTO: UserDTO) {
        service.insertData(userDTO)
    }

    override suspend  fun deleteData(userDTO: UserDTO) {
        service.deleteData(userDTO)
    }

    override suspend  fun getAllData(): Resource<List<UserDTO>> {
       return try {
            val response = service.getAllData()
            Resource.Success(response)
        }catch (e:Exception){
            Resource.Error(e.localizedMessage)
        }
    }
}