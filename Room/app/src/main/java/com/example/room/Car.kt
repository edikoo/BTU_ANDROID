package com.example.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "CARS")
data class Car(

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "CAR_ID")
    var carId: Long,

    @ColumnInfo(name = "CAR_NAME")
    var carName: String?,

    @ColumnInfo(name = "CAR_ENGINE")
    var carEngine: Float?,

    @ColumnInfo(name = "CAR_RELEASE_YEAR")
    var carReleaseYear: Int?

)
