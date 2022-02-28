package com.im.cookgaloreapp.utils

import java.lang.Exception

sealed class NetworkState<T>(
    val data: T? = null,
    val error: Throwable? = null,
) {

    class Success<T>(data: T?) : NetworkState<T>(data)
    class Error<T>(throwable: Throwable?) : NetworkState<T>(error = throwable)
    class Loading<T>() : NetworkState<T>()

}
