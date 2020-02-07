package com.sergio.study.presentation.ui.userdetail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sergio.study.domain.models.User
import com.sergio.study.domain.usecases.user.FindUserByIdUseCase
import kotlinx.coroutines.launch

class UserDetailViewModel(private val findUserByIdUseCase: FindUserByIdUseCase) : ViewModel() {

    private val _user = MutableLiveData<User>()
    val user: LiveData<User> = _user

    fun fetchUser(userId: String) {
        viewModelScope.launch {
            _user.value = findUserByIdUseCase(Integer.parseInt(userId))
        }
    }
}
