package com.hogentessentials1.essentials.data.network.local

import com.hogentessentials1.essentials.data.model.ChangeInitiative
import com.hogentessentials1.essentials.DAOs.ChangeInitiativeDao

class ChangeInitiativeLocalDataSource(val changeInitiativeDao: ChangeInitiativeDao) {
    fun getChangeInitiatives() = changeInitiativeDao.getChangeInitatives()

    fun saveChangeInitiatives(list: List<ChangeInitiative>) = changeInitiativeDao.insertAll(list)
}
