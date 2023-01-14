package com.daffa.core.data.source.local;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0019\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\tJ\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bJ\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u000bJ\u0012\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00100\u000bJ\u0019\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\fH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0013J\u0019\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u000eH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0016J\u0019\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\tJ\u001b\u0010\u0018\u001a\u00020\u00062\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u001c"}, d2 = {"Lcom/daffa/core/data/source/local/LocalDataSource;", "", "appDao", "Lcom/daffa/core/data/source/local/room/AppDao;", "(Lcom/daffa/core/data/source/local/room/AppDao;)V", "deleteWish", "", "wish", "Lcom/daffa/core/data/source/local/entity/WishlistEntity;", "(Lcom/daffa/core/data/source/local/entity/WishlistEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getUserData", "Lkotlinx/coroutines/flow/Flow;", "Lcom/daffa/core/data/source/local/entity/UserEntity;", "getWalletData", "Lcom/daffa/core/data/source/local/entity/WalletEntity;", "getWishlist", "", "insertUser", "user", "(Lcom/daffa/core/data/source/local/entity/UserEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertWallet", "wallet", "(Lcom/daffa/core/data/source/local/entity/WalletEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertWish", "updateBoughtWish", "wishId", "", "(Ljava/lang/Integer;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "core_debug"})
@javax.inject.Singleton()
public final class LocalDataSource {
    private final com.daffa.core.data.source.local.room.AppDao appDao = null;
    
    @javax.inject.Inject()
    public LocalDataSource(@org.jetbrains.annotations.NotNull()
    com.daffa.core.data.source.local.room.AppDao appDao) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object insertUser(@org.jetbrains.annotations.NotNull()
    com.daffa.core.data.source.local.entity.UserEntity user, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object insertWish(@org.jetbrains.annotations.NotNull()
    com.daffa.core.data.source.local.entity.WishlistEntity wish, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object insertWallet(@org.jetbrains.annotations.NotNull()
    com.daffa.core.data.source.local.entity.WalletEntity wallet, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object deleteWish(@org.jetbrains.annotations.NotNull()
    com.daffa.core.data.source.local.entity.WishlistEntity wish, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object updateBoughtWish(@org.jetbrains.annotations.Nullable()
    java.lang.Integer wishId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<com.daffa.core.data.source.local.entity.UserEntity> getUserData() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.daffa.core.data.source.local.entity.WishlistEntity>> getWishlist() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<com.daffa.core.data.source.local.entity.WalletEntity> getWalletData() {
        return null;
    }
}