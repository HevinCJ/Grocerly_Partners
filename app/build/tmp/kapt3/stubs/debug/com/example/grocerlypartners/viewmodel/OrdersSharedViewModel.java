package com.example.grocerlypartners.viewmodel;

@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0006\u0010\u0018\u001a\u00020\u0011J\u0006\u0010\u0019\u001a\u00020\u0011J\u0006\u0010\u001a\u001a\u00020\u0011J\u0006\u0010\u001b\u001a\u00020\u0011J\u0006\u0010\u001c\u001a\u00020\u0011J\u000e\u0010\u001d\u001a\u00020\u00112\u0006\u0010\u001e\u001a\u00020\u0014J\u0016\u0010\u001f\u001a\u00020\u00112\u0006\u0010\u001e\u001a\u00020\u00142\u0006\u0010 \u001a\u00020!J\u0016\u0010\"\u001a\u00020\u00112\u0006\u0010\u001e\u001a\u00020\u00142\u0006\u0010#\u001a\u00020$J\u001e\u0010%\u001a\u00020\u00112\u0006\u0010\u001e\u001a\u00020\u00142\u0006\u0010 \u001a\u00020!H\u0082@\u00a2\u0006\u0002\u0010&J\u001e\u0010\'\u001a\u00020\u00112\u0006\u0010\u001e\u001a\u00020\u00142\u0006\u0010#\u001a\u00020$H\u0082@\u00a2\u0006\u0002\u0010(J\b\u0010)\u001a\u00020\u0011H\u0014R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0019\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\f8F\u00a2\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00100\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R \u0010\u0012\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u00130\u00100\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R \u0010\u0015\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u00130\u00100\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R \u0010\u0016\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u00130\u00100\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R \u0010\u0017\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u00130\u00100\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006*"}, d2 = {"Lcom/example/grocerlypartners/viewmodel/OrdersSharedViewModel;", "Landroidx/lifecycle/AndroidViewModel;", "ordersRepoImpl", "Lcom/example/grocerlypartners/repository/OrdersRepoImpl;", "application", "Landroid/app/Application;", "<init>", "(Lcom/example/grocerlypartners/repository/OrdersRepoImpl;Landroid/app/Application;)V", "_orders", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/example/grocerlypartners/utils/OrderUiState;", "orders", "Lkotlinx/coroutines/flow/StateFlow;", "getOrders", "()Lkotlinx/coroutines/flow/StateFlow;", "_orderStatus", "Lcom/example/grocerlypartners/utils/NetworkResult;", "", "_pendingOrders", "", "Lcom/example/grocerlypartners/model/Order;", "_acceptedOrders", "_readyOrders", "_shippedOrders", "getPendingOrders", "getAcceptedOrders", "cleanCancelledOrders", "getReadyOrders", "getShippedOrders", "deleteOrder", "order", "setOrderStatus", "orderStatus", "Lcom/example/grocerlypartners/utils/OrderStatus;", "setCancellationStatus", "reason", "", "setOrderStatusInOrder", "(Lcom/example/grocerlypartners/model/Order;Lcom/example/grocerlypartners/utils/OrderStatus;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setCancellationStatusOrder", "(Lcom/example/grocerlypartners/model/Order;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onCleared", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel()
public final class OrdersSharedViewModel extends androidx.lifecycle.AndroidViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.example.grocerlypartners.repository.OrdersRepoImpl ordersRepoImpl = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<com.example.grocerlypartners.utils.OrderUiState> _orders = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<com.example.grocerlypartners.utils.NetworkResult<kotlin.Unit>> _orderStatus = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<com.example.grocerlypartners.utils.NetworkResult<java.util.List<com.example.grocerlypartners.model.Order>>> _pendingOrders = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<com.example.grocerlypartners.utils.NetworkResult<java.util.List<com.example.grocerlypartners.model.Order>>> _acceptedOrders = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<com.example.grocerlypartners.utils.NetworkResult<java.util.List<com.example.grocerlypartners.model.Order>>> _readyOrders = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<com.example.grocerlypartners.utils.NetworkResult<java.util.List<com.example.grocerlypartners.model.Order>>> _shippedOrders = null;
    
    @javax.inject.Inject()
    public OrdersSharedViewModel(@org.jetbrains.annotations.NotNull()
    com.example.grocerlypartners.repository.OrdersRepoImpl ordersRepoImpl, @org.jetbrains.annotations.NotNull()
    android.app.Application application) {
        super(null);
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<com.example.grocerlypartners.utils.OrderUiState> getOrders() {
        return null;
    }
    
    public final void getPendingOrders() {
    }
    
    public final void getAcceptedOrders() {
    }
    
    public final void cleanCancelledOrders() {
    }
    
    public final void getReadyOrders() {
    }
    
    public final void getShippedOrders() {
    }
    
    public final void deleteOrder(@org.jetbrains.annotations.NotNull()
    com.example.grocerlypartners.model.Order order) {
    }
    
    public final void setOrderStatus(@org.jetbrains.annotations.NotNull()
    com.example.grocerlypartners.model.Order order, @org.jetbrains.annotations.NotNull()
    com.example.grocerlypartners.utils.OrderStatus orderStatus) {
    }
    
    public final void setCancellationStatus(@org.jetbrains.annotations.NotNull()
    com.example.grocerlypartners.model.Order order, @org.jetbrains.annotations.NotNull()
    java.lang.String reason) {
    }
    
    private final java.lang.Object setOrderStatusInOrder(com.example.grocerlypartners.model.Order order, com.example.grocerlypartners.utils.OrderStatus orderStatus, kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    private final java.lang.Object setCancellationStatusOrder(com.example.grocerlypartners.model.Order order, java.lang.String reason, kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @java.lang.Override()
    protected void onCleared() {
    }
}