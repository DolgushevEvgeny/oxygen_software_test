package com.example.oxygensoftwaretestapp.domain.useCase

import android.content.ContentValues
import com.example.oxygensoftwaretestapp.domain.IUserNameRepository
import com.example.oxygensoftwaretestapp.domain.models.SaveInstUserNameParams

class SaveInstUserNameUseCase(
    private val usernameRepository: IUserNameRepository
) {

    fun execute(params: SaveInstUserNameParams) {
        val cv = ContentValues()
        cv.put(ID_COLUMN_INDEX, 1)
        cv.put(USERNAME_COLUMN_INDEX, params.username)
        usernameRepository.saveInstUsername(cv)
    }

    companion object {
        private const val ID_COLUMN_INDEX = "id"
        private const val USERNAME_COLUMN_INDEX = "username"
    }
}