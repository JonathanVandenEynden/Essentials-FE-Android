package com.hogentessentials1.essentials.data.repositories

import com.hogentessentials1.essentials.DAOs.PortfolioDao
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Repository for portfolios
 * @author Kilian Hoefman
 *
 * @property portfolioDao
 */
@Singleton
class PortfolioRepository @Inject constructor(private val portfolioDao: PortfolioDao) {

    /**
     * get all portfolios
     * @return liveData with list of portfolios
     */
    fun getPortfolios() = portfolioDao.getPortfolios()

    /**
     * get portfolio by id
     * @param portfolioId
     * @return LiveData with portfolio
     */
    fun getPortfolio(portfolioId: Int) = portfolioDao.getPortfolio(portfolioId)
}
