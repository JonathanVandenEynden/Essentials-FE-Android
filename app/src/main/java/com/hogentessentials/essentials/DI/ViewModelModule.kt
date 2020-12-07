package com.hogentessentials.essentials.DI

import com.hogentessentials.essentials.ui.changeGroup.TeamsViewModel
import com.hogentessentials.essentials.ui.changeInitiatives.ChangeInitiativesViewModel
import com.hogentessentials.essentials.ui.dashboard.DashboardViewModel
import com.hogentessentials.essentials.ui.login.ui.login.LoginViewModel
import com.hogentessentials.essentials.ui.roadMap.list.RoadMapListViewModel
import com.hogentessentials.essentials.ui.survey.SurveyDoneViewModel
import com.hogentessentials.essentials.ui.survey.SurveyQuestionViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { DashboardViewModel(get(), get(), get()) }
    viewModel { ChangeInitiativesViewModel(get()) }
    viewModel { RoadMapListViewModel(get()) }
    viewModel { SurveyQuestionViewModel(get()) }
    viewModel { TeamsViewModel(get()) }
    viewModel { LoginViewModel(get()) }
    viewModel { SurveyDoneViewModel(get()) }
}
