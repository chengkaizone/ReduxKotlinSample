package com.tony.reduxkotlinsample.state.dataflow.command

import com.tony.reduxkotlinsample.state.dataflow.AppAction
import com.tony.reduxkotlinsample.state.dataflow.Store

class LogoutAppCommand : AppCommand {

    override fun execute(store: Store) {
        Thread {
            kotlin.run {
                Thread.sleep(500L)
                store.dispatch(AppAction.LOGOUT_DONE)
            }
        }.start()
    }

}