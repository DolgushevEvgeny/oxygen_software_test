package com.example.oxygensoftwaretestapp.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.oxygensoftwaretestapp.R
import com.example.oxygensoftwaretestapp.di.MainActivityDICompanion
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val mViewModel: MainActivityViewModel by lazy {
        viewModel(
            getInstUserNameUseCase = MainActivityDICompanion.getInstUserNameUseCase
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        configureUI()
        subscribeToViewModel()
    }

    private fun configureUI() {
        configureStartInstagramAppButton()
    }

    private fun configureStartInstagramAppButton() {
        instNicknameBtn.setOnClickListener {
            mViewModel.getInstagramNickName(this)
        }
    }

    private fun subscribeToViewModel() {
        with(mViewModel) {
            usernameLiveData.observe(this@MainActivity) {
                nicknameTextView.text = it.value
            }
        }
    }
}