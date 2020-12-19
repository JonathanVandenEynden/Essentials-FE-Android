package com.hogentessentials1.essentials.data.network.local

import com.hogentessentials1.essentials.DAOs.ChangeGroupDao
import com.hogentessentials1.essentials.data.model.ChangeGroup

/**
 * The local data source for change groups
 *
 * @author Simon De Wilde
 *
 * @property changeGroupDao
 */
class ChangeGroupLocalDataSource(val changeGroupDao: ChangeGroupDao) {
    /**
     * gets all change groups from the db
     *
     */
    fun getChangeGroups() = changeGroupDao.getChangeGroups()

    /**
     * saves a list of change groups in the db
     *
     * @param list
     */
    suspend fun saveChangeGroups(list: List<ChangeGroup>) {
        changeGroupDao.deleteAll()
        changeGroupDao.insertAll(list)
    }
}
