package com.example.oxygensoftwaretestapp.domain.useCase

import android.content.ContentValues
import com.example.oxygensoftwaretestapp.domain.IUserNameRepository
import com.example.oxygensoftwaretestapp.domain.models.SaveInstUserNameParams

class SaveInstUserNameUseCase(
    private val usernameRepository: IUserNameRepository
) {

    fun execute(params: SaveInstUserNameParams) {
        val cv = ContentValues()
        cv.put("id", 1)
        cv.put("username", params.username)
        usernameRepository.saveInstUsername(cv)
    }
}