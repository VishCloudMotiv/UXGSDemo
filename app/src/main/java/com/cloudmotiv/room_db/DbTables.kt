package com.cloudmotiv.room_db

import androidx.room.Entity
import androidx.room.PrimaryKey
import dji.common.mission.waypoint.Waypoint


@Entity(tableName = "telematery_table")
data class Telematery(
    var lat: Double = 0.0,
    var long: Double = 0.0,
    var attitude: String = "null",
    @PrimaryKey(autoGenerate = false) var id: Int = 0
)


@Entity(tableName = "mission_table")
data class Mission(
    var missionName: String,
    var geoFencingRadius: Float,
    var droneLocationLat: Double,
    var droneLocationLng: Double,
    var wayPointList: String,
    @PrimaryKey(autoGenerate = false) var id: Int = 0
) {
    constructor(
        missionName: String,
        droneLocationLat: Double,
        droneLocationLng: Double,
        GEOFENCE_RADIUS: Float,
        wayPointList: String
    ) : this(
        missionName = missionName,
        droneLocationLng = droneLocationLng,
        droneLocationLat = droneLocationLat,
        geoFencingRadius = GEOFENCE_RADIUS,
        wayPointList =wayPointList,
    )
}
