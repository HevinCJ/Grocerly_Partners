package com.example.grocerlypartners.adaptor;

@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0013B/\u0012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016R\u001a\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0014"}, d2 = {"Lcom/example/grocerlypartners/adaptor/AcceptedAdaptor;", "Lcom/example/grocerlypartners/adaptor/BaseOrderAdaptor;", "onAccept", "Lkotlin/Function1;", "Lcom/example/grocerlypartners/model/Order;", "", "onDelete", "<init>", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "calculateCurrentTime", "", "timestamp", "", "onCreateViewHolder", "Lcom/example/grocerlypartners/adaptor/BaseOrderAdaptor$BaseOrderViewHolder;", "parent", "Landroid/view/ViewGroup;", "viewType", "", "AcceptedViewHolder", "app_debug"})
public final class AcceptedAdaptor extends com.example.grocerlypartners.adaptor.BaseOrderAdaptor {
    @org.jetbrains.annotations.NotNull()
    private final kotlin.jvm.functions.Function1<com.example.grocerlypartners.model.Order, kotlin.Unit> onAccept = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.jvm.functions.Function1<com.example.grocerlypartners.model.Order, kotlin.Unit> onDelete = null;
    
    public AcceptedAdaptor(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.example.grocerlypartners.model.Order, kotlin.Unit> onAccept, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.example.grocerlypartners.model.Order, kotlin.Unit> onDelete) {
        super();
    }
    
    private final java.lang.String calculateCurrentTime(long timestamp) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public com.example.grocerlypartners.adaptor.BaseOrderAdaptor.BaseOrderViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\n"}, d2 = {"Lcom/example/grocerlypartners/adaptor/AcceptedAdaptor$AcceptedViewHolder;", "Lcom/example/grocerlypartners/adaptor/BaseOrderAdaptor$BaseOrderViewHolder;", "binding", "Lcom/example/grocerlypartners/databinding/AcceptedRcLayoutBinding;", "<init>", "(Lcom/example/grocerlypartners/adaptor/AcceptedAdaptor;Lcom/example/grocerlypartners/databinding/AcceptedRcLayoutBinding;)V", "bind", "", "order", "Lcom/example/grocerlypartners/model/Order;", "app_debug"})
    public final class AcceptedViewHolder extends com.example.grocerlypartners.adaptor.BaseOrderAdaptor.BaseOrderViewHolder {
        @org.jetbrains.annotations.NotNull()
        private final com.example.grocerlypartners.databinding.AcceptedRcLayoutBinding binding = null;
        
        public AcceptedViewHolder(@org.jetbrains.annotations.NotNull()
        com.example.grocerlypartners.databinding.AcceptedRcLayoutBinding binding) {
            super(null);
        }
        
        @java.lang.Override()
        public void bind(@org.jetbrains.annotations.NotNull()
        com.example.grocerlypartners.model.Order order) {
        }
    }
}