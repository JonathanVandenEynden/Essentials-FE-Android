package com.hogentessentials1.essentials.DAOs

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.hogentessentials1.essentials.data.model.Portfolio

/**
 * @author Kilian Hoefman
 * Dao for the portfolio-entity
 */

@Dao
interface PortfolioDao {
    /**
     * @return list of all portfolio ordered by Id
     */
    @Query("SELECT * FROM portfolio ORDER BY portfolio_id")
    fun getPortfolios(): LiveData<List<Portfolio>>

    /**
     * @return list of all portfolio ordered by Id
     */
    @Query("SELECT * FROM portfolio WHERE portfolio_id = :portfolioId")
    fun getPortfolio(portfolioId: Int): LiveData<Portfolio>

    /**
     * inserts a list of portfolios to the database
     * @param portfolios: list of portfolio
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(portfolios: List<Portfolio>)
}
