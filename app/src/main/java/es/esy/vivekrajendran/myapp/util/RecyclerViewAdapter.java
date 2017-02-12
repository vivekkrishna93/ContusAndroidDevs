/**
 * Copyright will updated soon
 */

package es.esy.vivekrajendran.myapp.util;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import es.esy.vivekrajendran.myapp.R;
import es.esy.vivekrajendran.myapp.model.User;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder>{

    private ArrayList<User> users;

    public RecyclerViewAdapter(ArrayList<User> users) {
        this.users = users;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_recycler, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        String name_ref = users.get(position).getName();
        holder.name.setText(name_ref);
        holder.des.setText(users.get(position).getEmail());
        holder.single.setText(String.valueOf(name_ref.charAt(0)));
        holder.imageView.setImageResource(users.get(position).getId());

//        GradientDrawable backgroundGradient = (GradientDrawable)holder.imageView.setBackgroundColor(Color.GREEN);
//        if (backgroundGradient != null){
//            backgroundGradient.setColor(context.getResources().getColor(R.color.yellow));
//            Log.i("TAG", "onBindViewHolder: " + backgroundGradient.toString());
//        }

    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView name, des, single;

        public MyViewHolder(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.item_image);
            name = (TextView) itemView.findViewById(R.id.item_name);
            des = (TextView) itemView.findViewById(R.id.item_des);
            single = (TextView) itemView.findViewById(R.id.item_firstLetter);
        }
    }
}
