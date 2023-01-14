package com.daffa.core.ui;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001\u001aB\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\u001c\u0010\u0010\u001a\u00020\t2\n\u0010\u0011\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u000fH\u0016J\u001c\u0010\u0013\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u000fH\u0016J\u0018\u0010\u0017\u001a\u00020\t2\u000e\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0019H\u0007R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R(\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t\u0018\u00010\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r\u00a8\u0006\u001b"}, d2 = {"Lcom/daffa/core/ui/TransactionWishAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/daffa/core/ui/TransactionWishAdapter$WishViewHolder;", "()V", "listWish", "Ljava/util/ArrayList;", "Lcom/daffa/core/domain/model/Wishlist;", "onItemClick", "Lkotlin/Function1;", "", "getOnItemClick", "()Lkotlin/jvm/functions/Function1;", "setOnItemClick", "(Lkotlin/jvm/functions/Function1;)V", "getItemCount", "", "onBindViewHolder", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setWishlist", "wishlists", "", "WishViewHolder", "core_debug"})
public final class TransactionWishAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.daffa.core.ui.TransactionWishAdapter.WishViewHolder> {
    private java.util.ArrayList<com.daffa.core.domain.model.Wishlist> listWish;
    @org.jetbrains.annotations.Nullable()
    private kotlin.jvm.functions.Function1<? super com.daffa.core.domain.model.Wishlist, kotlin.Unit> onItemClick;
    
    public TransactionWishAdapter() {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final kotlin.jvm.functions.Function1<com.daffa.core.domain.model.Wishlist, kotlin.Unit> getOnItemClick() {
        return null;
    }
    
    public final void setOnItemClick(@org.jetbrains.annotations.Nullable()
    kotlin.jvm.functions.Function1<? super com.daffa.core.domain.model.Wishlist, kotlin.Unit> p0) {
    }
    
    @android.annotation.SuppressLint(value = {"NotifyDataSetChanged"})
    public final void setWishlist(@org.jetbrains.annotations.Nullable()
    java.util.List<com.daffa.core.domain.model.Wishlist> wishlists) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public com.daffa.core.ui.TransactionWishAdapter.WishViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    com.daffa.core.ui.TransactionWishAdapter.WishViewHolder holder, int position) {
    }
    
    @java.lang.Override()
    public int getItemCount() {
        return 0;
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2 = {"Lcom/daffa/core/ui/TransactionWishAdapter$WishViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/daffa/core/databinding/TransactionWishlistAdapterBinding;", "(Lcom/daffa/core/ui/TransactionWishAdapter;Lcom/daffa/core/databinding/TransactionWishlistAdapterBinding;)V", "bind", "", "wishlist", "Lcom/daffa/core/domain/model/Wishlist;", "core_debug"})
    public final class WishViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        private final com.daffa.core.databinding.TransactionWishlistAdapterBinding binding = null;
        
        public WishViewHolder(@org.jetbrains.annotations.NotNull()
        com.daffa.core.databinding.TransactionWishlistAdapterBinding binding) {
            super(null);
        }
        
        public final void bind(@org.jetbrains.annotations.NotNull()
        com.daffa.core.domain.model.Wishlist wishlist) {
        }
    }
}