package com.example.grocerlypartners.viewmodel;

@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\n\b\u0007\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0016\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u00182\u0006\u0010\"\u001a\u00020\u0018J\u000e\u0010#\u001a\u00020 2\u0006\u0010$\u001a\u00020\u001dJ\u0018\u0010\u0013\u001a\u00020\u001d2\u0006\u0010!\u001a\u00020\u00182\u0006\u0010\"\u001a\u00020\u0018H\u0002J\u001e\u0010%\u001a\u00020 2\u0006\u0010!\u001a\u00020\u00182\u0006\u0010\"\u001a\u00020\u0018H\u0082@\u00a2\u0006\u0002\u0010&J\u001e\u0010\'\u001a\u00020 2\u0006\u0010!\u001a\u00020\u00182\u0006\u0010\"\u001a\u00020\u0018H\u0082@\u00a2\u0006\u0002\u0010&J\u000e\u0010(\u001a\u00020 2\u0006\u0010!\u001a\u00020\u0018J\b\u0010)\u001a\u00020 H\u0014R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\r8F\u00a2\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u00148F\u00a2\u0006\u0006\u001a\u0004\b\u0013\u0010\u0015R\u001a\u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00180\n0\u0017X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\u0019\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00180\n0\u00148F\u00a2\u0006\u0006\u001a\u0004\b\u0019\u0010\u0015R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001d0\u0014\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0015\u00a8\u0006*"}, d2 = {"Lcom/example/grocerlypartners/viewmodel/LoginViewModel;", "Landroidx/lifecycle/AndroidViewModel;", "auth", "Lcom/google/firebase/auth/FirebaseAuth;", "application", "Landroid/app/Application;", "<init>", "(Lcom/google/firebase/auth/FirebaseAuth;Landroid/app/Application;)V", "_isloggedIn", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/example/grocerlypartners/utils/NetworkResult;", "Lcom/google/firebase/auth/FirebaseUser;", "isloggedIn", "Lkotlinx/coroutines/flow/StateFlow;", "getIsloggedIn", "()Lkotlinx/coroutines/flow/StateFlow;", "_isValidated", "Lkotlinx/coroutines/channels/Channel;", "Lcom/example/grocerlypartners/utils/LoginState;", "isValidated", "Lkotlinx/coroutines/flow/Flow;", "()Lkotlinx/coroutines/flow/Flow;", "_isReseted", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "", "isReseted", "datastore", "Lcom/example/grocerlypartners/preferences/GrocerlyDataStore;", "loginState", "", "getLoginState", "loginPartnerToFirebase", "", "email", "password", "saveLoginState", "state", "performLoginPartner", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "emitValidationErrors", "resetPassword", "onCleared", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel()
public final class LoginViewModel extends androidx.lifecycle.AndroidViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.google.firebase.auth.FirebaseAuth auth = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<com.example.grocerlypartners.utils.NetworkResult<com.google.firebase.auth.FirebaseUser>> _isloggedIn = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.channels.Channel<com.example.grocerlypartners.utils.LoginState> _isValidated = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableSharedFlow<com.example.grocerlypartners.utils.NetworkResult<java.lang.String>> _isReseted = null;
    @org.jetbrains.annotations.NotNull()
    private final com.example.grocerlypartners.preferences.GrocerlyDataStore datastore = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.Flow<java.lang.Boolean> loginState = null;
    
    @javax.inject.Inject()
    public LoginViewModel(@org.jetbrains.annotations.NotNull()
    com.google.firebase.auth.FirebaseAuth auth, @org.jetbrains.annotations.NotNull()
    android.app.Application application) {
        super(null);
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<com.example.grocerlypartners.utils.NetworkResult<com.google.firebase.auth.FirebaseUser>> getIsloggedIn() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<com.example.grocerlypartners.utils.LoginState> isValidated() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<com.example.grocerlypartners.utils.NetworkResult<java.lang.String>> isReseted() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<java.lang.Boolean> getLoginState() {
        return null;
    }
    
    public final void loginPartnerToFirebase(@org.jetbrains.annotations.NotNull()
    java.lang.String email, @org.jetbrains.annotations.NotNull()
    java.lang.String password) {
    }
    
    public final void saveLoginState(boolean state) {
    }
    
    private final boolean isValidated(java.lang.String email, java.lang.String password) {
        return false;
    }
    
    private final java.lang.Object performLoginPartner(java.lang.String email, java.lang.String password, kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    private final java.lang.Object emitValidationErrors(java.lang.String email, java.lang.String password, kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    public final void resetPassword(@org.jetbrains.annotations.NotNull()
    java.lang.String email) {
    }
    
    @java.lang.Override()
    protected void onCleared() {
    }
}