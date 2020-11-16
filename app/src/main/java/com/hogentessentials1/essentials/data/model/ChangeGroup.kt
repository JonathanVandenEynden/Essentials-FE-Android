package com.hogentessentials1.essentials.data.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 * @author Simon De Wilde
 *
 * Dataclass for a change group
 *
 */
@Parcelize
data class ChangeGroup(
    val id: Number,
    val name: String,
    val users: List<String> // TODO echte employees van maken
) : Parcelable
