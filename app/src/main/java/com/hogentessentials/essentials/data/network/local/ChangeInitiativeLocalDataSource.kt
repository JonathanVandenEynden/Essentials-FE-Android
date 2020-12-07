package com.hogentessentials.essentials.data.network.local

import com.hogentessentials.essentials.DAOs.ChangeInitiativeDao
import com.hogentessentials.essentials.data.model.ChangeInitiative

class ChangeInitiativeLocalDataSource(val changeInitiativeDao: ChangeInitiativeDao) {
    fun getChangeInitiatives() = changeInitiativeDao.getChangeInitatives()

    fun saveChangeInitiatives(list: List<ChangeInitiative>) = changeInitiativeDao.insertAll(list)
}
