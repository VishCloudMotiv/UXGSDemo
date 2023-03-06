package com.cloudmotiv.room_db.repository

import android.content.Context
import androidx.lifecycle.LiveData
import com.cloudmotiv.room_db.Telematery
import com.cloudmotiv.room_db.dao.TelemateryDao
import com.cloudmotiv.room_db.data_base.TelemateryDatabase
import com.cloudmotiv.room_db.subscribeOnBackground

class TelemateryRepository(application: Context) {

    private var telemateryDao: TelemateryDao
    private var allTelematery: LiveData<List<Telematery>>

    private val database = TelemateryDatabase.getInstance(application)

    init {
        telemateryDao = database.teleMateryDao()
        allTelematery = telemateryDao.getAllTelemateries()
    }

    fun insert(telematery: Telematery) {
        subscribeOnBackground {
            telemateryDao.insert(telematery)
        }
    }

    fun update(telematery: Telematery) {
        subscribeOnBackground {
            telemateryDao.update(telematery)
        }
    }

    fun delete(telematery: Telematery) {
        subscribeOnBackground {
            telemateryDao.delete(telematery)
        }
    }

    fun deleteAllTelemateries() {
        subscribeOnBackground {
            telemateryDao.deleteAllTelematery()
        }
    }

    fun getAllTelemateries(): LiveData<List<Telematery>> {
        return allTelematery
    }



}