package com.weather.isaiahj.androidweather.ui.main;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.location.Location;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationAvailability;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;
import com.weather.isaiahj.androidweather.R;
import com.weather.isaiahj.androidweather.data.network.model.currentweather.CurrentWeather;
import com.weather.isaiahj.androidweather.ui.base.BaseActivity;
import com.weather.isaiahj.androidweather.ui.main.weatherlist.WeatherListFragment;
import com.weather.isaiahj.androidweather.ui.weatherdetail.WeatherDetailActivity;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by isaiahj on 05/10/2018.
 */

public class MainActivity extends BaseActivity implements MainMvpView, GoogleApiClient.ConnectionCallbacks,
        GoogleApiClient.OnConnectionFailedListener {

    private static final int PERMISSION_ACCESS_LOCATION = 100;
    private static final int LOCATION_REQUEST_INTERVAL = 60000;
    private static final int LOCATION_REQUEST_FAST_INTERVAL = 5000;

    @Inject
    MainMvpPresenter<MainMvpView> mPresenter;

    @BindView(R.id.toolbar)
    Toolbar mToolbar;

    private GoogleApiClient mGoogleApiClient;

    public static Intent getStartIntent(Context context) {
        return new Intent(context, MainActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getActivityComponent().inject(this);

        setUnBinder(ButterKnife.bind(this));

        mPresenter.onAttach(this);

        mGoogleApiClient = new GoogleApiClient.Builder(this)
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .addApi(LocationServices.API)
                .build();

        setUp();
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (mGoogleApiClient != null) {
            mGoogleApiClient.connect();
        }
    }

    @Override
    protected void onStop() {
        if (mGoogleApiClient != null && mGoogleApiClient.isConnected()) {
            mGoogleApiClient.disconnect();
        }
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        mPresenter.onDetach();
        super.onDestroy();
    }

    @Override
    public void onFragmentAttached() {
    }

    @Override
    public void onFragmentDetached(String tag) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        Fragment fragment = fragmentManager.findFragmentByTag(tag);
        if (fragment != null) {
            fragmentManager
                    .beginTransaction()
                    .disallowAddToBackStack()
                    .setCustomAnimations(R.anim.slide_left, R.anim.slide_right)
                    .remove(fragment)
                    .commitNow();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Drawable drawable = item.getIcon();
        if (drawable instanceof Animatable) {
            ((Animatable) drawable).start();
        }
        switch (item.getItemId()) {
            case R.id.action_refresh:
                FragmentManager fragmentManager = getSupportFragmentManager();
                Fragment fragment = fragmentManager.findFragmentById(R.id.list_container);

                if (fragment instanceof WeatherListFragment) {
                    ((WeatherListFragment) fragment).refreshWeatherList(drawable);
                }
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    protected void setUp() {
        setSupportActionBar(mToolbar);
        setupWeatherListContainerView();
        mPresenter.onViewInitialized();
    }

    @Override
    public void setupWeatherListContainerView() {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.list_container, WeatherListFragment.newInstance())
                .commit();
    }

    @Override
    public void openWeatherDetailActivity(CurrentWeather currentWeather, Bundle sharedElementBundle) {
        startActivity(WeatherDetailActivity.getStartIntentWithParcelableExtra(
                MainActivity.this, currentWeather), sharedElementBundle);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == PERMISSION_ACCESS_LOCATION) {
            addCurrentLocation();
        }
    }

    @Override
    public void addCurrentLocation() {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION,
                    Manifest.permission.ACCESS_COARSE_LOCATION}, PERMISSION_ACCESS_LOCATION);
            return;
        }

        LocationRequest locationRequest = LocationRequest.create()
                .setInterval(LOCATION_REQUEST_INTERVAL)
                .setFastestInterval(LOCATION_REQUEST_FAST_INTERVAL)
                .setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);

        showMessage(R.string.checking_for_location);

        LocationServices.FusedLocationApi.requestLocationUpdates(mGoogleApiClient, locationRequest,
                new LocationCallback() {
                    @Override
                    public void onLocationResult(LocationResult locationResult) {
                        if (locationResult != null && locationResult.getLastLocation() != null) {
                            Location location = locationResult.getLastLocation();
                            mPresenter.onLocationReceived(location.getLatitude(), location.getLongitude());
                        } else {
                            onError(R.string.unable_to_detect_current_location);
                        }
                    }

                    @Override
                    public void onLocationAvailability(LocationAvailability locationAvailability) {
                        if (!locationAvailability.isLocationAvailable()) {
                            onError(R.string.unable_to_detect_current_location);
                        }
                    }
                }, null);

    }

    @Override
    public void onConnected(@Nullable Bundle bundle) {
        addCurrentLocation();
    }

    @Override
    public void onConnectionSuspended(int i) {

    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }
}
