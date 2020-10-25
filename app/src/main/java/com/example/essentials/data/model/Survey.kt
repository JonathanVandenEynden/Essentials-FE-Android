package com.example.essentials.data.model

import android.os.Parcel
import android.os.Parcelable

data class Survey(
    var name: String,
    var questions: ArrayList<SurveyQuestion>
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString()!!,
        // Solution found --> https://stackoverflow.com/questions/45459273/kotlin-parcelable-and-arraylist-of-parcelables
        arrayListOf<SurveyQuestion>().apply {
            parcel.readList(this, SurveyQuestion::class.java.classLoader)
        }
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeList(questions)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Survey> {
        override fun createFromParcel(parcel: Parcel): Survey {
            return Survey(parcel)
        }

        override fun newArray(size: Int): Array<Survey?> {
            return arrayOfNulls(size)
        }
    }
}
