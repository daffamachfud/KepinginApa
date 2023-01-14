package com.daffa.core.data.source.local.room;

import java.lang.System;

@androidx.room.Dao()
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\n\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\'J\u001b\u0010\u0006\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\tJ\u0016\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u000b2\u0006\u0010\f\u001a\u00020\bH\'J\u000e\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\'J\u000e\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u000eH\'J\u0014\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00130\u000eH\'J\u0019\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u000fH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0016J\u0019\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u0011H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0019J\u0019\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001bJ\u001b\u0010\u001c\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\t\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u001d"}, d2 = {"Lcom/daffa/core/data/source/local/room/AppDao;", "", "deleteWish", "", "wish", "Lcom/daffa/core/data/source/local/entity/WishlistEntity;", "deletedWish", "id", "", "(Ljava/lang/Integer;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getDetailWish", "Landroidx/lifecycle/LiveData;", "wishId", "getUserData", "Lkotlinx/coroutines/flow/Flow;", "Lcom/daffa/core/data/source/local/entity/UserEntity;", "getWalletData", "Lcom/daffa/core/data/source/local/entity/WalletEntity;", "getWishlist", "", "insertUser", "user", "(Lcom/daffa/core/data/source/local/entity/UserEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertWallet", "wallet", "(Lcom/daffa/core/data/source/local/entity/WalletEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertWish", "(Lcom/daffa/core/data/source/local/entity/WishlistEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateStatusWish", "core_debug"})
public abstract interface AppDao {
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Insert(onConflict = androidx.room.OnConflictStrategy.REPLACE)
    public abstract java.lang.Object insertUser(@org.jetbrains.annotations.NotNull()
    com.daffa.core.data.source.local.entity.UserEntity user, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Insert(onConflict = androidx.room.OnConflictStrategy.REPLACE)
    public abstract java.lang.Object insertWish(@org.jetbrains.annotations.NotNull()
    com.daffa.core.data.source.local.entity.WishlistEntity wish, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Insert(onConflict = androidx.room.OnConflictStrategy.REPLACE)
    public abstract java.lang.Object insertWallet(@org.jetbrains.annotations.NotNull()
    com.daffa.core.data.source.local.entity.WalletEntity wallet, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation);
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM user")
    public abstract kotlinx.coroutines.flow.Flow<com.daffa.core.data.source.local.entity.UserEntity> getUserData();
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM wishlist WHERE bought = 0 AND deleted = 0")
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.daffa.core.data.source.local.entity.WishlistEntity>> getWishlist();
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM wishlist WHERE id = :wishId")
    public abstract androidx.lifecycle.LiveData<com.daffa.core.data.source.local.entity.WishlistEntity> getDetailWish(int wishId);
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM wallet")
    public abstract kotlinx.coroutines.flow.Flow<com.daffa.core.data.source.local.entity.WalletEntity> getWalletData();
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Query(value = "UPDATE `wishlist` SET bought=1 WHERE id = :id")
    public abstract java.lang.Object updateStatusWish(@org.jetbrains.annotations.Nullable()
    java.lang.Integer id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Query(value = "UPDATE `wishlist` SET deleted=1 WHERE id = :id")
    public abstract java.lang.Object deletedWish(@org.jetbrains.annotations.Nullable()
    java.lang.Integer id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation);
    
    @androidx.room.Delete()
    public abstract void deleteWish(@org.jetbrains.annotations.NotNull()
    com.daffa.core.data.source.local.entity.WishlistEntity wish);
}