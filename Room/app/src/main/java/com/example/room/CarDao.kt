package com.example.room

import androidx.room.*

@Dao
interface CarDao {

    @Query("SELECT * FROM CARS")
    fun getAllCars(): List<Car>

    @Query("SELECT * FROM CARS A WHERE A.CAR_ID IN (:carIds)")
    fun getCarsById(carIds: IntArray) : List<Car>

    @Query("SELECT * FROM CARS A WHERE A.CAR_NAME LIKE :carName AND A.CAR_ENGINE > :carEngine LIMIT 1")
    fun getCarByNameAndEngine(carName: String, carEngine: Float) : Car
    // fun getCarByNameAndEngine(carName: String, carEngine: Float) : Car?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(vararg cars: Car)

    @Delete
    fun deleteCar(car: Car)

    @Query("DELETE FROM CARS")
    fun deleteAll()

}