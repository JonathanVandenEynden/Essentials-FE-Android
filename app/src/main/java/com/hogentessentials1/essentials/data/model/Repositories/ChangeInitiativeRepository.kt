package com.hogentessentials1.essentials.data.model.Repositories

import com.hogentessentials1.essentials.data.model.DAOs.ChangeInitiativeDao
import javax.inject.Inject
import javax.inject.Singleton

/**
 * @author Kilian Hoefman
 */

@Singleton
class ChangeInitiativeRepository @Inject constructor(private val changeInitiativeDao: ChangeInitiativeDao) {

    fun getChangeInitiatives() = changeInitiativeDao.getChangeInitatives()

    fun getChangeInitiative(changeInitiativeId: Int) = changeInitiativeDao.getChangeInitative(changeInitiativeId)
}