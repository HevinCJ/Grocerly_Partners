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
public final class OfferRepoImpl_Factory implements Factory<OfferRepoImpl> {
  private final Provider<FirebaseFirestore> dbProvider;

  private final Provider<FirebaseAuth> authProvider;

  private OfferRepoImpl_Factory(Provider<FirebaseFirestore> dbProvider,
      Provider<FirebaseAuth> authProvider) {
    this.dbProvider = dbProvider;
    this.authProvider = authProvider;
  }

  @Override
  public OfferRepoImpl get() {
    return newInstance(dbProvider.get(), authProvider.get());
  }

  public static OfferRepoImpl_Factory create(Provider<FirebaseFirestore> dbProvider,
      Provider<FirebaseAuth> authProvider) {
    return new OfferRepoImpl_Factory(dbProvider, authProvider);
  }

  public static OfferRepoImpl newInstance(FirebaseFirestore db, FirebaseAuth auth) {
    return new OfferRepoImpl(db, auth);
  }
}
