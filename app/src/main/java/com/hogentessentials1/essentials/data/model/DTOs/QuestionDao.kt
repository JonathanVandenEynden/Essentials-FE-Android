package com.hogentessentials1.essentials.data.model.DTOs

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.hogentessentials1.essentials.data.model.Question

/**
 * @author Kilian Hoefman
 */

@Dao
interface QuestionDao {
    @Query("SELECT * FROM questions ORDER BY id")
    fun getQuestions(): LiveData<List<Question>>

    @Query("SELECT * FROM questions WHERE id = :questionId")
    fun getQuestion(questionId: Int): LiveData<Question>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(questions: List<Question>)
}