package com.ocelopilli.testandroid.modules.userDetail.view.view

import android.os.Bundle
import androidx.annotation.LayoutRes
import com.ocelopilli.testandroid.R
import com.ocelopilli.testandroid.base.BaseActivity
import kotlinx.android.synthetic.main.shimmer_user_detail.*

class UserDetailActivity: BaseActivity() {

    @LayoutRes
    override fun getLayoutResource(): Int = R.layout.activity_user_detail

    override fun setUp(extras: Bundle?) {
        txt_user.text = extras?.getString("username")
        txt_email.text = extras?.getString("email")
    }

}