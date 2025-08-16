package com.example.grocerlypartners.repository;

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
public final class UpdateOfferRepoImpl_Factory implements Factory<UpdateOfferRepoImpl> {
  private final Provider<FirebaseFirestore> dbProvider;

  private final Provider<FirebaseAuth> authProvider;

  private UpdateOfferRepoImpl_Factory(Provider<FirebaseFirestore> dbProvider,
      Provider<FirebaseAuth> authProvider) {
    this.dbProvider = dbProvider;
    this.authProvider = authProvider;
  }

  @Override
  public UpdateOfferRepoImpl get() {
    return newInstance(dbProvider.get(), authProvider.get());
  }

  public static UpdateOfferRepoImpl_Factory create(Provider<FirebaseFirestore> dbProvider,
      Provider<FirebaseAuth> authProvider) {
    return new UpdateOfferRepoImpl_Factory(dbProvider, authProvider);
  }

  public static UpdateOfferRepoImpl newInstance(FirebaseFirestore db, FirebaseAuth auth) {
    return new UpdateOfferRepoImpl(db, auth);
  }
}
