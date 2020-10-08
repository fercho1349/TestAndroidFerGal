package com.ocelopilli.testandroid.modules.register.contract

import androidx.lifecycle.MutableLiveData
import com.ocelopilli.testandroid.TestAndroidError
import com.ocelopilli.testandroid.api.models.result.RegisterResult

interface RegisterContract {
    interface IModel {
        fun setUp(email: String, username: String, password: String)
        fun onGetRegisterSucces(): MutableLiveData<RegisterResult>
        fun onGetRegisterServiceError(): MutableLiveData<TestAndroidError>
        fun onError(): MutableLiveData<String>
    }
}