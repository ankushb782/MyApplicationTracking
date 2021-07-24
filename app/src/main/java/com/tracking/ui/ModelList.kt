package com.tracking.ui
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@Parcelize
class ModelList(
        var list: MutableList<TimeLineModel> = mutableListOf<TimeLineModel>()


) : Parcelable
