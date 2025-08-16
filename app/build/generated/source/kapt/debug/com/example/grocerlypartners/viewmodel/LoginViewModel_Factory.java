package com.example.grocerlypartners.viewmodel;

import android.app.Application;
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
public final class LoginViewModel_Factory implements Factory<LoginViewModel> {
  private final Provider<FirebaseAuth> authProvider;

  private final Provider<Application> applicationProvider;

  private LoginViewModel_Factory(Provider<FirebaseAuth> authProvider,
      Provider<Application> applicationProvider) {
    this.authProvider = authProvider;
    this.applicationProvider = applicationProvider;
  }

  @Override
  public LoginViewModel get() {
    return newInstance(authProvider.get(), applicationProvider.get());
  }

  public static LoginViewModel_Factory create(Provider<FirebaseAuth> authProvider,
      Provider<Application> applicationProvider) {
    return new LoginViewModel_Factory(authProvider, applicationProvider);
  }

  public static LoginViewModel newInstance(FirebaseAuth auth, Application application) {
    return new LoginViewModel(auth, application);
  }
}
