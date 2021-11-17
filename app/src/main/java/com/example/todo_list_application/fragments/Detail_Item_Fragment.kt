package com.example.todo_list_application.fragments

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
import com.example.todo_list_application.R.color.design_default_color_background
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


//        ColorStateList
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun onCardClick() {
        var theColor = binding?.mainItemCard?.checkedIconTint

        var count = 0
        if (count % 2 == 0) {
            theColor = ColorStateList.valueOf("@color/lightYellow".toColorInt())
            sharedViewModel.setSsImportant(true)
            ++count
        } else {

            resources.getColor(design_default_color_background)
            sharedViewModel.setSsImportant(false)
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun isFinished() {
        var checkingButton = binding?.finishedCheckBox?.isChecked
        var count = 0
        if (count % 2 == 0) {
            checkingButton = true
            binding?.titleText?.paintFlags!!.or(Paint.STRIKE_THRU_TEXT_FLAG)
            ++count
        } else {
            checkingButton = false
        }
        sharedViewModel.setIsFinished(checkingButton)
    }

@RequiresApi(Build.VERSION_CODES.O)
fun goEdite() {
   val requiredEdit = binding?.countNumber?.text
    sharedViewModel.getReqiredTitleonEditPress(requiredEdit.toString().toInt())
    findNavController().navigate(R.id.action_detail_Item_Fragment_to_detail_List_Fragment)
}

    fun convertMillisecondsToReadableDate(
        dateMilliseconds: Long,
        datePattern: String
    ): String {
        val format = SimpleDateFormat(datePattern, Locale.getDefault())
        return format.format(Date(dateMilliseconds))
    }


}
