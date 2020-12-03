package com.hogentessentials1.essentials.data.model.DI

import com.hogentessentials1.essentials.login.ui.login.LoginViewModel
import com.hogentessentials1.essentials.ui.changeGroup.TeamsViewModel
import com.hogentessentials1.essentials.ui.changeInitiatives.ChangeInitiativesViewModel
import com.hogentessentials1.essentials.ui.roadMap.list.RoadMapListViewModel
import com.hogentessentials1.essentials.ui.survey.SurveyDoneViewModel
import com.hogentessentials1.essentials.ui.survey.SurveyQuestionViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { ChangeInitiativesViewModel(get()) }
    viewModel { RoadMapListViewModel(get()) }
    viewModel { SurveyQuestionViewModel(get()) }
    viewModel { TeamsViewModel(get()) }
    viewModel { LoginViewModel(get()) }
    viewModel { SurveyDoneViewModel(get()) }
}
