package com.example.todo_list_application.data

import com.google.android.material.datepicker.MaterialDatePicker
import com.google.android.material.datepicker.MaterialDatePicker.Builder
import com.google.android.material.timepicker.MaterialTimePicker
import com.google.android.material.timepicker.TimeFormat

data class DataValues (
    val title : String = "",
    val urgency: Boolean = false,
    var date: String =
        MaterialDatePicker.Builder.datePicker()
            .setTitleText("chose the date")
            .setSelection(MaterialDatePicker.todayInUtcMilliseconds())
            .toString(),
    var finishing: Boolean = false,
        val detail: String = "",
    )
{


}
