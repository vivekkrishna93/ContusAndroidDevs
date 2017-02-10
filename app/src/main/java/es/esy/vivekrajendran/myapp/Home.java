/**
 * Copyright will updated soon
 */

package es.esy.vivekrajendran.myapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

import es.esy.vivekrajendran.myapp.model.Contract;
import es.esy.vivekrajendran.myapp.model.User;
import es.esy.vivekrajendran.myapp.util.Chooser;
import es.esy.vivekrajendran.myapp.util.CustomDialog;
import es.esy.vivekrajendran.myapp.util.Dev;
import es.esy.vivekrajendran.myapp.util.RecyclerViewAdapter;
import es.esy.vivekrajendran.myapp.util.ThemeDialog;


public class Home extends AppCompatActivity {

    private ArrayList<User> users = new ArrayList<>();
    private RecyclerViewAdapter mRecyclerViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Home");
        }

        RecyclerView mRecyclerView = (RecyclerView) findViewById(R.id.rcylr_home);
        mRecyclerViewAdapter = new RecyclerViewAdapter(users);
        mRecyclerView.setAdapter(mRecyclerViewAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getApplication()));
        populateFakeData();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_showDialog:
                FragmentTransaction fm = getSupportFragmentManager().beginTransaction();
                CustomDialog mCustomDiaglog = new CustomDialog();
                mCustomDiaglog.setContext(getApplicationContext());
                mCustomDiaglog.show(fm, "dialog");
                break;
            case R.id.menu_changeTheme:
                FragmentTransaction fm_theme = getSupportFragmentManager().beginTransaction();
                ThemeDialog mThemeDialog = new ThemeDialog();
                mThemeDialog.setContext(getApplicationContext());
                mThemeDialog.show(fm_theme, "Theme");
                break;
            case R.id.menu_dev:
                FragmentTransaction fm_dev = getSupportFragmentManager().beginTransaction();
                Dev dev = new Dev();
                dev.setContext(getApplicationContext());
                dev.show(fm_dev, "Dev");
                break;
            case R.id.menu_chooser:
                Chooser chooser = new Chooser(this);
                chooser.setContext(getApplicationContext());
                chooser.show();
                break;
            case R.id.menu_grid:
                startActivity(new Intent(Home.this, GridActivity.class));
                break;
            case R.id.menu_logout:
                SharedPreferences.Editor editor = getSharedPreferences(Contract.Pref.PREF_NAME, MODE_PRIVATE).edit();
                editor.putBoolean(Contract.Pref.ISLOGGED, false);
                editor.apply();
                startActivity(new Intent(this, LoginActivity.class));
                Home.this.finish();
                break;
            case R.id.menu_exit:
                this.finish();
                break;
            default:
        }
        return true;
    }

    private void populateFakeData() {
        users.add(new User("Karthik", "+91 9873210456", "UserOne", R.drawable.circle_a));
        users.add(new User("Sathish", "+91 9745444456", "UserOne", R.drawable.circle_b));
        users.add(new User("Nithya",  "+91 8745153724", "UserOne", R.drawable.circle_c));
        users.add(new User("Divya",   "+91 8514542554", "UserOne", R.drawable.circle_d));
        users.add(new User("Rahuram", "+91 9531584555", "UserOne", R.drawable.circle_e));
        users.add(new User("Rajen",   "+91 8211656584", "UserOne", R.drawable.circle_a));
        users.add(new User("Saravanan",   "+91 9638527410", "UserOne", R.drawable.circle_b));
        users.add(new User("Vinoth",       "+91 846548545", "UserOne", R.drawable.circle_c));
        users.add(new User("Thirukumaran", "+91 746518515", "UserOne", R.drawable.circle_d));
        users.add(new User("Gopinath",     "+91 941584554", "UserOne", R.drawable.circle_e));
        users.add(new User("Eliyas",       "+91 984654561", "UserOne", R.drawable.circle_a));
        users.add(new User("Raja",         "+91 814165185", "UserOne", R.drawable.circle_b));
        users.add(new User("Keerthi",      "+91 953151545", "UserOne", R.drawable.circle_c));
        mRecyclerViewAdapter.notifyDataSetChanged();
    }
}
