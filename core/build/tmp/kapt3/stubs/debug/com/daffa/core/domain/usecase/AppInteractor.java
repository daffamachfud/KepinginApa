package com.daffa.core.domain.usecase;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0019\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\tJ\u0014\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u000bH\u0016J\u0014\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\f0\u000bH\u0016J\u001a\u0010\u0010\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00110\f0\u000bH\u0016J\u0019\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\rH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0014J\u0019\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u000fH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0017J\u0019\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\tJ\u0019\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u001bH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001cR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u001d"}, d2 = {"Lcom/daffa/core/domain/usecase/AppInteractor;", "Lcom/daffa/core/domain/usecase/AppUseCase;", "appRepository", "Lcom/daffa/core/domain/repository/IAppRepository;", "(Lcom/daffa/core/domain/repository/IAppRepository;)V", "deleteWish", "", "wishlist", "Lcom/daffa/core/domain/model/Wishlist;", "(Lcom/daffa/core/domain/model/Wishlist;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getUserData", "Lkotlinx/coroutines/flow/Flow;", "Lcom/daffa/core/data/Resource;", "Lcom/daffa/core/domain/model/User;", "getWalletData", "Lcom/daffa/core/domain/model/Wallet;", "getWishList", "", "insertUser", "user", "(Lcom/daffa/core/domain/model/User;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertWallet", "wallet", "(Lcom/daffa/core/domain/model/Wallet;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertWish", "updateBoughtWish", "wishId", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "core_debug"})
public final class AppInteractor implements com.daffa.core.domain.usecase.AppUseCase {
    private final com.daffa.core.domain.repository.IAppRepository appRepository = null;
    
    @javax.inject.Inject()
    public AppInteractor(@org.jetbrains.annotations.NotNull()
    com.daffa.core.domain.repository.IAppRepository appRepository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public kotlinx.coroutines.flow.Flow<com.daffa.core.data.Resource<com.daffa.core.domain.model.User>> getUserData() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public kotlinx.coroutines.flow.Flow<com.daffa.core.data.Resource<java.util.List<com.daffa.core.domain.model.Wishlist>>> getWishList() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public kotlinx.coroutines.flow.Flow<com.daffa.core.data.Resource<com.daffa.core.domain.model.Wallet>> getWalletData() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object insertUser(@org.jetbrains.annotations.NotNull()
    com.daffa.core.domain.model.User user, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object insertWish(@org.jetbrains.annotations.NotNull()
    com.daffa.core.domain.model.Wishlist wishlist, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object insertWallet(@org.jetbrains.annotations.NotNull()
    com.daffa.core.domain.model.Wallet wallet, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object deleteWish(@org.jetbrains.annotations.NotNull()
    com.daffa.core.domain.model.Wishlist wishlist, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object updateBoughtWish(int wishId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
}