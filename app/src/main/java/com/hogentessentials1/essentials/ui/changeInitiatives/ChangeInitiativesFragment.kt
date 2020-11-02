package com.hogentessentials1.essentials.ui.changeInitiatives

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.hogentessentials1.essentials.R
import com.hogentessentials1.essentials.databinding.FragmentChangeInitiativesBinding

/**
 * @author Simon De Wilde
 * A simple [Fragment] subclass.
 * Use the [ChangeInitiativesFragment] factory method to
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

        binding.lifecycleOwner = this

        val manager = LinearLayoutManager(activity)

        binding.ciList.layoutManager = manager

        val adapter = ChangeInitiativeAdapter(
            ChangeInitiativeListener { changeInitiative ->
                viewModel.onChangeInitiativeClicked(changeInitiative)
            }
        )

        viewModel.navigateToChangeInitiative.observe(
            viewLifecycleOwner,
            { changeInitiative ->
                changeInitiative?.let {
                    this.findNavController().navigate(
                        ChangeInitiativesFragmentDirections.actionChangeInitiativesFragmentToSurveysChangeinitiativeFragment(
                            changeInitiative
                        )
                    )
                    viewModel.onChangeInitiativeNavigated()
                }
            }
        )

        binding.ciList.adapter = adapter

        adapter.submitList(viewModel.changeInitiatives)

        (activity as AppCompatActivity).supportActionBar?.title = "My change initiatives"

        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }
}
