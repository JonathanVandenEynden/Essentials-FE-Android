package com.hogentessentials1.essentials.ui.roadMap

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.hogentessentials1.essentials.R
import com.hogentessentials1.essentials.data.model.RoadMapItem
import com.hogentessentials1.essentials.databinding.RoadmapBinding

/**
 * @author Ziggy Moens
 */
class RoadMapFragment : Fragment() {

    private lateinit var roadmapitem: RoadMapItem

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding: RoadmapBinding =
            DataBindingUtil.inflate(inflater, R.layout.roadmap, container, false)

        val args = RoadMapFragmentArgs.fromBundle(requireArguments())
        roadmapitem = args.roadmapitem
        val changemanager = args.changemanager

        val viewModel = ViewModelProvider(this).get(RoadMapViewModel::class.java)

        viewModel.roadMapItem = roadmapitem

        binding.viewModel = viewModel

        viewModel.navigateToSurvey.observe(
            viewLifecycleOwner,
            {
                if (it) {
                    binding.root.findNavController().navigate(
                        RoadMapFragmentDirections.actionRoadMapFragmentToSurveyQuestionFragment(
                            changemanager,
                            roadmapitem
                        )
                    )
                    viewModel.onNavigatedToSurvey()
                }
            }
        )

        (activity as AppCompatActivity).supportActionBar?.title = "Roadmap"
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        if (roadmapitem.assessment == null) {
            view?.findNavController()
                ?.navigate(RoadMapFragmentDirections.actionRoadMapFragmentToNotFoundFragment())
        }
    }
}
