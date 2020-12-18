package com.hogentessentials1.essentials.data.network.local

import com.hogentessentials1.essentials.DAOs.ChangeInitiativeDao
import com.hogentessentials1.essentials.data.model.ChangeInitiative

/**
 * The local data source for change initiatives
 *
 * @property changeInitiativeDao
 */
class ChangeInitiativeLocalDataSource(val changeInitiativeDao: ChangeInitiativeDao) {
    /**
     * gets all change initiatives from the db
     *
     */
    fun getChangeInitiatives() = changeInitiativeDao.getChangeInitatives()

    /**
     * saves a list of change initiatives in the db
     *
     * @param list
     */
    suspend fun saveChangeInitiatives(list: List<ChangeInitiative>) {
        changeInitiativeDao.deleteAll()
        changeInitiativeDao.insertAll(list)
    }
}
