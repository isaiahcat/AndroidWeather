package com.weather.isaiahj.androidweather.di.module;

import com.weather.isaiahj.androidweather.data.network.ApiHeader;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class ApplicationModule_ProvideProtectedApiHeaderFactory
    implements Factory<ApiHeader.PublicApiHeader> {
  private final ApplicationModule module;

  public ApplicationModule_ProvideProtectedApiHeaderFactory(ApplicationModule module) {
    assert module != null;
    this.module = module;
  }

  @Override
  public ApiHeader.PublicApiHeader get() {
    return Preconditions.checkNotNull(
        module.provideProtectedApiHeader(),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<ApiHeader.PublicApiHeader> create(ApplicationModule module) {
    return new ApplicationModule_ProvideProtectedApiHeaderFactory(module);
  }

  /** Proxies {@link ApplicationModule#provideProtectedApiHeader()}. */
  public static ApiHeader.PublicApiHeader proxyProvideProtectedApiHeader(
      ApplicationModule instance) {
    return instance.provideProtectedApiHeader();
  }
}
