package com.hogentessentials1.essentials.data.network.local

import com.hogentessentials1.essentials.DAOs.ChangeGroupDao
import com.hogentessentials1.essentials.data.model.ChangeGroup
import timber.log.Timber

class ChangeGroupLocalDataSource(val changeGroupDao: ChangeGroupDao) {
    fun getChangeGroups() = changeGroupDao.getChangeGroups()

    suspend fun saveChangeGroups(list: List<ChangeGroup>){
        changeGroupDao.deleteAll()
        changeGroupDao.insertAll(list)
    }
}
