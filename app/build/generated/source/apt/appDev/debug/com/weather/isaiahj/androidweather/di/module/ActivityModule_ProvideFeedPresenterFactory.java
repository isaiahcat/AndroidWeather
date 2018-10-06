package com.weather.isaiahj.androidweather.di.module;

import com.weather.isaiahj.androidweather.ui.weatherdetail.WeatherDetailMvpPresenter;
import com.weather.isaiahj.androidweather.ui.weatherdetail.WeatherDetailMvpView;
import com.weather.isaiahj.androidweather.ui.weatherdetail.WeatherDetailPresenter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class ActivityModule_ProvideFeedPresenterFactory
    implements Factory<WeatherDetailMvpPresenter<WeatherDetailMvpView>> {
  private final ActivityModule module;

  private final Provider<WeatherDetailPresenter<WeatherDetailMvpView>> presenterProvider;

  public ActivityModule_ProvideFeedPresenterFactory(
      ActivityModule module,
      Provider<WeatherDetailPresenter<WeatherDetailMvpView>> presenterProvider) {
    assert module != null;
    this.module = module;
    assert presenterProvider != null;
    this.presenterProvider = presenterProvider;
  }

  @Override
  public WeatherDetailMvpPresenter<WeatherDetailMvpView> get() {
    return Preconditions.checkNotNull(
        module.provideFeedPresenter(presenterProvider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<WeatherDetailMvpPresenter<WeatherDetailMvpView>> create(
      ActivityModule module,
      Provider<WeatherDetailPresenter<WeatherDetailMvpView>> presenterProvider) {
    return new ActivityModule_ProvideFeedPresenterFactory(module, presenterProvider);
  }

  /** Proxies {@link ActivityModule#provideFeedPresenter(WeatherDetailPresenter)}. */
  public static WeatherDetailMvpPresenter<WeatherDetailMvpView> proxyProvideFeedPresenter(
      ActivityModule instance, WeatherDetailPresenter<WeatherDetailMvpView> presenter) {
    return instance.provideFeedPresenter(presenter);
  }
}
