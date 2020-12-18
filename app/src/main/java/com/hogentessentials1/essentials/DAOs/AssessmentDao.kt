package com.hogentessentials1.essentials.DAOs

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.hogentessentials1.essentials.data.model.Assessment

/**
 * Dao for the assesment-entity

 * @author Kilian Hoefman
 */

@Dao
interface AssessmentDao {
    /**
     * @return list of all assessments ordered by Id
     */
    @Query("SELECT * FROM assessment ORDER BY id")
    fun getAssessments(): LiveData<List<Assessment>>

    /**
     * @return assessment with specific id
     * @param assessmentId
     */
    @Query("SELECT * FROM assessment WHERE id= :assessmentId")
    fun getAssessment(assessmentId: Int): LiveData<Assessment>

    /**
     * inserts a list of assessments to the database
     * @param assessments: list of assessments
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(assessments: List<Assessment>)
}
