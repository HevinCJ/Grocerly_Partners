package com.example.grocerlypartners.viewmodel;

import com.example.grocerlypartners.repository.OfferRepoImpl;
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
public final class OfferViewModel_Factory implements Factory<OfferViewModel> {
  private final Provider<OfferRepoImpl> offerRepoImplProvider;

  private OfferViewModel_Factory(Provider<OfferRepoImpl> offerRepoImplProvider) {
    this.offerRepoImplProvider = offerRepoImplProvider;
  }

  @Override
  public OfferViewModel get() {
    return newInstance(offerRepoImplProvider.get());
  }

  public static OfferViewModel_Factory create(Provider<OfferRepoImpl> offerRepoImplProvider) {
    return new OfferViewModel_Factory(offerRepoImplProvider);
  }

  public static OfferViewModel newInstance(OfferRepoImpl offerRepoImpl) {
    return new OfferViewModel(offerRepoImpl);
  }
}
