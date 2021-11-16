package com.example.todo_list_application.fragments

import android.content.res.ColorStateList
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.graphics.toColor
import androidx.core.graphics.toColorInt
import androidx.fragment.app.activityViewModels
import com.example.todo_list_application.R
import com.example.todo_list_application.R.color.design_default_color_background
import com.example.todo_list_application.databinding.FragmentDetailItemBinding
import com.example.todo_list_application.databinding.FragmentDetailListBinding
import com.example.todo_list_application.databinding.FragmentFirstPageBinding
import com.example.todo_list_application.model.ListViewModel
import com.google.android.material.datepicker.MaterialDatePicker
import com.example.todo_list_application.R.color.lightYellow as lightYellow1

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Detail_Item_Fragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class Detail_Item_Fragment : Fragment() {
    private var binding: FragmentDetailItemBinding? = null

    private val sharedViewModel : ListViewModel by activityViewModels()

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

    fun onCardClick(){
        var theColor = binding?.mainItemCard?.checkedIconTint

        var count = 0
        if (count % 2 == 0){
            theColor =  ColorStateList.valueOf("@color/lightYellow".toColorInt())
            sharedViewModel.setSsImportant(true)
            ++count}
        else {

            resources.getColor(design_default_color_background)
            sharedViewModel.setSsImportant(false)
        }
    }
    fun isFinished(){
        val checkingButton = binding?.finishedCheckBox?.isChecked
        var count = 0
        if (count % 2 == 0) {

        }
    }
}