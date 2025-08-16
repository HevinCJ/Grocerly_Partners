package com.example.grocerlypartners.repository;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;
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
public final class AddProductRepoImpl_Factory implements Factory<AddProductRepoImpl> {
  private final Provider<FirebaseFirestore> dbProvider;

  private final Provider<FirebaseAuth> authProvider;

  private final Provider<FirebaseStorage> storageProvider;

  private AddProductRepoImpl_Factory(Provider<FirebaseFirestore> dbProvider,
      Provider<FirebaseAuth> authProvider, Provider<FirebaseStorage> storageProvider) {
    this.dbProvider = dbProvider;
    this.authProvider = authProvider;
    this.storageProvider = storageProvider;
  }

  @Override
  public AddProductRepoImpl get() {
    return newInstance(dbProvider.get(), authProvider.get(), storageProvider.get());
  }

  public static AddProductRepoImpl_Factory create(Provider<FirebaseFirestore> dbProvider,
      Provider<FirebaseAuth> authProvider, Provider<FirebaseStorage> storageProvider) {
    return new AddProductRepoImpl_Factory(dbProvider, authProvider, storageProvider);
  }

  public static AddProductRepoImpl newInstance(FirebaseFirestore db, FirebaseAuth auth,
      FirebaseStorage storage) {
    return new AddProductRepoImpl(db, auth, storage);
  }
}
