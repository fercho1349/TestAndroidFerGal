package com.ocelopilli.testandroid.modules.listUsers.view

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.annotation.LayoutRes
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.ocelopilli.testandroid.TestAndroidError
import com.ocelopilli.testandroid.R
import com.ocelopilli.testandroid.api.models.ListUser
import com.ocelopilli.testandroid.base.BaseActivity
import com.ocelopilli.testandroid.base.BaseAdapter
import com.ocelopilli.testandroid.modules.listUsers.viewModel.ListUsersViewModel
import com.ocelopilli.testandroid.modules.listUsers.view.adapter.ListUsersAdapter
import com.ocelopilli.testandroid.modules.userDetail.view.view.UserDetailActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.shimmer_recycler_view.*

class ListUsersActivity : BaseActivity(), BaseAdapter.OnItemClickListener<ArrayList<ListUser?>>,
    SwipeRefreshLayout.OnRefreshListener{

    private lateinit var adapter: ListUsersAdapter
    private lateinit var listUsersViewModel: ListUsersViewModel

    @LayoutRes
    override fun getLayoutResource(): Int = R.layout.activity_main

    override fun setUp(extras: Bundle?) {
        getRequest()
    }

    override fun initVMObservers() {
        super.initVMObservers()
        listUsersViewModel = ViewModelProvider(this).get(ListUsersViewModel::class.java)
        listUsersViewModel.onGetListUsersSucces().observe(this, Observer { onListUsersRetrieved(it) })
        listUsersViewModel.onGetListUsersServiceError().observe(this, Observer { onListUsersRetrieveError(it) })
        listUsersViewModel.onError().observe(this, Observer { onError(it) })
    }

    override fun initView() {
        super.initView()
        shimmerView_listUsers.startShimmer()
        adapter = ListUsersAdapter()
        recyclerView_listUsers.setHasFixedSize(true)
        recyclerView_listUsers.layoutManager = LinearLayoutManager(
            applicationContext,
            RecyclerView.VERTICAL,
            false
        )
        recyclerView_listUsers.adapter = adapter
        adapter.onItemClickListener = this

        itemsswipetorefresh.setProgressBackgroundColorSchemeColor(ContextCompat.getColor(this, R.color.colorPrimary))
        itemsswipetorefresh.setColorSchemeColors(Color.WHITE)
        itemsswipetorefresh.setOnRefreshListener(this)
    }

    private fun onListUsersRetrieved(it: ArrayList<ListUser?>) {
        shimmerView_listUsers.stopShimmer()
        adapter.changeDataSet(it)
    }

    private fun onListUsersRetrieveError(it: TestAndroidError) {
        Log.e(javaClass.simpleName, it.toString())
        shimmerView_listUsers.stopShimmer()
        showError(it, R.string.retry, reloadView)
    }

    private val reloadView = View.OnClickListener {
        hideError()
        getRequest()
    }

    private fun getRequest(){
        listUsersViewModel.setUp()
    }

    private fun onError(mensaje: String) {
        Toast.makeText(applicationContext, mensaje, Toast.LENGTH_LONG).show()
    }

    override fun onItemClick(view: View, entity: ArrayList<ListUser?>, position: Int) {
        val intent = Intent(applicationContext, UserDetailActivity::class.java)
        intent.putExtra("email", entity[position]?.email)
        intent.putExtra("username", entity[position]?.username)
        startActivity(intent)
    }

    override fun onRefresh() {
        shimmerView_listUsers.startShimmer()
        itemsswipetorefresh.isRefreshing = false
        getRequest()
    }

}