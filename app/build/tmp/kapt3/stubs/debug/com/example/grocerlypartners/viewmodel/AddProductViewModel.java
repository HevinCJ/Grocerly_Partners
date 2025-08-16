package com.example.grocerlypartners.viewmodel;

@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 J\u000e\u0010!\u001a\u00020\u001e2\u0006\u0010\"\u001a\u00020#J\u0016\u0010$\u001a\u00020\u001e2\u0006\u0010\"\u001a\u00020#H\u0082@\u00a2\u0006\u0002\u0010%J\u0016\u0010&\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0082@\u00a2\u0006\u0002\u0010\'J\u000e\u0010(\u001a\u00020\u000b2\u0006\u0010)\u001a\u00020*J\u000e\u0010+\u001a\u00020,2\u0006\u0010)\u001a\u00020*J\u0016\u0010-\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0082@\u00a2\u0006\u0002\u0010\'J\u000e\u0010.\u001a\u00020*2\u0006\u0010/\u001a\u00020\u000bJ\u0010\u00100\u001a\u0002012\u0006\u0010\u001f\u001a\u00020 H\u0002J\b\u00102\u001a\u00020\u001eH\u0014R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\r8F\u00a2\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u00148F\u00a2\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\u0018X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\u0019\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\u001a8F\u00a2\u0006\u0006\u001a\u0004\b\u001b\u0010\u001c\u00a8\u00063"}, d2 = {"Lcom/example/grocerlypartners/viewmodel/AddProductViewModel;", "Landroidx/lifecycle/AndroidViewModel;", "addProductRepoImpl", "Lcom/example/grocerlypartners/repository/AddProductRepoImpl;", "application", "Landroid/app/Application;", "<init>", "(Lcom/example/grocerlypartners/repository/AddProductRepoImpl;Landroid/app/Application;)V", "_uploadProduct", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Lcom/example/grocerlypartners/utils/NetworkResult;", "", "uploadProduct", "Landroidx/lifecycle/LiveData;", "getUploadProduct", "()Landroidx/lifecycle/LiveData;", "_productValState", "Lkotlinx/coroutines/channels/Channel;", "Lcom/example/grocerlypartners/utils/productValidationState;", "productValState", "Lkotlinx/coroutines/flow/Flow;", "getProductValState", "()Lkotlinx/coroutines/flow/Flow;", "_uploadImageState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "uploadImageState", "Lkotlinx/coroutines/flow/StateFlow;", "getUploadImageState", "()Lkotlinx/coroutines/flow/StateFlow;", "uploadProductToFirebase", "", "product", "Lcom/example/grocerlypartners/model/Product;", "uploadImageToFirebase", "uri", "Landroid/net/Uri;", "insertImageToFirebase", "(Landroid/net/Uri;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertDataIntoDb", "(Lcom/example/grocerlypartners/model/Product;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "parseProductIntoString", "category", "Lcom/example/grocerlypartners/utils/ProductCategory;", "parseProductIntoInt", "", "emitProductionValidationErrors", "parseStringIntoProduct", "productCategory", "isProductValidated", "", "onCleared", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel()
public final class AddProductViewModel extends androidx.lifecycle.AndroidViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.example.grocerlypartners.repository.AddProductRepoImpl addProductRepoImpl = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableSharedFlow<com.example.grocerlypartners.utils.NetworkResult<java.lang.String>> _uploadProduct = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.channels.Channel<com.example.grocerlypartners.utils.productValidationState> _productValState = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<com.example.grocerlypartners.utils.NetworkResult<java.lang.String>> _uploadImageState = null;
    
    @javax.inject.Inject()
    public AddProductViewModel(@org.jetbrains.annotations.NotNull()
    com.example.grocerlypartners.repository.AddProductRepoImpl addProductRepoImpl, @org.jetbrains.annotations.NotNull()
    android.app.Application application) {
        super(null);
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<com.example.grocerlypartners.utils.NetworkResult<java.lang.String>> getUploadProduct() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<com.example.grocerlypartners.utils.productValidationState> getProductValState() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<com.example.grocerlypartners.utils.NetworkResult<java.lang.String>> getUploadImageState() {
        return null;
    }
    
    public final void uploadProductToFirebase(@org.jetbrains.annotations.NotNull()
    com.example.grocerlypartners.model.Product product) {
    }
    
    public final void uploadImageToFirebase(@org.jetbrains.annotations.NotNull()
    android.net.Uri uri) {
    }
    
    private final java.lang.Object insertImageToFirebase(android.net.Uri uri, kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    private final java.lang.Object insertDataIntoDb(com.example.grocerlypartners.model.Product product, kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String parseProductIntoString(@org.jetbrains.annotations.NotNull()
    com.example.grocerlypartners.utils.ProductCategory category) {
        return null;
    }
    
    public final int parseProductIntoInt(@org.jetbrains.annotations.NotNull()
    com.example.grocerlypartners.utils.ProductCategory category) {
        return 0;
    }
    
    private final java.lang.Object emitProductionValidationErrors(com.example.grocerlypartners.model.Product product, kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.grocerlypartners.utils.ProductCategory parseStringIntoProduct(@org.jetbrains.annotations.NotNull()
    java.lang.String productCategory) {
        return null;
    }
    
    private final boolean isProductValidated(com.example.grocerlypartners.model.Product product) {
        return false;
    }
    
    @java.lang.Override()
    protected void onCleared() {
    }
}