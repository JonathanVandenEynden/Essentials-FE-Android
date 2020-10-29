package com.hogentessentials1.essentials.data.model

import android.os.Parcel
import android.os.Parcelable

/**
 * @author Ziggy Moens: start data class & made Parcelable
 */

data class SurveyQuestion(
    var question: String,
    var option0: String,
    var option5: String,
    var answer: Double = -1.0
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readDouble()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(question)
        parcel.writeString(option0)
        parcel.writeString(option5)
        parcel.writeDouble(answer)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<SurveyQuestion> {
        override fun createFromParcel(parcel: Parcel): SurveyQuestion {
            return SurveyQuestion(parcel)
        }

        override fun newArray(size: Int): Array<SurveyQuestion?> {
            return arrayOfNulls(size)
        }
    }
}
