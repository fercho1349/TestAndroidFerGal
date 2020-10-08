package com.ocelopilli.testandroid.modules.listUsers.view.holder

import android.view.View
import androidx.appcompat.widget.AppCompatTextView
import androidx.cardview.widget.CardView
import com.ocelopilli.testandroid.base.BaseHolder
import kotlinx.android.synthetic.main.item_user.view.*

class ListUsersHolder (itemView: View) : BaseHolder(itemView) {

    val emailtxtOutputText = itemView.emailtxt as AppCompatTextView
    val usernametxtOutputText = itemView.usernametxt as AppCompatTextView
    val cardview_book = itemView.cardview_book as CardView
}