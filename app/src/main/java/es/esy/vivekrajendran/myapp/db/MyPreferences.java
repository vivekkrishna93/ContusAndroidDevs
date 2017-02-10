package es.esy.vivekrajendran.myapp.db;


import android.content.Context;
import android.content.SharedPreferences;

import es.esy.vivekrajendran.myapp.model.Contract;

import static android.content.Context.MODE_PRIVATE;

public class MyPreferences {


    private SharedPreferences mSharedPreferences;

    private MyPreferences(Context context) {
        mSharedPreferences = context.getSharedPreferences(Contract.Pref.PREF_NAME, MODE_PRIVATE);
    }

    public void regUser(String name, String email, String password) {
        SharedPreferences.Editor editor = mSharedPreferences.edit();
        editor.putString(Contract.Pref.EMAIL, email.trim());
        editor.putString(Contract.Pref.NAME, name.trim());
        editor.putString(Contract.Pref.PASSWORD, password.trim());
        editor.apply();

    }

    public static MyPreferences init(Context context) {
        return new MyPreferences(context);
    }

    public boolean logInUser(String email, String password) {
        String email_cross = mSharedPreferences.getString(Contract.Pref.EMAIL, "default");
        String pass_cross = mSharedPreferences.getString(Contract.Pref.PASSWORD, "pass");
        SharedPreferences.Editor editor = mSharedPreferences.edit();

        if (email_cross.equals(email.trim()) && pass_cross.equals(password.trim())) {
            editor.putBoolean(Contract.Pref.ISLOGGED, true);
            editor.apply();
            return true;
        } else {
            editor.putBoolean(Contract.Pref.ISLOGGED, false);
            editor.apply();
            return false;
        }
    }

    public boolean isLogged() {
        return mSharedPreferences.getBoolean(Contract.Pref.ISLOGGED, false);
    }
}


