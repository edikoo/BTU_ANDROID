package com.example.mysqlite

import android.content.ContentValues
import android.database.sqlite.SQLiteOpenHelper
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.util.Log

class CarDbHelper(context: Context)
    : SQLiteOpenHelper(context, DbConfig.DATABASE_NAME, null, DbConfig.VERSION) {

    companion object {

        private const val SQL_CREATE_TABLE = "CREATE TABLE ${CarContract.TABLE_NAME} (" +
                "${CarContract.CarColumns.ID} INTEGER PRIMARY KEY, " +
                "${CarContract.CarColumns.CAR_NAME} TEXT, " +
                "${CarContract.CarColumns.ENGINE} REAL, " +
                "${CarContract.CarColumns.YEAR_OF_RELEASE} INTEGER NOT NULL)"

        private const val SQL_DELETE_TABLE = "DROP TABLE IF EXISTS ${CarContract.TABLE_NAME}"

    }

    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL(SQL_CREATE_TABLE)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL(SQL_DELETE_TABLE)
        onCreate(db)
    }

    fun insert(carName: String, year: Int, engine: Float) {

        val value = ContentValues().apply {
            put(CarContract.CarColumns.CAR_NAME, carName)
            put(CarContract.CarColumns.YEAR_OF_RELEASE, year)
            put(CarContract.CarColumns.ENGINE, engine)
        }

        writableDatabase.insert(CarContract.TABLE_NAME, null, value)

    }

    fun updateCarName(carId: Long, carName: String) {

        val value = ContentValues().apply {
            put(CarContract.CarColumns.CAR_NAME, carName)
        }

        val where = "${CarContract.CarColumns.ID} = ?"
        val args = arrayOf(carId.toString())

        writableDatabase.update(
            CarContract.TABLE_NAME,
            value,
            where,
            args
        )

    }

    fun deleteCar(carId: Long) {

        val where = "${CarContract.CarColumns.ID} = ?"
        val args = arrayOf(carId.toString())

        writableDatabase.delete(CarContract.TABLE_NAME, where, args)

    }

    fun deleteAll() {
        writableDatabase.delete(CarContract.TABLE_NAME, null, null)
    }

    fun selectByYear(year: Int) {

        val projection = arrayOf(
            CarContract.CarColumns.CAR_NAME,
            CarContract.CarColumns.ENGINE,
            CarContract.CarColumns.ID
        )

        val where = "${CarContract.CarColumns.YEAR_OF_RELEASE} > ?"
        val args = arrayOf(year.toString())

        val ordering = "${CarContract.CarColumns.YEAR_OF_RELEASE} DESC"

        val cursor = readableDatabase.query(
            CarContract.TABLE_NAME,
            projection,
            where,
            args,
            null,
            null,
            ordering
        )


        while (cursor.moveToNext()) {

            val name = cursor.getString(cursor.getColumnIndex(CarContract.CarColumns.CAR_NAME))
            val engine = cursor.getFloat(cursor.getColumnIndex(CarContract.CarColumns.ENGINE))
            val id = cursor.getLong(cursor.getColumnIndex(CarContract.CarColumns.ID))

            Log.d("MyData", "$name - $engine - $id")

        }

        cursor.close()

    }

    fun updateToPorsche() {
        readableDatabase.execSQL(
            "UPDATE ${CarContract.TABLE_NAME} SET " +
                    "${CarContract.CarColumns.CAR_NAME} = 'Porsche' " +
                    "WHERE ${CarContract.CarColumns.YEAR_OF_RELEASE} > 2016"
        )
    }
}