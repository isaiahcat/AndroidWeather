package com.weather.isaiahj.androidweather.di.component;

import android.app.Application;
import android.content.Context;
import com.weather.isaiahj.androidweather.WeatherApp;
import com.weather.isaiahj.androidweather.WeatherApp_MembersInjector;
import com.weather.isaiahj.androidweather.data.AppDataManager;
import com.weather.isaiahj.androidweather.data.AppDataManager_Factory;
import com.weather.isaiahj.androidweather.data.DataManager;
import com.weather.isaiahj.androidweather.data.db.AppDbHelper;
import com.weather.isaiahj.androidweather.data.db.AppDbHelper_Factory;
import com.weather.isaiahj.androidweather.data.db.DbHelper;
import com.weather.isaiahj.androidweather.data.db.DbOpenHelper;
import com.weather.isaiahj.androidweather.data.db.DbOpenHelper_Factory;
import com.weather.isaiahj.androidweather.data.network.ApiHeader;
import com.weather.isaiahj.androidweather.data.network.ApiHeader_Factory;
import com.weather.isaiahj.androidweather.data.network.ApiHelper;
import com.weather.isaiahj.androidweather.data.network.ApiParameter;
import com.weather.isaiahj.androidweather.data.network.ApiParameter_Factory;
import com.weather.isaiahj.androidweather.data.network.AppApiHelper;
import com.weather.isaiahj.androidweather.data.network.AppApiHelper_Factory;
import com.weather.isaiahj.androidweather.data.prefs.AppPreferencesHelper;
import com.weather.isaiahj.androidweather.data.prefs.AppPreferencesHelper_Factory;
import com.weather.isaiahj.androidweather.data.prefs.PreferencesHelper;
import com.weather.isaiahj.androidweather.di.module.ApplicationModule;
import com.weather.isaiahj.androidweather.di.module.ApplicationModule_ProvideApiHelperFactory;
import com.weather.isaiahj.androidweather.di.module.ApplicationModule_ProvideApplicationFactory;
import com.weather.isaiahj.androidweather.di.module.ApplicationModule_ProvideCalligraphyDefaultConfigFactory;
import com.weather.isaiahj.androidweather.di.module.ApplicationModule_ProvideContextFactory;
import com.weather.isaiahj.androidweather.di.module.ApplicationModule_ProvideDataManagerFactory;
import com.weather.isaiahj.androidweather.di.module.ApplicationModule_ProvideDatabaseNameFactory;
import com.weather.isaiahj.androidweather.di.module.ApplicationModule_ProvideDbHelperFactory;
import com.weather.isaiahj.androidweather.di.module.ApplicationModule_ProvideIdApiParameterFactory;
import com.weather.isaiahj.androidweather.di.module.ApplicationModule_ProvidePreferenceNameFactory;
import com.weather.isaiahj.androidweather.di.module.ApplicationModule_ProvidePreferencesHelperFactory;
import com.weather.isaiahj.androidweather.di.module.ApplicationModule_ProvidePublicApiHeaderFactory;
import dagger.MembersInjector;
import dagger.internal.DoubleCheck;
import dagger.internal.MembersInjectors;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;
import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class DaggerApplicationComponent implements ApplicationComponent {
  private Provider<Context> provideContextProvider;

  private Provider<String> provideDatabaseNameProvider;

  private Provider<DbOpenHelper> dbOpenHelperProvider;

  private Provider<AppDbHelper> appDbHelperProvider;

  private Provider<DbHelper> provideDbHelperProvider;

  private Provider<String> providePreferenceNameProvider;

  private Provider<AppPreferencesHelper> appPreferencesHelperProvider;

  private Provider<PreferencesHelper> providePreferencesHelperProvider;

  private Provider<ApiHeader.PublicApiHeader> providePublicApiHeaderProvider;

  private Provider<ApiHeader> apiHeaderProvider;

  private Provider<ApiParameter.IdApiParameter> provideIdApiParameterProvider;

  private Provider<ApiParameter> apiParameterProvider;

  private Provider<AppApiHelper> appApiHelperProvider;

  private Provider<ApiHelper> provideApiHelperProvider;

  private Provider<AppDataManager> appDataManagerProvider;

  private Provider<DataManager> provideDataManagerProvider;

  private Provider<CalligraphyConfig> provideCalligraphyDefaultConfigProvider;

  private MembersInjector<WeatherApp> weatherAppMembersInjector;

  private Provider<Application> provideApplicationProvider;

  private DaggerApplicationComponent(Builder builder) {
    assert builder != null;
    initialize(builder);
  }

  public static Builder builder() {
    return new Builder();
  }

  @SuppressWarnings("unchecked")
  private void initialize(final Builder builder) {

    this.provideContextProvider =
        ApplicationModule_ProvideContextFactory.create(builder.applicationModule);

    this.provideDatabaseNameProvider =
        ApplicationModule_ProvideDatabaseNameFactory.create(builder.applicationModule);

    this.dbOpenHelperProvider =
        DoubleCheck.provider(
            DbOpenHelper_Factory.create(
                MembersInjectors.<DbOpenHelper>noOp(),
                provideContextProvider,
                provideDatabaseNameProvider));

    this.appDbHelperProvider =
        DoubleCheck.provider(AppDbHelper_Factory.create(dbOpenHelperProvider));

    this.provideDbHelperProvider =
        DoubleCheck.provider(
            ApplicationModule_ProvideDbHelperFactory.create(
                builder.applicationModule, appDbHelperProvider));

    this.providePreferenceNameProvider =
        ApplicationModule_ProvidePreferenceNameFactory.create(builder.applicationModule);

    this.appPreferencesHelperProvider =
        DoubleCheck.provider(
            AppPreferencesHelper_Factory.create(
                provideContextProvider, providePreferenceNameProvider));

    this.providePreferencesHelperProvider =
        DoubleCheck.provider(
            ApplicationModule_ProvidePreferencesHelperFactory.create(
                builder.applicationModule, appPreferencesHelperProvider));

    this.providePublicApiHeaderProvider =
        DoubleCheck.provider(
            ApplicationModule_ProvidePublicApiHeaderFactory.create(builder.applicationModule));

    this.apiHeaderProvider =
        DoubleCheck.provider(ApiHeader_Factory.create(providePublicApiHeaderProvider));

    this.provideIdApiParameterProvider =
        DoubleCheck.provider(
            ApplicationModule_ProvideIdApiParameterFactory.create(builder.applicationModule));

    this.apiParameterProvider =
        DoubleCheck.provider(ApiParameter_Factory.create(provideIdApiParameterProvider));

    this.appApiHelperProvider =
        DoubleCheck.provider(AppApiHelper_Factory.create(apiHeaderProvider, apiParameterProvider));

    this.provideApiHelperProvider =
        DoubleCheck.provider(
            ApplicationModule_ProvideApiHelperFactory.create(
                builder.applicationModule, appApiHelperProvider));

    this.appDataManagerProvider =
        DoubleCheck.provider(
            AppDataManager_Factory.create(
                provideContextProvider,
                provideDbHelperProvider,
                providePreferencesHelperProvider,
                provideApiHelperProvider));

    this.provideDataManagerProvider =
        DoubleCheck.provider(
            ApplicationModule_ProvideDataManagerFactory.create(
                builder.applicationModule, appDataManagerProvider));

    this.provideCalligraphyDefaultConfigProvider =
        DoubleCheck.provider(
            ApplicationModule_ProvideCalligraphyDefaultConfigFactory.create(
                builder.applicationModule));

    this.weatherAppMembersInjector =
        WeatherApp_MembersInjector.create(
            provideDataManagerProvider, provideCalligraphyDefaultConfigProvider);

    this.provideApplicationProvider =
        ApplicationModule_ProvideApplicationFactory.create(builder.applicationModule);
  }

  @Override
  public void inject(WeatherApp app) {
    weatherAppMembersInjector.injectMembers(app);
  }

  @Override
  public Context context() {
    return provideContextProvider.get();
  }

  @Override
  public Application application() {
    return provideApplicationProvider.get();
  }

  @Override
  public DataManager getDataManager() {
    return provideDataManagerProvider.get();
  }

  public static final class Builder {
    private ApplicationModule applicationModule;

    private Builder() {}

    public ApplicationComponent build() {
      if (applicationModule == null) {
        throw new IllegalStateException(
            ApplicationModule.class.getCanonicalName() + " must be set");
      }
      return new DaggerApplicationComponent(this);
    }

    public Builder applicationModule(ApplicationModule applicationModule) {
      this.applicationModule = Preconditions.checkNotNull(applicationModule);
      return this;
    }
  }
}
