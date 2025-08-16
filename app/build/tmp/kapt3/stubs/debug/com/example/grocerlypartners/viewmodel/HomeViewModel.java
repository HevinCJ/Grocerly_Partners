package com.example.grocerlypartners.viewmodel;

@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0006\u0010\u0018\u001a\u00020\u0019J\u000e\u0010\u001a\u001a\u00020\u0019H\u0082@\u00a2\u0006\u0002\u0010\u001bJ\u000e\u0010\u0013\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\fJ\u0016\u0010\u001d\u001a\u00020\u00192\u0006\u0010\r\u001a\u00020\fH\u0082@\u00a2\u0006\u0002\u0010\u001eJ\b\u0010\u001f\u001a\u00020\u0019H\u0014R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R \u0010\b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\n0\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R#\u0010\r\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\n0\u000e8F\u00a2\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\n0\u0012X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\n0\u000e8F\u00a2\u0006\u0006\u001a\u0004\b\u0014\u0010\u0010R\u0011\u0010\u0015\u001a\u00020\u0016\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0017\u00a8\u0006 "}, d2 = {"Lcom/example/grocerlypartners/viewmodel/HomeViewModel;", "Landroidx/lifecycle/AndroidViewModel;", "homeRepoImpl", "Lcom/example/grocerlypartners/repository/HomeRepoImpl;", "application", "Landroid/app/Application;", "<init>", "(Lcom/example/grocerlypartners/repository/HomeRepoImpl;Landroid/app/Application;)V", "_product", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/example/grocerlypartners/utils/NetworkResult;", "", "Lcom/example/grocerlypartners/model/Product;", "product", "Landroidx/lifecycle/LiveData;", "getProduct", "()Landroidx/lifecycle/LiveData;", "_deleteProduct", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "deleteProduct", "getDeleteProduct", "isReady", "", "()Z", "fetchProductAddedByPartnerFromFirebase", "", "fetchProductFromFirebase", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "offer", "deleteProductFromFirebase", "(Lcom/example/grocerlypartners/model/Product;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onCleared", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel()
public final class HomeViewModel extends androidx.lifecycle.AndroidViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.example.grocerlypartners.repository.HomeRepoImpl homeRepoImpl = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<com.example.grocerlypartners.utils.NetworkResult<java.util.List<com.example.grocerlypartners.model.Product>>> _product = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableSharedFlow<com.example.grocerlypartners.utils.NetworkResult<com.example.grocerlypartners.model.Product>> _deleteProduct = null;
    private final boolean isReady = false;
    
    @javax.inject.Inject()
    public HomeViewModel(@org.jetbrains.annotations.NotNull()
    com.example.grocerlypartners.repository.HomeRepoImpl homeRepoImpl, @org.jetbrains.annotations.NotNull()
    android.app.Application application) {
        super(null);
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<com.example.grocerlypartners.utils.NetworkResult<java.util.List<com.example.grocerlypartners.model.Product>>> getProduct() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<com.example.grocerlypartners.utils.NetworkResult<com.example.grocerlypartners.model.Product>> getDeleteProduct() {
        return null;
    }
    
    public final boolean isReady() {
        return false;
    }
    
    public final void fetchProductAddedByPartnerFromFirebase() {
    }
    
    private final java.lang.Object fetchProductFromFirebase(kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    public final void deleteProduct(@org.jetbrains.annotations.NotNull()
    com.example.grocerlypartners.model.Product offer) {
    }
    
    private final java.lang.Object deleteProductFromFirebase(com.example.grocerlypartners.model.Product product, kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @java.lang.Override()
    protected void onCleared() {
    }
}