package com.hogentessentials1.essentials.ui.changeInitiatives

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.hogentessentials1.essentials.R
import com.hogentessentials1.essentials.databinding.ChangeinitiativesListBinding
import com.hogentessentials1.essentials.util.Globals
import org.koin.android.ext.android.inject
import timber.log.Timber

/**
 * @author Ziggy Moens
 * Fragment for the overview of change initiatives.
 * used for both employee and change manager (add boolean to action safe-args)
 */
class ChangeInitiativesFragment : Fragment() {

    private lateinit var binding: ChangeinitiativesListBinding
    private lateinit var viewModel: ChangeInitiativesViewModel
    private lateinit var adapter: ChangeInitiativeAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    fun getViewModel(): ChangeInitiativesViewModel {
        val viewModel: ChangeInitiativesViewModel by inject()
        return viewModel
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        Timber.e(Globals.userid.toString())

        val changemanager: Boolean
        val args = ChangeInitiativesFragmentArgs.fromBundle(requireArguments())
        changemanager = args.changemanager

        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.changeinitiatives_list,
            container,
            false
        )

        viewModel = getViewModel()

        binding.viewModel = viewModel

        binding.lifecycleOwner = this

        val manager = LinearLayoutManager(activity)

        binding.ciList.layoutManager = manager

        adapter = ChangeInitiativeAdapter(
            ChangeInitiativesListener { changeInitiative ->
                viewModel.onChangeInitiativeClicked(changeInitiative)
            }
        )

        viewModel.navigateToChangeInitiative.observe(
            viewLifecycleOwner,
            { changeInitiative ->
                changeInitiative?.let {
                    this.findNavController().navigate(
                        ChangeInitiativesFragmentDirections.actionChangeInitiativesToChangeInitiativeFragment(
                            changemanager,
                            changeInitiative
                        )
                    )
                    viewModel.onChangeInitiativeNavigated()
                }
            }
        )

        binding.ciList.adapter = adapter

        if (changemanager) {
            (activity as AppCompatActivity).supportActionBar?.title = "My Change initiatives"
            viewModel.changeinitiativesChangeManager()
        } else {
            (activity as AppCompatActivity).supportActionBar?.title = "Change initiatives"
            viewModel.changeinitiativesEmployee()
        }

        viewModel.changeinitiatives.observe(
            viewLifecycleOwner,
            { adapter.submitList(it) }
        )

        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        if (viewModel.changeinitiatives.value?.size == 0) {
            findNavController().navigate(ChangeInitiativesFragmentDirections.actionChangeInitiativesToNotFoundFragment())
        }
    }
}
