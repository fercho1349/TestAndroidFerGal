package com.ocelopilli.testandroid.modules.register.viewModel

import androidx.lifecycle.MutableLiveData
import com.ocelopilli.testandroid.TestAndroidError
import com.ocelopilli.testandroid.api.Retrofit
import com.ocelopilli.testandroid.api.models.request.RegisterRequest
import com.ocelopilli.testandroid.api.models.result.RegisterResult
import com.ocelopilli.testandroid.base.BaseViewModel
import com.ocelopilli.testandroid.modules.register.contract.RegisterContract
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class RegisterViewModel @Inject constructor() : BaseViewModel(), RegisterContract.IModel,
    Callback<RegisterResult> {

    private val registerListMLD: MutableLiveData<RegisterResult> = MutableLiveData()
    private val registerServiceErrorMLD: MutableLiveData<TestAndroidError> = MutableLiveData()
    private val errorMLD: MutableLiveData<String> = MutableLiveData()

    override fun setUp(email: String, username: String, password: String) {
        val registerRequest = RegisterRequest()
        registerRequest.email = email
        registerRequest.username = username
        registerRequest.password = password
        val api = Retrofit.provideApiService()
        val call = api.createNewUser(registerRequest)
        call.enqueue(this)
    }

    override fun onGetRegisterSucces(): MutableLiveData<RegisterResult> = registerListMLD
    override fun onGetRegisterServiceError(): MutableLiveData<TestAndroidError> = registerServiceErrorMLD
    override fun onError(): MutableLiveData<String> = errorMLD
    override fun onFailure(call: Call<RegisterResult>, t: Throwable) {
        t.printStackTrace()
        registerServiceErrorMLD.value = TestAndroidError(t)
    }

    override fun onResponse(call: Call<RegisterResult>, response: Response<RegisterResult>) {
        when {
            response.body() == null -> {
                errorMLD.value = "Error, intente de nuevo"
            }else -> {
                registerListMLD.value = response.body()!!
            }
        }
    }

}