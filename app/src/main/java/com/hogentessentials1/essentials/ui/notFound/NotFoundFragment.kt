package com.hogentessentials1.essentials.ui.notFound

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.hogentessentials1.essentials.R
import com.hogentessentials1.essentials.databinding.NotFound404Binding

/**
 * @author Ziggy Moens
 */

class NotFoundFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding: NotFound404Binding =
            DataBindingUtil.inflate(inflater, R.layout.not_found_404, container, false)

        binding.notfoundbutton.setOnClickListener { view: View ->
            view.findNavController().navigate(
                NotFoundFragmentDirections.actionNotFoundFragmentToHomeScreenFragment()
            )
        }

        binding.notFoundFragment = this

        (activity as AppCompatActivity).supportActionBar?.title = "Not found"
        return binding.root
    }
}
