package com.ocelopilli.testandroid.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Retrofit {

    companion object {
        fun provideApiService(): ApiService {
            val retrofit: Retrofit = Retrofit.Builder()
                .baseUrl("http://api-candidates-dev.us-west-2.elasticbeanstalk.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            return retrofit.create(ApiService::class.java)
        }
    }

}