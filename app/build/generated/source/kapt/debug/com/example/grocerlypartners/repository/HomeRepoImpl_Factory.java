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
public final class HomeRepoImpl_Factory implements Factory<HomeRepoImpl> {
  private final Provider<FirebaseFirestore> dbProvider;

  private final Provider<FirebaseAuth> authProvider;

  private HomeRepoImpl_Factory(Provider<FirebaseFirestore> dbProvider,
      Provider<FirebaseAuth> authProvider) {
    this.dbProvider = dbProvider;
    this.authProvider = authProvider;
  }

  @Override
  public HomeRepoImpl get() {
    return newInstance(dbProvider.get(), authProvider.get());
  }

  public static HomeRepoImpl_Factory create(Provider<FirebaseFirestore> dbProvider,
      Provider<FirebaseAuth> authProvider) {
    return new HomeRepoImpl_Factory(dbProvider, authProvider);
  }

  public static HomeRepoImpl newInstance(FirebaseFirestore db, FirebaseAuth auth) {
    return new HomeRepoImpl(db, auth);
  }
}
