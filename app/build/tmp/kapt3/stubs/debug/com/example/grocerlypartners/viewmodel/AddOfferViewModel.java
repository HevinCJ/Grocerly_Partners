package com.example.grocerlypartners.viewmodel;

@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aJ\u0016\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0082@\u00a2\u0006\u0002\u0010\u001cJ\u0016\u0010\u001d\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0082@\u00a2\u0006\u0002\u0010\u001cJ\u0010\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\b\u0010 \u001a\u00020\u0018H\u0014R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\r8F\u00a2\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u00148F\u00a2\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016\u00a8\u0006!"}, d2 = {"Lcom/example/grocerlypartners/viewmodel/AddOfferViewModel;", "Landroidx/lifecycle/AndroidViewModel;", "application", "Landroid/app/Application;", "addOfferRepoImpl", "Lcom/example/grocerlypartners/repository/AddOfferRepoImpl;", "<init>", "(Landroid/app/Application;Lcom/example/grocerlypartners/repository/AddOfferRepoImpl;)V", "_offerAdded", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Lcom/example/grocerlypartners/utils/NetworkResult;", "", "offerAdded", "Landroidx/lifecycle/LiveData;", "getOfferAdded", "()Landroidx/lifecycle/LiveData;", "_offerState", "Lkotlinx/coroutines/channels/Channel;", "Lcom/example/grocerlypartners/utils/OfferState;", "offerstate", "Lkotlinx/coroutines/flow/Flow;", "getOfferstate", "()Lkotlinx/coroutines/flow/Flow;", "insertOfferIntoIntoFirebase", "", "offerItem", "Lcom/example/grocerlypartners/model/OfferItem;", "validateAndInsertOffer", "(Lcom/example/grocerlypartners/model/OfferItem;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "emitOfferValidationErrors", "isOffersAreValidated", "", "onCleared", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel()
public final class AddOfferViewModel extends androidx.lifecycle.AndroidViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.example.grocerlypartners.repository.AddOfferRepoImpl addOfferRepoImpl = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableSharedFlow<com.example.grocerlypartners.utils.NetworkResult<java.lang.String>> _offerAdded = null;
    @org.jetbrains.annotations.NotNull()
    private kotlinx.coroutines.channels.Channel<com.example.grocerlypartners.utils.OfferState> _offerState;
    
    @javax.inject.Inject()
    public AddOfferViewModel(@org.jetbrains.annotations.NotNull()
    android.app.Application application, @org.jetbrains.annotations.NotNull()
    com.example.grocerlypartners.repository.AddOfferRepoImpl addOfferRepoImpl) {
        super(null);
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<com.example.grocerlypartners.utils.NetworkResult<java.lang.String>> getOfferAdded() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<com.example.grocerlypartners.utils.OfferState> getOfferstate() {
        return null;
    }
    
    public final void insertOfferIntoIntoFirebase(@org.jetbrains.annotations.NotNull()
    com.example.grocerlypartners.model.OfferItem offerItem) {
    }
    
    private final java.lang.Object validateAndInsertOffer(com.example.grocerlypartners.model.OfferItem offerItem, kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    private final java.lang.Object emitOfferValidationErrors(com.example.grocerlypartners.model.OfferItem offerItem, kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    private final boolean isOffersAreValidated(com.example.grocerlypartners.model.OfferItem offerItem) {
        return false;
    }
    
    @java.lang.Override()
    protected void onCleared() {
    }
}