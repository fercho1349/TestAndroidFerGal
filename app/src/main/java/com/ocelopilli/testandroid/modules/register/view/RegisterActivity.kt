package com.ocelopilli.testandroid.modules.register.view

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.inputmethod.EditorInfo
import android.widget.Toast
import androidx.annotation.LayoutRes
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.ocelopilli.testandroid.R
import com.ocelopilli.testandroid.TestAndroidError
import com.ocelopilli.testandroid.TestAndroidApplication
import com.ocelopilli.testandroid.api.models.result.RegisterResult
import com.ocelopilli.testandroid.base.BaseActivity
import com.ocelopilli.testandroid.modules.register.viewModel.RegisterViewModel
import com.ocelopilli.testandroid.modules.listUsers.view.ListUsersActivity
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : BaseActivity(), View.OnClickListener{

    private lateinit var registerViewModel: RegisterViewModel

    @LayoutRes
    override fun getLayoutResource(): Int = R.layout.activity_register

    override fun setUp(extras: Bundle?) {
        super.setUp(extras)
        register.setOnClickListener{
            getRequest()
        }
    }

    override fun initVMObservers() {
        super.initVMObservers()
        registerViewModel = ViewModelProvider(this).get(RegisterViewModel::class.java)
        registerViewModel.onGetRegisterSucces().observe(this, Observer { onRegisterRetrieved(it) })
        registerViewModel.onGetRegisterServiceError().observe(this, Observer { onRegisterRetrieveError(it) })
        registerViewModel.onError().observe(this, Observer { onError(it) })
    }

    private fun onRegisterRetrieved(it: RegisterResult) {
        TestAndroidApplication.prefs.login = true
        startActivity(Intent(this, ListUsersActivity::class.java))
    }

    private fun onRegisterRetrieveError(it: TestAndroidError) {
        showError(it, R.string.retry, reloadView)
    }

    private val reloadView = View.OnClickListener {
        hideError()
        getRequest()
    }

    private fun getRequest(){
        registerViewModel.setUp(email.text.toString(), username.text.toString(), password.text.toString())
    }

    private fun onError(mensaje: String) {
        Toast.makeText(applicationContext, mensaje, Toast.LENGTH_LONG).show()
    }

    override fun onClick(v: View?) {
        if(v?.id == R.id.register){
            getRequest()
        }
    }

}