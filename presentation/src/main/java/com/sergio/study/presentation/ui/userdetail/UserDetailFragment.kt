package com.sergio.study.presentation.ui.userdetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.sergio.study.data.database.LocalDB_Impl
import com.sergio.study.data.datasources.local.UserDataSourceLocalImpl
import com.sergio.study.data.datasources.remote.UserDataSourceRemoteImpl
import com.sergio.study.data.repositories.UserRepositoryImpl
import com.sergio.study.domain.models.User
import com.sergio.study.domain.usecases.user.FindUserByIdUseCaseImpl
import com.sergio.study.presentation.R
import com.sergio.study.presentation.utils.UserDetailViewModelFactory
import kotlinx.android.synthetic.main.user_detail_fragment.*

class UserDetailFragment : Fragment() {

    private val viewModel: UserDetailViewModel by lazy {
        val dao = LocalDB_Impl().userDao()
        val userRepository = UserRepositoryImpl(
            UserDataSourceRemoteImpl(context!!),
            UserDataSourceLocalImpl(dao)
        )
        UserDetailViewModelFactory(
            FindUserByIdUseCaseImpl(
                userRepository
            )
        )
            .create(UserDetailViewModel::class.java)
    }

    private lateinit var userId: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            userId = UserDetailFragmentArgs.fromBundle(it).userId
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.user_detail_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel.fetchUser(userId)
        viewModel.user.observe(this, Observer(::updateUI))
    }

    private fun updateUI(user: User) {
        txtName.text = user.name
        txtCompany.text = user.company.name
        txtWebsite.text = user.website
        txtEmail.text = user.email
        txtPhone.text = user.phone
    }
}
