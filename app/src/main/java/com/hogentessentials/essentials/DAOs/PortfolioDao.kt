package com.hogentessentials.essentials.DAOs

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.hogentessentials.essentials.data.model.Portfolio

/**
 * @author Kilian Hoefman
 */

@Dao
interface PortfolioDao {
    @Query("SELECT * FROM portfolio ORDER BY portfolio_id")
    fun getPortfolios(): LiveData<List<Portfolio>>

    @Query("SELECT * FROM portfolio WHERE portfolio_id = :portfolioId")
    fun getPortfolio(portfolioId: Int): LiveData<Portfolio>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(portfolios: List<Portfolio>)
}
