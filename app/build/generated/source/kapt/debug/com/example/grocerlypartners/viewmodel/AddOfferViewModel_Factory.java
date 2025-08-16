package com.example.grocerlypartners.viewmodel;

import android.app.Application;
import com.example.grocerlypartners.repository.AddOfferRepoImpl;
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
public final class AddOfferViewModel_Factory implements Factory<AddOfferViewModel> {
  private final Provider<Application> applicationProvider;

  private final Provider<AddOfferRepoImpl> addOfferRepoImplProvider;

  private AddOfferViewModel_Factory(Provider<Application> applicationProvider,
      Provider<AddOfferRepoImpl> addOfferRepoImplProvider) {
    this.applicationProvider = applicationProvider;
    this.addOfferRepoImplProvider = addOfferRepoImplProvider;
  }

  @Override
  public AddOfferViewModel get() {
    return newInstance(applicationProvider.get(), addOfferRepoImplProvider.get());
  }

  public static AddOfferViewModel_Factory create(Provider<Application> applicationProvider,
      Provider<AddOfferRepoImpl> addOfferRepoImplProvider) {
    return new AddOfferViewModel_Factory(applicationProvider, addOfferRepoImplProvider);
  }

  public static AddOfferViewModel newInstance(Application application,
      AddOfferRepoImpl addOfferRepoImpl) {
    return new AddOfferViewModel(application, addOfferRepoImpl);
  }
}
