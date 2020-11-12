package com.hogentessentials1.essentials.data.model

import androidx.room.Entity

@Entity(tableName = "organization")
data class Organization(
    val id: Int,
    val name: String
) {
}