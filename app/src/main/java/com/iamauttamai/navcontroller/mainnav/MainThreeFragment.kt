package com.iamauttamai.navcontroller.mainnav

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.core.os.bundleOf
import androidx.fragment.app.setFragmentResult
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.iamauttamai.navcontroller.R
import com.iamauttamai.navcontroller.databinding.FragmentMainThreeBinding
import com.iamauttamai.navcontroller.databinding.FragmentMainTwoBinding

class MainThreeFragment : Fragment() {

    private lateinit var binding: FragmentMainThreeBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentMainThreeBinding.inflate(layoutInflater, container, false)

        arguments?.let {
            Toast.makeText(requireActivity(), it.getString("date"), Toast.LENGTH_SHORT).show()
        }

        binding.btnMainOne.setOnClickListener {
            val bundle = Bundle()
            bundle.putSerializable("date", "Hello, i'm from Main Three")
            Navigation.findNavController(requireActivity(), R.id.main_nav).navigate(
                R.id.action_mainThreeFragment_to_mainOneFragment, bundle
            )
        }

        binding.btnMainTwo.setOnClickListener {
            val bundle = Bundle()
            bundle.putSerializable("date", "Hello, i'm from Main Three")
            Navigation.findNavController(requireActivity(), R.id.main_nav).navigate(
                R.id.action_mainThreeFragment_to_mainTwoFragment, bundle
            )
        }

        // Set up back button press callback
        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                setFragmentResult("IS_REQUEST_KEY", bundleOf("data" to "Hello, i'm from Main Three"))
                findNavController().popBackStack()
            }
        })

        return binding.root
    }

}