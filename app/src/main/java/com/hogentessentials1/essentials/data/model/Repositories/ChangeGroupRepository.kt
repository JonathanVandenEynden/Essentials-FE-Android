package com.hogentessentials1.essentials.data.model.Repositories

import com.hogentessentials1.essentials.data.model.DAOs.ChangeGroupDao
import javax.inject.Inject
import javax.inject.Singleton

/**
 * @author Kilian Hoefman
 */

@Singleton
class ChangeGroupRepository @Inject constructor(private val changeGroupDao: ChangeGroupDao) {

    fun getChangeGroups() = changeGroupDao.getChangeGroups()

    fun getChangeGroup(changeGroupId: Int) = changeGroupDao.getChangeGroup(changeGroupId)
}
