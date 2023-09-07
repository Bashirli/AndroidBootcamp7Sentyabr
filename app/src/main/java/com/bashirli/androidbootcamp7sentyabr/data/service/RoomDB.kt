package com.bashirli.androidbootcamp7sentyabr.data.service

import androidx.room.Database
import androidx.room.RoomDatabase
import com.bashirli.androidbootcamp7sentyabr.data.dto.UserDTO

@Database(entities = [UserDTO::class], version = 1)
abstract class RoomDB : RoomDatabase() {
    abstract fun getDao():RoomDAO
}