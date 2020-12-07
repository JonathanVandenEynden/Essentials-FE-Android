package com.hogentessentials.essentials.DAOs

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.hogentessentials.essentials.data.model.Assessment

/**
 * @author Kilian Hoefman
 */

@Dao
interface AssessmentDao {
    @Query("SELECT * FROM assessment ORDER BY id")
    fun getAssessments(): LiveData<List<Assessment>>

    @Query("SELECT * FROM assessment WHERE id= :assessmentId")
    fun getAssessment(assessmentId: Int): LiveData<Assessment>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(assessments: List<Assessment>)
}
