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
public final class UpdateOffer_MembersInjector implements MembersInjector<UpdateOffer> {
  private final Provider<FirebaseFirestore> dbProvider;

  private UpdateOffer_MembersInjector(Provider<FirebaseFirestore> dbProvider) {
    this.dbProvider = dbProvider;
  }

  public static MembersInjector<UpdateOffer> create(Provider<FirebaseFirestore> dbProvider) {
    return new UpdateOffer_MembersInjector(dbProvider);
  }

  @Override
  public void injectMembers(UpdateOffer instance) {
    injectDb(instance, dbProvider.get());
  }

  @InjectedFieldSignature("com.example.grocerlypartners.fragments.UpdateOffer.db")
  public static void injectDb(UpdateOffer instance, FirebaseFirestore db) {
    instance.db = db;
  }
}
