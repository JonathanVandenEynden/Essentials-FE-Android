package com.hogentessentials1.essentials.data.model

import androidx.room.Entity

@Entity
data class ChangeManager(
    val id: Int,
    val firstName: String,
    val lastName: String,
    val email: String,
    val createdChangeInitiatives: List<ChangeInitiative>
)
