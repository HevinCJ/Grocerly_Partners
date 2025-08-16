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
public final class AddOffer_MembersInjector implements MembersInjector<AddOffer> {
  private final Provider<FirebaseFirestore> dbProvider;

  private AddOffer_MembersInjector(Provider<FirebaseFirestore> dbProvider) {
    this.dbProvider = dbProvider;
  }

  public static MembersInjector<AddOffer> create(Provider<FirebaseFirestore> dbProvider) {
    return new AddOffer_MembersInjector(dbProvider);
  }

  @Override
  public void injectMembers(AddOffer instance) {
    injectDb(instance, dbProvider.get());
  }

  @InjectedFieldSignature("com.example.grocerlypartners.fragments.AddOffer.db")
  public static void injectDb(AddOffer instance, FirebaseFirestore db) {
    instance.db = db;
  }
}
