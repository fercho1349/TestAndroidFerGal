package com.ocelopilli.testandroid.api.models.result

import com.ocelopilli.testandroid.api.models.ListUser

data class ListUsersResult (
    val resources: ArrayList<ListUser?> = ArrayList(),
    val count: String
)