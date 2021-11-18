package com.example.todo_list_application.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.cardview.widget.CardView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.todo_list_application.R
import com.example.todo_list_application.data.DataValues
import com.example.todo_list_application.data.myList
import com.example.todo_list_application.fragments.Detail_Item_Fragment
import com.example.todo_list_application.fragments.Detail_Item_FragmentDirections
import com.example.todo_list_application.fragments.Detail_List_Fragment.Companion.title
import com.example.todo_list_application.fragments.FirstPageFragmentDirections
import javax.sql.DataSource

class Adapterdo(
private val context:Context,
private val itemLists: MutableList<DataValues> = myList) : RecyclerView.Adapter<Adapterdo.DoListViewHolder>() {


    class DoListViewHolder(val view: View?) : RecyclerView.ViewHolder(view!!) {
        val checkView: CheckBox? = view?.findViewById(R.id.finishedCheckBox)
        val dateTextView: TextView? = view?.findViewById(R.id.dateText)
        val editButtonView: Button? = view?.findViewById(R.id.editButton)
        val titleView: TextView? = view?.findViewById(R.id.titleText)
        val cardView: CardView? = view?.findViewById(R.id.mainItemCard)
        val numberedView: TextView? = view?.findViewById(R.id.countNumber)
        val deletButton: ImageView? = view?.findViewById(R.id.deleteImage)

//        val detailTitle: TextView? = view?.findViewById(R.id.Edit_writing_list)
//        val detaiButton: Button? = view?.findViewById(R.id.save_continue_Button)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DoListViewHolder {
        val adpterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.fragment_detail__item_, parent, false)
        return DoListViewHolder(adpterLayout)
    }

    @SuppressLint("NotifyDataSetChanged")
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onBindViewHolder(holder: DoListViewHolder, position: Int) {
        val item = itemLists[position]
        holder.checkView?.setOnClickListener { item.finishing }
        holder.numberedView?.text = item.quntity.toString()
        holder.titleView?.text = item.title
        holder.dateTextView?.text = item._date
        holder.cardView?.setOnClickListener {
        item.urgency
        }
        holder.deletButton?.setOnClickListener {
            itemLists.removeAt(position)
            notifyDataSetChanged()
        }


        holder.editButtonView?.setOnClickListener {
            val action = FirstPageFragmentDirections.actionFirstPageFragmentToDetailListFragment (
                title = item.title,
                description = item.detail
                    )

            holder.itemView.findNavController().navigate(action)
        }
    }
        override fun getItemCount(): Int {
            return itemLists.size
        }

}


