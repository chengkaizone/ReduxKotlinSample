package com.tony.reduxkotlinsample.state.dataflow

import android.content.Context
import com.tony.reduxkotlinsample.state.dataflow.reduce.AccountReducer
import com.tony.reduxkotlinsample.util.MessageEvent
import org.greenrobot.eventbus.EventBus

class Store {

    var appState: AppState = AppState()

    /**
     * 此处可能在主线程，也可能在子线程操作
     */
    fun dispatch(action: AppAction) {

        val result = AccountReducer.reduce(appState, action)
        appState = result.first

        // 此处发送事件来改变UI
        EventBus.getDefault().post(MessageEvent(action, appState))
        if (result.second != null) {
            result.second?.execute(this)
        }
    }

    companion object {

    }

}
