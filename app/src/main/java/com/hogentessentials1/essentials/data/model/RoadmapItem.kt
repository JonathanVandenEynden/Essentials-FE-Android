package com.hogentessentials1.essentials.data.model

import android.os.Parcel
import android.os.Parcelable
import java.time.LocalDate
import java.util.*

/**
 * @author Marbod Naassens
 */
data class RoadmapItem (var title: String, var start: String, var end: String, var survey: Survey)  : Parcelable {

    constructor(parcel: Parcel) : this(parcel.readString()!!, parcel.readString()!!, parcel.readString()!!, parcel.readSerializable() as Survey) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(title)
        parcel.writeSerializable(start)
        parcel.writeSerializable(end)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<RoadmapItem> {
        override fun createFromParcel(parcel: Parcel): RoadmapItem {
            return RoadmapItem(parcel)
        }

        override fun newArray(size: Int): Array<RoadmapItem?> {
            return arrayOfNulls(size)
        }
    }
}