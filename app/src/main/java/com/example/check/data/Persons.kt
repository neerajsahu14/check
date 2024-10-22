package com.example.check.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "persons")
data class Persons(
  @PrimaryKey(autoGenerate = true) val id: Int = 0,
  val name: String,
  val age: Int
)