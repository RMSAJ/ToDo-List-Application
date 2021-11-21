package com.example.todo_list_application.fragments

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.DatePicker
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.todo_list_application.R
import com.example.todo_list_application.data.myList
import com.example.todo_list_application.databinding.FragmentDetailListBinding
import com.example.todo_list_application.databinding.FragmentFirstPageBinding
import com.example.todo_list_application.model.ListViewModel
import com.google.android.material.datepicker.MaterialDatePicker
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.*
import java.util.Calendar.*

class Detail_List_Fragment : Fragment() {

        private var binding: FragmentDetailListBinding? = null
    private val sharedViewModel: ListViewModel by activityViewModels()
    var index: Int = sharedViewModel.quantityOfList.value!!
    companion object {
        val title = "title"
        val description = "description"
    }

    lateinit var date: String
     var comparable: Long = 0
    //val  getInsertedText = sharedViewModel.textInserted.value
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            binding?.EditWritingList?.setText(it.getString(title))
            binding?.EditDescrition?.setText(it.getString(description))
               index = it.getInt("index")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        val fragmentBinding = FragmentDetailListBinding.inflate(inflater, container, false)
        binding = fragmentBinding
        return fragmentBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.apply {
            lifecycleOwner = viewLifecycleOwner
            liveviewmodel = sharedViewModel
            detailfragment = this@Detail_List_Fragment
            DateButton.setOnClickListener {
                // create Intstance of the date Picker
                val supportFragmentManager = activity?.supportFragmentManager
                // Set Fragment Result
                supportFragmentManager?.setFragmentResultListener(
                    "REQUEST_KEY",
                    viewLifecycleOwner
                ) { resultKey, bundle ->
                    if (resultKey == "REQUEST_KEY") {
                        val date = bundle.getString("SELECTED_DATE")
                        DateButton.text = date
                    }
                }
            }
            compareTime()
        }
    }
        fun showDatePicker() {
            // prepare the calender to be selectable
            val datePicker = MaterialDatePicker.Builder.datePicker()
                .setTitleText("Select").setSelection(MaterialDatePicker.todayInUtcMilliseconds())
                .build()
            // show it in the secreen
            datePicker.show(parentFragmentManager, "DatePicker")
            // the click of the lestiner in side the table of calender
            datePicker.addOnPositiveButtonClickListener {
                // saving the value below ( the type is long) we use it  for the comparison
                comparable = it
                // here convert it to String and show it to the user to be user frindly
                date = convertMillisecondsToReadableDate(it, "EEE, MMM dd ")
                // we store the date in the view model
                sharedViewModel.setDate(date, index)
                // we store the comparison
                sharedViewModel.storedateBeCompared(comparable)
            }
             fun convertMillisecondsToReadableDate(
                dateMilliseconds: Long,
                datePattern: String
            ): String {
                val format = SimpleDateFormat(datePattern, Locale.getDefault())
                return format.format(Date(dateMilliseconds))
            }
        }

        fun onSave () {
            val myTitle = binding?.EditWritingList?.text.toString()
            val mydesrition = binding?.EditDescrition?.text.toString()
            val changedDate = binding?.DateButton?.text.toString()
            sharedViewModel.setDecription(mydesrition, index)
            sharedViewModel.setDate(changedDate, index)
            sharedViewModel.setTitleEdited(myTitle, index)
            findNavController().navigate(R.id.action_detail_List_Fragment_to_firstPageFragment)
        }

    fun onCancel() {
        findNavController().navigate(R.id.action_detail_List_Fragment_to_firstPageFragment)
    }
        private fun convertMillisecondsToReadableDate(
            dateMilliseconds: Long,
            datePattern: String
        ): String {
            val format = SimpleDateFormat(datePattern, Locale.getDefault())
            return format.format(Date(dateMilliseconds))
        }
    override fun onDestroy() {
//       val myTitle = binding?.EditWritingList?.text.toString()
//        val mydesrition = binding?.EditDescrition?.text.toString()
//        val changedDate = binding?.DateButton?.text.toString()
//        sharedViewModel.setTitleEdited(myTitle, index)
//        sharedViewModel.setDate(changedDate, index)
        super.onDestroy()
        binding = null
    }

fun compareTime() {
    if (sharedViewModel._comparing.value == null) {
        Toast.makeText(context,"pls chose Date",Toast.LENGTH_LONG).show()
    }
    else if (sharedViewModel._comparing.value!! < getInstance().timeInMillis  ) {
        Toast.makeText(context,"Times up!!!!!! ",Toast.LENGTH_LONG).show()
    }
    else Toast.makeText(context,"GooodBooy",Toast.LENGTH_LONG).show()
}
        fun SaveButten() {

        }
        fun cancelButton() {

        }
    }

