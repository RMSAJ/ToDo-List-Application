package com.example.todo_list_application.data

import android.app.ActivityManager
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentContainer
import com.example.todo_list_application.MainActivity
import com.example.todo_list_application.fragments.Detail_Item_Fragment
import com.example.todo_list_application.fragments.FirstPageFragment
import com.google.android.material.datepicker.MaterialDatePicker
import com.google.android.material.datepicker.MaterialDatePicker.Builder
import com.google.android.material.timepicker.MaterialTimePicker
import com.google.android.material.timepicker.TimeFormat
import androidx.fragment.app.FragmentManager
import com.example.todo_list_application.fragments.Detail_List_Fragment
import java.time.LocalDate
import java.time.format.DateTimeFormatter


data class DataValues (
    val quntity: Int = 0,
    val title : String = "",
    val urgency: Boolean = false,
    var _date: LocalDate? , //= Detail_List_Fragment().setTheDate()
    var finishing: Boolean = false,
    val detail: String = "",
    )
{

}
