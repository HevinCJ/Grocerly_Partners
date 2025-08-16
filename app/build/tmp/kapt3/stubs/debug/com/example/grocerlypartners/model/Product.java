package com.example.grocerlypartners.model;

@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b \n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B]\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f\u00a2\u0006\u0004\b\u0010\u0010\u0011B\t\b\u0016\u00a2\u0006\u0004\b\u0010\u0010\u0012J\t\u0010\"\u001a\u00020\u0003H\u00c6\u0003J\t\u0010#\u001a\u00020\u0003H\u00c6\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\t\u0010%\u001a\u00020\u0003H\u00c6\u0003J\u0010\u0010&\u001a\u0004\u0018\u00010\bH\u00c6\u0003\u00a2\u0006\u0002\u0010\u0019J\t\u0010\'\u001a\u00020\nH\u00c6\u0003J\u0010\u0010(\u001a\u0004\u0018\u00010\fH\u00c6\u0003\u00a2\u0006\u0002\u0010\u001eJ\u0010\u0010)\u001a\u0004\u0018\u00010\bH\u00c6\u0003\u00a2\u0006\u0002\u0010\u0019J\t\u0010*\u001a\u00020\u000fH\u00c6\u0003Jp\u0010+\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\u000e\u001a\u00020\u000fH\u00c6\u0001\u00a2\u0006\u0002\u0010,J\u0006\u0010-\u001a\u00020\bJ\u0013\u0010.\u001a\u00020\u000f2\b\u0010/\u001a\u0004\u0018\u000100H\u00d6\u0003J\t\u00101\u001a\u00020\bH\u00d6\u0001J\t\u00102\u001a\u00020\u0003H\u00d6\u0001J\u0016\u00103\u001a\u0002042\u0006\u00105\u001a\u0002062\u0006\u00107\u001a\u00020\bR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0014R\u0011\u0010\u0006\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0014R\u0015\u0010\u0007\u001a\u0004\u0018\u00010\b\u00a2\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\t\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0015\u0010\u000b\u001a\u0004\u0018\u00010\f\u00a2\u0006\n\n\u0002\u0010\u001f\u001a\u0004\b\u001d\u0010\u001eR\u0015\u0010\r\u001a\u0004\u0018\u00010\b\u00a2\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b \u0010\u0019R\u0011\u0010\u000e\u001a\u00020\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010!\u00a8\u00068"}, d2 = {"Lcom/example/grocerlypartners/model/Product;", "Landroid/os/Parcelable;", "productId", "", "partnerId", "image", "itemName", "itemPrice", "", "category", "Lcom/example/grocerlypartners/utils/ProductCategory;", "itemRating", "", "totalRating", "isOrdered", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Lcom/example/grocerlypartners/utils/ProductCategory;Ljava/lang/Double;Ljava/lang/Integer;Z)V", "()V", "getProductId", "()Ljava/lang/String;", "getPartnerId", "getImage", "getItemName", "getItemPrice", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getCategory", "()Lcom/example/grocerlypartners/utils/ProductCategory;", "getItemRating", "()Ljava/lang/Double;", "Ljava/lang/Double;", "getTotalRating", "()Z", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Lcom/example/grocerlypartners/utils/ProductCategory;Ljava/lang/Double;Ljava/lang/Integer;Z)Lcom/example/grocerlypartners/model/Product;", "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "app_debug"})
@kotlinx.parcelize.Parcelize()
public final class Product implements android.os.Parcelable {
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String productId = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String partnerId = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String image = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String itemName = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Integer itemPrice = null;
    @org.jetbrains.annotations.NotNull()
    private final com.example.grocerlypartners.utils.ProductCategory category = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Double itemRating = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Integer totalRating = null;
    private final boolean isOrdered = false;
    
    @java.lang.Override()
    public final int describeContents() {
        return 0;
    }
    
    @java.lang.Override()
    public final void writeToParcel(@org.jetbrains.annotations.NotNull()
    android.os.Parcel dest, int flags) {
    }
    
    public Product(@org.jetbrains.annotations.NotNull()
    java.lang.String productId, @org.jetbrains.annotations.NotNull()
    java.lang.String partnerId, @org.jetbrains.annotations.Nullable()
    java.lang.String image, @org.jetbrains.annotations.NotNull()
    java.lang.String itemName, @org.jetbrains.annotations.Nullable()
    java.lang.Integer itemPrice, @org.jetbrains.annotations.NotNull()
    com.example.grocerlypartners.utils.ProductCategory category, @org.jetbrains.annotations.Nullable()
    java.lang.Double itemRating, @org.jetbrains.annotations.Nullable()
    java.lang.Integer totalRating, boolean isOrdered) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getProductId() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getPartnerId() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getImage() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getItemName() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer getItemPrice() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.grocerlypartners.utils.ProductCategory getCategory() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Double getItemRating() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer getTotalRating() {
        return null;
    }
    
    public final boolean isOrdered() {
        return false;
    }
    
    public Product() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component1() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component2() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component3() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component4() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer component5() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.grocerlypartners.utils.ProductCategory component6() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Double component7() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer component8() {
        return null;
    }
    
    public final boolean component9() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.grocerlypartners.model.Product copy(@org.jetbrains.annotations.NotNull()
    java.lang.String productId, @org.jetbrains.annotations.NotNull()
    java.lang.String partnerId, @org.jetbrains.annotations.Nullable()
    java.lang.String image, @org.jetbrains.annotations.NotNull()
    java.lang.String itemName, @org.jetbrains.annotations.Nullable()
    java.lang.Integer itemPrice, @org.jetbrains.annotations.NotNull()
    com.example.grocerlypartners.utils.ProductCategory category, @org.jetbrains.annotations.Nullable()
    java.lang.Double itemRating, @org.jetbrains.annotations.Nullable()
    java.lang.Integer totalRating, boolean isOrdered) {
        return null;
    }
    
    @java.lang.Override()
    public boolean equals(@org.jetbrains.annotations.Nullable()
    java.lang.Object other) {
        return false;
    }
    
    @java.lang.Override()
    public int hashCode() {
        return 0;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public java.lang.String toString() {
        return null;
    }
}