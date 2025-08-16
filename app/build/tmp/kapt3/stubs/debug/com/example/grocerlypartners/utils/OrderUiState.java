package com.example.grocerlypartners.utils;

@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0005\u0004\u0005\u0006\u0007\bB\t\b\u0004\u00a2\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0005\t\n\u000b\f\r\u00a8\u0006\u000e"}, d2 = {"Lcom/example/grocerlypartners/utils/OrderUiState;", "", "<init>", "()V", "Pending", "Accepted", "Ready", "Shipped", "OrderStatus", "Lcom/example/grocerlypartners/utils/OrderUiState$Accepted;", "Lcom/example/grocerlypartners/utils/OrderUiState$OrderStatus;", "Lcom/example/grocerlypartners/utils/OrderUiState$Pending;", "Lcom/example/grocerlypartners/utils/OrderUiState$Ready;", "Lcom/example/grocerlypartners/utils/OrderUiState$Shipped;", "app_debug"})
public abstract class OrderUiState {
    
    private OrderUiState() {
        super();
    }
    
    @kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u001b\u0012\u0012\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0003\u00a2\u0006\u0004\b\u0006\u0010\u0007R\u001d\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t\u00a8\u0006\n"}, d2 = {"Lcom/example/grocerlypartners/utils/OrderUiState$Accepted;", "Lcom/example/grocerlypartners/utils/OrderUiState;", "result", "Lcom/example/grocerlypartners/utils/NetworkResult;", "", "Lcom/example/grocerlypartners/model/Order;", "<init>", "(Lcom/example/grocerlypartners/utils/NetworkResult;)V", "getResult", "()Lcom/example/grocerlypartners/utils/NetworkResult;", "app_debug"})
    public static final class Accepted extends com.example.grocerlypartners.utils.OrderUiState {
        @org.jetbrains.annotations.NotNull()
        private final com.example.grocerlypartners.utils.NetworkResult<java.util.List<com.example.grocerlypartners.model.Order>> result = null;
        
        public Accepted(@org.jetbrains.annotations.NotNull()
        com.example.grocerlypartners.utils.NetworkResult<java.util.List<com.example.grocerlypartners.model.Order>> result) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.example.grocerlypartners.utils.NetworkResult<java.util.List<com.example.grocerlypartners.model.Order>> getResult() {
            return null;
        }
    }
    
    @kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\t"}, d2 = {"Lcom/example/grocerlypartners/utils/OrderUiState$OrderStatus;", "Lcom/example/grocerlypartners/utils/OrderUiState;", "result", "Lcom/example/grocerlypartners/utils/NetworkResult;", "", "<init>", "(Lcom/example/grocerlypartners/utils/NetworkResult;)V", "getResult", "()Lcom/example/grocerlypartners/utils/NetworkResult;", "app_debug"})
    public static final class OrderStatus extends com.example.grocerlypartners.utils.OrderUiState {
        @org.jetbrains.annotations.NotNull()
        private final com.example.grocerlypartners.utils.NetworkResult<kotlin.Unit> result = null;
        
        public OrderStatus(@org.jetbrains.annotations.NotNull()
        com.example.grocerlypartners.utils.NetworkResult<kotlin.Unit> result) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.example.grocerlypartners.utils.NetworkResult<kotlin.Unit> getResult() {
            return null;
        }
    }
    
    @kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u001b\u0012\u0012\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0003\u00a2\u0006\u0004\b\u0006\u0010\u0007R\u001d\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t\u00a8\u0006\n"}, d2 = {"Lcom/example/grocerlypartners/utils/OrderUiState$Pending;", "Lcom/example/grocerlypartners/utils/OrderUiState;", "result", "Lcom/example/grocerlypartners/utils/NetworkResult;", "", "Lcom/example/grocerlypartners/model/Order;", "<init>", "(Lcom/example/grocerlypartners/utils/NetworkResult;)V", "getResult", "()Lcom/example/grocerlypartners/utils/NetworkResult;", "app_debug"})
    public static final class Pending extends com.example.grocerlypartners.utils.OrderUiState {
        @org.jetbrains.annotations.NotNull()
        private final com.example.grocerlypartners.utils.NetworkResult<java.util.List<com.example.grocerlypartners.model.Order>> result = null;
        
        public Pending(@org.jetbrains.annotations.NotNull()
        com.example.grocerlypartners.utils.NetworkResult<java.util.List<com.example.grocerlypartners.model.Order>> result) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.example.grocerlypartners.utils.NetworkResult<java.util.List<com.example.grocerlypartners.model.Order>> getResult() {
            return null;
        }
    }
    
    @kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u001b\u0012\u0012\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0003\u00a2\u0006\u0004\b\u0006\u0010\u0007R\u001d\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t\u00a8\u0006\n"}, d2 = {"Lcom/example/grocerlypartners/utils/OrderUiState$Ready;", "Lcom/example/grocerlypartners/utils/OrderUiState;", "result", "Lcom/example/grocerlypartners/utils/NetworkResult;", "", "Lcom/example/grocerlypartners/model/Order;", "<init>", "(Lcom/example/grocerlypartners/utils/NetworkResult;)V", "getResult", "()Lcom/example/grocerlypartners/utils/NetworkResult;", "app_debug"})
    public static final class Ready extends com.example.grocerlypartners.utils.OrderUiState {
        @org.jetbrains.annotations.NotNull()
        private final com.example.grocerlypartners.utils.NetworkResult<java.util.List<com.example.grocerlypartners.model.Order>> result = null;
        
        public Ready(@org.jetbrains.annotations.NotNull()
        com.example.grocerlypartners.utils.NetworkResult<java.util.List<com.example.grocerlypartners.model.Order>> result) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.example.grocerlypartners.utils.NetworkResult<java.util.List<com.example.grocerlypartners.model.Order>> getResult() {
            return null;
        }
    }
    
    @kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u001b\u0012\u0012\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0003\u00a2\u0006\u0004\b\u0006\u0010\u0007R\u001d\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t\u00a8\u0006\n"}, d2 = {"Lcom/example/grocerlypartners/utils/OrderUiState$Shipped;", "Lcom/example/grocerlypartners/utils/OrderUiState;", "result", "Lcom/example/grocerlypartners/utils/NetworkResult;", "", "Lcom/example/grocerlypartners/model/Order;", "<init>", "(Lcom/example/grocerlypartners/utils/NetworkResult;)V", "getResult", "()Lcom/example/grocerlypartners/utils/NetworkResult;", "app_debug"})
    public static final class Shipped extends com.example.grocerlypartners.utils.OrderUiState {
        @org.jetbrains.annotations.NotNull()
        private final com.example.grocerlypartners.utils.NetworkResult<java.util.List<com.example.grocerlypartners.model.Order>> result = null;
        
        public Shipped(@org.jetbrains.annotations.NotNull()
        com.example.grocerlypartners.utils.NetworkResult<java.util.List<com.example.grocerlypartners.model.Order>> result) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.example.grocerlypartners.utils.NetworkResult<java.util.List<com.example.grocerlypartners.model.Order>> getResult() {
            return null;
        }
    }
}