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

@ScopeMetadata("dagger.hilt.android.scopes.ActivityRetainedScoped")
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
public final class UpdateProductRepoImpl_Factory implements Factory<UpdateProductRepoImpl> {
  private final Provider<FirebaseFirestore> dbProvider;

  private final Provider<FirebaseAuth> authProvider;

  private final Provider<FirebaseStorage> storageProvider;

  private UpdateProductRepoImpl_Factory(Provider<FirebaseFirestore> dbProvider,
      Provider<FirebaseAuth> authProvider, Provider<FirebaseStorage> storageProvider) {
    this.dbProvider = dbProvider;
    this.authProvider = authProvider;
    this.storageProvider = storageProvider;
  }

  @Override
  public UpdateProductRepoImpl get() {
    return newInstance(dbProvider.get(), authProvider.get(), storageProvider.get());
  }

  public static UpdateProductRepoImpl_Factory create(Provider<FirebaseFirestore> dbProvider,
      Provider<FirebaseAuth> authProvider, Provider<FirebaseStorage> storageProvider) {
    return new UpdateProductRepoImpl_Factory(dbProvider, authProvider, storageProvider);
  }

  public static UpdateProductRepoImpl newInstance(FirebaseFirestore db, FirebaseAuth auth,
      FirebaseStorage storage) {
    return new UpdateProductRepoImpl(db, auth, storage);
  }
}
