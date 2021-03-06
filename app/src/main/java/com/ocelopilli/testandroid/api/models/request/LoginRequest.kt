package com.ocelopilli.testandroid.api.models.request

import com.google.gson.annotations.SerializedName
import java.io.Serializable

class LoginRequest : Serializable {
    @SerializedName("email")
    var email: String? = null
    @SerializedName("password")
    var password: String? = null
}