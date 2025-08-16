package com.example.grocerlypartners.viewmodel;

import android.app.Application;
import com.example.grocerlypartners.repository.AddProductRepoImpl;
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
public final class AddProductViewModel_Factory implements Factory<AddProductViewModel> {
  private final Provider<AddProductRepoImpl> addProductRepoImplProvider;

  private final Provider<Application> applicationProvider;

  private AddProductViewModel_Factory(Provider<AddProductRepoImpl> addProductRepoImplProvider,
      Provider<Application> applicationProvider) {
    this.addProductRepoImplProvider = addProductRepoImplProvider;
    this.applicationProvider = applicationProvider;
  }

  @Override
  public AddProductViewModel get() {
    return newInstance(addProductRepoImplProvider.get(), applicationProvider.get());
  }

  public static AddProductViewModel_Factory create(
      Provider<AddProductRepoImpl> addProductRepoImplProvider,
      Provider<Application> applicationProvider) {
    return new AddProductViewModel_Factory(addProductRepoImplProvider, applicationProvider);
  }

  public static AddProductViewModel newInstance(AddProductRepoImpl addProductRepoImpl,
      Application application) {
    return new AddProductViewModel(addProductRepoImpl, application);
  }
}
