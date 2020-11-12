package com.hogentessentials1.essentials.data.model

/**
 * @author Simon De Wilde
 *
 * Dataclass for a change group
 *
 */
data class ChangeGroup(
    val id: Long,
    val name: String,
    val members: List<String>) {
}