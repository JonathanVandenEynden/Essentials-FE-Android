package com.hogentessentials1.essentials.data.model.network

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.hogentessentials1.essentials.data.model.*
import com.hogentessentials1.essentials.data.model.DAOs.*
import com.hogentessentials1.essentials.data.model.network.converters.*

/**
 * @author Simon De Wilde
 * @author Kilian Hoefman
 */

@Database(
    entities = [Project::class, Employee::class, ChangeInitiative::class, RoadMapItem::class, ChangeGroup::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(
    EmployeeConverter::class,
    ChangeInitiativeConverter::class,
    ChangeGroupConverter::class,
    ProjectConverter::class,
    RoadMapItemConverter::class,
    AssessmentConverter::class,
    EmployeeArrayConverter::class,
    ChangeTypeConverter::class
)

abstract class EssentialsDatabase : RoomDatabase() {
    abstract fun EmployeeDao(): EmployeeDao
    abstract fun ChangeInitiativeDao(): ChangeInitiativeDao
    abstract fun ChangeGroupDao(): ChangeGroupDao
    abstract fun ProjectDao(): ProjectDao
    abstract fun RoadMapDao(): RoadMapDao

    companion object {
        @Volatile
        private var INSTANCE: EssentialsDatabase? = null

        fun getInstance(context: Context): EssentialsDatabase =
            INSTANCE ?: synchronized(this) {
                INSTANCE ?: buildDatabase(context).also {
                    INSTANCE = it
                }
            }

        private fun buildDatabase(appContext: Context) =
            Room.databaseBuilder(appContext, EssentialsDatabase::class.java, "essentials_db")
                .fallbackToDestructiveMigration()
                .build()

//        fun getInstance(context: Context): EssentialsDatabase {
//            synchronized(this) {
//                var instance = INSTANCE
//
//                if (instance == null) {
//                    instance = Room.databaseBuilder(
//                        context.applicationContext,
//                        EssentialsDatabase::class.java,
//                        "essentials_db"
//                    )
//                        .fallbackToDestructiveMigration()
//                        .build()
//                    INSTANCE = instance
//                }
//                return instance
//            }
//        }
    }
}
