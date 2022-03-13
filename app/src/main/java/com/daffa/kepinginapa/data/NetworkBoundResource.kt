package com.daffa.kepinginapa.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import com.daffa.kepinginapa.utils.AppExecutors
import com.daffa.kepinginapa.vo.Resource

abstract class NetworkBoundResource<ResultType>() {
    private val result = MediatorLiveData<Resource<ResultType>>()
    init {
        result.value = Resource.loading(null)

        @Suppress("LeakingThis")
        val dbSource = loadFromDB()

        result.addSource(dbSource) {
            result.removeSource(dbSource)
                result.addSource(dbSource) { newData -> result.value = Resource.success(newData) }
        }
    }

    protected abstract fun loadFromDB(): LiveData<ResultType>

    fun asLiveData(): LiveData<Resource<ResultType>> = result
}