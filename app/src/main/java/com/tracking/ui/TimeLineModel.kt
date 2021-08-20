package com.tracking.ui
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@Parcelize
class TimeLineModel(
        var title: String,
        var decription: String,
        var circleColor: String,
        var view1Color: String,
        var view2Color: String,
        var viewType: String

) : Parcelable
