package com.ocelopilli.testandroid.modules.listUsers.viewModel

import androidx.lifecycle.MutableLiveData
import com.ocelopilli.testandroid.TestAndroidError
import com.ocelopilli.testandroid.api.Retrofit
import com.ocelopilli.testandroid.api.models.ListUser
import com.ocelopilli.testandroid.api.models.result.ListUsersResult
import com.ocelopilli.testandroid.base.BaseViewModel
import com.ocelopilli.testandroid.modules.listUsers.contract.ListUsersContract
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class ListUsersViewModel @Inject constructor() : BaseViewModel(), ListUsersContract.IModel,
    Callback<ListUsersResult> {

    private val listUsersMLD: MutableLiveData<ArrayList<ListUser?>> = MutableLiveData()
    private val listUsersServiceErrorMLD: MutableLiveData<TestAndroidError> = MutableLiveData()
    private val errorMLD: MutableLiveData<String> = MutableLiveData()

    override fun setUp() {
        val api = Retrofit.provideApiService()
        val call = api.getAllUsers()
        call.enqueue(this)
    }

    override fun onGetListUsersSucces(): MutableLiveData<ArrayList<ListUser?>> = listUsersMLD
    override fun onGetListUsersServiceError(): MutableLiveData<TestAndroidError> = listUsersServiceErrorMLD
    override fun onError(): MutableLiveData<String> = errorMLD
    override fun onFailure(call: Call<ListUsersResult>, t: Throwable) {
        t.printStackTrace()
        listUsersServiceErrorMLD.value = TestAndroidError(t)
    }

    override fun onResponse(call: Call<ListUsersResult>, response: Response<ListUsersResult>) {
        when {
            response.body() == null -> {
                errorMLD.value = "Error, intente de nuevo"
            }else -> {
                listUsersMLD.value = response.body()!!.resources
            }
        }
    }

}