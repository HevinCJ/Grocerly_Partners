package com.example.grocerlypartners.repository;

import com.example.grocerlypartners.preferences.GrocerlyDataStore;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;
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
public final class SettingsRepoImpl_Factory implements Factory<SettingsRepoImpl> {
  private final Provider<FirebaseAuth> authProvider;

  private final Provider<FirebaseFirestore> dbProvider;

  private final Provider<GrocerlyDataStore> grocerlyDataStoreProvider;

  private SettingsRepoImpl_Factory(Provider<FirebaseAuth> authProvider,
      Provider<FirebaseFirestore> dbProvider,
      Provider<GrocerlyDataStore> grocerlyDataStoreProvider) {
    this.authProvider = authProvider;
    this.dbProvider = dbProvider;
    this.grocerlyDataStoreProvider = grocerlyDataStoreProvider;
  }

  @Override
  public SettingsRepoImpl get() {
    return newInstance(authProvider.get(), dbProvider.get(), grocerlyDataStoreProvider.get());
  }

  public static SettingsRepoImpl_Factory create(Provider<FirebaseAuth> authProvider,
      Provider<FirebaseFirestore> dbProvider,
      Provider<GrocerlyDataStore> grocerlyDataStoreProvider) {
    return new SettingsRepoImpl_Factory(authProvider, dbProvider, grocerlyDataStoreProvider);
  }

  public static SettingsRepoImpl newInstance(FirebaseAuth auth, FirebaseFirestore db,
      GrocerlyDataStore grocerlyDataStore) {
    return new SettingsRepoImpl(auth, db, grocerlyDataStore);
  }
}
