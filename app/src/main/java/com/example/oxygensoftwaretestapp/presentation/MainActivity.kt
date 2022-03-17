package com.example.oxygensoftwaretestapp.presentation

import android.content.Intent
import android.os.Bundle
import android.provider.Settings
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.example.oxygensoftwaretestapp.InstagramAccessibilityService
import com.example.oxygensoftwaretestapp.R
import com.example.oxygensoftwaretestapp.di.MainActivityDICompanion
import com.example.oxygensoftwaretestapp.isAccessibilityServiceEnabled
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val mViewModel: MainActivityViewModel by lazy {
        viewModel(
            getInstUserNameUseCase = MainActivityDICompanion.getInstUserNameUseCase
        )
    }

    private val instagramAccessibilityService =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
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
            if (isAccessibilityServiceEnabled(InstagramAccessibilityService::class.java)) {
                mViewModel.getInstagramNickName(this)
            } else {
                instagramAccessibilityService.launch(Intent(Settings.ACTION_ACCESSIBILITY_SETTINGS))
            }
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