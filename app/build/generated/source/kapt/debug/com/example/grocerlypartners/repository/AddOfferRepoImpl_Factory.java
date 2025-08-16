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
public final class AddOfferRepoImpl_Factory implements Factory<AddOfferRepoImpl> {
  private final Provider<FirebaseFirestore> dbProvider;

  private final Provider<FirebaseAuth> authProvider;

  private AddOfferRepoImpl_Factory(Provider<FirebaseFirestore> dbProvider,
      Provider<FirebaseAuth> authProvider) {
    this.dbProvider = dbProvider;
    this.authProvider = authProvider;
  }

  @Override
  public AddOfferRepoImpl get() {
    return newInstance(dbProvider.get(), authProvider.get());
  }

  public static AddOfferRepoImpl_Factory create(Provider<FirebaseFirestore> dbProvider,
      Provider<FirebaseAuth> authProvider) {
    return new AddOfferRepoImpl_Factory(dbProvider, authProvider);
  }

  public static AddOfferRepoImpl newInstance(FirebaseFirestore db, FirebaseAuth auth) {
    return new AddOfferRepoImpl(db, auth);
  }
}
