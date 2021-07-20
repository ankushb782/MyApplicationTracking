package com.tracking.ui
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@Parcelize
class TimeLineModel(
        var title: String,
        var decription: String

) : Parcelable
