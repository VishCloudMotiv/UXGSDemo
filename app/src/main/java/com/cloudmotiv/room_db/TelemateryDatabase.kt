package com.cloudmotiv.room_db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase

@Database(entities = [Telematery::class], version = 1)
abstract class TelemateryDatabase : RoomDatabase() {

    abstract fun teleMateryDao(): TelemateryDao

    companion object {
        private var instance: TelemateryDatabase? = null

        @Synchronized
        fun getInstance(ctx: Context): TelemateryDatabase {
            if(instance == null)
                instance = Room.databaseBuilder(ctx.applicationContext, TelemateryDatabase::class.java,
                    "telematery_database")
                    .fallbackToDestructiveMigration()
                    .addCallback(roomCallback)
                    .build()

            return instance!!

        }

        private val roomCallback = object : Callback() {
            override fun onCreate(db: SupportSQLiteDatabase) {
                super.onCreate(db)

            }
        }
        
        private fun subscribeOnBackground(function: () -> Unit) {

        }
    }



}
