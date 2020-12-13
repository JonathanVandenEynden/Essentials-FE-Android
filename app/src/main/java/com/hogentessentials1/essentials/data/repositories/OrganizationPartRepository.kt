package com.hogentessentials1.essentials.data.repositories

import com.hogentessentials1.essentials.DAOs.OrganizationPartDao
import javax.inject.Inject
import javax.inject.Singleton

/**
 * @author Kilian Hoefman
 */

@Singleton
class OrganizationPartRepository @Inject constructor(private val organizationPartDao: OrganizationPartDao) {

    fun getOrganizationParts() = organizationPartDao.getOrganizationParts()

    fun getOrganizationPart(organizationPartId: Int) = organizationPartDao.getOrganizationPart(organizationPartId)
}
