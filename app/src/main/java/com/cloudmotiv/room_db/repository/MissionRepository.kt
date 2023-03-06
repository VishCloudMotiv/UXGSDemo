package com.cloudmotiv.room_db.repository

import android.content.Context
import androidx.lifecycle.LiveData
import com.cloudmotiv.room_db.Mission
import com.cloudmotiv.room_db.Telematery
import com.cloudmotiv.room_db.dao.MissionDao
import com.cloudmotiv.room_db.dao.TelemateryDao
import com.cloudmotiv.room_db.data_base.MissionDatabase
import com.cloudmotiv.room_db.data_base.TelemateryDatabase
import com.cloudmotiv.room_db.subscribeOnBackground

class MissionRepository(application: Context) {

    private var missionDao: MissionDao
    private var allMission: LiveData<List<Mission>>

    private val database = MissionDatabase.getInstance(application)

    init {
        missionDao = database.missionDao()
        allMission = missionDao.getAllMissions()
    }

    fun insert(mission: Mission) {
        subscribeOnBackground {
            missionDao.insert(mission)
        }
    }

    fun update(mission: Mission) {
        subscribeOnBackground {
            missionDao.update(mission)
        }
    }

    fun delete(mission: Mission) {
        subscribeOnBackground {
            missionDao.delete(mission)
        }
    }

    fun deleteAllTelemateries() {
        subscribeOnBackground {
            missionDao.deleteAllMission()
        }
    }

    fun getAllTelemateries(): LiveData<List<Mission>> {
        return allMission
    }



}