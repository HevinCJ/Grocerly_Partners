package com.example.grocerlypartners.repository;

@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B!\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\u001c\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000b0\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0086@\u00a2\u0006\u0002\u0010\u0012J\u001a\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u000f0\u00142\u0006\u0010\u0015\u001a\u00020\u0016J,\u0010\u0017\u001a\"\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0018j\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u0001`\u0019*\u00020\u0011H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001a"}, d2 = {"Lcom/example/grocerlypartners/repository/UpdateProductRepoImpl;", "", "db", "Lcom/google/firebase/firestore/FirebaseFirestore;", "auth", "Lcom/google/firebase/auth/FirebaseAuth;", "storage", "Lcom/google/firebase/storage/FirebaseStorage;", "<init>", "(Lcom/google/firebase/firestore/FirebaseFirestore;Lcom/google/firebase/auth/FirebaseAuth;Lcom/google/firebase/storage/FirebaseStorage;)V", "userId", "", "updateProductRef", "Lcom/google/firebase/firestore/CollectionReference;", "updateProduct", "Lcom/example/grocerlypartners/utils/NetworkResult;", "product", "Lcom/example/grocerlypartners/model/Product;", "(Lcom/example/grocerlypartners/model/Product;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "uploadImageToFirebase", "Lkotlinx/coroutines/flow/Flow;", "uri", "Landroid/net/Uri;", "toHashMap", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "app_debug"})
@dagger.hilt.android.scopes.ActivityRetainedScoped()
public final class UpdateProductRepoImpl {
    @org.jetbrains.annotations.NotNull()
    private final com.google.firebase.firestore.FirebaseFirestore db = null;
    @org.jetbrains.annotations.NotNull()
    private final com.google.firebase.auth.FirebaseAuth auth = null;
    @org.jetbrains.annotations.NotNull()
    private final com.google.firebase.storage.FirebaseStorage storage = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String userId = null;
    @org.jetbrains.annotations.NotNull()
    private final com.google.firebase.firestore.CollectionReference updateProductRef = null;
    
    @javax.inject.Inject()
    public UpdateProductRepoImpl(@org.jetbrains.annotations.NotNull()
    com.google.firebase.firestore.FirebaseFirestore db, @org.jetbrains.annotations.NotNull()
    com.google.firebase.auth.FirebaseAuth auth, @org.jetbrains.annotations.NotNull()
    com.google.firebase.storage.FirebaseStorage storage) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object updateProduct(@org.jetbrains.annotations.NotNull()
    com.example.grocerlypartners.model.Product product, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.example.grocerlypartners.utils.NetworkResult<java.lang.String>> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<com.example.grocerlypartners.utils.NetworkResult<java.lang.String>> uploadImageToFirebase(@org.jetbrains.annotations.NotNull()
    android.net.Uri uri) {
        return null;
    }
    
    private final java.util.HashMap<java.lang.String, java.lang.Object> toHashMap(com.example.grocerlypartners.model.Product $this$toHashMap) {
        return null;
    }
}