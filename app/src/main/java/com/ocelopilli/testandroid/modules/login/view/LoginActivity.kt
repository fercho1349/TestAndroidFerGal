package com.ocelopilli.testandroid.modules.login.view

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.annotation.LayoutRes
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.ocelopilli.testandroid.TestAndroidError
import com.ocelopilli.testandroid.R
import com.ocelopilli.testandroid.TestAndroidApplication
import com.ocelopilli.testandroid.api.models.result.LoginResult
import com.ocelopilli.testandroid.base.BaseActivity
import com.ocelopilli.testandroid.modules.login.viewModel.LoginViewModel
import com.ocelopilli.testandroid.modules.listUsers.view.ListUsersActivity
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity: BaseActivity(), View.OnClickListener {

    private lateinit var loginViewModel: LoginViewModel

    @LayoutRes
    override fun getLayoutResource(): Int = R.layout.activity_login

    override fun setUp(extras: Bundle?) {
        login.setOnClickListener(this)
    }

    override fun initVMObservers() {
        super.initVMObservers()
        loginViewModel = ViewModelProvider(this).get(LoginViewModel::class.java)
        loginViewModel.onGetLoginSucces().observe(this, Observer { onLoginRetrieved(it) })
        loginViewModel.onGetLoginServiceError().observe(this, Observer { onLoginRetrieveError(it) })
        loginViewModel.onError().observe(this, Observer { onError(it) })
    }

    private fun onLoginRetrieved(it: LoginResult) {
        startActivity(Intent(this, ListUsersActivity::class.java))
    }

    private fun onLoginRetrieveError(it: TestAndroidError) {
        showError(it, R.string.retry, reloadView)
    }

    private val reloadView = View.OnClickListener {
        hideError()
        getRequest()
    }

    private fun getRequest(){
        loginViewModel.setUp(email_login.text.toString(), password_login.text.toString())
    }

    private fun onError(mensaje: String) {
        Toast.makeText(applicationContext, mensaje, Toast.LENGTH_LONG).show()
    }

    override fun onClick(v: View?) {
        if(v?.id == R.id.login){
            getRequest()
        }
    }

}