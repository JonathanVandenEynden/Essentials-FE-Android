package com.example.essentials.ui.changeInitiatives

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.essentials.R
import com.example.essentials.databinding.FragmentChangeInitiativesBinding

/**
 * A simple [Fragment] subclass.
 * Use the [ChangeInitiativesFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ChangeInitiativesFragment : Fragment() {

    lateinit var viewModel: ChangeInitiativeViewModel

    private lateinit var binding: FragmentChangeInitiativesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_change_initiatives,
            container,
            false
        )

        viewModel = ViewModelProvider(this).get(ChangeInitiativeViewModel::class.java)

        binding.viewModel = viewModel

        binding.setLifecycleOwner(this)

        val manager = LinearLayoutManager(activity)

        binding.ciList.layoutManager = manager

        val adapter = ChangeInitiativeAdapter()

        binding.ciList.adapter = adapter

        adapter.submitList(viewModel.changeInitiatives)

        return binding.root
    }

    // TODO de titel van de appbar kunnen veranderen
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

//        activity?.let {
//            it.updateActionbarTitle("My Change Initiatives");
//        }
    }
}
