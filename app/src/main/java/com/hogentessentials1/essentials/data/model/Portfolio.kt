package com.hogentessentials1.essentials.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * @author Kilian Hoefman
 */

@Entity(tableName = "portfolio")
data class Portfolio(
    @PrimaryKey @ColumnInfo(name= "portfolio_id") val id: Int
) {
}