package com.weather.isaiahj.androidweather.di.component;

import com.weather.isaiahj.androidweather.di.PerService;
import com.weather.isaiahj.androidweather.di.module.ServiceModule;
import com.weather.isaiahj.androidweather.service.SyncService;

import dagger.Component;

/**
 * Created by janisharali on 01/02/17.
 */

@PerService
@Component(dependencies = ApplicationComponent.class, modules = ServiceModule.class)
public interface ServiceComponent {

    void inject(SyncService service);

}
