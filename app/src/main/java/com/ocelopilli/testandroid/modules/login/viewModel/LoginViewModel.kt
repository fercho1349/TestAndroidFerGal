package com.ocelopilli.testandroid.modules.login.viewModel

import androidx.lifecycle.MutableLiveData
import com.ocelopilli.testandroid.TestAndroidError
import com.ocelopilli.testandroid.api.Retrofit
import com.ocelopilli.testandroid.api.models.request.LoginRequest
import com.ocelopilli.testandroid.api.models.result.LoginResult
import com.ocelopilli.testandroid.base.BaseViewModel
import com.ocelopilli.testandroid.modules.login.contract.LoginContract
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class LoginViewModel @Inject constructor() : BaseViewModel(), LoginContract.IModel,
    Callback<LoginResult> {

    private val loginListMLD: MutableLiveData<LoginResult> = MutableLiveData()
    private val loginServiceErrorMLD: MutableLiveData<TestAndroidError> = MutableLiveData()
    private val errorMLD: MutableLiveData<String> = MutableLiveData()

    override fun setUp(email: String, password: String) {
        val loginRequest = LoginRequest()
        loginRequest.email = email
        loginRequest.password = password
        val api = Retrofit.provideApiService()
        val call = api.login(loginRequest)
        call.enqueue(this)
    }

    override fun onGetLoginSucces(): MutableLiveData<LoginResult> = loginListMLD
    override fun onGetLoginServiceError(): MutableLiveData<TestAndroidError> = loginServiceErrorMLD
    override fun onError(): MutableLiveData<String> = errorMLD
    override fun onFailure(call: Call<LoginResult>, t: Throwable) {
        t.printStackTrace()
        loginServiceErrorMLD.value = TestAndroidError(t)
    }

    override fun onResponse(call: Call<LoginResult>, response: Response<LoginResult>) {
        when {
            response.body() == null -> {
                errorMLD.value = "Error, intente de nuevo"
            }else -> {
                loginListMLD.value = response.body()!!
            }
        }
    }

}