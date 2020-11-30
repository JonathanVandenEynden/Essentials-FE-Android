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
import org.koin.android.ext.android.inject
import timber.log.Timber

/**
 * @author Ziggy Moens
 * @author Simon De Wilde
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

        val changemanager: Boolean?
        val args = ChangeInitiativesFragmentArgs.fromBundle(requireArguments())
        changemanager = args.changemanager

        if (changemanager != true && changemanager != false) {
            ChangeInitiativesFragmentDirections.actionChangeInitiativesToNotFoundFragment()
        }

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

        val adapter = ChangeInitiativeAdapter(
            ChangeInitiativesListener { changeInitiative ->
                viewModel.onChangeInitiativeClicked(changeInitiative)
            }
        )

        /**
         * @author Ziggy Moens
         */
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

        Timber.e(viewModel.changeinitiatives.value.toString())

        viewModel.changeinitiatives.observe(
            viewLifecycleOwner,
            { adapter.submitList(it) }
        )

        // adapter.submitList(viewModel.changeinitiatives.value)

        /**
         * @author Ziggy Moens
         */
        (activity as AppCompatActivity).supportActionBar?.title = "Change initiatives"

        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }
}
