# Android Weather: Sample App

<p align="center">
  <img src="https://github.com/ijbcatimpo/AndroidWeather/blob/master/images/splash_prod.jpg" width="170">
  <img src="https://github.com/ijbcatimpo/AndroidWeather/blob/master/images/splash_dev.jpg" width="170">
  <img src="https://github.com/ijbcatimpo/AndroidWeather/blob/master/images/weather_list.jpg" width="170">
  <img src="https://github.com/ijbcatimpo/AndroidWeather/blob/master/images/location_permission.jpg" width="170">
  <img src="https://github.com/ijbcatimpo/AndroidWeather/blob/master/images/weather_detail.jpg" width="170">
</p>

### Overview
Application shows weather information from [OpenWeatherMap](https://openweathermap.org/api)

This application has 3 screens
1. Splash
- Shows logo for 2 seconds
- Different splash screen for dev and production
2. WeatherList (Using Fragment for List portion)
- List of weather information from London, Prague, and San Francisco
- Card shows location, weather description, and average temperature
- Shows shared element transition going to WeatherDetail upon clicking card
- AnimatedVectorDrawable refresh button on Action Bar starts spinning onClick and stops when refresh is finished
- Option to add current location to list of information, asks for Location permission onClick
3. WeatherDetail
- Detailed weather information for selected location
- Shows weather icon, weather description, average temperature, temperature range, etc.
- AnimatedVectorDrawable refresh button on Action Bar starts spinning onClick and stops when refresh is finished
- Shows shared element transition when pressing back button to go back to WeatherList

Additional Notes
- Application versionName is 3.3 with versionCode 3333
- Offline mode using SharedPrefrences and Gson library
- Third-party libraries listed below
- Used Git and GitHub for version control
- Analytics with Fabric.io Crashlytics
- With some unit testing based on MVP boilerplate
- Supports both tablet and phone

### Architecture and Boilerplate reference:
Mindorks MVP Boilerplate: https://github.com/MindorksOpenSource/android-mvp-architecture

### Library reference resources:
1. RxJava2: https://github.com/amitshekhariitbhu/RxJava2-Android-Samples
2. Dagger2: https://github.com/MindorksOpenSource/android-dagger2-example
3. Gson: https://github.com/google/gson
4. FastAndroidNetworking: https://github.com/amitshekhariitbhu/Fast-Android-Networking
5. PlaceHolderView: https://github.com/janishar/PlaceHolderView
6. Calligraphy: https://github.com/chrisjenx/Calligraphy
7. ButterKnife: http://jakewharton.github.io/butterknife/
8. Fabric.io: https://fabric.io/kits/android/crashlytics
9. Google Play Location: https://github.com/googlesamples/android-play-location
10. Glide: https://github.com/bumptech/glide
11. Timber: https://github.com/JakeWharton/timber

### License
```
   Copyright (C) 2018 ISAIAH JOSEPHINE CATIMPO

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
```
