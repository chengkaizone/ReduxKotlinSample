package com.tony.reduxkotlinsample.state.dataflow.reduce

import com.tony.reduxkotlinsample.model.User
import com.tony.reduxkotlinsample.state.dataflow.AppAction
import com.tony.reduxkotlinsample.state.dataflow.AppError
import com.tony.reduxkotlinsample.state.dataflow.AppState
import com.tony.reduxkotlinsample.state.dataflow.command.AppCommand
import com.tony.reduxkotlinsample.state.dataflow.command.LoginAppCommand
import com.tony.reduxkotlinsample.state.dataflow.command.LogoutAppCommand
import com.tony.reduxkotlinsample.state.dataflow.command.RegisterAppCommand

/**
 * 执行具体事件
 */
class AccountReducer {

    companion object {

        /**
         * 纯函数，由于Java语言的局限性，不支持结构体，所以state和action只能以class的形式出现
         * 但是reduce纯函数中不建议修改参数中的内容
         */
        fun reduce(state: AppState, action: AppAction): Pair<AppState, AppCommand?> {

            var command: AppCommand? = null
            when (action) {
                AppAction.REGISTER -> {
                    state.accountRequesting = true
                    // 保证传进来的参数一致
                    val params = action.extra!!.value as Triple<String, String, String>
                    command = RegisterAppCommand(params.first, params.second, params.third)
                }
                AppAction.LOGIN -> {
                    state.accountRequesting = true
                    // 保证传进来的参数一致
                    val params = action.extra!!.value as Pair<String, String>
                    command = LoginAppCommand(params.first, params.second)
                }
                AppAction.ACCOUNT_BEHAVIOR_DONE -> {
                    state.accountRequesting = false
                    val result = action.extra!!
                    if (result.failure != null) {
                        state.accountError = result.failure
                    } else {
                        if (result.value != null) {
                            val user = result.value as User
                            state.user = user
                            state.accountError = null
                        } else {
                            state.accountError = AppError("注册成功，请登录！")
                        }
                    }
                }
                AppAction.LOGOUT -> {
                    state.accountRequesting = false
                    command = LogoutAppCommand()
                }
                AppAction.LOGOUT_DONE -> {
                    state.user = null
                }
            }
            return Pair(state, command)
        }
    }



}