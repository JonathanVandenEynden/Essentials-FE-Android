package com.hogentessentials1.essentials.data.model.DI

import com.hogentessentials1.essentials.ui.surveys.AllSurveysViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { AllSurveysViewModel(get()) }
}
