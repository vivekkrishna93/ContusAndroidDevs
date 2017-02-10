/**
 * Copyright will updated soon
 */

package es.esy.vivekrajendran.myapp.util;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.Toast;

import es.esy.vivekrajendran.myapp.R;

/**
 * This class gives helps to create custom Diaglog box.
 */

public class CustomDialog extends DialogFragment {

    private Context context;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(context)
                .inflate(R.layout.layout_dialogbox, container);
        Button ok = (Button) view.findViewById(R.id.btn_dialog_ok);
        Button customize = (Button) view.findViewById(R.id.btn_dialog_customize);

        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });

        customize.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "Customized", Toast.LENGTH_SHORT).show();
                dismiss();
            }
        });
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
