/**
 * Copyright will updated soon
 */

package es.esy.vivekrajendran.myapp.data;

import android.net.Uri;
import android.provider.BaseColumns;
import android.provider.OpenableColumns;

/**
 * Created by VivekRajendran on 6/2/17.
 *
 * This helper class provides table fields and sqlite queries.
 */

public class WeatherContract {

    private WeatherContract() {}

    public static final String CONTENT_AUTHORITY = "es.esy.vivekrajendran.myapp";
    public static final String CONTENT_USERS = "users";
    public static final String CONTENT_USERS_ID = "users/#";
    public static final String CONTENT_WEATHER = "weather";

    public static final Uri BASE_CONTENT_URI = Uri.parse("content://" + CONTENT_AUTHORITY);
    public static final Uri USER_URI = Uri.withAppendedPath(BASE_CONTENT_URI, CONTENT_USERS);
    public static final Uri WEATHER_URI = Uri.withAppendedPath(BASE_CONTENT_URI, CONTENT_WEATHER);
    public static final Uri USER_ID_URI = Uri.withAppendedPath(BASE_CONTENT_URI, CONTENT_USERS_ID);

    public static final class LocationEntry implements BaseColumns, OpenableColumns {
        public static final String TABLE_NAME = "Location Entry";
        public static final String COLUMN_CITY = "City";
        public static final String COLUMN_COORD_LAT = "Coord_lat";
        public static final String COLUMN_COORD_LONG = "Coord_long";

        public static final String SQL_CREATE_ENTRIES = "CREATE TABLE " + TABLE_NAME + "( " +
                COLUMN_CITY + " VAR(20), " + COLUMN_COORD_LAT + " VAR(10), "+
                COLUMN_COORD_LONG + " VAR(10));";

        public static final String SQL_DELETE_ENTRIES = "DROP TABLE " + TABLE_NAME;
    }


    public static final class Users implements BaseColumns, OpenableColumns {
        public static final String TABLE_NAME = "Users";
        public static final String COLUMN_NAME = "Name";
        public static final String COLUMN_EMAIL = "Email";
        public static final String COLUMN_PASSWORD = "Password";

        public static final String SQL_CREATE_USERS = "CREATE TABLE " + TABLE_NAME + "( " +
                COLUMN_NAME + " VAR, " + COLUMN_EMAIL + " VAR, " +
                COLUMN_PASSWORD + " VAR);";
        public static final String SQL_DELETE_USERS = "DROP TABLE " + TABLE_NAME;
    }
}
