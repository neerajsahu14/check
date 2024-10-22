package com.example.check.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Persons::class], version = 1, exportSchema = false)
abstract class PersonsDataBase : RoomDatabase() {
    abstract fun personDao(): PersonDao

}