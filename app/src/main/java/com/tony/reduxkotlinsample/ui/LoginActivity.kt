package com.tony.reduxkotlinsample.ui

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.tony.reduxkotlinsample.AppContext
import com.tony.reduxkotlinsample.R
import com.tony.reduxkotlinsample.model.User
import com.tony.reduxkotlinsample.state.dataflow.AppAction
import com.tony.reduxkotlinsample.state.dataflow.AppResult
import com.tony.reduxkotlinsample.state.dataflow.AppState

/**
 * 用户登录
 */
class LoginActivity : BaseActivity() {

    var et_username: EditText? = null
    var et_password: EditText? = null
    var tv_userinfo: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        setup()
    }

    fun setup() {
        et_username = findViewById(R.id.et_username)
        et_password = findViewById(R.id.et_password)
        tv_userinfo = findViewById(R.id.tv_userinfo)

        findViewById<Button>(R.id.bt_login).setOnClickListener {

            val username = et_username!!.text.toString().trim()
            val password = et_password!!.text.toString().trim()
            AppContext.store.dispatch(AppAction.LOGIN.addExtra(AppResult(Pair(username, password) as Object)))
        }

        findViewById<Button>(R.id.bt_logout).setOnClickListener {
            AppContext.store.dispatch(AppAction.LOGOUT)
        }
    }

    override fun onChangedState(action: AppAction, state: AppState) {

        when(action) {
            AppAction.ACCOUNT_BEHAVIOR_DONE -> {
                if (action.extra != null) {
                    if (action.extra!!.failure != null) {
                        val error = action.extra!!.failure
                        Toast.makeText(this, error.toString(), Toast.LENGTH_SHORT).show()
                        tv_userinfo?.text = "用户信息：$error"
                    } else {
                        val user = action.extra!!.value as User
                        Toast.makeText(this, "登录成功！", Toast.LENGTH_SHORT).show()
                        tv_userinfo?.text = "用户信息：${user}"
                    }
                }
            }
            AppAction.LOGOUT_DONE -> {
                if (action.extra != null) {
                    if (action.extra!!.failure != null) {
                        val error = action.extra!!.failure
                        Toast.makeText(this, error.toString(), Toast.LENGTH_SHORT).show()
                        tv_userinfo?.text = "退出登录：$error"
                    }
                } else {
                    Toast.makeText(this, "登录成功！", Toast.LENGTH_SHORT).show()
                    tv_userinfo?.text = "退出成功"
                }
            }
        }
    }

}