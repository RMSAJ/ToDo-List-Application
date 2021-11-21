package com.example.todo_list_application.fragments
import android.os.Build
import android.os.Bundle
import android.text.format.DateFormat.is24HourFormat
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.todo_list_application.R
import com.example.todo_list_application.adapter.Adapterdo
import com.example.todo_list_application.databinding.FragmentFirstPageBinding
import com.example.todo_list_application.model.ListViewModel
import com.google.android.material.datepicker.MaterialDatePicker
import com.google.android.material.datepicker.MaterialDatePicker.Builder.datePicker
import com.google.android.material.timepicker.MaterialTimePicker

class FirstPageFragment : Fragment() {
    private var binding: FragmentFirstPageBinding? = null

    private val sharedViewModel : ListViewModel  by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val fragmentBinding = FragmentFirstPageBinding.inflate(inflater, container, false)
        binding = fragmentBinding
        return fragmentBinding.root
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.apply {
            lifecycleOwner = viewLifecycleOwner
            liveviewmodel = sharedViewModel
            firstpagefragment = this@FirstPageFragment
        }
        binding?.todoRecycler?.adapter = Adapterdo(this.requireContext())
        binding?.todoRecycler?.setHasFixedSize(true)
//        val cardClicking = Detail_Item_Fragment().onCardClick()
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun sortText(){
       val myText = binding?.EditWritingList?.text.toString()
        sharedViewModel.addTextTitle(myText)
        findNavController().navigate(R.id.action_firstPageFragment_to_detail_List_Fragment)
    }

    }

