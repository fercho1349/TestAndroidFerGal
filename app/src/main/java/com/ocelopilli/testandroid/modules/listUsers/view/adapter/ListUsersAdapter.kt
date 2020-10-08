package com.ocelopilli.testandroid.modules.listUsers.view.adapter

import android.graphics.Color
import android.view.View
import com.ocelopilli.testandroid.R
import com.ocelopilli.testandroid.api.models.ListUser
import com.ocelopilli.testandroid.base.BaseAdapter
import com.ocelopilli.testandroid.extensionFunctions.setText
import com.ocelopilli.testandroid.modules.listUsers.view.holder.ListUsersHolder

class ListUsersAdapter : BaseAdapter<ArrayList<ListUser?>, ListUsersHolder>() {

    override fun getRowViewResourceId(): Int = R.layout.item_user
    override fun createHolder(cardView: View, viewType: Int): ListUsersHolder = ListUsersHolder(cardView)
    override fun getItemCount(): Int = if (dataSet.isNullOrEmpty()) 0 else dataSet!!.size

    override fun bindViewHolder(holder: ListUsersHolder, item: ArrayList<ListUser?>, position: Int) {
        holder.emailtxtOutputText.setText(item[position]?.email, "")
        holder.usernametxtOutputText.setText(item[position]?.username, "")
        if(position %2 == 1) {
            holder.cardview_book.setCardBackgroundColor(Color.parseColor("#03DAC5"))
        } else {
            holder.cardview_book.setCardBackgroundColor(Color.parseColor("#3700B3"))
        }
    }

    override fun bindViewHolderDefaultState(holder: ListUsersHolder) {
        holder.emailtxtOutputText.text = ""
        holder.usernametxtOutputText.text = ""
    }
}