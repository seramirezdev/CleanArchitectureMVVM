package com.sergio.study.presentation.utils

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.sergio.study.domain.usecases.user.FindUserByIdUseCase
import com.sergio.study.domain.usecases.user.GetUsersUseCase
import com.sergio.study.presentation.ui.users.UserViewModel

@Suppress("UNCHECKED_CAST")
class UserViewModelFactory(
    private val getUsersUseCase: GetUsersUseCase
) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return UserViewModel(
            getUsersUseCase
        ) as T
    }
}