package com.tony.reduxkotlinsample.state.dataflow

/**
 * 返回请求的结果
 * Success 也作为参数使用
 */
class AppResult<Success: Object, Failure: AppError> (val value: Success? = null, val failure: Failure? = null) {


}