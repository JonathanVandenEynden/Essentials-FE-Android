package com.hogentessentials1.essentials.DAOs

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.hogentessentials1.essentials.data.model.Question

/**
 * Dao for the question-entity
 * @author Kilian Hoefman
 */

@Dao
interface QuestionDao {
    /**
     * @return list of all question ordered by Id
     */
    @Query("SELECT * FROM questions ORDER BY id")
    fun getQuestions(): LiveData<List<Question>>

    /**
     * @return list of all question ordered by Id
     */
    @Query("SELECT * FROM questions WHERE id = :questionId")
    fun getQuestion(questionId: Int): LiveData<Question>

    /**
     * inserts a list of questions to the database
     * @param questions: list of question
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(questions: List<Question>)
}
