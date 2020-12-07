package com.hogentessentials.essentials.DAOs

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.hogentessentials.essentials.data.model.Feedback

/**
 * @author Kilian Hoefman
 */

@Dao
interface FeedbackDao {
    @Query("SELECT * FROM feedback ORDER BY id")
    fun getFeedbacks(): LiveData<List<Feedback>>

    @Query("SELECT * FROM feedback WHERE id= :feedbackId")
    fun getFeedback(feedbackId: Int): LiveData<Feedback>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(feedbacks: List<Feedback>)
}
