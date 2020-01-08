package com.tony.reduxkotlinsample.state.dataflow.command

import com.tony.reduxkotlinsample.state.dataflow.Store

/**
 * 接受action后的额外操作（副作用）
 */
interface AppCommand {

    // 执行副作用操作
    fun execute(store: Store)
}
