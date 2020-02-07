package com.sergio.study.presentation.ui.users

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sergio.study.domain.models.User
import com.sergio.study.domain.usecases.user.GetUsersUseCase
import kotlinx.coroutines.launch

class UserViewModel(
    private val getUsersUseCase: GetUsersUseCase
) : ViewModel() {

    private val _users = MutableLiveData<List<User>>()

    val users: LiveData<List<User>> = _users

    fun fetchUsers() {
        viewModelScope.launch {
            _users.value = getUsersUseCase.invoke()
        }
    }
}
