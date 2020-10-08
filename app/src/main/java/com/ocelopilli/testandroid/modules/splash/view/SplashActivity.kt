package com.ocelopilli.testandroid.modules.splash.view

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.ocelopilli.testandroid.R
import com.ocelopilli.testandroid.TestAndroidApplication
import com.ocelopilli.testandroid.base.BaseActivity
import com.ocelopilli.testandroid.modules.userDetail.view.viewModel.UserDetailViewModel
import com.ocelopilli.testandroid.modules.login.view.LoginActivity
import com.ocelopilli.testandroid.modules.register.view.RegisterActivity
import com.ocelopilli.testandroid.modules.splash.viewModel.SplashViewModel
import javax.inject.Inject


class SplashActivity @Inject constructor(): BaseActivity() {

    private lateinit var splashViewModel: SplashViewModel

    override fun getLayoutResource() = R.layout.activity_splash

    override fun setUp(extras: Bundle?) {
        super.setUp(extras)
        splashViewModel.setUp()
    }

    override fun initVMObservers() {
        super.initVMObservers()
        splashViewModel = ViewModelProvider(this, viewModelFactory).get(SplashViewModel::class.java)
        splashViewModel.onAccessGranted().observe(this, Observer { onAccessGranted() })
        splashViewModel.onError().observe(this, Observer { onError(it) })
    }

    private fun onAccessGranted() {
        if(!TestAndroidApplication.prefs.login!!){
            startActivity(Intent(this, RegisterActivity::class.java))
        }else{
            startActivity(Intent(this, LoginActivity::class.java))
        }
        finish()
    }

    private fun onError(throwable: Throwable) {
        Log.e(javaClass.simpleName, throwable.message!!)
    }

}