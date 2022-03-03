package com.example.oxygensoftwaretestapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val viewModel: MainActivityViewModel by lazy {
        viewModel()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        configureUI()
        //Открыть сервисы
//        val intent = Intent(Settings.ACTION_ACCESSIBILITY_SETTINGS)
//        startActivityForResult(intent, 0)
    }

    private fun configureUI() {
        configureStartInstagramAppButton()
    }

    private fun configureStartInstagramAppButton() {
        instNicknameBtn.setOnClickListener {
            viewModel.getInstagramNickName(this)
        }
    }
}