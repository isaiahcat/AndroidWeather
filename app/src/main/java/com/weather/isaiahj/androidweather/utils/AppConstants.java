package com.weather.isaiahj.androidweather.utils;

/**
 * Created by amitshekhar on 08/01/17.
 */

public final class AppConstants {

    private static final String LONDON_CITY_ID = "2643743";
    private static final String PRAGUE_CITY_ID = "3067696";
    private static final String SAN_FRANCISCO_CITY_ID = "5391959";

    public static final String DEFAULT_CITY_IDS = LONDON_CITY_ID + "," + PRAGUE_CITY_ID + "," +
            SAN_FRANCISCO_CITY_ID;

    public static final String STATUS_CODE_SUCCESS = "success";
    public static final String STATUS_CODE_FAILED = "failed";

    public static final int API_STATUS_CODE_LOCAL_ERROR = 0;

    public static final String DB_NAME = "mindorks_mvp.db";
    public static final String PREF_NAME = "mindorks_pref";

    public static final long NULL_INDEX = -1L;

    public static final String SEED_DATABASE_OPTIONS = "seed/options.json";
    public static final String SEED_DATABASE_QUESTIONS = "seed/questions.json";

    public static final String TIMESTAMP_FORMAT = "yyyyMMdd_HHmmss";

    private AppConstants() {
        // This utility class is not publicly instantiable
    }
}
