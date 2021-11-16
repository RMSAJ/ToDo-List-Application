package com.example.todo_list_application.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.todo_list_application.R
import com.example.todo_list_application.data.DataValues
import com.example.todo_list_application.data.myList
import javax.sql.DataSource

class Adapterdo(
private val context:Context,
private val itemLists: MutableList<DataValues> = myList) : RecyclerView.Adapter<Adapterdo.DoListViewHolder>() {


class DoListViewHolder(val view: View?) :RecyclerView.ViewHolder(view!!){
      val checkView: CheckBox? = view?.findViewById(R.id.finishedCheckBox)
      val dateTextView: TextView? = view?.findViewById(R.id.dateText)
      val editButtonView: Button? = view?.findViewById(R.id.editButton)
      val titleView: TextView? = view?.findViewById(R.id.titleText)
      val cardView: CardView? = view?.findViewById(R.id.mainItemCard)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DoListViewHolder {
        val adpterLayout = LayoutInflater.from(parent.context).inflate(R.layout.fragment_detail__item_, parent, false)
        return DoListViewHolder(adpterLayout)
    }

    override fun onBindViewHolder(holder: DoListViewHolder, position: Int) {
        val item = itemLists[position]
        holder.checkView?.isChecked = item.urgency
        holder.titleView?.text = item.title
        holder.dateTextView?.text = item.date
    }

    override fun getItemCount(): Int {
        return  itemLists.size
    }

}


