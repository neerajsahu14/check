package com.example.check

class PersonRepository {
    private val persons = listOf(
        Person(1, "John", "Doe", 25),
        Person(2, "Jane", "Doe", 23),
        Person(3, "Alice", "Smith", 29),
        Person(4, "Bob", "Johnson", 31),
        Person(5, "Mike", "Brown", 22),
        Person(6, "Sara", "Wilson", 24),
        Person(7, "Tom", "Davis", 27),
        Person(8, "Emily", "Moore", 26),
        Person(9, "Olivia", "Taylor", 28),
        Person(10, "James", "Anderson", 30),
    )

    fun getAllData() = persons
}