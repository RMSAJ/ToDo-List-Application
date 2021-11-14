package com.example.todo_list_application.model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ListViewModel: ViewModel()  {

// DEFINING LISTS QUANTITY
   private val _quantityOfList = MutableLiveData <Int>()
    val quantityOfList = _quantityOfList
    // the title inserted by the user
   private val _textInserted = MutableLiveData <Int>()
    val textInserted = _textInserted
    // date_to be made
   private val _dateAssigned = MutableLiveData <Int>()
    val dateAssigned = _dateAssigned

    fun setQuantity(){

    }
    fun setText(){

    }
    fun setDate(){

    }



}