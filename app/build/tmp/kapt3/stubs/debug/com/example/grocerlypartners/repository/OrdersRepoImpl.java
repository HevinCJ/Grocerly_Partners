package com.example.grocerlypartners.repository;

@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000f0\u000e0\rJ\u0018\u0010\u0011\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000f0\u000e0\rJ\u0018\u0010\u0012\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000f0\u000e0\rJ\u0018\u0010\u0013\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000f0\u000e0\rJ\u000e\u0010\u0014\u001a\u00020\u0015H\u0086@\u00a2\u0006\u0002\u0010\u0016J$\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00150\u000e2\u0006\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020\u001aH\u0086@\u00a2\u0006\u0002\u0010\u001bJ\u001c\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00150\u000e2\u0006\u0010\u0018\u001a\u00020\u0010H\u0086@\u00a2\u0006\u0002\u0010\u001dJ$\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00150\u000e2\u0006\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u001f\u001a\u00020\tH\u0086@\u00a2\u0006\u0002\u0010 J\u0016\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00010\"*\u00020\u0010J\u0018\u0010!\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\u00010\"*\u00020#J\u0018\u0010!\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\u00010\"*\u00020$J\u0018\u0010!\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\u00010\"*\u00020%R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006&"}, d2 = {"Lcom/example/grocerlypartners/repository/OrdersRepoImpl;", "", "auth", "Lcom/google/firebase/auth/FirebaseAuth;", "db", "Lcom/google/firebase/firestore/FirebaseFirestore;", "<init>", "(Lcom/google/firebase/auth/FirebaseAuth;Lcom/google/firebase/firestore/FirebaseFirestore;)V", "userId", "", "orderRef", "Lcom/google/firebase/firestore/CollectionReference;", "fetchPendingOrders", "Lkotlinx/coroutines/flow/Flow;", "Lcom/example/grocerlypartners/utils/NetworkResult;", "", "Lcom/example/grocerlypartners/model/Order;", "fetchAcceptedOrders", "fetchReadyOrders", "fetchShippedOrders", "cleanCancelledOrders", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setOrderStateInOrder", "order", "status", "Lcom/example/grocerlypartners/utils/OrderStatus;", "(Lcom/example/grocerlypartners/model/Order;Lcom/example/grocerlypartners/utils/OrderStatus;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteOrderFromFirebase", "(Lcom/example/grocerlypartners/model/Order;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setCancellationStatus", "reason", "(Lcom/example/grocerlypartners/model/Order;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toMap", "", "Lcom/example/grocerlypartners/model/CartProduct;", "Lcom/example/grocerlypartners/model/Product;", "Lcom/example/grocerlypartners/model/CancellationInfo;", "app_debug"})
@dagger.hilt.android.scopes.ActivityRetainedScoped()
public final class OrdersRepoImpl {
    @org.jetbrains.annotations.NotNull()
    private final com.google.firebase.auth.FirebaseAuth auth = null;
    @org.jetbrains.annotations.NotNull()
    private final com.google.firebase.firestore.FirebaseFirestore db = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String userId = null;
    @org.jetbrains.annotations.NotNull()
    private final com.google.firebase.firestore.CollectionReference orderRef = null;
    
    @javax.inject.Inject()
    public OrdersRepoImpl(@org.jetbrains.annotations.NotNull()
    com.google.firebase.auth.FirebaseAuth auth, @org.jetbrains.annotations.NotNull()
    com.google.firebase.firestore.FirebaseFirestore db) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<com.example.grocerlypartners.utils.NetworkResult<java.util.List<com.example.grocerlypartners.model.Order>>> fetchPendingOrders() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<com.example.grocerlypartners.utils.NetworkResult<java.util.List<com.example.grocerlypartners.model.Order>>> fetchAcceptedOrders() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<com.example.grocerlypartners.utils.NetworkResult<java.util.List<com.example.grocerlypartners.model.Order>>> fetchReadyOrders() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<com.example.grocerlypartners.utils.NetworkResult<java.util.List<com.example.grocerlypartners.model.Order>>> fetchShippedOrders() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object cleanCancelledOrders(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object setOrderStateInOrder(@org.jetbrains.annotations.NotNull()
    com.example.grocerlypartners.model.Order order, @org.jetbrains.annotations.NotNull()
    com.example.grocerlypartners.utils.OrderStatus status, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.example.grocerlypartners.utils.NetworkResult<kotlin.Unit>> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object deleteOrderFromFirebase(@org.jetbrains.annotations.NotNull()
    com.example.grocerlypartners.model.Order order, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.example.grocerlypartners.utils.NetworkResult<kotlin.Unit>> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object setCancellationStatus(@org.jetbrains.annotations.NotNull()
    com.example.grocerlypartners.model.Order order, @org.jetbrains.annotations.NotNull()
    java.lang.String reason, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.example.grocerlypartners.utils.NetworkResult<kotlin.Unit>> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.Map<java.lang.String, java.lang.Object> toMap(@org.jetbrains.annotations.NotNull()
    com.example.grocerlypartners.model.Order $this$toMap) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.Map<java.lang.String, java.lang.Object> toMap(@org.jetbrains.annotations.NotNull()
    com.example.grocerlypartners.model.CartProduct $this$toMap) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.Map<java.lang.String, java.lang.Object> toMap(@org.jetbrains.annotations.NotNull()
    com.example.grocerlypartners.model.Product $this$toMap) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.Map<java.lang.String, java.lang.Object> toMap(@org.jetbrains.annotations.NotNull()
    com.example.grocerlypartners.model.CancellationInfo $this$toMap) {
        return null;
    }
}