package com.example.oxygensoftwaretestapp.domain.useCase

import com.example.oxygensoftwaretestapp.domain.IUserNameRepository
import com.example.oxygensoftwaretestapp.domain.models.UserName

class GetInstUserNameUseCase(private val usernameRepository: IUserNameRepository) {

    fun execute(): UserName {
        val cursor = usernameRepository.getInstUserName()
        if (cursor.moveToFirst()) {
            val usernameColIndex: Int = cursor.getColumnIndex("username")
            val username = cursor.getString(usernameColIndex)
            return UserName(username)
        }
        return UserName("")
    }
}