package com.example.grocerlypartners.fragments;

@dagger.hilt.android.AndroidEntryPoint()
@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J$\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\"2\b\u0010#\u001a\u0004\u0018\u00010$H\u0016J\u001a\u0010%\u001a\u00020&2\u0006\u0010\'\u001a\u00020\u001e2\b\u0010#\u001a\u0004\u0018\u00010$H\u0016J\b\u0010(\u001a\u00020&H\u0002J\b\u0010)\u001a\u00020&H\u0002J\b\u0010*\u001a\u00020&H\u0002J\b\u0010+\u001a\u00020&H\u0002J\b\u0010,\u001a\u00020&H\u0002J\b\u0010-\u001a\u00020&H\u0002J\b\u0010.\u001a\u00020&H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u00058BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\n8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001b\u0010\u000f\u001a\u00020\u00108BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0011\u0010\u0012R\u001b\u0010\u0015\u001a\u00020\u00168BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u0017\u0010\u0018R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006/"}, d2 = {"Lcom/example/grocerlypartners/fragments/UpdateOffer;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "updateOffer", "Lcom/example/grocerlypartners/databinding/FragmentUpdateOfferBinding;", "binding", "getBinding", "()Lcom/example/grocerlypartners/databinding/FragmentUpdateOfferBinding;", "db", "Lcom/google/firebase/firestore/FirebaseFirestore;", "getDb", "()Lcom/google/firebase/firestore/FirebaseFirestore;", "setDb", "(Lcom/google/firebase/firestore/FirebaseFirestore;)V", "args", "Lcom/example/grocerlypartners/fragments/UpdateOfferArgs;", "getArgs", "()Lcom/example/grocerlypartners/fragments/UpdateOfferArgs;", "args$delegate", "Landroidx/navigation/NavArgsLazy;", "updateOfferViewModel", "Lcom/example/grocerlypartners/viewmodel/UpdateOfferViewModel;", "getUpdateOfferViewModel", "()Lcom/example/grocerlypartners/viewmodel/UpdateOfferViewModel;", "updateOfferViewModel$delegate", "Lkotlin/Lazy;", "loadingDialogue", "Lcom/example/grocerlypartners/utils/LoadingDialogue;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "observeOfferValidation", "observeUpdateOffer", "updateOfferInDb", "setDefaultOfferData", "setColorPickButtonForBackground", "showPreviewToUser", "onDestroyView", "app_debug"})
public final class UpdateOffer extends androidx.fragment.app.Fragment {
    @org.jetbrains.annotations.Nullable()
    private com.example.grocerlypartners.databinding.FragmentUpdateOfferBinding updateOffer;
    @javax.inject.Inject()
    public com.google.firebase.firestore.FirebaseFirestore db;
    @org.jetbrains.annotations.NotNull()
    private final androidx.navigation.NavArgsLazy args$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy updateOfferViewModel$delegate = null;
    private com.example.grocerlypartners.utils.LoadingDialogue loadingDialogue;
    
    public UpdateOffer() {
        super();
    }
    
    private final com.example.grocerlypartners.databinding.FragmentUpdateOfferBinding getBinding() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.google.firebase.firestore.FirebaseFirestore getDb() {
        return null;
    }
    
    public final void setDb(@org.jetbrains.annotations.NotNull()
    com.google.firebase.firestore.FirebaseFirestore p0) {
    }
    
    private final com.example.grocerlypartners.fragments.UpdateOfferArgs getArgs() {
        return null;
    }
    
    private final com.example.grocerlypartners.viewmodel.UpdateOfferViewModel getUpdateOfferViewModel() {
        return null;
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
    public void onViewCreated(@org.jetbrains.annotations.NotNull()
    android.view.View view, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void observeOfferValidation() {
    }
    
    private final void observeUpdateOffer() {
    }
    
    private final void updateOfferInDb() {
    }
    
    private final void setDefaultOfferData() {
    }
    
    private final void setColorPickButtonForBackground() {
    }
    
    private final void showPreviewToUser() {
    }
    
    @java.lang.Override()
    public void onDestroyView() {
    }
}