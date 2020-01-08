package com.tony.reduxkotlinsample.state.dataflow

import com.tony.reduxkotlinsample.model.User

class AppState {

    var accountRequesting: Boolean = false

    var user: User? = null
    var accountError: AppError? = null


}
