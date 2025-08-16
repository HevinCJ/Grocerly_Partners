package com.example.grocerlypartners.fragments;

@dagger.hilt.android.AndroidEntryPoint()
@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000b\b\u0007\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J$\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010#2\b\u0010$\u001a\u0004\u0018\u00010%H\u0016J\u001a\u0010&\u001a\u00020\'2\u0006\u0010(\u001a\u00020\u001f2\b\u0010$\u001a\u0004\u0018\u00010%H\u0016J\b\u0010)\u001a\u00020\'H\u0002J\u0010\u0010*\u001a\u00020\'2\u0006\u0010+\u001a\u00020\u0016H\u0002J\b\u0010,\u001a\u00020\'H\u0002J\b\u0010-\u001a\u00020\'H\u0002J\b\u0010.\u001a\u00020\'H\u0002J\b\u0010/\u001a\u00020\'H\u0002J\b\u00100\u001a\u00020\'H\u0002J\b\u00101\u001a\u00020\'H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u00058BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\n8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001b\u0010\u000f\u001a\u00020\u00108BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0011\u0010\u0012R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082.\u00a2\u0006\u0002\n\u0000R\u001f\u0010\u0019\u001a\u0010\u0012\f\u0012\n \u001b*\u0004\u0018\u00010\u00160\u00160\u001a\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001d\u00a8\u00062"}, d2 = {"Lcom/example/grocerlypartners/fragments/AddProduct;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "addProduct", "Lcom/example/grocerlypartners/databinding/FragmentAddProductBinding;", "binding", "getBinding", "()Lcom/example/grocerlypartners/databinding/FragmentAddProductBinding;", "db", "Lcom/google/firebase/firestore/FirebaseFirestore;", "getDb", "()Lcom/google/firebase/firestore/FirebaseFirestore;", "setDb", "(Lcom/google/firebase/firestore/FirebaseFirestore;)V", "addProductViewModel", "Lcom/example/grocerlypartners/viewmodel/AddProductViewModel;", "getAddProductViewModel", "()Lcom/example/grocerlypartners/viewmodel/AddProductViewModel;", "addProductViewModel$delegate", "Lkotlin/Lazy;", "selectedImage", "", "loadingDialogue", "Lcom/example/grocerlypartners/utils/LoadingDialogue;", "galleryLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "kotlin.jvm.PlatformType", "getGalleryLauncher", "()Landroidx/activity/result/ActivityResultLauncher;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "observeImageUploadState", "loadPickedImage", "url", "observeProductValidationState", "observeUploadState", "setUpCategoriesSpinner", "uploadDataToFirebase", "getImageFromStorage", "onDestroyView", "app_debug"})
public final class AddProduct extends androidx.fragment.app.Fragment {
    @org.jetbrains.annotations.Nullable()
    private com.example.grocerlypartners.databinding.FragmentAddProductBinding addProduct;
    @javax.inject.Inject()
    public com.google.firebase.firestore.FirebaseFirestore db;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy addProductViewModel$delegate = null;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String selectedImage;
    private com.example.grocerlypartners.utils.LoadingDialogue loadingDialogue;
    @org.jetbrains.annotations.NotNull()
    private final androidx.activity.result.ActivityResultLauncher<java.lang.String> galleryLauncher = null;
    
    public AddProduct() {
        super();
    }
    
    private final com.example.grocerlypartners.databinding.FragmentAddProductBinding getBinding() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.google.firebase.firestore.FirebaseFirestore getDb() {
        return null;
    }
    
    public final void setDb(@org.jetbrains.annotations.NotNull()
    com.google.firebase.firestore.FirebaseFirestore p0) {
    }
    
    private final com.example.grocerlypartners.viewmodel.AddProductViewModel getAddProductViewModel() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.activity.result.ActivityResultLauncher<java.lang.String> getGalleryLauncher() {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
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
    
    private final void observeImageUploadState() {
    }
    
    private final void loadPickedImage(java.lang.String url) {
    }
    
    private final void observeProductValidationState() {
    }
    
    private final void observeUploadState() {
    }
    
    private final void setUpCategoriesSpinner() {
    }
    
    private final void uploadDataToFirebase() {
    }
    
    private final void getImageFromStorage() {
    }
    
    @java.lang.Override()
    public void onDestroyView() {
    }
}