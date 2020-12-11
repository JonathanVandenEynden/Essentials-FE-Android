package com.hogentessentials1.essentials.data.repositories

import com.hogentessentials1.essentials.DAOs.OrganizationPartDao
import javax.inject.Inject
import javax.inject.Singleton

/**
 * @author Kilian Hoefman
 *
 * Repository for organization parts
 */

@Singleton
class OrganizationPartRepository @Inject constructor(private val organizationPartDao: OrganizationPartDao) {

    /**
     * get all organization parts
     * @return liveData with list of organization parts
     */
    fun getOrganizationParts() = organizationPartDao.getOrganizationParts()

    /**
     * get organization parts by id
     * @param organizationPartId
     * @return LiveData with organization parts
     */
    fun getOrganizationPart(organizationPartId: Int) = organizationPartDao.getOrganizationPart(organizationPartId)
}
