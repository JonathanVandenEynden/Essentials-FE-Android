package com.hogentessentials1.essentials.data.model

/**
 * @author Ziggy Moens: Start data class & made Parcelable
 */

data class Survey(
    val id: Int = 20, // TODO niet hardcoden
    val name: String, // TODO wegdoen
//  val questions: ArrayList<Question>, // TODO terug insteken
    val questions: ArrayList<SurveyQuestion>, // TODO verwijderen
    val feedback: Question = Question(10, "randovraag"), // TODO niet hardcoden
    val amountSubmitted: Int = 20 // TODO niet hardcoden
)

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
