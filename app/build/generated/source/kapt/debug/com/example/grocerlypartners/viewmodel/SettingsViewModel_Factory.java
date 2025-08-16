package com.example.grocerlypartners.viewmodel;

import com.example.grocerlypartners.repository.SettingsRepoImpl;
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
public final class SettingsViewModel_Factory implements Factory<SettingsViewModel> {
  private final Provider<SettingsRepoImpl> settingsRepoImplProvider;

  private SettingsViewModel_Factory(Provider<SettingsRepoImpl> settingsRepoImplProvider) {
    this.settingsRepoImplProvider = settingsRepoImplProvider;
  }

  @Override
  public SettingsViewModel get() {
    return newInstance(settingsRepoImplProvider.get());
  }

  public static SettingsViewModel_Factory create(
      Provider<SettingsRepoImpl> settingsRepoImplProvider) {
    return new SettingsViewModel_Factory(settingsRepoImplProvider);
  }

  public static SettingsViewModel newInstance(SettingsRepoImpl settingsRepoImpl) {
    return new SettingsViewModel(settingsRepoImpl);
  }
}
