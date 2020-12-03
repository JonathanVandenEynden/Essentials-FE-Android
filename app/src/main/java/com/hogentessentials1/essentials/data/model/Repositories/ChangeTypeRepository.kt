package com.hogentessentials1.essentials.data.model.Repositories

import com.hogentessentials1.essentials.data.model.DAOs.ChangeTypeDao
import javax.inject.Inject
import javax.inject.Singleton

/**
 * @author Kilian Hoefman
 */

@Singleton
class ChangeTypeRepository @Inject constructor(private val changeTypeDao: ChangeTypeDao) {

    fun getChangeTypes() = changeTypeDao.getChangeTypes()

    fun getChangeType(changeTypeId: Int) = changeTypeDao.getChangeType(changeTypeId)
}
