package com.hogentessentials.essentials.data.network.local

import com.hogentessentials.essentials.DAOs.ChangeGroupDao
import com.hogentessentials.essentials.data.model.ChangeGroup

class ChangeGroupLocalDataSource(val changeGroupDao: ChangeGroupDao) {
    fun getChangeGroups() = changeGroupDao.getChangeGroups()

    fun saveChangeGroups(list: List<ChangeGroup>) = changeGroupDao.insertAll(list)
}
