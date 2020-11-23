package com.hogentessentials1.essentials.data.model

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

/**
 * @author Ziggy Moens: Start data class & made Parcelable
 */

@Parcelize
data class Survey(
    val id: Int = 20, // TODO niet hardcoden
    val name: String, // TODO wegdoen
//  val questions: ArrayList<Question>, // TODO terug insteken
    val questions: ArrayList<SurveyQuestion>, // TODO verwijderen
    val feedback: Question = Question("10", hashMapOf("key" to 1),"test", "1", hashMapOf("String" to 3)), // TODO niet hardcoden
    val amountSubmitted: Int = 20 // TODO niet hardcoden
) : Parcelable
//data class Survey(
//    @Json(name = "id")
//    val id: Number,
//    @Json(name = "questions")
//    val questions: ArrayList<Question>,
//    @Json(name = "feedback")
//    val feedback: Question,
//    @Json(name = "roadMapItemId")
//    val roadMapItemId: Number,
//    @Json(name = "roadMapItem")
//    val roadMapItem: RoadMapItem
//) : Parcelable

// data class Survey(
//    var name: String,
//    var questions: ArrayList<SurveyQuestion>
// ) : Parcelable {
//    constructor(parcel: Parcel) : this(
//        parcel.readString()!!,
//        // Solution found --> https://stackoverflow.com/questions/45459273/kotlin-parcelable-and-arraylist-of-parcelables
//        arrayListOf<SurveyQuestion>().apply {
//            parcel.readList(this, SurveyQuestion::class.java.classLoader)
//        }
//    ) {
//    }
//
//    override fun writeToParcel(parcel: Parcel, flags: Int) {
//        parcel.writeString(name)
//        parcel.writeList(questions)
//    }
//
//    override fun describeContents(): Int {
//        return 0
//    }
//
//    companion object CREATOR : Parcelable.Creator<Survey> {
//        override fun createFromParcel(parcel: Parcel): Survey {
//            return Survey(parcel)
//        }
//
//        override fun newArray(size: Int): Array<Survey?> {
//            return arrayOfNulls(size)
//        }
//    }
// }
