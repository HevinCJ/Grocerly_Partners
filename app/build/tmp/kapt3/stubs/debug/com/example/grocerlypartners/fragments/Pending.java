package com.example.grocerlypartners.fragments;

@dagger.hilt.android.AndroidEntryPoint()
@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\u001a\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u00142\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\b\u0010\u001e\u001a\u00020\u001cH\u0002J\b\u0010\u001f\u001a\u00020\u001cH\u0002J\b\u0010 \u001a\u00020\u001cH\u0016J\b\u0010!\u001a\u00020\u001cH\u0002J\b\u0010\"\u001a\u00020\u001cH\u0002J\b\u0010#\u001a\u00020\u001cH\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u00058BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u001b\u0010\t\u001a\u00020\n8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006$"}, d2 = {"Lcom/example/grocerlypartners/fragments/Pending;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "pending", "Lcom/example/grocerlypartners/databinding/FragmentPendingBinding;", "binding", "getBinding", "()Lcom/example/grocerlypartners/databinding/FragmentPendingBinding;", "ordersSharedViewModel", "Lcom/example/grocerlypartners/viewmodel/OrdersSharedViewModel;", "getOrdersSharedViewModel", "()Lcom/example/grocerlypartners/viewmodel/OrdersSharedViewModel;", "ordersSharedViewModel$delegate", "Lkotlin/Lazy;", "pendingAdaptor", "Lcom/example/grocerlypartners/adaptor/PendingAdaptor;", "loadingDialogue", "Lcom/example/grocerlypartners/utils/LoadingDialogue;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "observeOrderStatus", "observeUpdatedStateStatus", "onResume", "setRcView", "observePendingOrders", "onDestroyView", "app_debug"})
public final class Pending extends androidx.fragment.app.Fragment {
    @org.jetbrains.annotations.Nullable()
    private com.example.grocerlypartners.databinding.FragmentPendingBinding pending;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy ordersSharedViewModel$delegate = null;
    private com.example.grocerlypartners.adaptor.PendingAdaptor pendingAdaptor;
    private com.example.grocerlypartners.utils.LoadingDialogue loadingDialogue;
    
    public Pending() {
        super();
    }
    
    private final com.example.grocerlypartners.databinding.FragmentPendingBinding getBinding() {
        return null;
    }
    
    private final com.example.grocerlypartners.viewmodel.OrdersSharedViewModel getOrdersSharedViewModel() {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
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
    
    private final void observeOrderStatus() {
    }
    
    private final void observeUpdatedStateStatus() {
    }
    
    @java.lang.Override()
    public void onResume() {
    }
    
    private final void setRcView() {
    }
    
    private final void observePendingOrders() {
    }
    
    @java.lang.Override()
    public void onDestroyView() {
    }
}