package com.example.oxygensoftwaretestapp

fun MainActivity.viewModel(): MainActivityViewModel {
    return getViewModel {
        MainActivityViewModel()
    }
}