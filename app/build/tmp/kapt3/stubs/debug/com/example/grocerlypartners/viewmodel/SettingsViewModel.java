package com.example.grocerlypartners.viewmodel;

@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u000e\u001a\u00020\u000fJ\u000e\u0010\u0010\u001a\u00020\u000fH\u0082@\u00a2\u0006\u0002\u0010\u0011R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u000b8F\u00a2\u0006\u0006\u001a\u0004\b\f\u0010\r\u00a8\u0006\u0012"}, d2 = {"Lcom/example/grocerlypartners/viewmodel/SettingsViewModel;", "Landroidx/lifecycle/ViewModel;", "settingsRepoImpl", "Lcom/example/grocerlypartners/repository/SettingsRepoImpl;", "<init>", "(Lcom/example/grocerlypartners/repository/SettingsRepoImpl;)V", "_logout", "Lkotlinx/coroutines/channels/Channel;", "Lcom/example/grocerlypartners/utils/NetworkResult;", "", "logout", "Lkotlinx/coroutines/flow/Flow;", "getLogout", "()Lkotlinx/coroutines/flow/Flow;", "logoutFromFirebase", "", "handleNetworkResultLogout", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel()
public final class SettingsViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.example.grocerlypartners.repository.SettingsRepoImpl settingsRepoImpl = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.channels.Channel<com.example.grocerlypartners.utils.NetworkResult<java.lang.String>> _logout = null;
    
    @javax.inject.Inject()
    public SettingsViewModel(@org.jetbrains.annotations.NotNull()
    com.example.grocerlypartners.repository.SettingsRepoImpl settingsRepoImpl) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<com.example.grocerlypartners.utils.NetworkResult<java.lang.String>> getLogout() {
        return null;
    }
    
    public final void logoutFromFirebase() {
    }
    
    private final java.lang.Object handleNetworkResultLogout(kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
}