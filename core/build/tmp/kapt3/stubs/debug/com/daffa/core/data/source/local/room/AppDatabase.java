package com.daffa.core.data.source.local.room;

import java.lang.System;

@androidx.room.Database(entities = {com.daffa.core.data.source.local.entity.WishlistEntity.class, com.daffa.core.data.source.local.entity.UserEntity.class, com.daffa.core.data.source.local.entity.CategoryEntity.class, com.daffa.core.data.source.local.entity.WalletEntity.class}, version = 1, exportSchema = false)
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\'\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H&\u00a8\u0006\u0005"}, d2 = {"Lcom/daffa/core/data/source/local/room/AppDatabase;", "Landroidx/room/RoomDatabase;", "()V", "appDao", "Lcom/daffa/core/data/source/local/room/AppDao;", "core_debug"})
public abstract class AppDatabase extends androidx.room.RoomDatabase {
    
    public AppDatabase() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.daffa.core.data.source.local.room.AppDao appDao();
}