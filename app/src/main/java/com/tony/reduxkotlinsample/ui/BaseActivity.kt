package com.tony.reduxkotlinsample.ui

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import com.tony.reduxkotlinsample.state.dataflow.AppAction
import com.tony.reduxkotlinsample.state.dataflow.AppState
import com.tony.reduxkotlinsample.util.MessageEvent
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode

abstract class BaseActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onStart() {
        super.onStart()
        EventBus.getDefault().register(this)
    }

    override fun onDestroy() {
        EventBus.getDefault().unregister(this)
        super.onDestroy()
    }

    @Subscribe (threadMode = ThreadMode.MAIN)
    fun onMessageEvent(event: MessageEvent) {
        onChangedState(event.action, event.state)
    }

    abstract fun onChangedState(action: AppAction, state: AppState)

}