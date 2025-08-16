package com.example.grocerlypartners.fragments;

import com.google.firebase.firestore.FirebaseFirestore;
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
public final class AddProduct_MembersInjector implements MembersInjector<AddProduct> {
  private final Provider<FirebaseFirestore> dbProvider;

  private AddProduct_MembersInjector(Provider<FirebaseFirestore> dbProvider) {
    this.dbProvider = dbProvider;
  }

  public static MembersInjector<AddProduct> create(Provider<FirebaseFirestore> dbProvider) {
    return new AddProduct_MembersInjector(dbProvider);
  }

  @Override
  public void injectMembers(AddProduct instance) {
    injectDb(instance, dbProvider.get());
  }

  @InjectedFieldSignature("com.example.grocerlypartners.fragments.AddProduct.db")
  public static void injectDb(AddProduct instance, FirebaseFirestore db) {
    instance.db = db;
  }
}
