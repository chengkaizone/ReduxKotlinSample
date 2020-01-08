package com.tony.reduxkotlinsample

import android.app.Application
import com.tony.reduxkotlinsample.state.dataflow.Store

/**
 * 应用上下文
 */
class AppContext : Application() {

    override fun onCreate() {
        super.onCreate()

    }

    companion object {
        val store: Store = Store()

    }

}