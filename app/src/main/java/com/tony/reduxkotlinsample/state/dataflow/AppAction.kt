package com.tony.reduxkotlinsample.state.dataflow

import java.io.Serializable

/**
 * 可以携带参数的Action
 * extra作为参数传递给调用方法
 * 也可以作为执行的结果返回
 */
 enum class AppAction {

    REGISTER,
    LOGIN,
    ACCOUNT_BEHAVIOR_DONE,
    LOGOUT,
    LOGOUT_DONE;

    var extra: AppResult<Object, AppError>? = null
    fun addExtra(extra: AppResult<Object, AppError>? = null) : AppAction {
        this.extra = extra
        return this
    }

}
