package com.ocelopilli.testandroid.modules.listUsers.contract

import androidx.lifecycle.MutableLiveData
import com.ocelopilli.testandroid.TestAndroidError
import com.ocelopilli.testandroid.api.models.ListUser

interface ListUsersContract {
    interface IModel {
        fun setUp()
        fun onGetListUsersSucces(): MutableLiveData<ArrayList<ListUser?>>
        fun onGetListUsersServiceError(): MutableLiveData<TestAndroidError>
        fun onError(): MutableLiveData<String>
    }
}