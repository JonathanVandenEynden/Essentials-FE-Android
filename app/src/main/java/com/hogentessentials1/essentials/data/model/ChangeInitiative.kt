package com.hogentessentials1.essentials.data.model

import android.os.Parcel
import android.os.Parcelable

/**
 * @author Ziggy Moens: made Parcelable
 */
data class ChangeInitiative(
    var title: String,
    var surveys: ArrayList<Survey> = arrayListOf()
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString()!!,
        arrayListOf<Survey>().apply {
            parcel.readList(this, SurveyQuestion::class.java.classLoader)
        }
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(title)
        parcel.writeList(surveys)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<ChangeInitiative> {
        override fun createFromParcel(parcel: Parcel): ChangeInitiative {
            return ChangeInitiative(parcel)
        }

        override fun newArray(size: Int): Array<ChangeInitiative?> {
            return arrayOfNulls(size)
        }
    }
}
