package com.hogentessentials1.essentials.data.model.DI

import com.hogentessentials1.essentials.ui.dashboard.DashboardViewModel
import com.hogentessentials1.essentials.login.ui.login.LoginViewModel
import com.hogentessentials1.essentials.ui.changeGroup.TeamsViewModel
import com.hogentessentials1.essentials.ui.surveys.AllSurveysViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { AllSurveysViewModel(get()) }
    viewModel { DashboardViewModel(get(), get(), get()) }
    viewModel { TeamsViewModel(get()) }
    viewModel { LoginViewModel(get()) }
}
