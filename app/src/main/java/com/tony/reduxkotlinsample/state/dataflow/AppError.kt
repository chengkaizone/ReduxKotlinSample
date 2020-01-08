package com.tony.reduxkotlinsample.state.dataflow

/**
 * 应用错误信息
 */
class AppError(private val message: String) {

    override fun toString(): String {
        return this.message
    }

}
