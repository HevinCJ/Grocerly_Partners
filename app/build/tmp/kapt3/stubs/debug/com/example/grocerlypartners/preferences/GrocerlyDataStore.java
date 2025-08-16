package com.example.grocerlypartners.preferences;

@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0011\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0086@\u00a2\u0006\u0002\u0010\rJ\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\f0\u000fR\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0011"}, d2 = {"Lcom/example/grocerlypartners/preferences/GrocerlyDataStore;", "", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "datastore", "Landroidx/datastore/core/DataStore;", "Landroidx/datastore/preferences/core/Preferences;", "setLoginState", "", "islogin", "", "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getLoginState", "Lkotlinx/coroutines/flow/Flow;", "Companion", "app_debug"})
public final class GrocerlyDataStore {
    @org.jetbrains.annotations.NotNull()
    private final androidx.datastore.core.DataStore<androidx.datastore.preferences.core.Preferences> datastore = null;
    @org.jetbrains.annotations.NotNull()
    private static final androidx.datastore.preferences.core.Preferences.Key<java.lang.Boolean> isLoggedIn = null;
    @org.jetbrains.annotations.NotNull()
    public static final com.example.grocerlypartners.preferences.GrocerlyDataStore.Companion Companion = null;
    
    public GrocerlyDataStore(@dagger.hilt.android.qualifiers.ApplicationContext()
    @org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object setLoginState(boolean islogin, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<java.lang.Boolean> getLoginState() {
        return null;
    }
    
    @kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0007\u00a8\u0006\b"}, d2 = {"Lcom/example/grocerlypartners/preferences/GrocerlyDataStore$Companion;", "", "<init>", "()V", "isLoggedIn", "Landroidx/datastore/preferences/core/Preferences$Key;", "", "()Landroidx/datastore/preferences/core/Preferences$Key;", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final androidx.datastore.preferences.core.Preferences.Key<java.lang.Boolean> isLoggedIn() {
            return null;
        }
    }
}