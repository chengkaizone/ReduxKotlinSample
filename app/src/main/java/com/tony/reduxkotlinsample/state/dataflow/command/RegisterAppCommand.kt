package com.tony.reduxkotlinsample.state.dataflow.command

import com.tony.reduxkotlinsample.state.dataflow.*

/**
 * 注册操作
 */
class RegisterAppCommand (val username: String, val password: String, val password2: String) : AppCommand {

    override fun execute(store: Store) {

        Thread {
            kotlin.run {
                Thread.sleep(500L)
                if (username == "tony@email.com") {
                    store.dispatch(AppAction.ACCOUNT_BEHAVIOR_DONE.addExtra(AppResult(failure = AppError("账户已注册！"))))
                } else if (username.length < 6 || username.length > 16) {
                    store.dispatch(AppAction.ACCOUNT_BEHAVIOR_DONE.addExtra(AppResult(failure = AppError("用户名长度限制为6~16位"))))
                } else {
                    if (password != password2) {
                        store.dispatch(AppAction.ACCOUNT_BEHAVIOR_DONE.addExtra(AppResult(failure = AppError("两次密码不一致！"))))
                    } else if (password.length < 6 || password.length > 16) {
                        store.dispatch(AppAction.ACCOUNT_BEHAVIOR_DONE.addExtra(AppResult(failure = AppError("密码长度限制为6~16位"))))
                    } else {
                        store.dispatch(AppAction.ACCOUNT_BEHAVIOR_DONE.addExtra(AppResult(null)))
                    }
                }
            }
        }.start()
    }


}