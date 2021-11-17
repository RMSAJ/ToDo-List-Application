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
import androidx.annotation.RequiresApi
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.activityViewModels
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


/**
 * A simple [Fragment] subclass.
 * Use the [Detail_List_Fragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class Detail_List_Fragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var binding: FragmentDetailListBinding? = null
    private val sharedViewModel : ListViewModel by activityViewModels()

    //val  getInsertedText = sharedViewModel.textInserted.value
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        arguments?.let {
//            param1 = it.getString(ARG_PARAM1)
//            param2 = it.getString(ARG_PARAM2)
//        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
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
        }

    }
//        fun getTitle() {
//          val title =  binding?.EditWritingList?.text
//            sharedViewModel.setText()
//
//        }

        fun getDescription() {

        }
    private fun convertMillisecondsToReadableDate(
        dateMilliseconds: Long,
        datePattern: String
    ): String {
        val format = SimpleDateFormat(datePattern, Locale.getDefault())
        return format.format(Date(dateMilliseconds))
    }

//        fun getDate() {
//            // Create the date picker builder and set the title
//           val datePicker = MaterialDatePicker.Builder.datePicker()
//               .setTitleText("Select Activity date")
//               .setSelection(MaterialDatePicker.todayInUtcMilliseconds())
//               .setInputMode(MaterialDatePicker.INPUT_MODE_TEXT)
//               .build()
//                datePicker.show(parentFragmentManager, "datePicker")
//            datePicker.addOnPositiveButtonClickListener {
//               date = convertMillisecondsToReadableDate(it, "EEE, MMM d ")
//            }
//            datePicker.selection
//        }

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




//    companion object {
       /**
//         * Use this factory method to create a new instance of
//         * this fragment using the provided parameters.
//         *
//         * @param param1 Parameter 1.
//         * @param param2 Parameter 2.
//         * @return A new instance of fragment Detail_List_Fragment.
//         */
//        @JvmStatic
//        fun newInstance(param1: String, param2: String) =
//            Detail_List_Fragment().apply {
//                arguments = Bundle().apply {
//                    putString(ARG_PARAM1, param1)
//                    putString(ARG_PARAM2, param2)
//                }
//            }
    }
