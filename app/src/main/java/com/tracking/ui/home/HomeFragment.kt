package com.tracking.ui.home

import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.tracking.R
import com.tracking.ui.DeliveryDetailAdapter
import com.tracking.ui.ProgressStage
import com.tracking.ui.TimeLineModel
import kotlinx.android.synthetic.*
import kotlinx.android.synthetic.main.fragment_home.*
import java.util.*

class HomeFragment : Fragment() {

  //  private lateinit var homeViewModel: HomeViewModel
    private lateinit var mAdapter: DeliveryDetailAdapter
    private val mDataList = ArrayList<TimeLineModel>()
    private lateinit var mLayoutManager: LinearLayoutManager
    var recyclerView:RecyclerView?=null
    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
       // homeViewModel = ViewModelProviders.of(this).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_home, container, false)
     /*   homeViewModel.text.observe(viewLifecycleOwner, Observer {
          //  textView.text = it
        })*/

       var imageView:ImageView =root!!.findViewById(R.id.imageView)
        recyclerView =root!!.findViewById(R.id.recyclerView)
        imageView.setOnClickListener {
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
        assignData()
        initAdapter()
        return root
    }
    private fun initAdapter() {
        mLayoutManager = LinearLayoutManager(activity, RecyclerView.VERTICAL, false)
        recyclerView?.layoutManager=LinearLayoutManager(activity, RecyclerView.VERTICAL, false)
        mAdapter =  DeliveryDetailAdapter(mDataList,requireActivity())
        recyclerView?.adapter=mAdapter
    }


    fun assignData(){

        mDataList.add(TimeLineModel("CARLISLE,PA","Jul 29 @0800 - 2000 EDT"))
        mDataList.add(TimeLineModel("CARLISLE,PA","Jul 29 @0800 - 2000 EDT"))
        mDataList.add(TimeLineModel("CARLISLE,PA","Jul 29 @0800 - 2000 EDT"))
        mDataList.add(TimeLineModel("CARLISLE,PA","Jul 29 @0800 - 2000 EDT"))
        mDataList.add(TimeLineModel("CARLISLE,PA","Jul 29 @0800 - 2000 EDT"))


    }
}