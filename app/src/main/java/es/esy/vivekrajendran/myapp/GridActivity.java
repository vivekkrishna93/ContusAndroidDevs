package es.esy.vivekrajendran.myapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

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

}
