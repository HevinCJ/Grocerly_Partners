package com.example.grocerlypartners.viewmodel;

@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017J\u0016\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0082@\u00a2\u0006\u0002\u0010\u0019J\u0016\u0010\u001a\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0082@\u00a2\u0006\u0002\u0010\u0019J\u0010\u0010\u0011\u001a\u00020\u001b2\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\b\u0010\u001c\u001a\u00020\u0015H\u0014R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u000b8F\u00a2\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u00128F\u00a2\u0006\u0006\u001a\u0004\b\u0011\u0010\u0013\u00a8\u0006\u001d"}, d2 = {"Lcom/example/grocerlypartners/viewmodel/UpdateOfferViewModel;", "Landroidx/lifecycle/ViewModel;", "updateOfferRepoImpl", "Lcom/example/grocerlypartners/repository/UpdateOfferRepoImpl;", "<init>", "(Lcom/example/grocerlypartners/repository/UpdateOfferRepoImpl;)V", "_updateOffer", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Lcom/example/grocerlypartners/utils/NetworkResult;", "", "updateOffer", "Landroidx/lifecycle/LiveData;", "getUpdateOffer", "()Landroidx/lifecycle/LiveData;", "_isOfferValidated", "Lkotlinx/coroutines/channels/Channel;", "Lcom/example/grocerlypartners/utils/OfferState;", "isOfferValidated", "Lkotlinx/coroutines/flow/Flow;", "()Lkotlinx/coroutines/flow/Flow;", "updateOfferIntoFb", "", "offerItem", "Lcom/example/grocerlypartners/model/OfferItem;", "handleNetworkResultUpdateIntoFirebase", "(Lcom/example/grocerlypartners/model/OfferItem;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "emitValidationErrors", "", "onCleared", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel()
public final class UpdateOfferViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.example.grocerlypartners.repository.UpdateOfferRepoImpl updateOfferRepoImpl = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableSharedFlow<com.example.grocerlypartners.utils.NetworkResult<java.lang.String>> _updateOffer = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.channels.Channel<com.example.grocerlypartners.utils.OfferState> _isOfferValidated = null;
    
    @javax.inject.Inject()
    public UpdateOfferViewModel(@org.jetbrains.annotations.NotNull()
    com.example.grocerlypartners.repository.UpdateOfferRepoImpl updateOfferRepoImpl) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<com.example.grocerlypartners.utils.NetworkResult<java.lang.String>> getUpdateOffer() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<com.example.grocerlypartners.utils.OfferState> isOfferValidated() {
        return null;
    }
    
    public final void updateOfferIntoFb(@org.jetbrains.annotations.NotNull()
    com.example.grocerlypartners.model.OfferItem offerItem) {
    }
    
    private final java.lang.Object handleNetworkResultUpdateIntoFirebase(com.example.grocerlypartners.model.OfferItem offerItem, kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    private final java.lang.Object emitValidationErrors(com.example.grocerlypartners.model.OfferItem offerItem, kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    private final boolean isOfferValidated(com.example.grocerlypartners.model.OfferItem offerItem) {
        return false;
    }
    
    @java.lang.Override()
    protected void onCleared() {
    }
}