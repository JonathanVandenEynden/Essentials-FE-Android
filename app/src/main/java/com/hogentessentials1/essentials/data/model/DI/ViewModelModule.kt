package com.hogentessentials1.essentials.data.model.DI

import com.hogentessentials1.essentials.login.ui.login.LoginViewModel
import com.hogentessentials1.essentials.ui.changeGroup.TeamsViewModel
import com.hogentessentials1.essentials.ui.surveys.AllSurveysViewModel
import com.hogentessentials1.essentials.ui.changeInitiatives.ChangeInitiativesViewModel
import com.hogentessentials1.essentials.ui.roadMap.list.RoadMapListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { ChangeInitiativesViewModel(get()) }
    viewModel { RoadMapListViewModel(get()) }
    viewModel { AllSurveysViewModel(get()) }
    viewModel { TeamsViewModel(get()) }
    viewModel { LoginViewModel(get()) }
}
