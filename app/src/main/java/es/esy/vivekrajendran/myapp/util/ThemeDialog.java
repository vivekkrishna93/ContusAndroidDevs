package es.esy.vivekrajendran.myapp.util;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import es.esy.vivekrajendran.myapp.R;

public class ThemeDialog extends DialogFragment {

    private Context context;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(context)
                .inflate(R.layout.layout_dialog_theme, container);
        getDialog().setTitle("Color Scheme");
        RecyclerView mThemeRecycler = (RecyclerView) view.findViewById(R.id.item_theme_recycler);
        GridLayoutManager glm = new GridLayoutManager(context, 4);
        mThemeRecycler.setLayoutManager(glm);
        mThemeRecycler.setAdapter(new ThemeRecyclerAdapter());
        return view;
    }

    public void setContext(Context context) {
        this.context = context;
    }
}
