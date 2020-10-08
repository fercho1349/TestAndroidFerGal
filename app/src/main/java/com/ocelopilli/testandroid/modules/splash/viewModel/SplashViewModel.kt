package com.ocelopilli.testandroid.modules.splash.viewModel

import android.os.Handler
import androidx.lifecycle.MutableLiveData
import com.ocelopilli.testandroid.base.BaseViewModel
import com.ocelopilli.testandroid.modules.splash.contract.SplashContract
import com.ocelopilli.testandroid.modules.userDetail.view.contract.UserDetailContract
import javax.inject.Inject

class SplashViewModel @Inject constructor() : BaseViewModel(), SplashContract.IModel {

    private val grantedAccessAppMLD: MutableLiveData<Boolean> = MutableLiveData()
    private val errorMLD: MutableLiveData<Throwable> = MutableLiveData()
    private val TIME_OUT = 3000L

    override fun setUp() {
        Handler().postDelayed({
            grantedAccessAppMLD.value = true
        }, TIME_OUT)
    }

    override fun onAccessGranted(): MutableLiveData<Boolean> = grantedAccessAppMLD
    override fun onError(): MutableLiveData<Throwable> = errorMLD

}