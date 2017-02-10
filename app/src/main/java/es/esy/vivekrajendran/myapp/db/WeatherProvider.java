/**
 * Copyright will updated soon
 */

package es.esy.vivekrajendran.myapp.db;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

public class WeatherProvider extends ContentProvider {

    private Weather mWeather;

    private static UriMatcher mUriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
    private static final int WEATHER_CODE = 101;
    private static final int USER_CODE = 102;
    private static final int USER_ID_CODE = 103;

    static {
        mUriMatcher.addURI(WeatherContract.CONTENT_AUTHORITY, WeatherContract.CONTENT_WEATHER, WEATHER_CODE);
        mUriMatcher.addURI(WeatherContract.CONTENT_AUTHORITY,WeatherContract.CONTENT_USERS, USER_CODE);
        mUriMatcher.addURI(WeatherContract.CONTENT_AUTHORITY, WeatherContract.CONTENT_USERS_ID, USER_ID_CODE);
    }

    public WeatherProvider() {
    }

    @Override
    public boolean onCreate() {
        mWeather = new Weather(getContext());
        return true;
    }

    @Nullable
    @Override
    public Cursor query(@NonNull Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {

        SQLiteDatabase mSQLiteDatabase = mWeather.getReadableDatabase();

        if (mUriMatcher.match(WeatherContract.WEATHER_URI) == WEATHER_CODE ) {
            String[] projection_weather = new String[] {
                    WeatherContract.LocationEntry.COLUMN_CITY,
                    WeatherContract.LocationEntry.COLUMN_COORD_LAT,
                    WeatherContract.LocationEntry.COLUMN_COORD_LONG};
            return mSQLiteDatabase.query(
                        WeatherContract.LocationEntry.TABLE_NAME,
                        projection_weather,
                        selection,
                        selectionArgs,
                        sortOrder,
                        null,
                        null,
                        null);

        } else if (mUriMatcher.match(WeatherContract.USER_ID_URI) == USER_ID_CODE) {
            String[] projection_users_id = new String[] {
                    WeatherContract.Users.COLUMN_NAME,
                    WeatherContract.Users.COLUMN_EMAIL,
                    WeatherContract.Users.COLUMN_PASSWORD };
            String selection_id = WeatherContract.Users.COLUMN_EMAIL + "=?";
            String selectionArgs_id[] = new String[] {String.valueOf(ContentUris.parseId(uri ))};
            return mSQLiteDatabase.query(
                    WeatherContract.Users.TABLE_NAME,
                    projection_users_id,
                    selection_id,
                    selectionArgs_id,
                    sortOrder,
                    null,
                    null,
                    null);

        } else if (mUriMatcher.match(WeatherContract.USER_URI) == USER_CODE) {
            String[] projection_users = {
                    WeatherContract.Users.COLUMN_NAME,
                    WeatherContract.Users.COLUMN_EMAIL,
                    WeatherContract.Users.COLUMN_PASSWORD};
            return mSQLiteDatabase.query(
                    WeatherContract.Users.TABLE_NAME,
                    projection_users,
                    selection,
                    selectionArgs,
                    sortOrder,
                    null,
                    null,
                    null);

        } else throw new IllegalArgumentException("query: Uri match not found. " + uri);
    }

    @Nullable
    @Override
    public String getType(Uri uri) {
        return null;
    }

    @Nullable
    @Override
    public Uri insert(Uri uri, ContentValues values) {
        SQLiteDatabase mWritableDatabase = mWeather.getWritableDatabase();
        if (mUriMatcher.match(uri) == WEATHER_CODE) {
            mWritableDatabase.insert(
                    WeatherContract.LocationEntry.TABLE_NAME,
                    null,
                    values);

        } else if (mUriMatcher.match(uri) == USER_CODE) {
            mWritableDatabase.insert(
                    WeatherContract.LocationEntry.TABLE_NAME,
                    null,
                    values);

        } else throw new IllegalArgumentException("insert: Uri match not found. " + uri);
        return null;
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        return 0;
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        return 0;
    }
}
