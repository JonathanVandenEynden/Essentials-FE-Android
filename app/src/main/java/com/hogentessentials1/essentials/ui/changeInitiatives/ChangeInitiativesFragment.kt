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
 * @author Ziggy Moens
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

        val args = ChangeInitiativesFragmentArgs.fromBundle(requireArguments())
        val changemanager = args.changemanager

        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_change_initiatives,
            container,
            false
        )

        viewModel = ViewModelProvider(this).get(ChangeInitiativeViewModel::class.java)

        viewModel.changemanager = changemanager

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
                            changeInitiative, changemanager
                        )
                    )
                    viewModel.onChangeInitiativeNavigated()
                }
            }
        )

        binding.ciList.adapter = adapter

        adapter.submitList(viewModel.getChangeInitiatives())

        if (changemanager) {
            (activity as AppCompatActivity).supportActionBar?.title = "My Change initiatives"
        } else {
            (activity as AppCompatActivity).supportActionBar?.title = "Change initiatives"
        }

        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }
}
