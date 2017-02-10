package es.esy.vivekrajendran.myapp.util;

import android.os.Bundle;
import android.support.v4.app.DialogFragment;


public class ButtonChooser extends DialogFragment {

    public ButtonChooser newInstance(int title) {
        Bundle args = new Bundle();
        args.putInt("title", title);
        ButtonChooser buttonChooser = new ButtonChooser();
        buttonChooser.setArguments(args);
        return buttonChooser;
    }


}