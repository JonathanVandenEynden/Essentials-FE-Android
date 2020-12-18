package com.hogentessentials1.essentials.data.repositories

import com.hogentessentials1.essentials.DAOs.ChangeTypeDao
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Repository for change type
 * @author Kilian Hoefman
 *
 * @property changeTypeDao
 */
@Singleton
class ChangeTypeRepository @Inject constructor(private val changeTypeDao: ChangeTypeDao) {

    /**
     * get all change types
     * @return liveData with list of change types
     */
    fun getChangeTypes() = changeTypeDao.getChangeTypes()

    /**
     * get change type by id
     * @param changeTypeId
     * @return LiveData with change type
     */
    fun getChangeType(changeTypeId: Int) = changeTypeDao.getChangeType(changeTypeId)
}
