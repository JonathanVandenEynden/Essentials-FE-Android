package com.hogentessentials1.essentials.data.network.local

import com.hogentessentials1.essentials.data.model.ChangeGroup
import com.hogentessentials1.essentials.DAOs.ChangeGroupDao

class ChangeGroupLocalDataSource(val changeGroupDao: ChangeGroupDao) {
    fun getChangeGroups() = changeGroupDao.getChangeGroups()

    fun saveChangeGroups(list: List<ChangeGroup>) = changeGroupDao.insertAll(list)
}
