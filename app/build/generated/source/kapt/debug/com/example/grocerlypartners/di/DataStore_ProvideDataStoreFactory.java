package com.example.grocerlypartners.di;

import android.content.Context;
import com.example.grocerlypartners.preferences.GrocerlyDataStore;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.Provider;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;

@ScopeMetadata("javax.inject.Singleton")
@QualifierMetadata("dagger.hilt.android.qualifiers.ApplicationContext")
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
public final class DataStore_ProvideDataStoreFactory implements Factory<GrocerlyDataStore> {
  private final Provider<Context> contextProvider;

  private DataStore_ProvideDataStoreFactory(Provider<Context> contextProvider) {
    this.contextProvider = contextProvider;
  }

  @Override
  public GrocerlyDataStore get() {
    return provideDataStore(contextProvider.get());
  }

  public static DataStore_ProvideDataStoreFactory create(Provider<Context> contextProvider) {
    return new DataStore_ProvideDataStoreFactory(contextProvider);
  }

  public static GrocerlyDataStore provideDataStore(Context context) {
    return Preconditions.checkNotNullFromProvides(DataStore.INSTANCE.provideDataStore(context));
  }
}
