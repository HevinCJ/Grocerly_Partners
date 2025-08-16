package com.example.grocerlypartners.viewmodel;

@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0006\u0010\u0007J&\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u0017J(\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u0017H\u0002J.\u0010\u001d\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u0017H\u0082@\u00a2\u0006\u0002\u0010\u001eJ\u0016\u0010\u001f\u001a\u00020\u001c2\u0006\u0010 \u001a\u00020!H\u0082@\u00a2\u0006\u0002\u0010\"J.\u0010#\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u0017H\u0082@\u00a2\u0006\u0002\u0010\u001eJ\b\u0010$\u001a\u00020\u0015H\u0014R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\r8F\u00a2\u0006\u0006\u001a\u0004\b\f\u0010\u000eR\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\r8F\u00a2\u0006\u0006\u001a\u0004\b\u0013\u0010\u000e\u00a8\u0006%"}, d2 = {"Lcom/example/grocerlypartners/viewmodel/SignUpViewModel;", "Landroidx/lifecycle/ViewModel;", "auth", "Lcom/google/firebase/auth/FirebaseAuth;", "db", "Lcom/google/firebase/firestore/FirebaseFirestore;", "<init>", "(Lcom/google/firebase/auth/FirebaseAuth;Lcom/google/firebase/firestore/FirebaseFirestore;)V", "_isSigned", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Lcom/example/grocerlypartners/utils/NetworkResult;", "Lcom/google/firebase/auth/FirebaseUser;", "isSigned", "Lkotlinx/coroutines/flow/Flow;", "()Lkotlinx/coroutines/flow/Flow;", "_signUpState", "Lkotlinx/coroutines/channels/Channel;", "Lcom/example/grocerlypartners/utils/SignUpState;", "signUpState", "getSignUpState", "performSignUpForPartner", "", "firstName", "", "lastName", "email", "password", "isValidated", "", "performSignUp", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "saveAccountToDb", "account", "Lcom/example/grocerlypartners/model/Account;", "(Lcom/example/grocerlypartners/model/Account;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "emitValidationErrors", "onCleared", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel()
public final class SignUpViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.google.firebase.auth.FirebaseAuth auth = null;
    @org.jetbrains.annotations.NotNull()
    private final com.google.firebase.firestore.FirebaseFirestore db = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableSharedFlow<com.example.grocerlypartners.utils.NetworkResult<com.google.firebase.auth.FirebaseUser>> _isSigned = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.channels.Channel<com.example.grocerlypartners.utils.SignUpState> _signUpState = null;
    
    @javax.inject.Inject()
    public SignUpViewModel(@org.jetbrains.annotations.NotNull()
    com.google.firebase.auth.FirebaseAuth auth, @org.jetbrains.annotations.NotNull()
    com.google.firebase.firestore.FirebaseFirestore db) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<com.example.grocerlypartners.utils.NetworkResult<com.google.firebase.auth.FirebaseUser>> isSigned() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<com.example.grocerlypartners.utils.SignUpState> getSignUpState() {
        return null;
    }
    
    public final void performSignUpForPartner(@org.jetbrains.annotations.NotNull()
    java.lang.String firstName, @org.jetbrains.annotations.NotNull()
    java.lang.String lastName, @org.jetbrains.annotations.NotNull()
    java.lang.String email, @org.jetbrains.annotations.NotNull()
    java.lang.String password) {
    }
    
    private final boolean isValidated(java.lang.String firstName, java.lang.String lastName, java.lang.String email, java.lang.String password) {
        return false;
    }
    
    private final java.lang.Object performSignUp(java.lang.String firstName, java.lang.String lastName, java.lang.String email, java.lang.String password, kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    private final java.lang.Object saveAccountToDb(com.example.grocerlypartners.model.Account account, kotlin.coroutines.Continuation<? super java.lang.Boolean> $completion) {
        return null;
    }
    
    private final java.lang.Object emitValidationErrors(java.lang.String firstName, java.lang.String lastName, java.lang.String email, java.lang.String password, kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @java.lang.Override()
    protected void onCleared() {
    }
}