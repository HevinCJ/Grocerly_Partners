package com.example.grocerlypartners.viewmodel;

import com.example.grocerlypartners.repository.UpdateProductRepoImpl;
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
public final class UpdateProductViewModel_Factory implements Factory<UpdateProductViewModel> {
  private final Provider<UpdateProductRepoImpl> updateProductRepoImplProvider;

  private UpdateProductViewModel_Factory(
      Provider<UpdateProductRepoImpl> updateProductRepoImplProvider) {
    this.updateProductRepoImplProvider = updateProductRepoImplProvider;
  }

  @Override
  public UpdateProductViewModel get() {
    return newInstance(updateProductRepoImplProvider.get());
  }

  public static UpdateProductViewModel_Factory create(
      Provider<UpdateProductRepoImpl> updateProductRepoImplProvider) {
    return new UpdateProductViewModel_Factory(updateProductRepoImplProvider);
  }

  public static UpdateProductViewModel newInstance(UpdateProductRepoImpl updateProductRepoImpl) {
    return new UpdateProductViewModel(updateProductRepoImpl);
  }
}
