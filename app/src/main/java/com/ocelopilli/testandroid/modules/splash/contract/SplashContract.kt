package com.ocelopilli.testandroid.modules.splash.contract

import androidx.lifecycle.MutableLiveData

interface SplashContract {
    interface IModel {
        fun setUp()
        fun onAccessGranted(): MutableLiveData<Boolean>
        fun onError(): MutableLiveData<Throwable>
    }
}