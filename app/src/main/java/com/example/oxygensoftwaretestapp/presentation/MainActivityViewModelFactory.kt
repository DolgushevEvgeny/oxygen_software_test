package com.example.oxygensoftwaretestapp.presentation

import com.example.oxygensoftwaretestapp.getViewModel

fun MainActivity.viewModel(): MainActivityViewModel {
    return getViewModel {
        MainActivityViewModel()
    }
}