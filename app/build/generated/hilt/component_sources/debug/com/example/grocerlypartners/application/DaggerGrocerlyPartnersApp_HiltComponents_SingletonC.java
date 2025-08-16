package com.example.grocerlypartners.application;

import android.app.Activity;
import android.app.Service;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;
import com.example.grocerlypartners.activity.MainActivity;
import com.example.grocerlypartners.di.DataStore_ProvideDataStoreFactory;
import com.example.grocerlypartners.di.FirebaseModule_ProvideAuthFactory;
import com.example.grocerlypartners.di.FirebaseModule_ProvideFireStoreFactory;
import com.example.grocerlypartners.di.FirebaseModule_ProvideFirebaseStorageFactory;
import com.example.grocerlypartners.fragments.AddOffer;
import com.example.grocerlypartners.fragments.AddOffer_MembersInjector;
import com.example.grocerlypartners.fragments.AddProduct;
import com.example.grocerlypartners.fragments.AddProduct_MembersInjector;
import com.example.grocerlypartners.fragments.Home;
import com.example.grocerlypartners.fragments.Login;
import com.example.grocerlypartners.fragments.Offers;
import com.example.grocerlypartners.fragments.Pending;
import com.example.grocerlypartners.fragments.Settings;
import com.example.grocerlypartners.fragments.SignUp;
import com.example.grocerlypartners.fragments.Splash;
import com.example.grocerlypartners.fragments.Splash_MembersInjector;
import com.example.grocerlypartners.fragments.UpdateOffer;
import com.example.grocerlypartners.fragments.UpdateOffer_MembersInjector;
import com.example.grocerlypartners.fragments.UpdateProduct;
import com.example.grocerlypartners.preferences.GrocerlyDataStore;
import com.example.grocerlypartners.repository.AddOfferRepoImpl;
import com.example.grocerlypartners.repository.AddProductRepoImpl;
import com.example.grocerlypartners.repository.HomeRepoImpl;
import com.example.grocerlypartners.repository.OfferRepoImpl;
import com.example.grocerlypartners.repository.OrdersRepoImpl;
import com.example.grocerlypartners.repository.SettingsRepoImpl;
import com.example.grocerlypartners.repository.UpdateOfferRepoImpl;
import com.example.grocerlypartners.repository.UpdateProductRepoImpl;
import com.example.grocerlypartners.viewmodel.AddOfferViewModel;
import com.example.grocerlypartners.viewmodel.AddOfferViewModel_HiltModules;
import com.example.grocerlypartners.viewmodel.AddOfferViewModel_HiltModules_BindsModule_Binds_LazyMapKey;
import com.example.grocerlypartners.viewmodel.AddOfferViewModel_HiltModules_KeyModule_Provide_LazyMapKey;
import com.example.grocerlypartners.viewmodel.AddProductViewModel;
import com.example.grocerlypartners.viewmodel.AddProductViewModel_HiltModules;
import com.example.grocerlypartners.viewmodel.AddProductViewModel_HiltModules_BindsModule_Binds_LazyMapKey;
import com.example.grocerlypartners.viewmodel.AddProductViewModel_HiltModules_KeyModule_Provide_LazyMapKey;
import com.example.grocerlypartners.viewmodel.GraphViewModel;
import com.example.grocerlypartners.viewmodel.GraphViewModel_HiltModules;
import com.example.grocerlypartners.viewmodel.GraphViewModel_HiltModules_BindsModule_Binds_LazyMapKey;
import com.example.grocerlypartners.viewmodel.GraphViewModel_HiltModules_KeyModule_Provide_LazyMapKey;
import com.example.grocerlypartners.viewmodel.HomeViewModel;
import com.example.grocerlypartners.viewmodel.HomeViewModel_HiltModules;
import com.example.grocerlypartners.viewmodel.HomeViewModel_HiltModules_BindsModule_Binds_LazyMapKey;
import com.example.grocerlypartners.viewmodel.HomeViewModel_HiltModules_KeyModule_Provide_LazyMapKey;
import com.example.grocerlypartners.viewmodel.LoginViewModel;
import com.example.grocerlypartners.viewmodel.LoginViewModel_HiltModules;
import com.example.grocerlypartners.viewmodel.LoginViewModel_HiltModules_BindsModule_Binds_LazyMapKey;
import com.example.grocerlypartners.viewmodel.LoginViewModel_HiltModules_KeyModule_Provide_LazyMapKey;
import com.example.grocerlypartners.viewmodel.OfferViewModel;
import com.example.grocerlypartners.viewmodel.OfferViewModel_HiltModules;
import com.example.grocerlypartners.viewmodel.OfferViewModel_HiltModules_BindsModule_Binds_LazyMapKey;
import com.example.grocerlypartners.viewmodel.OfferViewModel_HiltModules_KeyModule_Provide_LazyMapKey;
import com.example.grocerlypartners.viewmodel.OrdersSharedViewModel;
import com.example.grocerlypartners.viewmodel.OrdersSharedViewModel_HiltModules;
import com.example.grocerlypartners.viewmodel.OrdersSharedViewModel_HiltModules_BindsModule_Binds_LazyMapKey;
import com.example.grocerlypartners.viewmodel.OrdersSharedViewModel_HiltModules_KeyModule_Provide_LazyMapKey;
import com.example.grocerlypartners.viewmodel.SettingsViewModel;
import com.example.grocerlypartners.viewmodel.SettingsViewModel_HiltModules;
import com.example.grocerlypartners.viewmodel.SettingsViewModel_HiltModules_BindsModule_Binds_LazyMapKey;
import com.example.grocerlypartners.viewmodel.SettingsViewModel_HiltModules_KeyModule_Provide_LazyMapKey;
import com.example.grocerlypartners.viewmodel.SignUpViewModel;
import com.example.grocerlypartners.viewmodel.SignUpViewModel_HiltModules;
import com.example.grocerlypartners.viewmodel.SignUpViewModel_HiltModules_BindsModule_Binds_LazyMapKey;
import com.example.grocerlypartners.viewmodel.SignUpViewModel_HiltModules_KeyModule_Provide_LazyMapKey;
import com.example.grocerlypartners.viewmodel.UpdateOfferViewModel;
import com.example.grocerlypartners.viewmodel.UpdateOfferViewModel_HiltModules;
import com.example.grocerlypartners.viewmodel.UpdateOfferViewModel_HiltModules_BindsModule_Binds_LazyMapKey;
import com.example.grocerlypartners.viewmodel.UpdateOfferViewModel_HiltModules_KeyModule_Provide_LazyMapKey;
import com.example.grocerlypartners.viewmodel.UpdateProductViewModel;
import com.example.grocerlypartners.viewmodel.UpdateProductViewModel_HiltModules;
import com.example.grocerlypartners.viewmodel.UpdateProductViewModel_HiltModules_BindsModule_Binds_LazyMapKey;
import com.example.grocerlypartners.viewmodel.UpdateProductViewModel_HiltModules_KeyModule_Provide_LazyMapKey;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;
import dagger.hilt.android.ActivityRetainedLifecycle;
import dagger.hilt.android.ViewModelLifecycle;
import dagger.hilt.android.internal.builders.ActivityComponentBuilder;
import dagger.hilt.android.internal.builders.ActivityRetainedComponentBuilder;
import dagger.hilt.android.internal.builders.FragmentComponentBuilder;
import dagger.hilt.android.internal.builders.ServiceComponentBuilder;
import dagger.hilt.android.internal.builders.ViewComponentBuilder;
import dagger.hilt.android.internal.builders.ViewModelComponentBuilder;
import dagger.hilt.android.internal.builders.ViewWithFragmentComponentBuilder;
import dagger.hilt.android.internal.lifecycle.DefaultViewModelFactories;
import dagger.hilt.android.internal.lifecycle.DefaultViewModelFactories_InternalFactoryFactory_Factory;
import dagger.hilt.android.internal.managers.ActivityRetainedComponentManager_LifecycleModule_ProvideActivityRetainedLifecycleFactory;
import dagger.hilt.android.internal.managers.SavedStateHandleHolder;
import dagger.hilt.android.internal.modules.ApplicationContextModule;
import dagger.hilt.android.internal.modules.ApplicationContextModule_ProvideApplicationFactory;
import dagger.hilt.android.internal.modules.ApplicationContextModule_ProvideContextFactory;
import dagger.internal.DaggerGenerated;
import dagger.internal.DoubleCheck;
import dagger.internal.LazyClassKeyMap;
import dagger.internal.Preconditions;
import dagger.internal.Provider;
import java.util.Map;
import java.util.Set;
import javax.annotation.processing.Generated;

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
public final class DaggerGrocerlyPartnersApp_HiltComponents_SingletonC {
  private DaggerGrocerlyPartnersApp_HiltComponents_SingletonC() {
  }

  public static Builder builder() {
    return new Builder();
  }

  public static final class Builder {
    private ApplicationContextModule applicationContextModule;

    private Builder() {
    }

    public Builder applicationContextModule(ApplicationContextModule applicationContextModule) {
      this.applicationContextModule = Preconditions.checkNotNull(applicationContextModule);
      return this;
    }

    public GrocerlyPartnersApp_HiltComponents.SingletonC build() {
      Preconditions.checkBuilderRequirement(applicationContextModule, ApplicationContextModule.class);
      return new SingletonCImpl(applicationContextModule);
    }
  }

  private static final class ActivityRetainedCBuilder implements GrocerlyPartnersApp_HiltComponents.ActivityRetainedC.Builder {
    private final SingletonCImpl singletonCImpl;

    private SavedStateHandleHolder savedStateHandleHolder;

    private ActivityRetainedCBuilder(SingletonCImpl singletonCImpl) {
      this.singletonCImpl = singletonCImpl;
    }

    @Override
    public ActivityRetainedCBuilder savedStateHandleHolder(
        SavedStateHandleHolder savedStateHandleHolder) {
      this.savedStateHandleHolder = Preconditions.checkNotNull(savedStateHandleHolder);
      return this;
    }

    @Override
    public GrocerlyPartnersApp_HiltComponents.ActivityRetainedC build() {
      Preconditions.checkBuilderRequirement(savedStateHandleHolder, SavedStateHandleHolder.class);
      return new ActivityRetainedCImpl(singletonCImpl, savedStateHandleHolder);
    }
  }

  private static final class ActivityCBuilder implements GrocerlyPartnersApp_HiltComponents.ActivityC.Builder {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private Activity activity;

    private ActivityCBuilder(SingletonCImpl singletonCImpl,
        ActivityRetainedCImpl activityRetainedCImpl) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
    }

    @Override
    public ActivityCBuilder activity(Activity activity) {
      this.activity = Preconditions.checkNotNull(activity);
      return this;
    }

    @Override
    public GrocerlyPartnersApp_HiltComponents.ActivityC build() {
      Preconditions.checkBuilderRequirement(activity, Activity.class);
      return new ActivityCImpl(singletonCImpl, activityRetainedCImpl, activity);
    }
  }

  private static final class FragmentCBuilder implements GrocerlyPartnersApp_HiltComponents.FragmentC.Builder {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ActivityCImpl activityCImpl;

    private Fragment fragment;

    private FragmentCBuilder(SingletonCImpl singletonCImpl,
        ActivityRetainedCImpl activityRetainedCImpl, ActivityCImpl activityCImpl) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
      this.activityCImpl = activityCImpl;
    }

    @Override
    public FragmentCBuilder fragment(Fragment fragment) {
      this.fragment = Preconditions.checkNotNull(fragment);
      return this;
    }

    @Override
    public GrocerlyPartnersApp_HiltComponents.FragmentC build() {
      Preconditions.checkBuilderRequirement(fragment, Fragment.class);
      return new FragmentCImpl(singletonCImpl, activityRetainedCImpl, activityCImpl, fragment);
    }
  }

  private static final class ViewWithFragmentCBuilder implements GrocerlyPartnersApp_HiltComponents.ViewWithFragmentC.Builder {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ActivityCImpl activityCImpl;

    private final FragmentCImpl fragmentCImpl;

    private View view;

    private ViewWithFragmentCBuilder(SingletonCImpl singletonCImpl,
        ActivityRetainedCImpl activityRetainedCImpl, ActivityCImpl activityCImpl,
        FragmentCImpl fragmentCImpl) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
      this.activityCImpl = activityCImpl;
      this.fragmentCImpl = fragmentCImpl;
    }

    @Override
    public ViewWithFragmentCBuilder view(View view) {
      this.view = Preconditions.checkNotNull(view);
      return this;
    }

    @Override
    public GrocerlyPartnersApp_HiltComponents.ViewWithFragmentC build() {
      Preconditions.checkBuilderRequirement(view, View.class);
      return new ViewWithFragmentCImpl(singletonCImpl, activityRetainedCImpl, activityCImpl, fragmentCImpl, view);
    }
  }

  private static final class ViewCBuilder implements GrocerlyPartnersApp_HiltComponents.ViewC.Builder {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ActivityCImpl activityCImpl;

    private View view;

    private ViewCBuilder(SingletonCImpl singletonCImpl, ActivityRetainedCImpl activityRetainedCImpl,
        ActivityCImpl activityCImpl) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
      this.activityCImpl = activityCImpl;
    }

    @Override
    public ViewCBuilder view(View view) {
      this.view = Preconditions.checkNotNull(view);
      return this;
    }

    @Override
    public GrocerlyPartnersApp_HiltComponents.ViewC build() {
      Preconditions.checkBuilderRequirement(view, View.class);
      return new ViewCImpl(singletonCImpl, activityRetainedCImpl, activityCImpl, view);
    }
  }

  private static final class ViewModelCBuilder implements GrocerlyPartnersApp_HiltComponents.ViewModelC.Builder {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private SavedStateHandle savedStateHandle;

    private ViewModelLifecycle viewModelLifecycle;

    private ViewModelCBuilder(SingletonCImpl singletonCImpl,
        ActivityRetainedCImpl activityRetainedCImpl) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
    }

    @Override
    public ViewModelCBuilder savedStateHandle(SavedStateHandle handle) {
      this.savedStateHandle = Preconditions.checkNotNull(handle);
      return this;
    }

    @Override
    public ViewModelCBuilder viewModelLifecycle(ViewModelLifecycle viewModelLifecycle) {
      this.viewModelLifecycle = Preconditions.checkNotNull(viewModelLifecycle);
      return this;
    }

    @Override
    public GrocerlyPartnersApp_HiltComponents.ViewModelC build() {
      Preconditions.checkBuilderRequirement(savedStateHandle, SavedStateHandle.class);
      Preconditions.checkBuilderRequirement(viewModelLifecycle, ViewModelLifecycle.class);
      return new ViewModelCImpl(singletonCImpl, activityRetainedCImpl, savedStateHandle, viewModelLifecycle);
    }
  }

  private static final class ServiceCBuilder implements GrocerlyPartnersApp_HiltComponents.ServiceC.Builder {
    private final SingletonCImpl singletonCImpl;

    private Service service;

    private ServiceCBuilder(SingletonCImpl singletonCImpl) {
      this.singletonCImpl = singletonCImpl;
    }

    @Override
    public ServiceCBuilder service(Service service) {
      this.service = Preconditions.checkNotNull(service);
      return this;
    }

    @Override
    public GrocerlyPartnersApp_HiltComponents.ServiceC build() {
      Preconditions.checkBuilderRequirement(service, Service.class);
      return new ServiceCImpl(singletonCImpl, service);
    }
  }

  private static final class ViewWithFragmentCImpl extends GrocerlyPartnersApp_HiltComponents.ViewWithFragmentC {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ActivityCImpl activityCImpl;

    private final FragmentCImpl fragmentCImpl;

    private final ViewWithFragmentCImpl viewWithFragmentCImpl = this;

    ViewWithFragmentCImpl(SingletonCImpl singletonCImpl,
        ActivityRetainedCImpl activityRetainedCImpl, ActivityCImpl activityCImpl,
        FragmentCImpl fragmentCImpl, View viewParam) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
      this.activityCImpl = activityCImpl;
      this.fragmentCImpl = fragmentCImpl;


    }
  }

  private static final class FragmentCImpl extends GrocerlyPartnersApp_HiltComponents.FragmentC {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ActivityCImpl activityCImpl;

    private final FragmentCImpl fragmentCImpl = this;

    FragmentCImpl(SingletonCImpl singletonCImpl, ActivityRetainedCImpl activityRetainedCImpl,
        ActivityCImpl activityCImpl, Fragment fragmentParam) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
      this.activityCImpl = activityCImpl;


    }

    @Override
    public void injectAddOffer(AddOffer arg0) {
      injectAddOffer2(arg0);
    }

    @Override
    public void injectAddProduct(AddProduct arg0) {
      injectAddProduct2(arg0);
    }

    @Override
    public void injectHome(Home arg0) {
    }

    @Override
    public void injectLogin(Login arg0) {
    }

    @Override
    public void injectOffers(Offers arg0) {
    }

    @Override
    public void injectPending(Pending arg0) {
    }

    @Override
    public void injectSettings(Settings arg0) {
    }

    @Override
    public void injectSignUp(SignUp arg0) {
    }

    @Override
    public void injectSplash(Splash arg0) {
      injectSplash2(arg0);
    }

    @Override
    public void injectUpdateOffer(UpdateOffer arg0) {
      injectUpdateOffer2(arg0);
    }

    @Override
    public void injectUpdateProduct(UpdateProduct arg0) {
    }

    @Override
    public DefaultViewModelFactories.InternalFactoryFactory getHiltInternalFactoryFactory() {
      return activityCImpl.getHiltInternalFactoryFactory();
    }

    @Override
    public ViewWithFragmentComponentBuilder viewWithFragmentComponentBuilder() {
      return new ViewWithFragmentCBuilder(singletonCImpl, activityRetainedCImpl, activityCImpl, fragmentCImpl);
    }

    @CanIgnoreReturnValue
    private AddOffer injectAddOffer2(AddOffer instance) {
      AddOffer_MembersInjector.injectDb(instance, singletonCImpl.provideFireStoreProvider.get());
      return instance;
    }

    @CanIgnoreReturnValue
    private AddProduct injectAddProduct2(AddProduct instance2) {
      AddProduct_MembersInjector.injectDb(instance2, singletonCImpl.provideFireStoreProvider.get());
      return instance2;
    }

    @CanIgnoreReturnValue
    private Splash injectSplash2(Splash instance3) {
      Splash_MembersInjector.injectGrocerlyDataStore(instance3, singletonCImpl.provideDataStoreProvider.get());
      return instance3;
    }

    @CanIgnoreReturnValue
    private UpdateOffer injectUpdateOffer2(UpdateOffer instance4) {
      UpdateOffer_MembersInjector.injectDb(instance4, singletonCImpl.provideFireStoreProvider.get());
      return instance4;
    }
  }

  private static final class ViewCImpl extends GrocerlyPartnersApp_HiltComponents.ViewC {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ActivityCImpl activityCImpl;

    private final ViewCImpl viewCImpl = this;

    ViewCImpl(SingletonCImpl singletonCImpl, ActivityRetainedCImpl activityRetainedCImpl,
        ActivityCImpl activityCImpl, View viewParam) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
      this.activityCImpl = activityCImpl;


    }
  }

  private static final class ActivityCImpl extends GrocerlyPartnersApp_HiltComponents.ActivityC {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ActivityCImpl activityCImpl = this;

    ActivityCImpl(SingletonCImpl singletonCImpl, ActivityRetainedCImpl activityRetainedCImpl,
        Activity activityParam) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;


    }

    @Override
    public void injectMainActivity(MainActivity arg0) {
    }

    @Override
    public DefaultViewModelFactories.InternalFactoryFactory getHiltInternalFactoryFactory() {
      return DefaultViewModelFactories_InternalFactoryFactory_Factory.newInstance(getViewModelKeys(), new ViewModelCBuilder(singletonCImpl, activityRetainedCImpl));
    }

    @Override
    public Map<Class<?>, Boolean> getViewModelKeys() {
      return LazyClassKeyMap.<Boolean>of(ImmutableMap.<String, Boolean>builderWithExpectedSize(11).put(AddOfferViewModel_HiltModules_KeyModule_Provide_LazyMapKey.lazyClassKeyName, AddOfferViewModel_HiltModules.KeyModule.provide()).put(AddProductViewModel_HiltModules_KeyModule_Provide_LazyMapKey.lazyClassKeyName, AddProductViewModel_HiltModules.KeyModule.provide()).put(GraphViewModel_HiltModules_KeyModule_Provide_LazyMapKey.lazyClassKeyName, GraphViewModel_HiltModules.KeyModule.provide()).put(HomeViewModel_HiltModules_KeyModule_Provide_LazyMapKey.lazyClassKeyName, HomeViewModel_HiltModules.KeyModule.provide()).put(LoginViewModel_HiltModules_KeyModule_Provide_LazyMapKey.lazyClassKeyName, LoginViewModel_HiltModules.KeyModule.provide()).put(OfferViewModel_HiltModules_KeyModule_Provide_LazyMapKey.lazyClassKeyName, OfferViewModel_HiltModules.KeyModule.provide()).put(OrdersSharedViewModel_HiltModules_KeyModule_Provide_LazyMapKey.lazyClassKeyName, OrdersSharedViewModel_HiltModules.KeyModule.provide()).put(SettingsViewModel_HiltModules_KeyModule_Provide_LazyMapKey.lazyClassKeyName, SettingsViewModel_HiltModules.KeyModule.provide()).put(SignUpViewModel_HiltModules_KeyModule_Provide_LazyMapKey.lazyClassKeyName, SignUpViewModel_HiltModules.KeyModule.provide()).put(UpdateOfferViewModel_HiltModules_KeyModule_Provide_LazyMapKey.lazyClassKeyName, UpdateOfferViewModel_HiltModules.KeyModule.provide()).put(UpdateProductViewModel_HiltModules_KeyModule_Provide_LazyMapKey.lazyClassKeyName, UpdateProductViewModel_HiltModules.KeyModule.provide()).build());
    }

    @Override
    public ViewModelComponentBuilder getViewModelComponentBuilder() {
      return new ViewModelCBuilder(singletonCImpl, activityRetainedCImpl);
    }

    @Override
    public FragmentComponentBuilder fragmentComponentBuilder() {
      return new FragmentCBuilder(singletonCImpl, activityRetainedCImpl, activityCImpl);
    }

    @Override
    public ViewComponentBuilder viewComponentBuilder() {
      return new ViewCBuilder(singletonCImpl, activityRetainedCImpl, activityCImpl);
    }
  }

  private static final class ViewModelCImpl extends GrocerlyPartnersApp_HiltComponents.ViewModelC {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ViewModelCImpl viewModelCImpl = this;

    Provider<AddOfferViewModel> addOfferViewModelProvider;

    Provider<AddProductViewModel> addProductViewModelProvider;

    Provider<GraphViewModel> graphViewModelProvider;

    Provider<HomeViewModel> homeViewModelProvider;

    Provider<LoginViewModel> loginViewModelProvider;

    Provider<OfferViewModel> offerViewModelProvider;

    Provider<OrdersSharedViewModel> ordersSharedViewModelProvider;

    Provider<SettingsViewModel> settingsViewModelProvider;

    Provider<SignUpViewModel> signUpViewModelProvider;

    Provider<UpdateOfferViewModel> updateOfferViewModelProvider;

    Provider<UpdateProductViewModel> updateProductViewModelProvider;

    ViewModelCImpl(SingletonCImpl singletonCImpl, ActivityRetainedCImpl activityRetainedCImpl,
        SavedStateHandle savedStateHandleParam, ViewModelLifecycle viewModelLifecycleParam) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;

      initialize(savedStateHandleParam, viewModelLifecycleParam);

    }

    AddOfferRepoImpl addOfferRepoImpl() {
      return new AddOfferRepoImpl(singletonCImpl.provideFireStoreProvider.get(), singletonCImpl.provideAuthProvider.get());
    }

    AddProductRepoImpl addProductRepoImpl() {
      return new AddProductRepoImpl(singletonCImpl.provideFireStoreProvider.get(), singletonCImpl.provideAuthProvider.get(), singletonCImpl.provideFirebaseStorageProvider.get());
    }

    HomeRepoImpl homeRepoImpl() {
      return new HomeRepoImpl(singletonCImpl.provideFireStoreProvider.get(), singletonCImpl.provideAuthProvider.get());
    }

    OfferRepoImpl offerRepoImpl() {
      return new OfferRepoImpl(singletonCImpl.provideFireStoreProvider.get(), singletonCImpl.provideAuthProvider.get());
    }

    SettingsRepoImpl settingsRepoImpl() {
      return new SettingsRepoImpl(singletonCImpl.provideAuthProvider.get(), singletonCImpl.provideFireStoreProvider.get(), singletonCImpl.provideDataStoreProvider.get());
    }

    UpdateOfferRepoImpl updateOfferRepoImpl() {
      return new UpdateOfferRepoImpl(singletonCImpl.provideFireStoreProvider.get(), singletonCImpl.provideAuthProvider.get());
    }

    @SuppressWarnings("unchecked")
    private void initialize(final SavedStateHandle savedStateHandleParam,
        final ViewModelLifecycle viewModelLifecycleParam) {
      this.addOfferViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 0);
      this.addProductViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 1);
      this.graphViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 2);
      this.homeViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 3);
      this.loginViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 4);
      this.offerViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 5);
      this.ordersSharedViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 6);
      this.settingsViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 7);
      this.signUpViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 8);
      this.updateOfferViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 9);
      this.updateProductViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 10);
    }

    @Override
    public Map<Class<?>, javax.inject.Provider<ViewModel>> getHiltViewModelMap() {
      return LazyClassKeyMap.<javax.inject.Provider<ViewModel>>of(ImmutableMap.<String, javax.inject.Provider<ViewModel>>builderWithExpectedSize(11).put(AddOfferViewModel_HiltModules_BindsModule_Binds_LazyMapKey.lazyClassKeyName, ((Provider) (addOfferViewModelProvider))).put(AddProductViewModel_HiltModules_BindsModule_Binds_LazyMapKey.lazyClassKeyName, ((Provider) (addProductViewModelProvider))).put(GraphViewModel_HiltModules_BindsModule_Binds_LazyMapKey.lazyClassKeyName, ((Provider) (graphViewModelProvider))).put(HomeViewModel_HiltModules_BindsModule_Binds_LazyMapKey.lazyClassKeyName, ((Provider) (homeViewModelProvider))).put(LoginViewModel_HiltModules_BindsModule_Binds_LazyMapKey.lazyClassKeyName, ((Provider) (loginViewModelProvider))).put(OfferViewModel_HiltModules_BindsModule_Binds_LazyMapKey.lazyClassKeyName, ((Provider) (offerViewModelProvider))).put(OrdersSharedViewModel_HiltModules_BindsModule_Binds_LazyMapKey.lazyClassKeyName, ((Provider) (ordersSharedViewModelProvider))).put(SettingsViewModel_HiltModules_BindsModule_Binds_LazyMapKey.lazyClassKeyName, ((Provider) (settingsViewModelProvider))).put(SignUpViewModel_HiltModules_BindsModule_Binds_LazyMapKey.lazyClassKeyName, ((Provider) (signUpViewModelProvider))).put(UpdateOfferViewModel_HiltModules_BindsModule_Binds_LazyMapKey.lazyClassKeyName, ((Provider) (updateOfferViewModelProvider))).put(UpdateProductViewModel_HiltModules_BindsModule_Binds_LazyMapKey.lazyClassKeyName, ((Provider) (updateProductViewModelProvider))).build());
    }

    @Override
    public Map<Class<?>, Object> getHiltViewModelAssistedMap() {
      return ImmutableMap.<Class<?>, Object>of();
    }

    private static final class SwitchingProvider<T> implements Provider<T> {
      private final SingletonCImpl singletonCImpl;

      private final ActivityRetainedCImpl activityRetainedCImpl;

      private final ViewModelCImpl viewModelCImpl;

      private final int id;

      SwitchingProvider(SingletonCImpl singletonCImpl, ActivityRetainedCImpl activityRetainedCImpl,
          ViewModelCImpl viewModelCImpl, int id) {
        this.singletonCImpl = singletonCImpl;
        this.activityRetainedCImpl = activityRetainedCImpl;
        this.viewModelCImpl = viewModelCImpl;
        this.id = id;
      }

      @Override
      @SuppressWarnings("unchecked")
      public T get() {
        switch (id) {
          case 0: // com.example.grocerlypartners.viewmodel.AddOfferViewModel
          return (T) new AddOfferViewModel(ApplicationContextModule_ProvideApplicationFactory.provideApplication(singletonCImpl.applicationContextModule), viewModelCImpl.addOfferRepoImpl());

          case 1: // com.example.grocerlypartners.viewmodel.AddProductViewModel
          return (T) new AddProductViewModel(viewModelCImpl.addProductRepoImpl(), ApplicationContextModule_ProvideApplicationFactory.provideApplication(singletonCImpl.applicationContextModule));

          case 2: // com.example.grocerlypartners.viewmodel.GraphViewModel
          return (T) new GraphViewModel(singletonCImpl.provideAuthProvider.get(), singletonCImpl.provideDataStoreProvider.get());

          case 3: // com.example.grocerlypartners.viewmodel.HomeViewModel
          return (T) new HomeViewModel(viewModelCImpl.homeRepoImpl(), ApplicationContextModule_ProvideApplicationFactory.provideApplication(singletonCImpl.applicationContextModule));

          case 4: // com.example.grocerlypartners.viewmodel.LoginViewModel
          return (T) new LoginViewModel(singletonCImpl.provideAuthProvider.get(), ApplicationContextModule_ProvideApplicationFactory.provideApplication(singletonCImpl.applicationContextModule));

          case 5: // com.example.grocerlypartners.viewmodel.OfferViewModel
          return (T) new OfferViewModel(viewModelCImpl.offerRepoImpl());

          case 6: // com.example.grocerlypartners.viewmodel.OrdersSharedViewModel
          return (T) new OrdersSharedViewModel(activityRetainedCImpl.ordersRepoImplProvider.get(), ApplicationContextModule_ProvideApplicationFactory.provideApplication(singletonCImpl.applicationContextModule));

          case 7: // com.example.grocerlypartners.viewmodel.SettingsViewModel
          return (T) new SettingsViewModel(viewModelCImpl.settingsRepoImpl());

          case 8: // com.example.grocerlypartners.viewmodel.SignUpViewModel
          return (T) new SignUpViewModel(singletonCImpl.provideAuthProvider.get(), singletonCImpl.provideFireStoreProvider.get());

          case 9: // com.example.grocerlypartners.viewmodel.UpdateOfferViewModel
          return (T) new UpdateOfferViewModel(viewModelCImpl.updateOfferRepoImpl());

          case 10: // com.example.grocerlypartners.viewmodel.UpdateProductViewModel
          return (T) new UpdateProductViewModel(activityRetainedCImpl.updateProductRepoImplProvider.get());

          default: throw new AssertionError(id);
        }
      }
    }
  }

  private static final class ActivityRetainedCImpl extends GrocerlyPartnersApp_HiltComponents.ActivityRetainedC {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl = this;

    Provider<ActivityRetainedLifecycle> provideActivityRetainedLifecycleProvider;

    Provider<OrdersRepoImpl> ordersRepoImplProvider;

    Provider<UpdateProductRepoImpl> updateProductRepoImplProvider;

    ActivityRetainedCImpl(SingletonCImpl singletonCImpl,
        SavedStateHandleHolder savedStateHandleHolderParam) {
      this.singletonCImpl = singletonCImpl;

      initialize(savedStateHandleHolderParam);

    }

    @SuppressWarnings("unchecked")
    private void initialize(final SavedStateHandleHolder savedStateHandleHolderParam) {
      this.provideActivityRetainedLifecycleProvider = DoubleCheck.provider(new SwitchingProvider<ActivityRetainedLifecycle>(singletonCImpl, activityRetainedCImpl, 0));
      this.ordersRepoImplProvider = DoubleCheck.provider(new SwitchingProvider<OrdersRepoImpl>(singletonCImpl, activityRetainedCImpl, 1));
      this.updateProductRepoImplProvider = DoubleCheck.provider(new SwitchingProvider<UpdateProductRepoImpl>(singletonCImpl, activityRetainedCImpl, 2));
    }

    @Override
    public ActivityComponentBuilder activityComponentBuilder() {
      return new ActivityCBuilder(singletonCImpl, activityRetainedCImpl);
    }

    @Override
    public ActivityRetainedLifecycle getActivityRetainedLifecycle() {
      return provideActivityRetainedLifecycleProvider.get();
    }

    private static final class SwitchingProvider<T> implements Provider<T> {
      private final SingletonCImpl singletonCImpl;

      private final ActivityRetainedCImpl activityRetainedCImpl;

      private final int id;

      SwitchingProvider(SingletonCImpl singletonCImpl, ActivityRetainedCImpl activityRetainedCImpl,
          int id) {
        this.singletonCImpl = singletonCImpl;
        this.activityRetainedCImpl = activityRetainedCImpl;
        this.id = id;
      }

      @Override
      @SuppressWarnings("unchecked")
      public T get() {
        switch (id) {
          case 0: // dagger.hilt.android.ActivityRetainedLifecycle
          return (T) ActivityRetainedComponentManager_LifecycleModule_ProvideActivityRetainedLifecycleFactory.provideActivityRetainedLifecycle();

          case 1: // com.example.grocerlypartners.repository.OrdersRepoImpl
          return (T) new OrdersRepoImpl(singletonCImpl.provideAuthProvider.get(), singletonCImpl.provideFireStoreProvider.get());

          case 2: // com.example.grocerlypartners.repository.UpdateProductRepoImpl
          return (T) new UpdateProductRepoImpl(singletonCImpl.provideFireStoreProvider.get(), singletonCImpl.provideAuthProvider.get(), singletonCImpl.provideFirebaseStorageProvider.get());

          default: throw new AssertionError(id);
        }
      }
    }
  }

  private static final class ServiceCImpl extends GrocerlyPartnersApp_HiltComponents.ServiceC {
    private final SingletonCImpl singletonCImpl;

    private final ServiceCImpl serviceCImpl = this;

    ServiceCImpl(SingletonCImpl singletonCImpl, Service serviceParam) {
      this.singletonCImpl = singletonCImpl;


    }
  }

  private static final class SingletonCImpl extends GrocerlyPartnersApp_HiltComponents.SingletonC {
    private final ApplicationContextModule applicationContextModule;

    private final SingletonCImpl singletonCImpl = this;

    Provider<FirebaseFirestore> provideFireStoreProvider;

    Provider<GrocerlyDataStore> provideDataStoreProvider;

    Provider<FirebaseAuth> provideAuthProvider;

    Provider<FirebaseStorage> provideFirebaseStorageProvider;

    SingletonCImpl(ApplicationContextModule applicationContextModuleParam) {
      this.applicationContextModule = applicationContextModuleParam;
      initialize(applicationContextModuleParam);

    }

    @SuppressWarnings("unchecked")
    private void initialize(final ApplicationContextModule applicationContextModuleParam) {
      this.provideFireStoreProvider = DoubleCheck.provider(new SwitchingProvider<FirebaseFirestore>(singletonCImpl, 0));
      this.provideDataStoreProvider = DoubleCheck.provider(new SwitchingProvider<GrocerlyDataStore>(singletonCImpl, 1));
      this.provideAuthProvider = DoubleCheck.provider(new SwitchingProvider<FirebaseAuth>(singletonCImpl, 2));
      this.provideFirebaseStorageProvider = DoubleCheck.provider(new SwitchingProvider<FirebaseStorage>(singletonCImpl, 3));
    }

    @Override
    public void injectGrocerlyPartnersApp(GrocerlyPartnersApp grocerlyPartnersApp) {
    }

    @Override
    public Set<Boolean> getDisableFragmentGetContextFix() {
      return ImmutableSet.<Boolean>of();
    }

    @Override
    public ActivityRetainedComponentBuilder retainedComponentBuilder() {
      return new ActivityRetainedCBuilder(singletonCImpl);
    }

    @Override
    public ServiceComponentBuilder serviceComponentBuilder() {
      return new ServiceCBuilder(singletonCImpl);
    }

    private static final class SwitchingProvider<T> implements Provider<T> {
      private final SingletonCImpl singletonCImpl;

      private final int id;

      SwitchingProvider(SingletonCImpl singletonCImpl, int id) {
        this.singletonCImpl = singletonCImpl;
        this.id = id;
      }

      @Override
      @SuppressWarnings("unchecked")
      public T get() {
        switch (id) {
          case 0: // com.google.firebase.firestore.FirebaseFirestore
          return (T) FirebaseModule_ProvideFireStoreFactory.provideFireStore();

          case 1: // com.example.grocerlypartners.preferences.GrocerlyDataStore
          return (T) DataStore_ProvideDataStoreFactory.provideDataStore(ApplicationContextModule_ProvideContextFactory.provideContext(singletonCImpl.applicationContextModule));

          case 2: // com.google.firebase.auth.FirebaseAuth
          return (T) FirebaseModule_ProvideAuthFactory.provideAuth();

          case 3: // com.google.firebase.storage.FirebaseStorage
          return (T) FirebaseModule_ProvideFirebaseStorageFactory.provideFirebaseStorage();

          default: throw new AssertionError(id);
        }
      }
    }
  }
}
