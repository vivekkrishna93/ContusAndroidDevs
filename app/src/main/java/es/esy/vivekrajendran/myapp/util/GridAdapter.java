package es.esy.vivekrajendran.myapp.util;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

import es.esy.vivekrajendran.myapp.R;
import es.esy.vivekrajendran.myapp.model.GridModel;


public class GridAdapter extends RecyclerView.Adapter<GridAdapter.MyViewHolder> {

    private ArrayList<GridModel> gridModels = new ArrayList<>();
    private Context context;

    public GridAdapter(Context context) {
        populateData();
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_grid, parent, false);
        return new GridAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.imageView.setImageResource(gridModels.get(position).getImageRes());
        holder.textView.setText(gridModels.get(position).getText());
        holder.linearLayout.setBackgroundColor(ContextCompat.getColor(context,
                gridModels.get(position).getColorRes()));
        //holder.linearLayout.setBackgroundColor(gridModels.get(position).getColorRes());
    }

    @Override
    public int getItemCount() {
        return gridModels.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView textView;
        ImageView imageView;
        LinearLayout linearLayout;
        public MyViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.item_grid_text);
            imageView = (ImageView) itemView.findViewById(R.id.item_grid_image);
            linearLayout = (LinearLayout) itemView.findViewById(R.id.item_grid_background);
        }
    }


    private void populateData() {
        gridModels.add(new GridModel(R.drawable.img1, "material one", R.color.a));
        gridModels.add(new GridModel(R.drawable.img2, "material two", R.color.b));
        gridModels.add(new GridModel(R.drawable.img3, "material three", R.color.c));
        gridModels.add(new GridModel(R.drawable.img4, "material four", R.color.d));
        gridModels.add(new GridModel(R.drawable.img5, "material five", R.color.e));
        gridModels.add(new GridModel(R.drawable.img6, "material one", R.color.a));
        gridModels.add(new GridModel(R.drawable.img1, "material two", R.color.b));
        gridModels.add(new GridModel(R.drawable.img2, "mateial three", R.color.c));
    }
}
