package com.example.oxygensoftwaretestapp.presentation

import com.example.oxygensoftwaretestapp.domain.useCase.GetInstUserNameUseCase
import com.example.oxygensoftwaretestapp.getViewModel

fun MainActivity.viewModel(
    getInstUserNameUseCase: GetInstUserNameUseCase
): MainActivityViewModel {
    return getViewModel {
        MainActivityViewModel(getInstUserNameUseCase = getInstUserNameUseCase)
    }
}