package com.daffa.core.utils;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0006\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0003\u0007\b\tB\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0011\u0010\u0003\u001a\u00020\u0004*\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/daffa/core/utils/Utils;", "", "()V", "formatCurrencyRupiah", "", "", "(Ljava/lang/Double;)Ljava/lang/String;", "MoneyTextWatcher", "Presets", "UriPathHelper", "core_debug"})
public final class Utils {
    @org.jetbrains.annotations.NotNull()
    public static final com.daffa.core.utils.Utils INSTANCE = null;
    
    private Utils() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String formatCurrencyRupiah(@org.jetbrains.annotations.Nullable()
    java.lang.Double $this$formatCurrencyRupiah) {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J;\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\u00042\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000bH\u0002\u00a2\u0006\u0002\u0010\fJ\u0018\u0010\r\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u0010\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u0010\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0007\u001a\u00020\bH\u0002\u00a8\u0006\u0012"}, d2 = {"Lcom/daffa/core/utils/Utils$UriPathHelper;", "", "()V", "getDataColumn", "", "context", "Landroid/content/Context;", "uri", "Landroid/net/Uri;", "selection", "selectionArgs", "", "(Landroid/content/Context;Landroid/net/Uri;Ljava/lang/String;[Ljava/lang/String;)Ljava/lang/String;", "getPath", "isDownloadsDocument", "", "isExternalStorageDocument", "isMediaDocument", "core_debug"})
    public static final class UriPathHelper {
        
        public UriPathHelper() {
            super();
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.String getPath(@org.jetbrains.annotations.NotNull()
        android.content.Context context, @org.jetbrains.annotations.NotNull()
        android.net.Uri uri) {
            return null;
        }
        
        private final java.lang.String getDataColumn(android.content.Context context, android.net.Uri uri, java.lang.String selection, java.lang.String[] selectionArgs) {
            return null;
        }
        
        private final boolean isExternalStorageDocument(android.net.Uri uri) {
            return false;
        }
        
        private final boolean isDownloadsDocument(android.net.Uri uri) {
            return false;
        }
        
        private final boolean isMediaDocument(android.net.Uri uri) {
            return false;
        }
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J(\u0010\u000b\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000eH\u0016J(\u0010\u0011\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0014"}, d2 = {"Lcom/daffa/core/utils/Utils$MoneyTextWatcher;", "Landroid/text/TextWatcher;", "editText", "Landroid/widget/EditText;", "(Landroid/widget/EditText;)V", "editTextWeakReference", "Ljava/lang/ref/WeakReference;", "afterTextChanged", "", "s", "Landroid/text/Editable;", "beforeTextChanged", "", "start", "", "count", "after", "onTextChanged", "before", "Companion", "core_debug"})
    public static final class MoneyTextWatcher implements android.text.TextWatcher {
        private final java.lang.ref.WeakReference<android.widget.EditText> editTextWeakReference = null;
        @org.jetbrains.annotations.NotNull()
        public static final com.daffa.core.utils.Utils.MoneyTextWatcher.Companion Companion = null;
        @org.jetbrains.annotations.NotNull()
        private static final java.text.NumberFormat numberFormat = null;
        
        public MoneyTextWatcher(@org.jetbrains.annotations.Nullable()
        android.widget.EditText editText) {
            super();
        }
        
        @java.lang.Override()
        public void beforeTextChanged(@org.jetbrains.annotations.NotNull()
        java.lang.CharSequence s, int start, int count, int after) {
        }
        
        @java.lang.Override()
        public void onTextChanged(@org.jetbrains.annotations.NotNull()
        java.lang.CharSequence s, int start, int before, int count) {
        }
        
        @java.lang.Override()
        public void afterTextChanged(@org.jetbrains.annotations.NotNull()
        android.text.Editable s) {
        }
        
        @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nR\u0011\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u000b"}, d2 = {"Lcom/daffa/core/utils/Utils$MoneyTextWatcher$Companion;", "", "()V", "numberFormat", "Ljava/text/NumberFormat;", "getNumberFormat", "()Ljava/text/NumberFormat;", "parseCurrencyValue", "Ljava/math/BigDecimal;", "value", "", "core_debug"})
        public static final class Companion {
            
            private Companion() {
                super();
            }
            
            @org.jetbrains.annotations.NotNull()
            public final java.text.NumberFormat getNumberFormat() {
                return null;
            }
            
            @org.jetbrains.annotations.NotNull()
            public final java.math.BigDecimal parseCurrencyValue(@org.jetbrains.annotations.NotNull()
            java.lang.String value) {
                return null;
            }
        }
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0004"}, d2 = {"Lcom/daffa/core/utils/Utils$Presets;", "", "()V", "Companion", "core_debug"})
    public static final class Presets {
        @org.jetbrains.annotations.NotNull()
        public static final com.daffa.core.utils.Utils.Presets.Companion Companion = null;
        
        public Presets() {
            super();
        }
        
        @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004J\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004J\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004J\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u00a8\u0006\t"}, d2 = {"Lcom/daffa/core/utils/Utils$Presets$Companion;", "", "()V", "explode", "", "Lnl/dionsegijn/konfetti/core/Party;", "festive", "parade", "rain", "core_debug"})
        public static final class Companion {
            
            private Companion() {
                super();
            }
            
            @org.jetbrains.annotations.NotNull()
            public final java.util.List<nl.dionsegijn.konfetti.core.Party> festive() {
                return null;
            }
            
            @org.jetbrains.annotations.NotNull()
            public final java.util.List<nl.dionsegijn.konfetti.core.Party> explode() {
                return null;
            }
            
            @org.jetbrains.annotations.NotNull()
            public final java.util.List<nl.dionsegijn.konfetti.core.Party> parade() {
                return null;
            }
            
            @org.jetbrains.annotations.NotNull()
            public final java.util.List<nl.dionsegijn.konfetti.core.Party> rain() {
                return null;
            }
        }
    }
}