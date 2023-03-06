package com.cloudmotiv.room_db.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.cloudmotiv.room_db.Mission
import com.cloudmotiv.room_db.Telematery

@Dao
interface MissionDao {

    @Insert
    fun insert(mission: Mission)

    @Update
    fun update(mission: Mission)

    @Delete
    fun delete(mission: Mission)

    @Query("delete from mission_table")
    fun deleteAllMission()

    @Query("select * from mission_table")
    fun getAllMissions(): LiveData<List<Mission>>
}