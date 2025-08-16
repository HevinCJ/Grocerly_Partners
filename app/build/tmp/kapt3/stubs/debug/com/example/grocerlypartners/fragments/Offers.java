package com.example.grocerlypartners.fragments;

@dagger.hilt.android.AndroidEntryPoint()
@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J$\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010$2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\b\u0010%\u001a\u00020\u001cH\u0016J\u001a\u0010&\u001a\u00020\u001c2\u0006\u0010\'\u001a\u00020 2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\b\u0010(\u001a\u00020\u001cH\u0002J\u0010\u0010)\u001a\u00020\u001c2\u0006\u0010*\u001a\u00020+H\u0002J\b\u0010,\u001a\u00020\u001cH\u0002J\b\u0010-\u001a\u00020\u001cH\u0002J\u0016\u0010.\u001a\u00020\u001c2\f\u0010/\u001a\b\u0012\u0004\u0012\u00020+00H\u0002J\b\u00101\u001a\u00020\u001cH\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u00058BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u001b\u0010\t\u001a\u00020\n8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fR\u001b\u0010\u000f\u001a\u00020\u00108BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0013\u0010\u000e\u001a\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082.\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u0016\u001a\u00020\u00178BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001a\u0010\u000e\u001a\u0004\b\u0018\u0010\u0019\u00a8\u00062"}, d2 = {"Lcom/example/grocerlypartners/fragments/Offers;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "offers", "Lcom/example/grocerlypartners/databinding/FragmentOffersBinding;", "binding", "getBinding", "()Lcom/example/grocerlypartners/databinding/FragmentOffersBinding;", "offerViewModel", "Lcom/example/grocerlypartners/viewmodel/OfferViewModel;", "getOfferViewModel", "()Lcom/example/grocerlypartners/viewmodel/OfferViewModel;", "offerViewModel$delegate", "Lkotlin/Lazy;", "addOfferViewModel", "Lcom/example/grocerlypartners/viewmodel/AddOfferViewModel;", "getAddOfferViewModel", "()Lcom/example/grocerlypartners/viewmodel/AddOfferViewModel;", "addOfferViewModel$delegate", "loadingDialogue", "Lcom/example/grocerlypartners/utils/LoadingDialogue;", "offerAdaptor", "Lcom/example/grocerlypartners/adaptor/OfferAdaptor;", "getOfferAdaptor", "()Lcom/example/grocerlypartners/adaptor/OfferAdaptor;", "offerAdaptor$delegate", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onStart", "onViewCreated", "view", "observeOfferDeletion", "showSnackBar", "data", "Lcom/example/grocerlypartners/model/OfferItem;", "setDeleteOffer", "observeOffersFromFirebase", "setOfferAdaptor", "it", "", "onDestroyView", "app_debug"})
public final class Offers extends androidx.fragment.app.Fragment {
    @org.jetbrains.annotations.Nullable()
    private com.example.grocerlypartners.databinding.FragmentOffersBinding offers;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy offerViewModel$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy addOfferViewModel$delegate = null;
    private com.example.grocerlypartners.utils.LoadingDialogue loadingDialogue;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy offerAdaptor$delegate = null;
    
    public Offers() {
        super();
    }
    
    private final com.example.grocerlypartners.databinding.FragmentOffersBinding getBinding() {
        return null;
    }
    
    private final com.example.grocerlypartners.viewmodel.OfferViewModel getOfferViewModel() {
        return null;
    }
    
    private final com.example.grocerlypartners.viewmodel.AddOfferViewModel getAddOfferViewModel() {
        return null;
    }
    
    private final com.example.grocerlypartners.adaptor.OfferAdaptor getOfferAdaptor() {
        return null;
    }
    
    @java.lang.Override()
    public void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull()
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable()
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    @java.lang.Override()
    public void onStart() {
    }
    
    @java.lang.Override()
    public void onViewCreated(@org.jetbrains.annotations.NotNull()
    android.view.View view, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void observeOfferDeletion() {
    }
    
    private final void showSnackBar(com.example.grocerlypartners.model.OfferItem data) {
    }
    
    private final void setDeleteOffer() {
    }
    
    private final void observeOffersFromFirebase() {
    }
    
    private final void setOfferAdaptor(java.util.List<com.example.grocerlypartners.model.OfferItem> it) {
    }
    
    @java.lang.Override()
    public void onDestroyView() {
    }
}