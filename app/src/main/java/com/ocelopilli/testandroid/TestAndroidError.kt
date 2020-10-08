package com.ocelopilli.testandroid

import retrofit2.HttpException

class TestAndroidError {
    var errorType: Int

    constructor(error: Throwable) {
        errorType = when {
            (error is HttpException) -> getError(error)
            else -> R.string.fallback_error
        }
    }

    private fun getError(error: HttpException): Int =
        when (error.code()) {
            400 -> R.string.error_400
            else -> R.string.fallback_error
        }
}