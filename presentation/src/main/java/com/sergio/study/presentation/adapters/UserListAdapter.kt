package com.sergio.study.presentation.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.marshalchen.ultimaterecyclerview.UltimateViewAdapter
import com.sergio.study.domain.models.User
import com.sergio.study.presentation.R
import com.sergio.study.presentation.ui.users.OnItemClick
import kotlinx.android.synthetic.main.custom_item_user_list.view.*

class UserListAdapter(private val context: Context, private val onClickItemListener: OnItemClick) :
    UltimateViewAdapter<UserListAdapter.UserViewHolder>() {

    private var users = mutableListOf<User>()
    fun setUsers(users: List<User>) {
        this.users = users as MutableList<User>
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup?): UserViewHolder {
        val view =
            LayoutInflater.from(context).inflate(R.layout.custom_item_user_list, parent, false)
        return UserViewHolder(
            view
        )
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) =
        holder.bind(users[position], onClickItemListener)

    override fun getAdapterItemCount(): Int = users.size

    class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(user: User, onClickItemListener: OnItemClick) {
            itemView.setOnClickListener { onClickItemListener.onClick(user.id) }
            itemView.txtInitialLetter.text = user.name[0].toString()
            itemView.txtName.text = user.name
            itemView.txtUserName.text = user.username
        }
    }

    override fun onBindHeaderViewHolder(holder: RecyclerView.ViewHolder?, position: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onCreateHeaderViewHolder(parent: ViewGroup?): RecyclerView.ViewHolder {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun generateHeaderId(position: Int): Long {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun newFooterHolder(view: View?): UserViewHolder {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun newHeaderHolder(view: View?): UserViewHolder {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
