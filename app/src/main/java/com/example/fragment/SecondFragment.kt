package com.example.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer

class SecondFragment : Fragment() {
    private val communicationViewModel: CommunicationViewModel by activityViewModels()
    private lateinit var txtName: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_second, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        txtName = view.findViewById(R.id.textViewName)

        communicationViewModel.name.observe(viewLifecycleOwner, Observer { name ->
            txtName.text = name
        })
    }

    companion object {
        @JvmStatic
        fun newInstance(): SecondFragment {
            return SecondFragment()
        }
    }
}
