package com.daffa.core.data

import kotlinx.coroutines.flow.*

abstract class NetworkBoundResource<ResultType> {

    private var result: Flow<Resource<ResultType>> = flow {
        emit(Resource.Loading())
        emitAll(loadFromDB().map { Resource.Success(it) })
    }

    protected open fun onFetchFailed() {}

    protected abstract fun loadFromDB(): Flow<ResultType>


    fun asFlow(): Flow<Resource<ResultType>> = result
}