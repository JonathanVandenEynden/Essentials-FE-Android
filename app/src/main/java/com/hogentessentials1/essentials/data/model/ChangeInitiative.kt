package com.hogentessentials1.essentials.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

/**
 * @author Ziggy Moens: made Parcelable
 * @author Kilian Hoefman: start of Dataclass
 */

@Entity(tableName = "changeInitiative")
data class ChangeInitiative(
    @PrimaryKey val id: Int,
    val title: String,
    val description: String,
    val startDate: Date,
    val endDate: Date,
    val changeGroup: ChangeGroup,
    val changeSponsor: Employee,
    val changeType: ChangeType,
    val roadMapItem: RoadMapItem
){

}


//data class ChangeInitiative(
//    var title: String,
//    var surveys: ArrayList<Survey> = arrayListOf()
//) : Parcelable {
//    constructor(parcel: Parcel) : this(
//        parcel.readString()!!,
//        arrayListOf<Survey>().apply {
//            parcel.readList(this, SurveyQuestion::class.java.classLoader)
//        }
//    ) {
//    }
//
//    override fun writeToParcel(parcel: Parcel, flags: Int) {
//        parcel.writeString(title)
//        parcel.writeList(surveys)
//    }
//
//    override fun describeContents(): Int {
//        return 0
//    }
//
//    companion object CREATOR : Parcelable.Creator<ChangeInitiative> {
//        override fun createFromParcel(parcel: Parcel): ChangeInitiative {
//            return ChangeInitiative(parcel)
//        }
//
//        override fun newArray(size: Int): Array<ChangeInitiative?> {
//            return arrayOfNulls(size)
//        }
//    }
//}
