package com.example.grocerlypartners.viewmodel;

import com.example.grocerlypartners.repository.UpdateOfferRepoImpl;
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
public final class UpdateOfferViewModel_Factory implements Factory<UpdateOfferViewModel> {
  private final Provider<UpdateOfferRepoImpl> updateOfferRepoImplProvider;

  private UpdateOfferViewModel_Factory(Provider<UpdateOfferRepoImpl> updateOfferRepoImplProvider) {
    this.updateOfferRepoImplProvider = updateOfferRepoImplProvider;
  }

  @Override
  public UpdateOfferViewModel get() {
    return newInstance(updateOfferRepoImplProvider.get());
  }

  public static UpdateOfferViewModel_Factory create(
      Provider<UpdateOfferRepoImpl> updateOfferRepoImplProvider) {
    return new UpdateOfferViewModel_Factory(updateOfferRepoImplProvider);
  }

  public static UpdateOfferViewModel newInstance(UpdateOfferRepoImpl updateOfferRepoImpl) {
    return new UpdateOfferViewModel(updateOfferRepoImpl);
  }
}
