package com.tony.reduxkotlinsample.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.tony.reduxkotlinsample.AppContext
import com.tony.reduxkotlinsample.R
import com.tony.reduxkotlinsample.state.dataflow.AppAction
import com.tony.reduxkotlinsample.state.dataflow.AppResult
import com.tony.reduxkotlinsample.state.dataflow.AppState

/**
 * 用户注册
 */
class RegisterActivity: BaseActivity() {


    var et_username: EditText? = null
    var et_password: EditText? = null
    var et_password2: EditText? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        setup()
    }

    fun setup() {
        et_username = findViewById(R.id.et_username)
        et_password = findViewById(R.id.et_password)
        et_password2 = findViewById(R.id.et_password2)

        findViewById<Button>(R.id.bt_login).setOnClickListener {

            val username = et_username!!.text.toString().trim()
            val password = et_password!!.text.toString().trim()
            val password2 = et_password2!!.text.toString().trim()
            AppContext.store.dispatch(AppAction.REGISTER.addExtra(AppResult(Triple(username, password, password2) as Object)))
        }
    }

    override fun onChangedState(action: AppAction, state: AppState) {

        when(action) {
            AppAction.ACCOUNT_BEHAVIOR_DONE -> {
                if (action.extra != null) {
                    if (action.extra?.failure != null) {
                        val error = action.extra!!.failure
                        Toast.makeText(this, error.toString(), Toast.LENGTH_SHORT).show()
                    } else {
                        Toast.makeText(this, "注册成功，请登录！", Toast.LENGTH_SHORT).show()
                        startActivity(Intent(this@RegisterActivity, LoginActivity::class.java))
                        finish()
                    }
                }
            }
        }
    }

}