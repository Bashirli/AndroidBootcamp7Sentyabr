package com.bashirli.androidbootcamp7sentyabr.data.source

import com.bashirli.androidbootcamp7sentyabr.common.Resource
import com.bashirli.androidbootcamp7sentyabr.data.dto.UserDTO

interface LocalSource {

    suspend fun insertData(userDTO: UserDTO)

    suspend fun deleteData(userDTO: UserDTO)

    suspend fun getAllData():Resource<List<UserDTO>>


}