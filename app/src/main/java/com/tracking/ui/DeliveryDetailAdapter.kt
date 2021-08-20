package com.tracking.ui

import android.content.Context
import android.graphics.Color
import android.graphics.ColorFilter
import android.graphics.LightingColorFilter
import android.graphics.PorterDuff
import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.tracking.R
import kotlinx.android.synthetic.main.item_timeline.view.*
import java.util.*

class DeliveryDetailAdapter(
    private val mFeedList: List<TimeLineModel>,
    private var context: Context
) : RecyclerView.Adapter<DeliveryDetailAdapter.TimeLineViewHolder>() {

    private lateinit var mLayoutInflater: LayoutInflater

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TimeLineViewHolder {


            mLayoutInflater = LayoutInflater.from(parent.context)


        return TimeLineViewHolder(
            mLayoutInflater.inflate(R.layout.item_timeline, parent, false),
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

        if (timeLineModel.viewType.equals("dotted")){

        }
        if(position==0){
            holder.view1.visibility=View.INVISIBLE
         //   holder.view1.setBackgroundColor(Color.parseColor(mFeedList[position-1].view1Color))

            val myIcon = ContextCompat.getDrawable(context,R.drawable.dotted)
            val filter: ColorFilter = LightingColorFilter(Color.parseColor(timeLineModel.view2Color), Color.parseColor(timeLineModel.view2Color))
            myIcon?.colorFilter = filter
            if(timeLineModel.viewType.equals("dotted")){
                holder.view2.background=(myIcon)
            }else{
                val myIcon = ContextCompat.getDrawable(context,R.drawable.line)
                val filter: ColorFilter = LightingColorFilter(Color.parseColor(timeLineModel.view2Color), Color.parseColor(timeLineModel.view2Color))
                myIcon?.colorFilter = filter
                holder.view2.background=(myIcon)
               // holder.view2.setBackgroundColor(Color.parseColor(mFeedList[position].view2Color))
            }


        }else  if(position==mFeedList.size-1){
            holder.view2.visibility=View.INVISIBLE
           // holder.view1.setBackgroundColor(Color.parseColor(mFeedList[position-1].view1Color))
          //  holder.view2.setBackgroundColor(Color.parseColor(mFeedList[position].view2Color))

            val myIcon = ContextCompat.getDrawable(context,R.drawable.dotted)
            val filter: ColorFilter = LightingColorFilter(Color.parseColor(timeLineModel.view2Color), Color.parseColor(timeLineModel.view2Color))
            myIcon?.colorFilter = filter
            if(timeLineModel.viewType.equals("dotted")){
                holder.view2.background=(myIcon)
            }else{
                val myIcon = ContextCompat.getDrawable(context,R.drawable.line)
                val filter: ColorFilter = LightingColorFilter(Color.parseColor(timeLineModel.view2Color), Color.parseColor(timeLineModel.view2Color))
                myIcon?.colorFilter = filter
                holder.view2.background=(myIcon)
              //  holder.view2.setBackgroundColor(Color.parseColor(mFeedList[position].view2Color))
            }

            val myIcon1 = ContextCompat.getDrawable(context,R.drawable.dotted)
            val filter1: ColorFilter = LightingColorFilter(Color.parseColor(mFeedList[position-1].view1Color), Color.parseColor(mFeedList[position-1].view1Color))
            myIcon1?.colorFilter = filter1
            if(timeLineModel.viewType.equals("dotted")){
                holder.view1.background=(myIcon1)
            }else{
                val myIcon = ContextCompat.getDrawable(context,R.drawable.line)
                val filter: ColorFilter = LightingColorFilter(Color.parseColor(mFeedList[position-1].view1Color), Color.parseColor(mFeedList[position-1].view1Color))
                myIcon?.colorFilter = filter
                holder.view1.background=(myIcon)
               // holder.view1.setBackgroundColor(Color.parseColor(mFeedList[position-1].view1Color))
            }
        }else{
            holder.view1.visibility=View.VISIBLE
            holder.view1.setBackgroundColor(Color.parseColor(mFeedList[position-1].view1Color))
            holder.view2.setBackgroundColor(Color.parseColor(mFeedList[position].view2Color))


            val myIcon = ContextCompat.getDrawable(context,R.drawable.dotted)
            val filter: ColorFilter = LightingColorFilter(Color.parseColor(timeLineModel.view2Color), Color.parseColor(timeLineModel.view2Color))
            myIcon?.colorFilter = filter
            if(timeLineModel.viewType.equals("dotted")){
                holder.view2.background=(myIcon)
            }else{
                val myIcon = ContextCompat.getDrawable(context,R.drawable.line)
                val filter: ColorFilter = LightingColorFilter(Color.parseColor(mFeedList[position].view2Color), Color.parseColor(mFeedList[position].view2Color))
                myIcon?.colorFilter = filter
                holder.view2.background=(myIcon)
               // holder.view2.setBackgroundColor(Color.parseColor(mFeedList[position].view2Color))
            }

            val myIcon1 = ContextCompat.getDrawable(context,R.drawable.dotted)
            val filter1: ColorFilter = LightingColorFilter(Color.parseColor(mFeedList[position-1].view1Color), Color.parseColor(mFeedList[position-1].view1Color))
            myIcon1?.colorFilter = filter1
            if(timeLineModel.viewType.equals("dotted")){
                holder.view1.background=(myIcon1)
            }else{
                val myIcon = ContextCompat.getDrawable(context,R.drawable.line)
                val filter: ColorFilter = LightingColorFilter(Color.parseColor(mFeedList[position-1].view1Color), Color.parseColor(mFeedList[position-1].view1Color))
                myIcon?.colorFilter = filter
                holder.view1.background=(myIcon)
               // holder.view1.setBackgroundColor(Color.parseColor(mFeedList[position-1].view1Color))
            }
        }
      /* else{
            holder.view2.visibility=View.VISIBLE
            holder.view1.setBackgroundColor(Color.parseColor(mFeedList[position].view1Color))
            holder.view2.setBackgroundColor(Color.parseColor(mFeedList[position].view2Color))
        }*/

        val myIcon = ContextCompat.getDrawable(context,R.drawable.bg_circle)
        val filter: ColorFilter = LightingColorFilter(Color.parseColor(timeLineModel.circleColor), Color.parseColor(timeLineModel.circleColor))

        myIcon?.colorFilter = filter
        holder.rlText.background=(myIcon)



        holder.timeline.setText((position+1).toString())




        holder.message.text = timeLineModel.title
        holder.description.text = timeLineModel.decription
    }

    override fun getItemCount() = mFeedList.size

    inner class TimeLineViewHolder(itemView: View, viewType: Int) : RecyclerView.ViewHolder(itemView) {

        val description = itemView.text_timeline_date
        val message = itemView.text_timeline_title
        val timeline = itemView.timeline
        val rlText = itemView.rlText
        val view1 = itemView.view1
        val view2 = itemView.view2

        init {
        }
    }

}
