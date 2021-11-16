package com.example.todo_list_application.fragments
import android.os.Bundle
import android.text.format.DateFormat.is24HourFormat
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.todo_list_application.R
import com.example.todo_list_application.databinding.FragmentFirstPageBinding
import com.example.todo_list_application.model.ListViewModel
import com.google.android.material.datepicker.MaterialDatePicker
import com.google.android.material.datepicker.MaterialDatePicker.Builder.datePicker
import com.google.android.material.timepicker.MaterialTimePicker


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER


/**
 * A simple [Fragment] subclass.
 * Use the [FirstPageFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class FirstPageFragment : Fragment() {

    private var binding: FragmentFirstPageBinding? = null

    private val sharedViewModel : ListViewModel  by activityViewModels()

    // TODO: Rename and change types of parameters
//    private var param1: String? = null
//    private var param2: String? = null

//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        arguments?.let {
//            param1 = it.getString(ARG_PARAM1)
//            param2 = it.getString(ARG_PARAM2)
//        }
//    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val fragmentBinding = FragmentFirstPageBinding.inflate(inflater, container, false)
        binding = fragmentBinding
        return fragmentBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.apply {
            lifecycleOwner = viewLifecycleOwner
            liveviewmodel = sharedViewModel
            firstpagefragment = this@FirstPageFragment
        }

    }

    fun sortText(){
       val myText = binding?.EditWritingList?.text.toString()
        sharedViewModel.setText(myText)
        findNavController().navigate(R.id.action_firstPageFragment_to_detail_List_Fragment)
    }

    fun currentTime(){

//        val is24HrsSystem = is24HourFormat(requireContext())
//        val timeFormat = when(is24HrsSystem){
//            true -> TimeFormat.CLOCK_24H
//            else -> TimeFormat.CLOCK_12H

        var dateTimePicker = MaterialDatePicker.Builder.datePicker()
            .setTitleText("chose the date")
            .setSelection(MaterialDatePicker.todayInUtcMilliseconds())
            .toString()
    }


}