package com.hogentessentials1.essentials.data.model.Repositories

import com.hogentessentials1.essentials.data.model.DAOs.PortfolioDao
import javax.inject.Inject
import javax.inject.Singleton

/**
 * @author Kilian Hoefman
 */

@Singleton
class PortfolioRepository @Inject constructor(private val portfolioDao: PortfolioDao){

    fun getPortfolios() = portfolioDao.getPortfolios()

    fun getPortfolio(portfolioId: Int) = portfolioDao.getPortfolio(portfolioId)
}