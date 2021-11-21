package com.example.todo_list_application.fragments

import android.annotation.SuppressLint
import android.content.res.ColorStateList
import android.graphics.Paint
import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.core.graphics.toColor
import androidx.core.graphics.toColorInt
import androidx.core.view.isVisible
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.todo_list_application.R
import com.example.todo_list_application.R.color.*
import com.example.todo_list_application.databinding.FragmentDetailItemBinding
import com.example.todo_list_application.databinding.FragmentDetailListBinding
import com.example.todo_list_application.databinding.FragmentFirstPageBinding
import com.example.todo_list_application.model.ListViewModel
import com.google.android.material.datepicker.MaterialDatePicker

import com.google.android.material.datepicker.MaterialDatePicker.Builder.datePicker
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.*
import kotlin.concurrent.timerTask
import com.example.todo_list_application.R.color.lightYellow as lightYellow1

class Detail_Item_Fragment : Fragment() {
    var isImportantcount = 0
    var finishCount = 0

    private var binding: FragmentDetailItemBinding? = null

    private val sharedViewModel: ListViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val fragmentBinding = FragmentDetailItemBinding.inflate(inflater, container, false)
        binding = fragmentBinding
        return fragmentBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.apply {
            lifecycleOwner = viewLifecycleOwner
            listviewmodel = sharedViewModel
            detailedFragment = this@Detail_Item_Fragment
        }
    }

    @SuppressLint("ResourceAsColor")
    @RequiresApi(Build.VERSION_CODES.O)
    fun onCardClick() {
        if (isImportantcount % 2 == 0) {
            binding?.mainItemCard?.setBackgroundColor(R.color.black)
            sharedViewModel.setSsImportant(true)
            ++isImportantcount
        } else {
            binding?.mainItemCard?.background?.setTint(white)
            sharedViewModel.setSsImportant(false)
        }
    }

    fun isFinished() {
        var checkingButton = binding?.titleText?.paintFlags!!.or(Paint.STRIKE_THRU_TEXT_FLAG)
        if (finishCount % 2 == 0) {
            binding?.titleText?.paintFlags!!.or(Paint.STRIKE_THRU_TEXT_FLAG)
            sharedViewModel.setIsFinished(true)
            checkingButton
            ++finishCount
        } else {
            sharedViewModel.setIsFinished(isChecked = false)
        }
    }

//fun goEdite() {
//   val requiredEdit = binding?.countNumber?.text
//    sharedViewModel.getReqiredTitleonEditPress(requiredEdit.toString().toInt())
// }

 fun convertMillisecondsToReadableDate(
        dateMilliseconds: Long,
        datePattern: String
    ): String {
        val format = SimpleDateFormat(datePattern, Locale.getDefault())
        return format.format(Date(dateMilliseconds))
    }
}
