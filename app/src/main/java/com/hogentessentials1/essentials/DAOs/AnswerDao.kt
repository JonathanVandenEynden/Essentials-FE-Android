package com.hogentessentials1.essentials.DAOs

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.hogentessentials1.essentials.data.model.Answer

/**
 * Dao for the answer-entity
 *
 * @author Kilian Hoefman
 *
 */

@Dao
interface AnswerDao {
    /**
     * @return list of all answers ordered by Id
     */
    @Query("SELECT * FROM answer ORDER BY id")
    fun getAnswers(): LiveData<List<Answer>>

    /**
     * @return answer with specific id
     * @param answerId
     */
    @Query("SELECT * FROM answer WHERE id= :answerId")
    fun getAnswer(answerId: Int): LiveData<Answer>

    /**
     * inserts a list of Answers to the database
     * @param answers: list of answers
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(answers: List<Answer>)
}
