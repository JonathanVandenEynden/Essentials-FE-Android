package com.hogentessentials1.essentials.data.model.DI

import com.hogentessentials1.essentials.ui.changeInitiatives.ChangeInitiativesViewModel
import com.hogentessentials1.essentials.ui.roadMap.list.RoadMapListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { ChangeInitiativesViewModel(get()) }
    viewModel { RoadMapListViewModel(get()) }
}
