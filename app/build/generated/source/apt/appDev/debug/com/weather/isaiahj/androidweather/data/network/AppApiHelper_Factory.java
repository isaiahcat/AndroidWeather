package com.weather.isaiahj.androidweather.data.network;

import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class AppApiHelper_Factory implements Factory<AppApiHelper> {
  private final Provider<ApiHeader> apiHeaderProvider;

  private final Provider<ApiParameter> apiParameterProvider;

  public AppApiHelper_Factory(
      Provider<ApiHeader> apiHeaderProvider, Provider<ApiParameter> apiParameterProvider) {
    assert apiHeaderProvider != null;
    this.apiHeaderProvider = apiHeaderProvider;
    assert apiParameterProvider != null;
    this.apiParameterProvider = apiParameterProvider;
  }

  @Override
  public AppApiHelper get() {
    return new AppApiHelper(apiHeaderProvider.get(), apiParameterProvider.get());
  }

  public static Factory<AppApiHelper> create(
      Provider<ApiHeader> apiHeaderProvider, Provider<ApiParameter> apiParameterProvider) {
    return new AppApiHelper_Factory(apiHeaderProvider, apiParameterProvider);
  }
}
