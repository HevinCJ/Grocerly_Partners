package com.example.grocerlypartners.viewmodel;

@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u0013\u001a\u00020\u0014J\u000e\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\tJ\u0016\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\tH\u0082@\u00a2\u0006\u0002\u0010\u0018J\u000e\u0010\u0019\u001a\u00020\u0014H\u0082@\u00a2\u0006\u0002\u0010\u001aJ\b\u0010\u001b\u001a\u00020\u0014H\u0014R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u000b8F\u00a2\u0006\u0006\u001a\u0004\b\f\u0010\rR \u0010\u000e\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u00100\b0\u000fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R#\u0010\u0011\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u00100\b0\u000b8F\u00a2\u0006\u0006\u001a\u0004\b\u0012\u0010\r\u00a8\u0006\u001c"}, d2 = {"Lcom/example/grocerlypartners/viewmodel/OfferViewModel;", "Landroidx/lifecycle/ViewModel;", "offerRepoImpl", "Lcom/example/grocerlypartners/repository/OfferRepoImpl;", "<init>", "(Lcom/example/grocerlypartners/repository/OfferRepoImpl;)V", "_deletedOffer", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Lcom/example/grocerlypartners/utils/NetworkResult;", "Lcom/example/grocerlypartners/model/OfferItem;", "deletedOffer", "Landroidx/lifecycle/LiveData;", "getDeletedOffer", "()Landroidx/lifecycle/LiveData;", "_offerItems", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "offerItems", "getOfferItems", "getOfferFromFirebase", "", "deleteOfferFromFirebase", "offerItem", "handleNetworkResultForDeleteOffer", "(Lcom/example/grocerlypartners/model/OfferItem;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fetchOfferFromDb", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onCleared", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel()
public final class OfferViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.example.grocerlypartners.repository.OfferRepoImpl offerRepoImpl = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableSharedFlow<com.example.grocerlypartners.utils.NetworkResult<com.example.grocerlypartners.model.OfferItem>> _deletedOffer = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<com.example.grocerlypartners.utils.NetworkResult<java.util.List<com.example.grocerlypartners.model.OfferItem>>> _offerItems = null;
    
    @javax.inject.Inject()
    public OfferViewModel(@org.jetbrains.annotations.NotNull()
    com.example.grocerlypartners.repository.OfferRepoImpl offerRepoImpl) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<com.example.grocerlypartners.utils.NetworkResult<com.example.grocerlypartners.model.OfferItem>> getDeletedOffer() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<com.example.grocerlypartners.utils.NetworkResult<java.util.List<com.example.grocerlypartners.model.OfferItem>>> getOfferItems() {
        return null;
    }
    
    public final void getOfferFromFirebase() {
    }
    
    public final void deleteOfferFromFirebase(@org.jetbrains.annotations.NotNull()
    com.example.grocerlypartners.model.OfferItem offerItem) {
    }
    
    private final java.lang.Object handleNetworkResultForDeleteOffer(com.example.grocerlypartners.model.OfferItem offerItem, kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    private final java.lang.Object fetchOfferFromDb(kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @java.lang.Override()
    protected void onCleared() {
    }
}