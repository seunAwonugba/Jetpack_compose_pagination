package com.example.base.resource


sealed class Resource<T>(
    val data : T? = null,
    val message : String? =  null
) {
    //when success, do this
    class Success<T>(data: T) : Resource<T>(data,null)
    //when error, get the error message
    class Error<T>(message: String) : Resource<T>(null, message)

    //passes default null
    class Loading<T> : Resource<T>()
}

