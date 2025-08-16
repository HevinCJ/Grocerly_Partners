package com.example.grocerlypartners.viewmodel;

import android.app.Application;
import com.example.grocerlypartners.repository.OrdersRepoImpl;
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
public final class OrdersSharedViewModel_Factory implements Factory<OrdersSharedViewModel> {
  private final Provider<OrdersRepoImpl> ordersRepoImplProvider;

  private final Provider<Application> applicationProvider;

  private OrdersSharedViewModel_Factory(Provider<OrdersRepoImpl> ordersRepoImplProvider,
      Provider<Application> applicationProvider) {
    this.ordersRepoImplProvider = ordersRepoImplProvider;
    this.applicationProvider = applicationProvider;
  }

  @Override
  public OrdersSharedViewModel get() {
    return newInstance(ordersRepoImplProvider.get(), applicationProvider.get());
  }

  public static OrdersSharedViewModel_Factory create(
      Provider<OrdersRepoImpl> ordersRepoImplProvider, Provider<Application> applicationProvider) {
    return new OrdersSharedViewModel_Factory(ordersRepoImplProvider, applicationProvider);
  }

  public static OrdersSharedViewModel newInstance(OrdersRepoImpl ordersRepoImpl,
      Application application) {
    return new OrdersSharedViewModel(ordersRepoImpl, application);
  }
}
