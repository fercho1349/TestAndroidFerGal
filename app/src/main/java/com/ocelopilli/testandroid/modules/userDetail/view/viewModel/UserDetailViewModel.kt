package com.ocelopilli.testandroid.modules.userDetail.view.viewModel

import com.ocelopilli.testandroid.base.BaseViewModel
import com.ocelopilli.testandroid.modules.userDetail.view.contract.UserDetailContract
import javax.inject.Inject

class UserDetailViewModel @Inject constructor() : BaseViewModel(), UserDetailContract.IModel {

    override fun setUp() {}
}