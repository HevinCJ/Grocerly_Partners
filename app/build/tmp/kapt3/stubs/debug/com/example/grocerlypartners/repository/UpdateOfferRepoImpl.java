package com.example.grocerlypartners.repository;

@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u001c\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u000b\u001a\u00020\fH\u0086@\u00a2\u0006\u0002\u0010\rJ(\u0010\u000e\u001a\u001e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00010\u000fj\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0001`\u0010*\u00020\fH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0011"}, d2 = {"Lcom/example/grocerlypartners/repository/UpdateOfferRepoImpl;", "", "db", "Lcom/google/firebase/firestore/FirebaseFirestore;", "auth", "Lcom/google/firebase/auth/FirebaseAuth;", "<init>", "(Lcom/google/firebase/firestore/FirebaseFirestore;Lcom/google/firebase/auth/FirebaseAuth;)V", "updateOfferIntoDatabase", "Lcom/example/grocerlypartners/utils/NetworkResult;", "", "offerItem", "Lcom/example/grocerlypartners/model/OfferItem;", "(Lcom/example/grocerlypartners/model/OfferItem;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toHashMap", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "app_debug"})
public final class UpdateOfferRepoImpl {
    @org.jetbrains.annotations.NotNull()
    private final com.google.firebase.firestore.FirebaseFirestore db = null;
    @org.jetbrains.annotations.NotNull()
    private final com.google.firebase.auth.FirebaseAuth auth = null;
    
    @javax.inject.Inject()
    public UpdateOfferRepoImpl(@org.jetbrains.annotations.NotNull()
    com.google.firebase.firestore.FirebaseFirestore db, @org.jetbrains.annotations.NotNull()
    com.google.firebase.auth.FirebaseAuth auth) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object updateOfferIntoDatabase(@org.jetbrains.annotations.NotNull()
    com.example.grocerlypartners.model.OfferItem offerItem, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.example.grocerlypartners.utils.NetworkResult<java.lang.String>> $completion) {
        return null;
    }
    
    private final java.util.HashMap<java.lang.String, java.lang.Object> toHashMap(com.example.grocerlypartners.model.OfferItem $this$toHashMap) {
        return null;
    }
}