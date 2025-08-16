package com.example.grocerlypartners.viewmodel;

import com.example.grocerlypartners.preferences.GrocerlyDataStore;
import com.google.firebase.auth.FirebaseAuth;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Provider;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;

@ScopeMetadata
@QualifierMetadata
@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes",
    "KotlinInternal",
    "KotlinInternalInJava",
    "cast",
    "deprecation",
    "nullness:initialization.field.uninitialized"
})
public final class GraphViewModel_Factory implements Factory<GraphViewModel> {
  private final Provider<FirebaseAuth> authProvider;

  private final Provider<GrocerlyDataStore> grocerlyDataStoreProvider;

  private GraphViewModel_Factory(Provider<FirebaseAuth> authProvider,
      Provider<GrocerlyDataStore> grocerlyDataStoreProvider) {
    this.authProvider = authProvider;
    this.grocerlyDataStoreProvider = grocerlyDataStoreProvider;
  }

  @Override
  public GraphViewModel get() {
    return newInstance(authProvider.get(), grocerlyDataStoreProvider.get());
  }

  public static GraphViewModel_Factory create(Provider<FirebaseAuth> authProvider,
      Provider<GrocerlyDataStore> grocerlyDataStoreProvider) {
    return new GraphViewModel_Factory(authProvider, grocerlyDataStoreProvider);
  }

  public static GraphViewModel newInstance(FirebaseAuth auth, GrocerlyDataStore grocerlyDataStore) {
    return new GraphViewModel(auth, grocerlyDataStore);
  }
}
