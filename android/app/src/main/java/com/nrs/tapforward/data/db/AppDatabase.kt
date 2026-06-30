package com.nrs.tapforward.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.nrs.tapforward.data.model.Donation
import com.nrs.tapforward.data.model.Event
import com.nrs.tapforward.data.model.Member

@Database(
    entities = [Donation::class, Event::class, Member::class],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun donationDao(): DonationDao
    abstract fun eventDao(): EventDao
    abstract fun memberDao(): MemberDao

    companion object {
        @Volatile private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase =
            INSTANCE ?: synchronized(this) {
                INSTANCE ?: Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "tapforward.db"
                ).build().also { INSTANCE = it }
            }
    }
}
