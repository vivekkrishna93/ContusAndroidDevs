package es.esy.vivekrajendran.myapp.util;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import java.util.ArrayList;

import es.esy.vivekrajendran.myapp.R;
import es.esy.vivekrajendran.myapp.model.ThemeModel;


public class ThemeRecyclerAdapter extends RecyclerView.Adapter<ThemeRecyclerAdapter.ThemeViewHolder> {

    class ThemeViewHolder extends RecyclerView.ViewHolder{
        ImageButton themeButton;

        private ThemeViewHolder(View itemView) {
            super(itemView);
            themeButton = (ImageButton) itemView.findViewById(R.id.item_theme_imageButton);
        }
    }

    private ArrayList<ThemeModel> myColors;

    public ThemeRecyclerAdapter() {
        populateColors();
    }

    @Override
    public ThemeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_recycler_theme, parent, false);
        return new ThemeViewHolder(view);
    }

    @Override
    public int getItemCount() {
        return myColors.size();
    }

    @Override
    public void onBindViewHolder(ThemeViewHolder holder, int position) {
        holder.themeButton.setImageResource(myColors.get(position).getThemeResource());
    }

    private void populateColors() {
        myColors = new ArrayList<>();
        myColors.add(new ThemeModel("", R.drawable.circle_red));
        myColors.add(new ThemeModel("", R.drawable.circle_fushsia));
        myColors.add(new ThemeModel("", R.drawable.circle_purple));
        myColors.add(new ThemeModel("", R.drawable.circle_blue));
        myColors.add(new ThemeModel("", R.drawable.green_tick_icon));
        myColors.add(new ThemeModel("", R.drawable.circle_teal));
        myColors.add(new ThemeModel("", R.drawable.circle_lime));
        myColors.add(new ThemeModel("", R.drawable.circle_gray));
        myColors.add(new ThemeModel("", R.drawable.circle_e));
        myColors.add(new ThemeModel("", R.drawable.circle_navy));
        myColors.add(new ThemeModel("", R.drawable.circle_olive));
        myColors.add(new ThemeModel("", R.drawable.circle_b));
    }
}
