package com.dwarvesv.mvvm.view.list.adapter

import android.support.v7.widget.RecyclerView
import android.view.View
import com.dwarvesv.mvvm.data.model.User
import io.reactivex.subjects.PublishSubject
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_list.*

class MvpViewHolder(override val containerView: View?) : RecyclerView.ViewHolder(containerView!!),
        LayoutContainer {

    fun bind(user: User, clickSubject: PublishSubject<User>) {

        itemView.setOnClickListener {
            clickSubject.onNext(user)
        }
        tvUserName.text = user.fullName
        tvContent.text = user.description
        tvName.text = user.name
    }

}

