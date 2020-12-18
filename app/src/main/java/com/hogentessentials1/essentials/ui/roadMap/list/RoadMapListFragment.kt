package com.hogentessentials1.essentials.ui.roadMap.list

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.hogentessentials1.essentials.R
import com.hogentessentials1.essentials.data.model.RoadMapItem
import com.hogentessentials1.essentials.databinding.RoadmapListBinding
import com.hogentessentials1.essentials.util.Status
import org.koin.android.ext.android.inject

/**
 * fragment for the road map overview
 *
 * @author Ziggy Moens
 */
class RoadMapListFragment : Fragment() {

    lateinit var viewModel: RoadMapListViewModel

    private lateinit var binding: RoadmapListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    fun viewModel(): RoadMapListViewModel {
        val viewModel: RoadMapListViewModel by inject()
        return viewModel
    }

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.roadmap_list,
            container,
            false
        )

        viewModel = viewModel()

        val allSurveys: Boolean?
        val changemanager: Boolean?
        val roadmapItems: ArrayList<RoadMapItem> = arrayListOf()
        val args = RoadMapListFragmentArgs.fromBundle(requireArguments())

        allSurveys = args.allSurveys
        changemanager = args.changemanager
        if (!allSurveys) {
            args.roadmapitems!!.forEach { e ->
                roadmapItems.add(e)
            }
        }

        binding.viewModel = viewModel

        binding.lifecycleOwner = this

        val manager = LinearLayoutManager(activity)

        binding.roadmapSummary.layoutManager = manager

        val adapter = RoadMapAdapter(
            RoadMapListener { roadmapItem ->
                viewModel.onRoadMapClicked(roadmapItem)
            }
        )

        viewModel.navigateToRoadMapItem.observe(
            viewLifecycleOwner,
            { rmi ->
                rmi?.let {
                    this.findNavController().navigate(
                        RoadMapListFragmentDirections.actionRoadMapListFragmentToRoadMapFragment(
                            changemanager,
                            rmi
                        )
                    )
                    viewModel.onRoadMapNavigated()
                }
            }
        )

        binding.roadmapSummary.adapter = adapter

        if (!allSurveys) {
            adapter.submitList(roadmapItems)
        } else {
            viewModel.allCI.observe(
                viewLifecycleOwner,
                {
                    it?.let { resource ->
                        when (resource.status) {
                            Status.SUCCESS -> {
                                if (resource.data?.isEmpty() == true) {
                                    binding.noRmiBanner.visibility = View.VISIBLE
                                    adapter.submitList(arrayListOf())
                                } else {
                                    binding.noRmiBanner.visibility = View.GONE

                                    // Get all RMI
                                    var list = arrayListOf<RoadMapItem>()
                                    resource.data?.map { ci -> list.addAll(ci.roadMap) }
                                    adapter.submitList(list)
                                }
                            }
                            Status.LOADING -> {
                                binding.noRmiBanner.visibility = View.GONE
                            }
                            Status.ERROR -> {
                                binding.noRmiBanner.visibility = View.VISIBLE
                            }
                        }
                    }
                }
            )

//            viewModel.getAllSurveys()
//            viewModel.RoadMapItems.observe(
//                viewLifecycleOwner,
//                { adapter.submitList(it) }
//            )
        }

        /**
         * @author Ziggy Moens
         */
        (activity as AppCompatActivity).supportActionBar?.title = "Road map"

        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }
}
