package com.daffa.core.domain.repository;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0019\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0006J\u0014\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\bH&J\u0014\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\t0\bH&J\u001a\u0010\r\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u000e0\t0\bH&J\u0019\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\nH\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0011J\u0019\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\fH\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0014J\u0019\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0006J\u0019\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u0018H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0019\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u001a"}, d2 = {"Lcom/daffa/core/domain/repository/IAppRepository;", "", "deleteWish", "", "wishlist", "Lcom/daffa/core/domain/model/Wishlist;", "(Lcom/daffa/core/domain/model/Wishlist;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getUserData", "Lkotlinx/coroutines/flow/Flow;", "Lcom/daffa/core/data/Resource;", "Lcom/daffa/core/domain/model/User;", "getWalletData", "Lcom/daffa/core/domain/model/Wallet;", "getWishList", "", "insertUser", "user", "(Lcom/daffa/core/domain/model/User;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertWallet", "wallet", "(Lcom/daffa/core/domain/model/Wallet;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertWishlist", "updateBoughtWish", "wishId", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "core_debug"})
public abstract interface IAppRepository {
    
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<com.daffa.core.data.Resource<com.daffa.core.domain.model.User>> getUserData();
    
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<com.daffa.core.data.Resource<java.util.List<com.daffa.core.domain.model.Wishlist>>> getWishList();
    
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<com.daffa.core.data.Resource<com.daffa.core.domain.model.Wallet>> getWalletData();
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object insertUser(@org.jetbrains.annotations.NotNull()
    com.daffa.core.domain.model.User user, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object insertWishlist(@org.jetbrains.annotations.NotNull()
    com.daffa.core.domain.model.Wishlist wishlist, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object insertWallet(@org.jetbrains.annotations.NotNull()
    com.daffa.core.domain.model.Wallet wallet, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object deleteWish(@org.jetbrains.annotations.NotNull()
    com.daffa.core.domain.model.Wishlist wishlist, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object updateBoughtWish(int wishId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation);
}