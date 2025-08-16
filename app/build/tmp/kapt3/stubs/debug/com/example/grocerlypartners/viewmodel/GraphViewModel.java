package com.example.grocerlypartners.viewmodel;

@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0006\u0010\u000f\u001a\u00020\u0010R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0019\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\f8F\u00a2\u0006\u0006\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u0011"}, d2 = {"Lcom/example/grocerlypartners/viewmodel/GraphViewModel;", "Landroidx/lifecycle/ViewModel;", "auth", "Lcom/google/firebase/auth/FirebaseAuth;", "grocerlyDataStore", "Lcom/example/grocerlypartners/preferences/GrocerlyDataStore;", "<init>", "(Lcom/google/firebase/auth/FirebaseAuth;Lcom/example/grocerlypartners/preferences/GrocerlyDataStore;)V", "_targetGraph", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "targetGraph", "Lkotlinx/coroutines/flow/StateFlow;", "getTargetGraph", "()Lkotlinx/coroutines/flow/StateFlow;", "decideGraph", "", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel()
public final class GraphViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.google.firebase.auth.FirebaseAuth auth = null;
    @org.jetbrains.annotations.NotNull()
    private final com.example.grocerlypartners.preferences.GrocerlyDataStore grocerlyDataStore = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.Integer> _targetGraph = null;
    
    @javax.inject.Inject()
    public GraphViewModel(@org.jetbrains.annotations.NotNull()
    com.google.firebase.auth.FirebaseAuth auth, @org.jetbrains.annotations.NotNull()
    com.example.grocerlypartners.preferences.GrocerlyDataStore grocerlyDataStore) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.lang.Integer> getTargetGraph() {
        return null;
    }
    
    public final void decideGraph() {
    }
}