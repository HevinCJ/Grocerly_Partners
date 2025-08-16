package com.example.grocerlypartners.viewmodel;

import android.app.Application;
import com.example.grocerlypartners.repository.HomeRepoImpl;
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
public final class HomeViewModel_Factory implements Factory<HomeViewModel> {
  private final Provider<HomeRepoImpl> homeRepoImplProvider;

  private final Provider<Application> applicationProvider;

  private HomeViewModel_Factory(Provider<HomeRepoImpl> homeRepoImplProvider,
      Provider<Application> applicationProvider) {
    this.homeRepoImplProvider = homeRepoImplProvider;
    this.applicationProvider = applicationProvider;
  }

  @Override
  public HomeViewModel get() {
    return newInstance(homeRepoImplProvider.get(), applicationProvider.get());
  }

  public static HomeViewModel_Factory create(Provider<HomeRepoImpl> homeRepoImplProvider,
      Provider<Application> applicationProvider) {
    return new HomeViewModel_Factory(homeRepoImplProvider, applicationProvider);
  }

  public static HomeViewModel newInstance(HomeRepoImpl homeRepoImpl, Application application) {
    return new HomeViewModel(homeRepoImpl, application);
  }
}
