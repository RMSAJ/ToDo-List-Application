package com.example.todo_list_application.model

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.todo_list_application.data.DataValues
import com.example.todo_list_application.data.myList
import com.example.todo_list_application.databinding.FragmentFirstPageBinding
import com.google.android.material.datepicker.MaterialDatePicker
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.util.*

class ListViewModel: ViewModel()  {

 private   var clicksTitle = 0
    private var dateClick = 0
    private var importantClicke = 0
    private var finishedClick = 0
private var binding: FragmentFirstPageBinding? = null
// DEFINING LISTS QUANTITY
   private var _quantityOfList = MutableLiveData <Int>()
    val quantityOfList: LiveData<Int> get() = _quantityOfList
    // the title inserted by the user
   private val _textInserted = MutableLiveData <String>()
    val textInserted: LiveData<String> = _textInserted
    // date_to be made
   private val _dateAssigned = MutableLiveData <String>()
    val dateAssigned = _dateAssigned
    private val _isImportant = MutableLiveData<Boolean>()
    val isImportant = _isImportant
    private val _isFinished = MutableLiveData<Boolean>()
    val isFinished = _isFinished
    private val _detailedText = MutableLiveData<String>()
    val detailedText = _detailedText

    @RequiresApi(Build.VERSION_CODES.O)
    fun addTextTitle(userInput : String) {

        _textInserted.value = userInput
        myList.add(clicksTitle, DataValues(title = _textInserted.value!!, _date = _dateAssigned.value.toString(), quntity = clicksTitle  ))
        _quantityOfList.value = clicksTitle
        clicksTitle++  }

fun setTitleEdited(newTitle: String) {
    _textInserted.value = newTitle
    myList.set(clicksTitle-1, DataValues(title = _textInserted.value.toString())  )
}

    fun setDecription (newDecription: String){
        _detailedText.value = newDecription
        myList.set(clicksTitle-1, DataValues(detail = _detailedText.value.toString()))
    }

    fun setDate(currentDate: String) {
        _dateAssigned.value = currentDate
        myList.set(clicksTitle-1, DataValues(_date = _dateAssigned.value!!) )
    }

     fun getPickupOptions(): String {
        val options : String
        val formatter = SimpleDateFormat("E MMM d", Locale.getDefault())
        val calendar = Calendar.getInstance()
            options = (formatter.format(calendar.time))
        return options
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun setSsImportant(isColored: Boolean) {
        _isImportant.value = isColored == true
        myList.add(importantClicke, DataValues(urgency = _isImportant.value!!))
        ++importantClicke
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun setIsFinished(isChecked:Boolean){
      _isFinished.value = isChecked == true
       finishedClick = 0
      myList.add(finishedClick, DataValues(finishing = _isFinished.value!!))
      ++finishedClick
    }

    fun getReqiredTitleonEditPress(requiredIndext: Int) {
        _textInserted.value = myList[requiredIndext].title
        _dateAssigned.value = myList[requiredIndext]._date
        _detailedText.value = myList[requiredIndext].detail
        _quantityOfList.value = myList[requiredIndext].quntity
        _isFinished.value = myList[requiredIndext].finishing
        _isImportant.value = myList[requiredIndext].urgency
    }
}