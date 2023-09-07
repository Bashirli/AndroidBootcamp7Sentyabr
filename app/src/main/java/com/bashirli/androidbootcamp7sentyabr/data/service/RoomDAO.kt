package com.bashirli.androidbootcamp7sentyabr.data.service

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.bashirli.androidbootcamp7sentyabr.data.dto.UserDTO


@Dao
interface RoomDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertData(userDTO: UserDTO)

    @Delete
    suspend fun deleteData(userDTO: UserDTO)


    @Query("SELECT * FROM UserInformation")
    suspend fun getAllData():List<UserDTO>

}