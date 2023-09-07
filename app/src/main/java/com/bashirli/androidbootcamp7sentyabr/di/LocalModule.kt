package com.bashirli.androidbootcamp7sentyabr.di

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.bashirli.androidbootcamp7sentyabr.data.repository.LocalRepositoryImpl
import com.bashirli.androidbootcamp7sentyabr.data.service.RoomDAO
import com.bashirli.androidbootcamp7sentyabr.data.service.RoomDB
import com.bashirli.androidbootcamp7sentyabr.data.source.LocalSource
import com.bashirli.androidbootcamp7sentyabr.data.source.LocalSourceImpl
import com.bashirli.androidbootcamp7sentyabr.domain.repository.LocalRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object LocalModule {

    @Singleton
    @Provides
    fun injectRoomDB(@ApplicationContext context: Context)=Room.databaseBuilder(
        context,RoomDB::class.java,"UserDatabase"
    ).build()

    @Singleton
    @Provides
    fun injectRoomDAO(roomDB: RoomDB)=roomDB.getDao()

    @Singleton
    @Provides
    fun injectSource(service:RoomDAO) = LocalSourceImpl(service) as LocalSource

    @Singleton
    @Provides
    fun injectRepo(source:LocalSource)=LocalRepositoryImpl(source) as LocalRepository


}