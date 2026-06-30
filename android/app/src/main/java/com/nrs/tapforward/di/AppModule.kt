package com.nrs.tapforward.di

import android.content.Context
import androidx.room.Room
import com.nrs.tapforward.data.db.AppDatabase
import com.nrs.tapforward.data.db.DonationDao
import com.nrs.tapforward.data.db.EventDao
import com.nrs.tapforward.data.db.MemberDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): AppDatabase =
        Room.databaseBuilder(context, AppDatabase::class.java, "tapforward.db").build()

    @Provides fun provideDonationDao(db: AppDatabase): DonationDao = db.donationDao()
    @Provides fun provideEventDao(db: AppDatabase): EventDao = db.eventDao()
    @Provides fun provideMemberDao(db: AppDatabase): MemberDao = db.memberDao()
}
