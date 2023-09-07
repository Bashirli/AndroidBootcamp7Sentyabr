package com.bashirli.androidbootcamp7sentyabr.data.dto

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "UserInformation")
data class UserDTO(
    @PrimaryKey(autoGenerate = false) val id:Int?,
     val name:String?,
     val surname:String?
)
