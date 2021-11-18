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

    companion object {
        val title = "title"
        val description = "description"
    }

    lateinit var date: String

    //val  getInsertedText = sharedViewModel.textInserted.value
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            binding?.EditWritingList?.setText(it.getString(title))
            binding?.EditDescrition?.setText(it.getString(description))
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
                val datePickerDialog = DateFragment()
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


        }
    }
        fun showDatePicker() {
            val datePicker = MaterialDatePicker.Builder.datePicker()
                .setTitleText("Select").setSelection(MaterialDatePicker.todayInUtcMilliseconds())
                .build()
            datePicker.show(parentFragmentManager, "DatePicker")
            datePicker.addOnPositiveButtonClickListener {

                date = convertMillisecondsToReadableDate(it, "EEE, MMM dd ")
                sharedViewModel.setDate(date)
            }
             fun convertMillisecondsToReadableDate(
                dateMilliseconds: Long,
                datePattern: String
            ): String {
                val format = SimpleDateFormat(datePattern, Locale.getDefault())
                return format.format(Date(dateMilliseconds))
            }
        }


        fun onCancelingandSave () {
            val myTitle = binding?.EditWritingList?.text.toString()
            val mydesrition = binding?.EditDescrition?.text.toString()

            sharedViewModel.setTitleEdited(myTitle)
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
       val myTitle = binding?.EditWritingList?.text.toString()
        val mydesrition = binding?.EditDescrition?.text.toString()

        sharedViewModel.setTitleEdited(myTitle)

        super.onDestroy()
    }



        fun SaveButten() {

        }

        fun cancelButton() {

        }


//    fun setTheDate() {
//
//        var dateinput = binding!!.dateText.text
//        val formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy")
//        val date = LocalDate.parse(dateinput, formatter)
//        sharedViewModel.setDate(date)
//
//    }


    }

