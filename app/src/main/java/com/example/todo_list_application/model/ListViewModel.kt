package com.example.todo_list_application.model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.todo_list_application.data.DataValues
import com.example.todo_list_application.databinding.FragmentFirstPageBinding

class ListViewModel: ViewModel()  {
private var binding: FragmentFirstPageBinding? = null
// DEFINING LISTS QUANTITY
   private val _quantityOfList = MutableLiveData <Int>()
    val quantityOfList = _quantityOfList
    // the title inserted by the user
   private val _textInserted = MutableLiveData <String>()
    val textInserted = _textInserted
    // date_to be made
   private val _dateAssigned = MutableLiveData <Int>()
    val dateAssigned = _dateAssigned

    fun setQuantity(){

    }
    fun setText(userInput : String) {
        _textInserted.value = userInput
    }
    fun setDate() {

    }





}