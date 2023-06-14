package com.iamauttamai.navcontroller.mainnav

import android.app.Activity
import android.app.Activity.RESULT_OK
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.setFragmentResultListener
import androidx.navigation.Navigation
import com.iamauttamai.navcontroller.R
import com.iamauttamai.navcontroller.SecondActivity
import com.iamauttamai.navcontroller.databinding.FragmentMainOneBinding

class MainOneFragment : Fragment() {

    private lateinit var binding: FragmentMainOneBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentMainOneBinding.inflate(layoutInflater, container, false)

        setFragmentResultListener("IS_REQUEST_KEY"){ _, bundle ->
            bundle.getString("data")?.let {
                if (it.isNotEmpty()) {
                    Toast.makeText(requireActivity(), it, Toast.LENGTH_SHORT).show()
                }
            }
        }

        binding.btnMainTwo.setOnClickListener {
            val bundle = Bundle()
            bundle.putSerializable("date", "Hello, i'm from Main One")
            Navigation.findNavController(requireActivity(), R.id.main_nav).navigate(
                R.id.action_mainOneFragment_to_mainTwoFragment, bundle
            )
        }

        binding.btnMainThree.setOnClickListener {
            val bundle = Bundle()
            bundle.putSerializable("date", "Hello, i'm from Main One")
            Navigation.findNavController(requireActivity(), R.id.main_nav).navigate(
                R.id.action_mainOneFragment_to_mainThreeFragment, bundle
            )
        }

        binding.btnNext.setOnClickListener {
            val intent: Intent = Intent(requireActivity(), SecondActivity::class.java)
                .putExtra("data", "Hello, World!")
            activityResultLauncher.launch(intent)
        }

        return binding.root
    }

    private var activityResultLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        if (result.resultCode == RESULT_OK) {
            val data = result.data
            if (data != null) {
                Toast.makeText(requireActivity(), data.getStringExtra("data"), Toast.LENGTH_SHORT).show()
            }
        }
    }

}