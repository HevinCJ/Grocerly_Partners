package com.example.grocerlypartners.repository;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;
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
public final class OrdersRepoImpl_Factory implements Factory<OrdersRepoImpl> {
  private final Provider<FirebaseAuth> authProvider;

  private final Provider<FirebaseFirestore> dbProvider;

  private OrdersRepoImpl_Factory(Provider<FirebaseAuth> authProvider,
      Provider<FirebaseFirestore> dbProvider) {
    this.authProvider = authProvider;
    this.dbProvider = dbProvider;
  }

  @Override
  public OrdersRepoImpl get() {
    return newInstance(authProvider.get(), dbProvider.get());
  }

  public static OrdersRepoImpl_Factory create(Provider<FirebaseAuth> authProvider,
      Provider<FirebaseFirestore> dbProvider) {
    return new OrdersRepoImpl_Factory(authProvider, dbProvider);
  }

  public static OrdersRepoImpl newInstance(FirebaseAuth auth, FirebaseFirestore db) {
    return new OrdersRepoImpl(auth, db);
  }
}
