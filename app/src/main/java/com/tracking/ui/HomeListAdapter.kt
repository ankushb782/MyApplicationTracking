package com.tracking.ui

import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.graphics.Color
import android.graphics.ColorFilter
import android.graphics.LightingColorFilter
import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.tracking.R
import kotlinx.android.synthetic.main.fragment_home.view.*
import kotlinx.android.synthetic.main.home_list_item.view.*
import kotlinx.android.synthetic.main.home_list_item.view.recyclerView
import kotlinx.android.synthetic.main.item_timeline.view.*
import java.util.*

class HomeListAdapter(
    private val mFeedList: List<ModelList>,
    private var context: Context
) : RecyclerView.Adapter<HomeListAdapter.TimeLineViewHolder>() {

    private lateinit var mLayoutInflater: LayoutInflater

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TimeLineViewHolder {


            mLayoutInflater = LayoutInflater.from(parent.context)


        return TimeLineViewHolder(
            mLayoutInflater.inflate(R.layout.home_list_item, parent, false),
            viewType
        )
    }

    private var statusActive = false


    @RequiresApi(Build.VERSION_CODES.M)
    fun changeConnectingLineColor(holder: TimeLineViewHolder, view1: Int, view2: Int){


    }




    @RequiresApi(Build.VERSION_CODES.M)
    override fun onBindViewHolder(holder: TimeLineViewHolder, position: Int) {


        val timeLineModel = mFeedList[position]


       val mAdapter:DeliveryDetailAdapter =  DeliveryDetailAdapter(timeLineModel.list,context)
        holder.recyclerView?.adapter=mAdapter

        holder.imageView.setOnClickListener {
            val builder =
                AlertDialog.Builder(context)
            builder.setTitle("Your desired title")
            builder.setMessage("msg")
            builder.setCancelable(true)
            builder.setPositiveButton("Yes") { dialogInterface: DialogInterface?, i: Int ->
                //  dialogListener.onPositiveClick()
                dialogInterface?.dismiss()
            }
            builder.setNegativeButton("No")
            { dialogInterface: DialogInterface?, i: Int ->
                //   dialogListener.onNegativeClick()
                dialogInterface?.dismiss()
            }
            val alertDialog = builder.create()
            alertDialog.show()
        }
    }

    override fun getItemCount() = mFeedList.size

    inner class TimeLineViewHolder(itemView: View, viewType: Int) : RecyclerView.ViewHolder(itemView) {

        var imageView = itemView.imageViewKabob
        val recyclerView = itemView.recyclerView
        var mLayoutManager: LinearLayoutManager
        init {
            mLayoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
            recyclerView?.layoutManager=LinearLayoutManager(context, RecyclerView.VERTICAL, false)

        }
    }

}
