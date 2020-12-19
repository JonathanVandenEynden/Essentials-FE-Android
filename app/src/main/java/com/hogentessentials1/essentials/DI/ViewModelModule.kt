package com.hogentessentials1.essentials.DI

import com.hogentessentials1.essentials.DeviceTokenViewModel
import com.hogentessentials1.essentials.ui.changeGroup.TeamsViewModel
import com.hogentessentials1.essentials.ui.changeInitiatives.ChangeInitiativesViewModel
import com.hogentessentials1.essentials.ui.dashboard.DashboardViewModel
import com.hogentessentials1.essentials.ui.login.ui.login.LoginViewModel
import com.hogentessentials1.essentials.ui.myChangeInitiatives.list.MyChangesQuestionListViewModel
import com.hogentessentials1.essentials.ui.roadMap.list.RoadMapListViewModel
import com.hogentessentials1.essentials.ui.survey.SurveyDoneViewModel
import com.hogentessentials1.essentials.ui.survey.SurveyQuestionViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
/**
 * Definitions of the viewmodel module
 *
 * @author Simon De Wilde
 * @author Kilian Hoefman
 * @author Jonathan VEVL
 * @author Marbod Naasens
 * @author Ziggy Moens
 * @author Sébastien De Pauw
 */
val viewModelModule = module {
    viewModel { DashboardViewModel(get(), get(), get()) }
    viewModel { ChangeInitiativesViewModel(get()) }
    viewModel { RoadMapListViewModel(get()) }
    viewModel { SurveyQuestionViewModel(get()) }
    viewModel { TeamsViewModel(get()) }
    viewModel { LoginViewModel(get()) }
    viewModel { SurveyDoneViewModel(get()) }
    viewModel { MyChangesQuestionListViewModel(get()) }
    viewModel { DeviceTokenViewModel(get()) }
}