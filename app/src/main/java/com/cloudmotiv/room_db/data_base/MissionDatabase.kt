package com.cloudmotiv.room_db.data_base

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.cloudmotiv.room_db.Mission
import com.cloudmotiv.room_db.Telematery
import com.cloudmotiv.room_db.dao.MissionDao
import com.cloudmotiv.room_db.dao.TelemateryDao

@Database(entities = [Mission::class], version = 1)
abstract class MissionDatabase : RoomDatabase() {

    abstract fun missionDao(): MissionDao

    companion object {
        private var instance: MissionDatabase? = null

        @Synchronized
        fun getInstance(ctx: Context): MissionDatabase {
            if(instance == null)
                instance = Room.databaseBuilder(ctx.applicationContext, MissionDatabase::class.java,
                    "mission_database")
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
