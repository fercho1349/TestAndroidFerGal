package com.ocelopilli.testandroid.modules.login.contract

import androidx.lifecycle.MutableLiveData
import com.ocelopilli.testandroid.TestAndroidError
import com.ocelopilli.testandroid.api.models.result.LoginResult

interface LoginContract {
    interface IModel {
        fun setUp(email: String, password: String)
        fun onGetLoginSucces(): MutableLiveData<LoginResult>
        fun onGetLoginServiceError(): MutableLiveData<TestAndroidError>
        fun onError(): MutableLiveData<String>
    }
}