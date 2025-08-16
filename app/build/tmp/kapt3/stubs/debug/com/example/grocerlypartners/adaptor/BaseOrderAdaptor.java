package com.example.grocerlypartners.adaptor;

@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b&\u0018\u0000 \u000b2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\u000b\fB\u0007\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\nH\u0016\u00a8\u0006\r"}, d2 = {"Lcom/example/grocerlypartners/adaptor/BaseOrderAdaptor;", "Landroidx/recyclerview/widget/ListAdapter;", "Lcom/example/grocerlypartners/model/Order;", "Lcom/example/grocerlypartners/adaptor/BaseOrderAdaptor$BaseOrderViewHolder;", "<init>", "()V", "onBindViewHolder", "", "holder", "position", "", "Companion", "BaseOrderViewHolder", "app_debug"})
public abstract class BaseOrderAdaptor extends androidx.recyclerview.widget.ListAdapter<com.example.grocerlypartners.model.Order, com.example.grocerlypartners.adaptor.BaseOrderAdaptor.BaseOrderViewHolder> {
    @org.jetbrains.annotations.NotNull()
    private static final androidx.recyclerview.widget.DiffUtil.ItemCallback<com.example.grocerlypartners.model.Order> DiffCallback = null;
    @org.jetbrains.annotations.NotNull()
    public static final com.example.grocerlypartners.adaptor.BaseOrderAdaptor.Companion Companion = null;
    
    public BaseOrderAdaptor() {
        super(null);
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    com.example.grocerlypartners.adaptor.BaseOrderAdaptor.BaseOrderViewHolder holder, int position) {
    }
    
    @kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&\u00a8\u0006\n"}, d2 = {"Lcom/example/grocerlypartners/adaptor/BaseOrderAdaptor$BaseOrderViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "bind", "", "order", "Lcom/example/grocerlypartners/model/Order;", "app_debug"})
    public static abstract class BaseOrderViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        
        public BaseOrderViewHolder(@org.jetbrains.annotations.NotNull()
        android.view.View itemView) {
            super(null);
        }
        
        public abstract void bind(@org.jetbrains.annotations.NotNull()
        com.example.grocerlypartners.model.Order order);
    }
    
    @kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\t"}, d2 = {"Lcom/example/grocerlypartners/adaptor/BaseOrderAdaptor$Companion;", "", "<init>", "()V", "DiffCallback", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lcom/example/grocerlypartners/model/Order;", "getDiffCallback", "()Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final androidx.recyclerview.widget.DiffUtil.ItemCallback<com.example.grocerlypartners.model.Order> getDiffCallback() {
            return null;
        }
    }
}