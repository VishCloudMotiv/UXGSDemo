package com.cloudmotiv.room_db

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "telematery_table")
data class Telematery(
    var lat: Double = 0.0,
    var long: Double = 0.0,
    var attitude: String = "null",
    @PrimaryKey(autoGenerate = false) var id: Int = 0)