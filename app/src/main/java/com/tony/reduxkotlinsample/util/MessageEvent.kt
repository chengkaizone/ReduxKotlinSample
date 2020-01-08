package com.tony.reduxkotlinsample.util

import com.tony.reduxkotlinsample.state.dataflow.AppAction
import com.tony.reduxkotlinsample.state.dataflow.AppState

class MessageEvent(val action: AppAction, val state: AppState) {

}