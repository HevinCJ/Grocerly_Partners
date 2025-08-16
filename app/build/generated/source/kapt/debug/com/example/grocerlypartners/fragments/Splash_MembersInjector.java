package com.example.grocerlypartners.fragments;

import com.example.grocerlypartners.preferences.GrocerlyDataStore;
import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import dagger.internal.Provider;
import dagger.internal.QualifierMetadata;
import javax.annotation.processing.Generated;

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
public final class Splash_MembersInjector implements MembersInjector<Splash> {
  private final Provider<GrocerlyDataStore> grocerlyDataStoreProvider;

  private Splash_MembersInjector(Provider<GrocerlyDataStore> grocerlyDataStoreProvider) {
    this.grocerlyDataStoreProvider = grocerlyDataStoreProvider;
  }

  public static MembersInjector<Splash> create(
      Provider<GrocerlyDataStore> grocerlyDataStoreProvider) {
    return new Splash_MembersInjector(grocerlyDataStoreProvider);
  }

  @Override
  public void injectMembers(Splash instance) {
    injectGrocerlyDataStore(instance, grocerlyDataStoreProvider.get());
  }

  @InjectedFieldSignature("com.example.grocerlypartners.fragments.Splash.grocerlyDataStore")
  public static void injectGrocerlyDataStore(Splash instance, GrocerlyDataStore grocerlyDataStore) {
    instance.grocerlyDataStore = grocerlyDataStore;
  }
}
