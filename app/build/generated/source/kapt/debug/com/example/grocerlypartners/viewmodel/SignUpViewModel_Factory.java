package com.example.grocerlypartners.viewmodel;

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
public final class SignUpViewModel_Factory implements Factory<SignUpViewModel> {
  private final Provider<FirebaseAuth> authProvider;

  private final Provider<FirebaseFirestore> dbProvider;

  private SignUpViewModel_Factory(Provider<FirebaseAuth> authProvider,
      Provider<FirebaseFirestore> dbProvider) {
    this.authProvider = authProvider;
    this.dbProvider = dbProvider;
  }

  @Override
  public SignUpViewModel get() {
    return newInstance(authProvider.get(), dbProvider.get());
  }

  public static SignUpViewModel_Factory create(Provider<FirebaseAuth> authProvider,
      Provider<FirebaseFirestore> dbProvider) {
    return new SignUpViewModel_Factory(authProvider, dbProvider);
  }

  public static SignUpViewModel newInstance(FirebaseAuth auth, FirebaseFirestore db) {
    return new SignUpViewModel(auth, db);
  }
}
