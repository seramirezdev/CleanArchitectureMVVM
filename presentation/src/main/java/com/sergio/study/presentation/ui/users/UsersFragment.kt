package com.sergio.study.presentation.ui.users

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.sergio.study.data.database.LocalDB_Impl
import com.sergio.study.data.datasources.local.UserDataSourceLocalImpl
import com.sergio.study.data.datasources.remote.UserDataSourceRemoteImpl
import com.sergio.study.data.repositories.UserRepositoryImpl
import com.sergio.study.domain.models.User
import com.sergio.study.domain.usecases.user.GetUsersUseCaseImpl
import com.sergio.study.presentation.R
import com.sergio.study.presentation.adapters.UserListAdapter
import com.sergio.study.presentation.utils.UserViewModelFactory
import kotlinx.android.synthetic.main.users_fragment.*

class UsersFragment : Fragment(),
    OnItemClick {

    private val viewModel: UserViewModel by lazy {
        val dao = LocalDB_Impl().userDao()
        val userRepository = UserRepositoryImpl(
            UserDataSourceRemoteImpl(context!!),
            UserDataSourceLocalImpl(dao)
        )
        UserViewModelFactory(
            GetUsersUseCaseImpl(
                userRepository
            )
        )
            .create(UserViewModel::class.java)
    }

    private lateinit var navController: NavController
    private val adapter by lazy {
        UserListAdapter(
            context!!,
            this
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.users_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)

        rvUserList.layoutManager = LinearLayoutManager(context)
        rvUserList.setAdapter(adapter)

        viewModel.fetchUsers()
        viewModel.users.observe(this, Observer(::updateUI))
    }

    private fun updateUI(users: List<User>) {
        adapter.setUsers(users)
    }

    override fun onClick(userId: String) {
        val usersFragmentDirections =
            UsersFragmentDirections.actionUserFragmentToUserDetailFragment(userId)
        navController.navigate(usersFragmentDirections)
    }
}

interface OnItemClick {
    fun onClick(userId: String)
}
