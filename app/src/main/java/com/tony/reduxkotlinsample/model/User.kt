package com.tony.reduxkotlinsample.model

/**
 * 用户信息
 */
class User(val username: String, val password: String): Object() {


    override fun toString(): String {
        return "username: $username password: $password"
    }
}