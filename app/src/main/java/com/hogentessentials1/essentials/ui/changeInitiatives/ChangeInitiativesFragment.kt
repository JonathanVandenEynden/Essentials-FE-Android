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
import com.hogentessentials1.essentials.ui.LoadingFragment
import com.hogentessentials1.essentials.util.Globals
import com.hogentessentials1.essentials.util.Status
import org.koin.android.ext.android.bind
import org.koin.android.ext.android.inject
import timber.log.Timber

/**
 * @author Ziggy Moens
 */
class ChangeInitiativesFragment : Fragment() {

    private lateinit var binding: ChangeinitiativesListBinding
    private lateinit var viewModel: ChangeInitiativesViewModel
    private lateinit var adapter: ChangeInitiativeAdapter
    private val loadingDialogFragment by lazy { LoadingFragment() }

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

        /*if (changemanager) {
            (activity as AppCompatActivity).supportActionBar?.title = "My Change initiatives"
            viewModel.changeinitiativesChangeManager()
        } else {
            (activity as AppCompatActivity).supportActionBar?.title = "Change initiatives"
            viewModel.changeinitiativesEmployee()
        }*/

        if (changemanager) {
            (activity as AppCompatActivity).supportActionBar?.title = "My Change initiatives"

            viewModel.changeinitiativesChangeManager.observe(
                viewLifecycleOwner,
                {
                    it?.let { resource ->
                        when (resource.status) {
                            Status.SUCCESS -> {
                                showLoading(false)
                                adapter.submitList(resource.data)
                                if (resource.data?.isEmpty() == true) {
                                } else {
                                }
                            }
                            Status.LOADING -> {
                                showLoading(true)
                            }
                            Status.ERROR -> {
                                showLoading(false)
                            }
                        }
                    }
                }
            )
        } else {
            (activity as AppCompatActivity).supportActionBar?.title = "Change initiatives"

            viewModel.changeinitiativesEmployee.observe(
                viewLifecycleOwner,
                {
                    it?.let { resource ->
                        when (resource.status) {
                            Status.SUCCESS -> {
                                showLoading(false)
                                if (resource.data?.isEmpty() == true) {
                                    binding.noChangesBanner.visibility = View.VISIBLE
                                } else {
                                }
                                adapter.submitList(resource.data)
                            }
                            Status.LOADING -> {
                                showLoading(true)
                            }
                            Status.ERROR -> {
                                showLoading(false)
                                findNavController().navigate(ChangeInitiativesFragmentDirections.actionChangeInitiativesToNotFoundFragment())
                            }
                        }
                    }
                }
            )
        }

        /*viewModel.changeinitiatives.observe(
            viewLifecycleOwner,
            {
                showLoading(true)
                adapter.submitList(it)
                showLoading(false)
            }
        )*/

        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        if (viewModel.changeinitiatives.value?.size == 0) {
            findNavController().navigate(ChangeInitiativesFragmentDirections.actionChangeInitiativesToNotFoundFragment())
        }
    }

    fun showLoading(b: Boolean)
    {
        if (b) {
            if (!loadingDialogFragment.isAdded) {
                loadingDialogFragment.show(requireActivity().supportFragmentManager, "loader")
            }
        } else {
            if (loadingDialogFragment.isAdded) {
                loadingDialogFragment.dismissAllowingStateLoss()
            }
        }
    }

    /*       if (changemanager) {
            (activity as AppCompatActivity).supportActionBar?.title = "My Change initiatives"

            viewModel.changeinitiavtivesCM.observe(
                viewLifecycleOwner,
                {
                    it?.let { resource ->
                        when (resource.status) {
                            Status.SUCCESS -> {
                                showLoading(false)
                                if (resource.data?.isEmpty() == true) {
                                    findNavController().navigate(ChangeInitiativesFragmentDirections.actionChangeInitiativesToNotFoundFragment())
                                } else {
                                }
                                adapter.submitList(resource.data)
                            }
                            Status.LOADING -> {
                                showLoading(true)
                            }
                            Status.ERROR -> {
                                showLoading(false)
                            }
                        }
                    }
                }
            )
        } else {
            (activity as AppCompatActivity).supportActionBar?.title = "Change initiatives"

            viewModel.changeinitiavtivesE.observe(
                viewLifecycleOwner,
                {
                    it?.let { resource ->
                        when (resource.status) {
                            Status.SUCCESS -> {
                                showLoading(false)
                                if (resource.data?.isEmpty() == true) {
                                    findNavController().navigate(ChangeInitiativesFragmentDirections.actionChangeInitiativesToNotFoundFragment())
                                } else {
                                }
                                adapter.submitList(resource.data)
                            }
                            Status.LOADING -> {
                                showLoading(true)
                            }
                            Status.ERROR -> {
                                showLoading(false)
                            }
                        }
                    }
                }
            )
        }*/
}
