package com.weather.isaiahj.androidweather.di.component;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import com.weather.isaiahj.androidweather.data.DataManager;
import com.weather.isaiahj.androidweather.di.module.ActivityModule;
import com.weather.isaiahj.androidweather.di.module.ActivityModule_ProvideAboutPresenterFactory;
import com.weather.isaiahj.androidweather.di.module.ActivityModule_ProvideActivityFactory;
import com.weather.isaiahj.androidweather.di.module.ActivityModule_ProvideBlogAdapterFactory;
import com.weather.isaiahj.androidweather.di.module.ActivityModule_ProvideBlogMvpPresenterFactory;
import com.weather.isaiahj.androidweather.di.module.ActivityModule_ProvideCompositeDisposableFactory;
import com.weather.isaiahj.androidweather.di.module.ActivityModule_ProvideFeedPagerAdapterFactory;
import com.weather.isaiahj.androidweather.di.module.ActivityModule_ProvideFeedPresenterFactory;
import com.weather.isaiahj.androidweather.di.module.ActivityModule_ProvideLinearLayoutManagerFactory;
import com.weather.isaiahj.androidweather.di.module.ActivityModule_ProvideMainPresenterFactory;
import com.weather.isaiahj.androidweather.di.module.ActivityModule_ProvideOpenSourceAdapterFactory;
import com.weather.isaiahj.androidweather.di.module.ActivityModule_ProvideOpenSourcePresenterFactory;
import com.weather.isaiahj.androidweather.di.module.ActivityModule_ProvideSchedulerProviderFactory;
import com.weather.isaiahj.androidweather.di.module.ActivityModule_ProvideSplashPresenterFactory;
import com.weather.isaiahj.androidweather.ui.about.AboutFragment;
import com.weather.isaiahj.androidweather.ui.about.AboutFragment_MembersInjector;
import com.weather.isaiahj.androidweather.ui.about.AboutMvpPresenter;
import com.weather.isaiahj.androidweather.ui.about.AboutMvpView;
import com.weather.isaiahj.androidweather.ui.about.AboutPresenter;
import com.weather.isaiahj.androidweather.ui.about.AboutPresenter_Factory;
import com.weather.isaiahj.androidweather.ui.feed.FeedActivity;
import com.weather.isaiahj.androidweather.ui.feed.FeedActivity_MembersInjector;
import com.weather.isaiahj.androidweather.ui.feed.FeedMvpPresenter;
import com.weather.isaiahj.androidweather.ui.feed.FeedMvpView;
import com.weather.isaiahj.androidweather.ui.feed.FeedPagerAdapter;
import com.weather.isaiahj.androidweather.ui.feed.FeedPresenter;
import com.weather.isaiahj.androidweather.ui.feed.FeedPresenter_Factory;
import com.weather.isaiahj.androidweather.ui.feed.blogs.BlogAdapter;
import com.weather.isaiahj.androidweather.ui.feed.blogs.BlogFragment;
import com.weather.isaiahj.androidweather.ui.feed.blogs.BlogFragment_MembersInjector;
import com.weather.isaiahj.androidweather.ui.feed.blogs.BlogMvpPresenter;
import com.weather.isaiahj.androidweather.ui.feed.blogs.BlogMvpView;
import com.weather.isaiahj.androidweather.ui.feed.blogs.BlogPresenter;
import com.weather.isaiahj.androidweather.ui.feed.blogs.BlogPresenter_Factory;
import com.weather.isaiahj.androidweather.ui.feed.opensource.OpenSourceAdapter;
import com.weather.isaiahj.androidweather.ui.feed.opensource.OpenSourceFragment;
import com.weather.isaiahj.androidweather.ui.feed.opensource.OpenSourceFragment_MembersInjector;
import com.weather.isaiahj.androidweather.ui.feed.opensource.OpenSourceMvpPresenter;
import com.weather.isaiahj.androidweather.ui.feed.opensource.OpenSourceMvpView;
import com.weather.isaiahj.androidweather.ui.feed.opensource.OpenSourcePresenter;
import com.weather.isaiahj.androidweather.ui.feed.opensource.OpenSourcePresenter_Factory;
import com.weather.isaiahj.androidweather.ui.main.MainActivity;
import com.weather.isaiahj.androidweather.ui.main.MainActivity_MembersInjector;
import com.weather.isaiahj.androidweather.ui.main.MainMvpPresenter;
import com.weather.isaiahj.androidweather.ui.main.MainMvpView;
import com.weather.isaiahj.androidweather.ui.main.MainPresenter;
import com.weather.isaiahj.androidweather.ui.main.MainPresenter_Factory;
import com.weather.isaiahj.androidweather.ui.splash.SplashActivity;
import com.weather.isaiahj.androidweather.ui.splash.SplashActivity_MembersInjector;
import com.weather.isaiahj.androidweather.ui.splash.SplashMvpPresenter;
import com.weather.isaiahj.androidweather.ui.splash.SplashMvpView;
import com.weather.isaiahj.androidweather.ui.splash.SplashPresenter;
import com.weather.isaiahj.androidweather.ui.splash.SplashPresenter_Factory;
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

  private Provider<FeedPresenter<FeedMvpView>> feedPresenterProvider;

  private Provider<FeedMvpPresenter<FeedMvpView>> provideFeedPresenterProvider;

  private Provider<AppCompatActivity> provideActivityProvider;

  private Provider<FeedPagerAdapter> provideFeedPagerAdapterProvider;

  private MembersInjector<FeedActivity> feedActivityMembersInjector;

  private Provider<AboutPresenter<AboutMvpView>> aboutPresenterProvider;

  private Provider<AboutMvpPresenter<AboutMvpView>> provideAboutPresenterProvider;

  private MembersInjector<AboutFragment> aboutFragmentMembersInjector;

  private Provider<OpenSourcePresenter<OpenSourceMvpView>> openSourcePresenterProvider;

  private Provider<OpenSourceMvpPresenter<OpenSourceMvpView>> provideOpenSourcePresenterProvider;

  private Provider<OpenSourceAdapter> provideOpenSourceAdapterProvider;

  private Provider<LinearLayoutManager> provideLinearLayoutManagerProvider;

  private MembersInjector<OpenSourceFragment> openSourceFragmentMembersInjector;

  private Provider<BlogPresenter<BlogMvpView>> blogPresenterProvider;

  private Provider<BlogMvpPresenter<BlogMvpView>> provideBlogMvpPresenterProvider;

  private Provider<BlogAdapter> provideBlogAdapterProvider;

  private MembersInjector<BlogFragment> blogFragmentMembersInjector;

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

    this.feedPresenterProvider =
        FeedPresenter_Factory.create(
            MembersInjectors.<FeedPresenter<FeedMvpView>>noOp(),
            getDataManagerProvider,
            provideSchedulerProvider,
            provideCompositeDisposableProvider);

    this.provideFeedPresenterProvider =
        ActivityModule_ProvideFeedPresenterFactory.create(
            builder.activityModule, feedPresenterProvider);

    this.provideActivityProvider =
        ActivityModule_ProvideActivityFactory.create(builder.activityModule);

    this.provideFeedPagerAdapterProvider =
        ActivityModule_ProvideFeedPagerAdapterFactory.create(
            builder.activityModule, provideActivityProvider);

    this.feedActivityMembersInjector =
        FeedActivity_MembersInjector.create(
            provideFeedPresenterProvider, provideFeedPagerAdapterProvider);

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

    this.openSourcePresenterProvider =
        OpenSourcePresenter_Factory.create(
            MembersInjectors.<OpenSourcePresenter<OpenSourceMvpView>>noOp(),
            getDataManagerProvider,
            provideSchedulerProvider,
            provideCompositeDisposableProvider);

    this.provideOpenSourcePresenterProvider =
        ActivityModule_ProvideOpenSourcePresenterFactory.create(
            builder.activityModule, openSourcePresenterProvider);

    this.provideOpenSourceAdapterProvider =
        ActivityModule_ProvideOpenSourceAdapterFactory.create(builder.activityModule);

    this.provideLinearLayoutManagerProvider =
        ActivityModule_ProvideLinearLayoutManagerFactory.create(
            builder.activityModule, provideActivityProvider);

    this.openSourceFragmentMembersInjector =
        OpenSourceFragment_MembersInjector.create(
            provideOpenSourcePresenterProvider,
            provideOpenSourceAdapterProvider,
            provideLinearLayoutManagerProvider);

    this.blogPresenterProvider =
        BlogPresenter_Factory.create(
            MembersInjectors.<BlogPresenter<BlogMvpView>>noOp(),
            getDataManagerProvider,
            provideSchedulerProvider,
            provideCompositeDisposableProvider);

    this.provideBlogMvpPresenterProvider =
        ActivityModule_ProvideBlogMvpPresenterFactory.create(
            builder.activityModule, blogPresenterProvider);

    this.provideBlogAdapterProvider =
        ActivityModule_ProvideBlogAdapterFactory.create(builder.activityModule);

    this.blogFragmentMembersInjector =
        BlogFragment_MembersInjector.create(
            provideBlogMvpPresenterProvider,
            provideBlogAdapterProvider,
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
  public void inject(FeedActivity activity) {
    feedActivityMembersInjector.injectMembers(activity);
  }

  @Override
  public void inject(AboutFragment fragment) {
    aboutFragmentMembersInjector.injectMembers(fragment);
  }

  @Override
  public void inject(OpenSourceFragment fragment) {
    openSourceFragmentMembersInjector.injectMembers(fragment);
  }

  @Override
  public void inject(BlogFragment fragment) {
    blogFragmentMembersInjector.injectMembers(fragment);
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
