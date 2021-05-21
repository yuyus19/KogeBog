package com.example.kogebog.dataBase

import android.content.Context
import androidx.room.Room.databaseBuilder
import androidx.room.RoomDatabase

class Database {
    @androidx.room.Database(entities = arrayOf(entity::class), version = 1, exportSchema = false)
    public abstract class Database : RoomDatabase() {
        abstract fun dao(): Dao

        companion object {
            @Volatile

            private var INSTANCE: com.example.kogebog.dataBase.Database? = null
            fun getDatabase(context: Context): com.example.kogebog.dataBase.Database {

                return (INSTANCE ?: synchronized(this) {
                    val instance = databaseBuilder(
                        context.applicationContext,
                        com.example.kogebog.dataBase.Database::class,
                        "Favoritter").build()

                    INSTANCE = instance
                    return instance
                })
            }
        }
    }
}