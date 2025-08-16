package com.example.grocerlypartners.adaptor;

@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001\u0015B\u0007\u00a2\u0006\u0004\b\u0003\u0010\u0004J\u001c\u0010\b\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\fH\u0016J\u001c\u0010\u000e\u001a\u00020\u000f2\n\u0010\u0010\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0011\u001a\u00020\fH\u0016J\u0014\u0010\u0012\u001a\u00020\u000f2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006J\u000e\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\fR\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0016"}, d2 = {"Lcom/example/grocerlypartners/adaptor/HomeAdaptor;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/example/grocerlypartners/adaptor/HomeAdaptor$HomeViewHolder;", "<init>", "()V", "products", "", "Lcom/example/grocerlypartners/model/Product;", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "getItemCount", "onBindViewHolder", "", "holder", "position", "setProduct", "product", "getProduct", "HomeViewHolder", "app_debug"})
public final class HomeAdaptor extends androidx.recyclerview.widget.RecyclerView.Adapter<com.example.grocerlypartners.adaptor.HomeAdaptor.HomeViewHolder> {
    @org.jetbrains.annotations.NotNull()
    private java.util.List<com.example.grocerlypartners.model.Product> products;
    
    public HomeAdaptor() {
        super();
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public com.example.grocerlypartners.adaptor.HomeAdaptor.HomeViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public int getItemCount() {
        return 0;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    com.example.grocerlypartners.adaptor.HomeAdaptor.HomeViewHolder holder, int position) {
    }
    
    public final void setProduct(@org.jetbrains.annotations.NotNull()
    java.util.List<com.example.grocerlypartners.model.Product> product) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.grocerlypartners.model.Product getProduct(int position) {
        return null;
    }
    
    @kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\n"}, d2 = {"Lcom/example/grocerlypartners/adaptor/HomeAdaptor$HomeViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/example/grocerlypartners/databinding/ProductHomeRclayoutBinding;", "<init>", "(Lcom/example/grocerlypartners/adaptor/HomeAdaptor;Lcom/example/grocerlypartners/databinding/ProductHomeRclayoutBinding;)V", "bindProduct", "", "product", "Lcom/example/grocerlypartners/model/Product;", "app_debug"})
    public final class HomeViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull()
        private final com.example.grocerlypartners.databinding.ProductHomeRclayoutBinding binding = null;
        
        public HomeViewHolder(@org.jetbrains.annotations.NotNull()
        com.example.grocerlypartners.databinding.ProductHomeRclayoutBinding binding) {
            super(null);
        }
        
        public final void bindProduct(@org.jetbrains.annotations.NotNull()
        com.example.grocerlypartners.model.Product product) {
        }
    }
}