package com.hogentessentials1.essentials.DAOs

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.hogentessentials1.essentials.data.model.Feedback

/**
 * Dao for the feedback-entity
 * @author Kilian Hoefman
 */

@Dao
interface FeedbackDao {
    /**
     * @return list of all feedback ordered by Id
     */
    @Query("SELECT * FROM feedback ORDER BY id")
    fun getFeedbacks(): LiveData<List<Feedback>>

    /**
     * @return list of all feedback ordered by Id
     */
    @Query("SELECT * FROM feedback WHERE id= :feedbackId")
    fun getFeedback(feedbackId: Int): LiveData<Feedback>

    /**
     * inserts a list of feedbacks to the database
     * @param feedbacks: list of feedback
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(feedbacks: List<Feedback>)
}
