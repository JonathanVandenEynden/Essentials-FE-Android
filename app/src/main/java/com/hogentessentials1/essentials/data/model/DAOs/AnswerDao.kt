package com.hogentessentials1.essentials.data.model.DAOs

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.hogentessentials1.essentials.data.model.Answer

/**
 * @author Kilian Hoefman
 */

@Dao
interface AnswerDao {
    @Query("SELECT * FROM answer ORDER BY id")
    fun getAnswers(): LiveData<List<Answer>>

    @Query("SELECT * FROM answer WHERE id= :answerId")
    fun getAnswer(answerId: Int): LiveData<Answer>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(answers: List<Answer>)
}
