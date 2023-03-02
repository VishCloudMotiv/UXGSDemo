package com.cloudmotiv.room_db

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface TelemateryDao {

    @Insert
    fun insert(telematery: Telematery)

    @Update
    fun update(telematery: Telematery)

    @Delete
    fun delete(telematery: Telematery)

    @Query("delete from telematery_table")
    fun deleteAllTelematery()

    @Query("select * from telematery_table")
    fun getAllTelemateries(): LiveData<List<Telematery>>
}