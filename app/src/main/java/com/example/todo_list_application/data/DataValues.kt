package com.example.todo_list_application.data

import com.google.android.material.datepicker.MaterialDatePicker
import com.google.android.material.datepicker.MaterialDatePicker.Builder

data class DataValues (
    val title : String,
    val urgency: Boolean = false,
    var date: String,
    val time: String,
    val detail: String,

)
{


}
