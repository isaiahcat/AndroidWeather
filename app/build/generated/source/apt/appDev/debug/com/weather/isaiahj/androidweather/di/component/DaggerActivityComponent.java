package com.weather.isaiahj.androidweather.di.component;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import com.weather.isaiahj.androidweather.data.DataManager;
import com.weather.isaiahj.androidweather.di.module.ActivityModule;
import com.weather.isaiahj.androidweather.di.module.ActivityModule_ProvideAboutPresenterFactory;
import com.weather.isaiahj.androidweather.di.module.ActivityModule_ProvideActivityFactory;
import com.weather.isaiahj.androidweather.di.module.ActivityModule_ProvideCompositeDisposableFactory;
import com.weather.isaiahj.androidweather.di.module.ActivityModule_ProvideFeedPresenterFactory;
import com.weather.isaiahj.androidweather.di.module.ActivityModule_ProvideLinearLayoutManagerFactory;
import com.weather.isaiahj.androidweather.di.module.ActivityModule_ProvideMainPresenterFactory;
import com.weather.isaiahj.androidweather.di.module.ActivityModule_ProvideSchedulerProviderFactory;
import com.weather.isaiahj.androidweather.di.module.ActivityModule_ProvideSplashPresenterFactory;
import com.weather.isaiahj.androidweather.di.module.ActivityModule_ProvideWeatherListAdapterFactory;
import com.weather.isaiahj.androidweather.di.module.ActivityModule_ProvideWeatherListMvpPresenterFactory;
import com.weather.isaiahj.androidweather.ui.about.AboutFragment;
import com.weather.isaiahj.androidweather.ui.about.AboutFragment_MembersInjector;
import com.weather.isaiahj.androidweather.ui.about.AboutMvpPresenter;
import com.weather.isaiahj.androidweather.ui.about.AboutMvpView;
import com.weather.isaiahj.androidweather.ui.about.AboutPresenter;
import com.weather.isaiahj.androidweather.ui.about.AboutPresenter_Factory;
import com.weather.isaiahj.androidweather.ui.main.MainActivity;
import com.weather.isaiahj.androidweather.ui.main.MainActivity_MembersInjector;
import com.weather.isaiahj.androidweather.ui.main.MainMvpPresenter;
import com.weather.isaiahj.androidweather.ui.main.MainMvpView;
import com.weather.isaiahj.androidweather.ui.main.MainPresenter;
import com.weather.isaiahj.androidweather.ui.main.MainPresenter_Factory;
import com.weather.isaiahj.androidweather.ui.main.weatherlist.WeatherListAdapter;
import com.weather.isaiahj.androidweather.ui.main.weatherlist.WeatherListFragment;
import com.weather.isaiahj.androidweather.ui.main.weatherlist.WeatherListFragment_MembersInjector;
import com.weather.isaiahj.androidweather.ui.main.weatherlist.WeatherListMvpPresenter;
import com.weather.isaiahj.androidweather.ui.main.weatherlist.WeatherListMvpView;
import com.weather.isaiahj.androidweather.ui.main.weatherlist.WeatherListPresenter;
import com.weather.isaiahj.androidweather.ui.main.weatherlist.WeatherListPresenter_Factory;
import com.weather.isaiahj.androidweather.ui.splash.SplashActivity;
import com.weather.isaiahj.androidweather.ui.splash.SplashActivity_MembersInjector;
import com.weather.isaiahj.androidweather.ui.splash.SplashMvpPresenter;
import com.weather.isaiahj.androidweather.ui.splash.SplashMvpView;
import com.weather.isaiahj.androidweather.ui.splash.SplashPresenter;
import com.weather.isaiahj.androidweather.ui.splash.SplashPresenter_Factory;
import com.weather.isaiahj.androidweather.ui.weatherdetail.WeatherDetailActivity;
import com.weather.isaiahj.androidweather.ui.weatherdetail.WeatherDetailActivity_MembersInjector;
import com.weather.isaiahj.androidweather.ui.weatherdetail.WeatherDetailMvpPresenter;
import com.weather.isaiahj.androidweather.ui.weatherdetail.WeatherDetailMvpView;
import com.weather.isaiahj.androidweather.ui.weatherdetail.WeatherDetailPresenter;
import com.weather.isaiahj.androidweather.ui.weatherdetail.WeatherDetailPresenter_Factory;
import com.weather.isaiahj.androidweather.utils.rx.SchedulerProvider;
import dagger.MembersInjector;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;
import dagger.internal.Preconditions;
import io.reactivex.disposables.CompositeDisposable;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class DaggerActivityComponent implements ActivityComponent {
  private Provider<DataManager> getDataManagerProvider;

  private Provider<SchedulerProvider> provideSchedulerProvider;

  private Provider<CompositeDisposable> provideCompositeDisposableProvider;

  private Provider<MainPresenter<MainMvpView>> mainPresenterProvider;

  private Provider<MainMvpPresenter<MainMvpView>> provideMainPresenterProvider;

  private MembersInjector<MainActivity> mainActivityMembersInjector;

  private Provider<SplashPresenter<SplashMvpView>> splashPresenterProvider;

  private Provider<SplashMvpPresenter<SplashMvpView>> provideSplashPresenterProvider;

  private MembersInjector<SplashActivity> splashActivityMembersInjector;

  private Provider<WeatherDetailPresenter<WeatherDetailMvpView>> weatherDetailPresenterProvider;

  private Provider<WeatherDetailMvpPresenter<WeatherDetailMvpView>> provideFeedPresenterProvider;

  private MembersInjector<WeatherDetailActivity> weatherDetailActivityMembersInjector;

  private Provider<AboutPresenter<AboutMvpView>> aboutPresenterProvider;

  private Provider<AboutMvpPresenter<AboutMvpView>> provideAboutPresenterProvider;

  private MembersInjector<AboutFragment> aboutFragmentMembersInjector;

  private Provider<WeatherListPresenter<WeatherListMvpView>> weatherListPresenterProvider;

  private Provider<WeatherListMvpPresenter<WeatherListMvpView>>
      provideWeatherListMvpPresenterProvider;

  private Provider<WeatherListAdapter> provideWeatherListAdapterProvider;

  private Provider<AppCompatActivity> provideActivityProvider;

  private Provider<LinearLayoutManager> provideLinearLayoutManagerProvider;

  private MembersInjector<WeatherListFragment> weatherListFragmentMembersInjector;

  private DaggerActivityComponent(Builder builder) {
    assert builder != null;
    initialize(builder);
  }

  public static Builder builder() {
    return new Builder();
  }

  @SuppressWarnings("unchecked")
  private void initialize(final Builder builder) {

    this.getDataManagerProvider =
        new Factory<DataManager>() {
          private final ApplicationComponent applicationComponent = builder.applicationComponent;

          @Override
          public DataManager get() {
            return Preconditions.checkNotNull(
                applicationComponent.getDataManager(),
                "Cannot return null from a non-@Nullable component method");
          }
        };

    this.provideSchedulerProvider =
        ActivityModule_ProvideSchedulerProviderFactory.create(builder.activityModule);

    this.provideCompositeDisposableProvider =
        ActivityModule_ProvideCompositeDisposableFactory.create(builder.activityModule);

    this.mainPresenterProvider =
        MainPresenter_Factory.create(
            MembersInjectors.<MainPresenter<MainMvpView>>noOp(),
            getDataManagerProvider,
            provideSchedulerProvider,
            provideCompositeDisposableProvider);

    this.provideMainPresenterProvider =
        DoubleCheck.provider(
            ActivityModule_ProvideMainPresenterFactory.create(
                builder.activityModule, mainPresenterProvider));

    this.mainActivityMembersInjector =
        MainActivity_MembersInjector.create(provideMainPresenterProvider);

    this.splashPresenterProvider =
        SplashPresenter_Factory.create(
            MembersInjectors.<SplashPresenter<SplashMvpView>>noOp(),
            getDataManagerProvider,
            provideSchedulerProvider,
            provideCompositeDisposableProvider);

    this.provideSplashPresenterProvider =
        DoubleCheck.provider(
            ActivityModule_ProvideSplashPresenterFactory.create(
                builder.activityModule, splashPresenterProvider));

    this.splashActivityMembersInjector =
        SplashActivity_MembersInjector.create(provideSplashPresenterProvider);

    this.weatherDetailPresenterProvider =
        WeatherDetailPresenter_Factory.create(
            MembersInjectors.<WeatherDetailPresenter<WeatherDetailMvpView>>noOp(),
            getDataManagerProvider,
            provideSchedulerProvider,
            provideCompositeDisposableProvider);

    this.provideFeedPresenterProvider =
        ActivityModule_ProvideFeedPresenterFactory.create(
            builder.activityModule, weatherDetailPresenterProvider);

    this.weatherDetailActivityMembersInjector =
        WeatherDetailActivity_MembersInjector.create(provideFeedPresenterProvider);

    this.aboutPresenterProvider =
        AboutPresenter_Factory.create(
            MembersInjectors.<AboutPresenter<AboutMvpView>>noOp(),
            getDataManagerProvider,
            provideSchedulerProvider,
            provideCompositeDisposableProvider);

    this.provideAboutPresenterProvider =
        ActivityModule_ProvideAboutPresenterFactory.create(
            builder.activityModule, aboutPresenterProvider);

    this.aboutFragmentMembersInjector =
        AboutFragment_MembersInjector.create(provideAboutPresenterProvider);

    this.weatherListPresenterProvider =
        WeatherListPresenter_Factory.create(
            MembersInjectors.<WeatherListPresenter<WeatherListMvpView>>noOp(),
            getDataManagerProvider,
            provideSchedulerProvider,
            provideCompositeDisposableProvider);

    this.provideWeatherListMvpPresenterProvider =
        ActivityModule_ProvideWeatherListMvpPresenterFactory.create(
            builder.activityModule, weatherListPresenterProvider);

    this.provideWeatherListAdapterProvider =
        ActivityModule_ProvideWeatherListAdapterFactory.create(builder.activityModule);

    this.provideActivityProvider =
        ActivityModule_ProvideActivityFactory.create(builder.activityModule);

    this.provideLinearLayoutManagerProvider =
        ActivityModule_ProvideLinearLayoutManagerFactory.create(
            builder.activityModule, provideActivityProvider);

    this.weatherListFragmentMembersInjector =
        WeatherListFragment_MembersInjector.create(
            provideWeatherListMvpPresenterProvider,
            provideWeatherListAdapterProvider,
            provideLinearLayoutManagerProvider);
  }

  @Override
  public void inject(MainActivity activity) {
    mainActivityMembersInjector.injectMembers(activity);
  }

  @Override
  public void inject(SplashActivity activity) {
    splashActivityMembersInjector.injectMembers(activity);
  }

  @Override
  public void inject(WeatherDetailActivity activity) {
    weatherDetailActivityMembersInjector.injectMembers(activity);
  }

  @Override
  public void inject(AboutFragment fragment) {
    aboutFragmentMembersInjector.injectMembers(fragment);
  }

  @Override
  public void inject(WeatherListFragment fragment) {
    weatherListFragmentMembersInjector.injectMembers(fragment);
  }

  public static final class Builder {
    private ActivityModule activityModule;

    private ApplicationComponent applicationComponent;

    private Builder() {}

    public ActivityComponent build() {
      if (activityModule == null) {
        throw new IllegalStateException(ActivityModule.class.getCanonicalName() + " must be set");
      }
      if (applicationComponent == null) {
        throw new IllegalStateException(
            ApplicationComponent.class.getCanonicalName() + " must be set");
      }
      return new DaggerActivityComponent(this);
    }

    public Builder activityModule(ActivityModule activityModule) {
      this.activityModule = Preconditions.checkNotNull(activityModule);
      return this;
    }

    public Builder applicationComponent(ApplicationComponent applicationComponent) {
      this.applicationComponent = Preconditions.checkNotNull(applicationComponent);
      return this;
    }
  }
}
