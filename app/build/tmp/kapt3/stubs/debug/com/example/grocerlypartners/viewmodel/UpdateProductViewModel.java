package com.example.grocerlypartners.viewmodel;

@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eJ\u000e\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"J\u0016\u0010#\u001a\u00020 2\u0006\u0010\u001d\u001a\u00020\u001eH\u0082@\u00a2\u0006\u0002\u0010$J\u0016\u0010%\u001a\u00020 2\u0006\u0010!\u001a\u00020\"H\u0082@\u00a2\u0006\u0002\u0010&J\u0016\u0010\'\u001a\u00020 2\u0006\u0010\u001d\u001a\u00020\u001eH\u0082@\u00a2\u0006\u0002\u0010$J\u0010\u0010(\u001a\u00020)2\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J\u000e\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020\tJ\u000e\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020+J\b\u00100\u001a\u00020 H\u0014R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u000b8F\u00a2\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u00128F\u00a2\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u0016X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u00188F\u00a2\u0006\u0006\u001a\u0004\b\u0019\u0010\u001a\u00a8\u00061"}, d2 = {"Lcom/example/grocerlypartners/viewmodel/UpdateProductViewModel;", "Landroidx/lifecycle/ViewModel;", "updateProductRepoImpl", "Lcom/example/grocerlypartners/repository/UpdateProductRepoImpl;", "<init>", "(Lcom/example/grocerlypartners/repository/UpdateProductRepoImpl;)V", "_updateProduct", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Lcom/example/grocerlypartners/utils/NetworkResult;", "", "updateProduct", "Landroidx/lifecycle/LiveData;", "getUpdateProduct", "()Landroidx/lifecycle/LiveData;", "_productValidationState", "Lkotlinx/coroutines/channels/Channel;", "Lcom/example/grocerlypartners/utils/productValidationState;", "productValidationState", "Lkotlinx/coroutines/flow/Flow;", "getProductValidationState", "()Lkotlinx/coroutines/flow/Flow;", "_uploadImageState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "uploadImageState", "Lkotlinx/coroutines/flow/StateFlow;", "getUploadImageState", "()Lkotlinx/coroutines/flow/StateFlow;", "updateDataIntoFirebase", "Lkotlinx/coroutines/Job;", "product", "Lcom/example/grocerlypartners/model/Product;", "uploadImageToFirebase", "", "uri", "Landroid/net/Uri;", "updateDataIntoFirebaseSafeCall", "(Lcom/example/grocerlypartners/model/Product;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertImageToFirebase", "(Landroid/net/Uri;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "emitProductValidationErrors", "isProductValidated", "", "parseStringIntoProduct", "Lcom/example/grocerlypartners/utils/ProductCategory;", "productCategory", "parseProductIntoInt", "", "category", "onCleared", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel()
public final class UpdateProductViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.example.grocerlypartners.repository.UpdateProductRepoImpl updateProductRepoImpl = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableSharedFlow<com.example.grocerlypartners.utils.NetworkResult<java.lang.String>> _updateProduct = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.channels.Channel<com.example.grocerlypartners.utils.productValidationState> _productValidationState = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<com.example.grocerlypartners.utils.NetworkResult<java.lang.String>> _uploadImageState = null;
    
    @javax.inject.Inject()
    public UpdateProductViewModel(@org.jetbrains.annotations.NotNull()
    com.example.grocerlypartners.repository.UpdateProductRepoImpl updateProductRepoImpl) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<com.example.grocerlypartners.utils.NetworkResult<java.lang.String>> getUpdateProduct() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<com.example.grocerlypartners.utils.productValidationState> getProductValidationState() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<com.example.grocerlypartners.utils.NetworkResult<java.lang.String>> getUploadImageState() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job updateDataIntoFirebase(@org.jetbrains.annotations.NotNull()
    com.example.grocerlypartners.model.Product product) {
        return null;
    }
    
    public final void uploadImageToFirebase(@org.jetbrains.annotations.NotNull()
    android.net.Uri uri) {
    }
    
    private final java.lang.Object updateDataIntoFirebaseSafeCall(com.example.grocerlypartners.model.Product product, kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    private final java.lang.Object insertImageToFirebase(android.net.Uri uri, kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    private final java.lang.Object emitProductValidationErrors(com.example.grocerlypartners.model.Product product, kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    private final boolean isProductValidated(com.example.grocerlypartners.model.Product product) {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.grocerlypartners.utils.ProductCategory parseStringIntoProduct(@org.jetbrains.annotations.NotNull()
    java.lang.String productCategory) {
        return null;
    }
    
    public final int parseProductIntoInt(@org.jetbrains.annotations.NotNull()
    com.example.grocerlypartners.utils.ProductCategory category) {
        return 0;
    }
    
    @java.lang.Override()
    protected void onCleared() {
    }
}