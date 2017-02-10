package es.esy.vivekrajendran.myapp.util;

import android.content.Context;
import android.util.DisplayMetrics;

public class SpanCount {
    public static int calculateNoOfColumns(Context context) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        float dpWidth = displayMetrics.widthPixels / displayMetrics.density;
        return (int) (dpWidth / 180);
    }
}
