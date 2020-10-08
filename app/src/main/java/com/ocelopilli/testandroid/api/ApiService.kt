package com.ocelopilli.testandroid.api

import com.ocelopilli.testandroid.api.models.request.LoginRequest
import com.ocelopilli.testandroid.api.models.request.RegisterRequest
import com.ocelopilli.testandroid.api.models.result.*
import retrofit2.http.*

interface ApiService {

    @Headers("Content-Type: application/json")
    @POST("login/")
    fun login(@Body loginRequest: LoginRequest): retrofit2.Call<LoginResult>

    @Headers("Content-Type: application/json")
    @POST("users/")
    fun createNewUser(@Body registerRequest: RegisterRequest): retrofit2.Call<RegisterResult>

    @GET("users/")
    fun getAllUsers(): retrofit2.Call<ListUsersResult>

}