package com.example.todo_list_application.data

import android.app.ActivityManager
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

data class DataValues (
    val title : String = "",
    val urgency: Boolean = false,
    var date: String =
        Detail_Item_Fragment().setTheDate().toString(),
    var finishing: Boolean = false,
    val detail: String = "",
    )
{


}
