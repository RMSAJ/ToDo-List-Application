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
import java.time.LocalDate

class ListViewModel: ViewModel()  {

 private   var clicks = 0
private var binding: FragmentFirstPageBinding? = null
// DEFINING LISTS QUANTITY
   private var _quantityOfList = MutableLiveData <Int>()
    val quantityOfList: LiveData<Int> get() = _quantityOfList
    // the title inserted by the user
   private val _textInserted = MutableLiveData <String>()
    val textInserted: LiveData<String> = _textInserted
    // date_to be made
   private val _dateAssigned = MutableLiveData <LocalDate>()
    val dateAssigned = _dateAssigned
    private val _isImportant = MutableLiveData<Boolean>()
    val isImportant = _isImportant
    private val _isFinished = MutableLiveData<Boolean>()
    val isFinished = _isFinished
    private val _detailedText = MutableLiveData<String>()
    val detailedText = _detailedText

    fun setQuantity(){

    }

    fun setQuantityofList(){
// used in the first page for the first init
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun setText(userInput : String) {

        _textInserted.value = userInput
        myList.add(clicks, DataValues(title = _textInserted.value!!, _date = _dateAssigned.value, quntity = clicks  ))
        _quantityOfList.value = clicks
       clicks++  }

//    fun editText() {
//        myList.set(this)
//    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun setDate(currentDate: LocalDate) {
        _dateAssigned.value = currentDate
        var clicks = 0
        myList.add(clicks, DataValues(_date = _dateAssigned.value!!) )
        ++clicks
    }

//    fun setInitialDate () {
//        _dateAssigned.value = MaterialDatePicker.Builder.datePicker()
//            .setTitleText("chose the date")
//            .setSelection(MaterialDatePicker.todayInUtcMilliseconds())
//
//    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun setSsImportant(isColored: Boolean){
        _isImportant.value = isColored == true
        var clicks = 0
        myList.add(clicks, DataValues(urgency = _isImportant.value!!, _date = _dateAssigned.value))
        ++clicks
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun setIsFinished(isChecked:Boolean){
      _isFinished.value = isChecked == true
      var clicks = 0
      myList.add(clicks, DataValues(finishing = _isFinished.value!!, _date = _dateAssigned.value))
      ++clicks
    }

    fun getReqiredTitleonEditPress(requiredIndext: Int) {

        _textInserted.value = myList[requiredIndext].title
        _dateAssigned.value = myList[requiredIndext]._date!!
        _detailedText.value = myList[requiredIndext].detail
        _quantityOfList.value = myList[requiredIndext].quntity
        _isFinished.value = myList[requiredIndext].finishing
        _isImportant.value = myList[requiredIndext].urgency

    }

}