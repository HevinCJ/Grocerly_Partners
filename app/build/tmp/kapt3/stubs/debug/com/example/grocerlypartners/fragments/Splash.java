package com.example.grocerlypartners.fragments;

@dagger.hilt.android.AndroidEntryPoint()
@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J$\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\u0010 \u001a\u0004\u0018\u00010!H\u0016J\u001a\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u001b2\b\u0010 \u001a\u0004\u0018\u00010!H\u0016J\b\u0010%\u001a\u00020#H\u0002J\b\u0010&\u001a\u00020#H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u00058BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\n8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001b\u0010\u000f\u001a\u00020\u00108BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0011\u0010\u0012R\u001b\u0010\u0015\u001a\u00020\u00168BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0019\u0010\u0014\u001a\u0004\b\u0017\u0010\u0018\u00a8\u0006\'"}, d2 = {"Lcom/example/grocerlypartners/fragments/Splash;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "splash", "Lcom/example/grocerlypartners/databinding/FragmentSplashBinding;", "binding", "getBinding", "()Lcom/example/grocerlypartners/databinding/FragmentSplashBinding;", "grocerlyDataStore", "Lcom/example/grocerlypartners/preferences/GrocerlyDataStore;", "getGrocerlyDataStore", "()Lcom/example/grocerlypartners/preferences/GrocerlyDataStore;", "setGrocerlyDataStore", "(Lcom/example/grocerlypartners/preferences/GrocerlyDataStore;)V", "homeViewModel", "Lcom/example/grocerlypartners/viewmodel/HomeViewModel;", "getHomeViewModel", "()Lcom/example/grocerlypartners/viewmodel/HomeViewModel;", "homeViewModel$delegate", "Lkotlin/Lazy;", "graphViewModel", "Lcom/example/grocerlypartners/viewmodel/GraphViewModel;", "getGraphViewModel", "()Lcom/example/grocerlypartners/viewmodel/GraphViewModel;", "graphViewModel$delegate", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "navigateToHome", "onDestroyView", "app_debug"})
public final class Splash extends androidx.fragment.app.Fragment {
    @org.jetbrains.annotations.Nullable()
    private com.example.grocerlypartners.databinding.FragmentSplashBinding splash;
    @javax.inject.Inject()
    public com.example.grocerlypartners.preferences.GrocerlyDataStore grocerlyDataStore;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy homeViewModel$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy graphViewModel$delegate = null;
    
    public Splash() {
        super();
    }
    
    private final com.example.grocerlypartners.databinding.FragmentSplashBinding getBinding() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.grocerlypartners.preferences.GrocerlyDataStore getGrocerlyDataStore() {
        return null;
    }
    
    public final void setGrocerlyDataStore(@org.jetbrains.annotations.NotNull()
    com.example.grocerlypartners.preferences.GrocerlyDataStore p0) {
    }
    
    private final com.example.grocerlypartners.viewmodel.HomeViewModel getHomeViewModel() {
        return null;
    }
    
    private final com.example.grocerlypartners.viewmodel.GraphViewModel getGraphViewModel() {
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
    
    private final void navigateToHome() {
    }
    
    @java.lang.Override()
    public void onDestroyView() {
    }
}