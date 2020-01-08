package com.tony.reduxkotlinsample.state.dataflow.command

import com.tony.reduxkotlinsample.model.User
import com.tony.reduxkotlinsample.state.dataflow.*

/**
 * 登录请求
 */
class LoginAppCommand (val username: String, val password: String) : AppCommand {

    override fun execute(store: Store) {
        Thread {
            kotlin.run {
                Thread.sleep(500L)

                if (username.length < 6 || username.length > 16) {
                    store.dispatch(AppAction.ACCOUNT_BEHAVIOR_DONE.addExtra(AppResult(failure = AppError("用户名长度限制为6~16位"))))
                } else if (password == "password") {
                    val user = User(username, password)
                    store.dispatch(AppAction.ACCOUNT_BEHAVIOR_DONE.addExtra(AppResult(user)))
                } else {
                    store.dispatch(AppAction.ACCOUNT_BEHAVIOR_DONE.addExtra(AppResult(failure = AppError("账户密码不正确"))))
                }

            }
        }.start()
    }

}