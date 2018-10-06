package com.weather.isaiahj.androidweather.data.network;

import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class ApiHeader_Factory implements Factory<ApiHeader> {
  private final Provider<ApiHeader.PublicApiHeader> publicApiHeaderProvider;

  public ApiHeader_Factory(Provider<ApiHeader.PublicApiHeader> publicApiHeaderProvider) {
    assert publicApiHeaderProvider != null;
    this.publicApiHeaderProvider = publicApiHeaderProvider;
  }

  @Override
  public ApiHeader get() {
    return new ApiHeader(publicApiHeaderProvider.get());
  }

  public static Factory<ApiHeader> create(
      Provider<ApiHeader.PublicApiHeader> publicApiHeaderProvider) {
    return new ApiHeader_Factory(publicApiHeaderProvider);
  }
}
