package com.example.grocerlypartners.adaptor;

@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0007J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\tH\u0002J\u0018\u0010\f\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000bH\u0007J\u0018\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0007\u00a8\u0006\u0013"}, d2 = {"Lcom/example/grocerlypartners/adaptor/BindingAdaptors;", "", "<init>", "()V", "parseCategoryIntoString", "", "view", "Landroid/widget/TextView;", "category", "Lcom/example/grocerlypartners/utils/ProductCategory;", "convertCategoryIntoString", "", "setImageToView", "Landroid/widget/ImageView;", "src", "ActionToUpdateProduct", "Landroidx/cardview/widget/CardView;", "product", "Lcom/example/grocerlypartners/model/Product;", "app_debug"})
public final class BindingAdaptors {
    @org.jetbrains.annotations.NotNull()
    public static final com.example.grocerlypartners.adaptor.BindingAdaptors INSTANCE = null;
    
    private BindingAdaptors() {
        super();
    }
    
    @androidx.databinding.BindingAdapter(value = {"parseCategoryIntoString"})
    @kotlin.jvm.JvmStatic()
    public static final void parseCategoryIntoString(@org.jetbrains.annotations.NotNull()
    android.widget.TextView view, @org.jetbrains.annotations.NotNull()
    com.example.grocerlypartners.utils.ProductCategory category) {
    }
    
    private final java.lang.String convertCategoryIntoString(com.example.grocerlypartners.utils.ProductCategory category) {
        return null;
    }
    
    @androidx.databinding.BindingAdapter(value = {"setImageToView"})
    @kotlin.jvm.JvmStatic()
    public static final void setImageToView(@org.jetbrains.annotations.NotNull()
    android.widget.ImageView view, @org.jetbrains.annotations.NotNull()
    java.lang.String src) {
    }
    
    @androidx.databinding.BindingAdapter(value = {"ActionToUpdateProduct"})
    @kotlin.jvm.JvmStatic()
    public static final void ActionToUpdateProduct(@org.jetbrains.annotations.NotNull()
    androidx.cardview.widget.CardView view, @org.jetbrains.annotations.NotNull()
    com.example.grocerlypartners.model.Product product) {
    }
}