package com.daffa.core.data;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J\u0012\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00060\u0005J\u000e\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H$J\b\u0010\t\u001a\u00020\nH\u0014R\u001a\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00060\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000b"}, d2 = {"Lcom/daffa/core/data/NetworkBoundResource;", "ResultType", "", "()V", "result", "Lkotlinx/coroutines/flow/Flow;", "Lcom/daffa/core/data/Resource;", "asFlow", "loadFromDB", "onFetchFailed", "", "core_debug"})
public abstract class NetworkBoundResource<ResultType extends java.lang.Object> {
    private kotlinx.coroutines.flow.Flow<? extends com.daffa.core.data.Resource<ResultType>> result;
    
    public NetworkBoundResource() {
        super();
    }
    
    protected void onFetchFailed() {
    }
    
    @org.jetbrains.annotations.NotNull()
    protected abstract kotlinx.coroutines.flow.Flow<ResultType> loadFromDB();
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<com.daffa.core.data.Resource<ResultType>> asFlow() {
        return null;
    }
}