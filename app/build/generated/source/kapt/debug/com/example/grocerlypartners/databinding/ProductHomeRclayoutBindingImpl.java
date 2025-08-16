package com.example.grocerlypartners.databinding;
import com.example.grocerlypartners.R;
import com.example.grocerlypartners.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ProductHomeRclayoutBindingImpl extends ProductHomeRclayoutBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.txtviewrs, 5);
    }
    // views
    @NonNull
    private final androidx.cardview.widget.CardView mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ProductHomeRclayoutBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 6, sIncludes, sViewsWithIds));
    }
    private ProductHomeRclayoutBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (android.widget.ImageView) bindings[1]
            , (android.widget.TextView) bindings[3]
            , (android.widget.TextView) bindings[4]
            , (android.widget.TextView) bindings[2]
            , (android.widget.ImageView) bindings[5]
            );
        this.imageView.setTag(null);
        this.mboundView0 = (androidx.cardview.widget.CardView) bindings[0];
        this.mboundView0.setTag(null);
        this.textView6.setTag(null);
        this.txtviewcategory.setTag(null);
        this.txtviewproductname.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x2L;
        }
        requestRebind();
    }

    @Override
    public boolean hasPendingBindings() {
        synchronized(this) {
            if (mDirtyFlags != 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean setVariable(int variableId, @Nullable Object variable)  {
        boolean variableSet = true;
        if (BR.product == variableId) {
            setProduct((com.example.grocerlypartners.model.Product) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setProduct(@Nullable com.example.grocerlypartners.model.Product Product) {
        this.mProduct = Product;
        synchronized(this) {
            mDirtyFlags |= 0x1L;
        }
        notifyPropertyChanged(BR.product);
        super.requestRebind();
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
        }
        return false;
    }

    @Override
    protected void executeBindings() {
        long dirtyFlags = 0;
        synchronized(this) {
            dirtyFlags = mDirtyFlags;
            mDirtyFlags = 0;
        }
        java.lang.String productImage = null;
        java.lang.Integer productItemPrice = null;
        java.lang.String productItemName = null;
        int androidxDatabindingViewDataBindingSafeUnboxProductItemPrice = 0;
        com.example.grocerlypartners.utils.ProductCategory productCategory = null;
        java.lang.String stringValueOfProductItemPrice = null;
        com.example.grocerlypartners.model.Product product = mProduct;

        if ((dirtyFlags & 0x3L) != 0) {



                if (product != null) {
                    // read product.image
                    productImage = product.getImage();
                    // read product.itemPrice
                    productItemPrice = product.getItemPrice();
                    // read product.itemName
                    productItemName = product.getItemName();
                    // read product.category
                    productCategory = product.getCategory();
                }


                // read androidx.databinding.ViewDataBinding.safeUnbox(product.itemPrice)
                androidxDatabindingViewDataBindingSafeUnboxProductItemPrice = androidx.databinding.ViewDataBinding.safeUnbox(productItemPrice);


                // read String.valueOf(androidx.databinding.ViewDataBinding.safeUnbox(product.itemPrice))
                stringValueOfProductItemPrice = java.lang.String.valueOf(androidxDatabindingViewDataBindingSafeUnboxProductItemPrice);
        }
        // batch finished
        if ((dirtyFlags & 0x3L) != 0) {
            // api target 1

            com.example.grocerlypartners.adaptor.BindingAdaptors.setImageToView(this.imageView, productImage);
            com.example.grocerlypartners.adaptor.BindingAdaptors.ActionToUpdateProduct(this.mboundView0, product);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.textView6, stringValueOfProductItemPrice);
            com.example.grocerlypartners.adaptor.BindingAdaptors.parseCategoryIntoString(this.txtviewcategory, productCategory);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.txtviewproductname, productItemName);
        }
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): product
        flag 1 (0x2L): null
    flag mapping end*/
    //end
}