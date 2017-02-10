package es.esy.vivekrajendran.myapp.util;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.Toast;

import es.esy.vivekrajendran.myapp.R;

/**
 * Created by user on 9/2/17.
 */

public class Dev extends DialogFragment {

    private Context context;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(context)
                .inflate(R.layout.layout_circular, container);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getDialog().requestWindowFeature(Window.FEATURE_NO_TITLE);
        if (getDialog().getWindow() != null) {
            Log.i("TAG", "onViewCreated: ");
            getDialog().getWindow().setBackgroundDrawableResource(R.drawable.frame);
        }
        setStyle(DialogFragment.STYLE_NO_FRAME, android.R.style.Theme);
    }

    public void setContext(Context context) {
        this.context = context;
    }


}
