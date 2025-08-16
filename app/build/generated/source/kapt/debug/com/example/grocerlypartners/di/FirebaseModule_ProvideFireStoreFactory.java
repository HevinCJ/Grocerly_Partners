package com.example.grocerlypartners.di;

import com.google.firebase.firestore.FirebaseFirestore;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;

@ScopeMetadata("javax.inject.Singleton")
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
public final class FirebaseModule_ProvideFireStoreFactory implements Factory<FirebaseFirestore> {
  @Override
  public FirebaseFirestore get() {
    return provideFireStore();
  }

  public static FirebaseModule_ProvideFireStoreFactory create() {
    return InstanceHolder.INSTANCE;
  }

  public static FirebaseFirestore provideFireStore() {
    return Preconditions.checkNotNullFromProvides(FirebaseModule.INSTANCE.provideFireStore());
  }

  private static final class InstanceHolder {
    static final FirebaseModule_ProvideFireStoreFactory INSTANCE = new FirebaseModule_ProvideFireStoreFactory();
  }
}
