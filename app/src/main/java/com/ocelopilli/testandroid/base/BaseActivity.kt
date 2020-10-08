package com.ocelopilli.testandroid.base

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.annotation.LayoutRes
import androidx.annotation.StringRes
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.google.android.material.snackbar.Snackbar
import com.ocelopilli.testandroid.TestAndroidError
import com.ocelopilli.testandroid.R
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_base.*
import javax.inject.Inject

abstract class BaseActivity : DaggerAppCompatActivity(){

    private var snackbar: Snackbar? = null

    @LayoutRes
    abstract fun getLayoutResource(): Int

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_base)
        layoutInflater.inflate(getLayoutResource(), bodyContent, true)
        initVMObservers()
        initView()
        setUp(intent.extras)
    }

    protected open fun setUp(extras: Bundle?) {}

    protected open fun initVMObservers() {}

    protected open fun initView() {}

    fun showError(error: TestAndroidError, @StringRes actionTitle: Int, callback: View.OnClickListener){
        snackbar = Snackbar.make(findViewById(android.R.id.content), getText(error.errorType), Snackbar.LENGTH_INDEFINITE)
            .setAction(getText(actionTitle), callback)
            .setActionTextColor(ContextCompat.getColor(applicationContext, R.color.colorPrimary))
        snackbar?.view?.findViewById<TextView>(com.google.android.material.R.id.snackbar_text)?.maxLines = 4
        snackbar?.show()
    }

    fun hideError(){
        snackbar?.dismiss()
        snackbar = null
    }

}