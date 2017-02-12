package es.esy.vivekrajendran.myapp;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import es.esy.vivekrajendran.myapp.data.WeatherContract;
import es.esy.vivekrajendran.myapp.data.WeatherDbHelper;
import es.esy.vivekrajendran.myapp.util.GridAdapter;
import es.esy.vivekrajendran.myapp.util.SpanCount;

public class GridActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        RecyclerView mRecyclerView = (RecyclerView) findViewById(R.id.content_grid);
        GridLayoutManager gml = new GridLayoutManager(GridActivity.this,
                SpanCount.calculateNoOfColumns(getApplicationContext()));
        gml.generateDefaultLayoutParams();
        mRecyclerView.setLayoutManager(gml);
        mRecyclerView.setAdapter(new GridAdapter(getApplicationContext()));
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.grid_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        ContentResolver contentResolver = getContentResolver();
        WeatherDbHelper weatherDbHelper = new WeatherDbHelper(this);

        switch (item.getItemId()) {
            case R.id.menu_grid_add:
                ContentValues contentValues = new ContentValues();
                contentValues.put(WeatherContract.LocationEntry.COLUMN_CITY, "Chennai");
                contentValues.put(WeatherContract.LocationEntry.COLUMN_COORD_LAT, "Latitude");
                contentValues.put(WeatherContract.LocationEntry.COLUMN_COORD_LONG, "Longitude");
                weatherDbHelper.getWritableDatabase().insert(
                        WeatherContract.LocationEntry.TABLE_NAME, null, contentValues);
                break;
            case R.id.menu_grid_show:
                Cursor cursor = weatherDbHelper.getReadableDatabase()
                        .query(WeatherContract.LocationEntry.TABLE_NAME,
                                null,
                                null,
                                null,
                                null,
                                null,
                                null);
                StringBuilder stringBuilder = new StringBuilder();
                cursor.moveToNext();
                    stringBuilder.append(cursor.getString(cursor.getColumnIndexOrThrow(WeatherContract.LocationEntry.COLUMN_CITY)));
                cursor.close();
                Toast.makeText(this, stringBuilder.toString(), Toast.LENGTH_SHORT).show();
                break;
            case R.id.menu_grid_delete:
                String args[] = new String[] {"Chennai"};
                weatherDbHelper.getWritableDatabase()
                        .delete(WeatherContract.LocationEntry.TABLE_NAME,
                                WeatherContract.LocationEntry.COLUMN_CITY + "=?",
                                args);
                break;
            case R.id.menu_grid_deleteAll:
                weatherDbHelper.getWritableDatabase()
                        .delete(WeatherContract.LocationEntry.TABLE_NAME,
                                null,
                                null);
                break;
        }


        return true;
    }
}
